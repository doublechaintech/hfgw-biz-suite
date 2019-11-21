package com.doublechaintech.hfgw;

import com.doublechaintech.hfgw.application.Application;
import com.doublechaintech.hfgw.application.ApplicationTokens;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetwork;
import com.doublechaintech.hfgw.hyperledgernetwork.HyperledgerNetworkTokens;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.nodetype.NodeType;
import com.google.gson.Gson;

import com.terapico.utils.MapUtil;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.NetworkConfig;
import org.hyperledger.fabric.sdk.User;

import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric.sdk.security.CryptoSuiteFactoryImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hyperledger.fabric.sdk.helper.Config.*;

public class HFNetworkHelper {

    private static ConcurrentHashMap<String, HFClient> appClientMapping = new ConcurrentHashMap<>();

    public static HFClient findClientByApp(HfgwUserContext pContext, String pAppId) throws Exception {
        if (appClientMapping.containsKey(pAppId)) {
            return appClientMapping.get(pAppId);
        }

        HFClient client = initClientForApp(pContext, pAppId);
        appClientMapping.putIfAbsent(pAppId, client);
        return client;
    }

    private static HFClient initClientForApp(HfgwUserContext pContext, String pAppId) throws Exception {
        System.setProperty(DEFAULT_CRYPTO_SUITE_FACTORY, CryptoSuiteFactoryImpl.class.getName());
        HFClient client = HFClient.createNewInstance();
        Properties p = new Properties();
        p.setProperty(ASYMMETRIC_KEY_TYPE, "RSA");
        p.setProperty(SIGNATURE_ALGORITHM, "sha256WithRSA");
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite(p));
        Application app = pContext.getManagerGroup().getApplicationManager().loadApplication(
                pContext, pAppId, ApplicationTokens.withoutListsTokens().toArray());

        client.loadChannelFromConfig(app.getChannel().getName(), initNetworkConfig(pContext, app));

        client.setUserContext(new User() {
            @Override
            public String getName() {
                return app.getName();
            }

            @Override
            public Set<String> getRoles() {
                return null;
            }

            @Override
            public String getAccount() {
                return null;
            }

            @Override
            public String getAffiliation() {
                return null;
            }

            @Override
            public Enrollment getEnrollment() {
                String publicKey = app.getPublicKey();
                String privateKey = app.getPrivateKey();
                final Reader pemReader = new StringReader(privateKey);
                PEMKeyPair pemPair = null;
                try (PEMParser pemParser = new PEMParser(pemReader)) {
                    pemPair = (PEMKeyPair) pemParser.readObject();
                } catch (IOException pE) {
                    pE.printStackTrace();
                }
                try {
                    return new X509Enrollment(new JcaPEMKeyConverter().getPrivateKey(pemPair.getPrivateKeyInfo()), publicKey);
                } catch (PEMException pE) {
                    pE.printStackTrace();
                }
                return null;
            }

            @Override
            public String getMspId() {
                return app.getMspid();
            }
        });

        org.hyperledger.fabric.sdk.Channel channel = client.getChannel(app.getChannel().getName());
        if (channel == null) {
            throw new Exception("channel [" + app.getChannel().getName() + "] is not existed in the network");
        }

        channel.initialize();

        return client;
    }

    private static NetworkConfig initNetworkConfig(HfgwUserContext pContext, Application pApp) throws Exception {

        HyperledgerNetwork network = pApp.getNetwork();
        network = pContext.getManagerGroup().getHyperledgerNetworkManager().loadHyperledgerNetwork(
                pContext, network.getId(),
                HyperledgerNetworkTokens.start().withChannelList().withOrganizationList().withNodeList().toArray());
        pContext.getDAOGroup().getNodeDAO().loadOurGrpcOptionList(pContext, network.getNodeList(), Collections.emptyMap());

        MapUtil.MapBuilder networkConfig = MapUtil
                .put("name", network.getName())
                .put("version", "1.0.0")
                .put("x-type", "hlfv1")
                .put("peers", initNodes(pContext, network, node -> node.getType().getId().equals(NodeType.PEER)).into_map())
                .put("orderers", initNodes(pContext, network, node -> node.getType().getId().equals(NodeType.ORDERER)).into_map())
                .put("organizations", initOrgs(pContext, network).into_map())
                .put("channels", initChannels(pContext, network).into_map());

        Gson gson = new Gson();
        ByteArrayInputStream bis = new ByteArrayInputStream(gson.toJson(networkConfig.into_map()).getBytes());
        return NetworkConfig.fromJsonStream(bis);
    }

    private static MapUtil.MapBuilder initChannels(HfgwUserContext pContext, HyperledgerNetwork pNetwork) throws Exception {
        pContext.getDAOGroup().getChannelDAO().loadOurNodeList(pContext, pNetwork.getChannelList(), Collections.emptyMap());
        pContext.getDAOGroup().getChannelDAO().loadOurChainCodeList(pContext, pNetwork.getChannelList(), Collections.emptyMap());
        pContext.getDAOGroup().getChannelDAO().loadOurChannelPeerRoleList(pContext, pNetwork.getChannelList(), Collections.emptyMap());
        MapUtil.MapBuilder builder = new MapUtil.MapBuilder();

        pNetwork.getChannelList().forEach(
                channel -> {
                    MapUtil.MapBuilder channelBuilder = new MapUtil.MapBuilder();

                    //chaincodes
                    List<String> chaincodes = new ArrayList<>();
                    channel.getChainCodeList().forEach(cc -> {
                        chaincodes.add(cc.getCodeName() + ":" + cc.getCodeVersion());
                    });
                    builder.put("chaincodes", chaincodes);

                    //orderers
                    List<String> orderers = new ArrayList<>();
                    channel.getNodeList().stream().filter(node -> node.getType().getId().equals(NodeType.ORDERER)).forEach(
                            node -> orderers.add(node.getName())
                    );
                    builder.put("orderers", orderers);


                    //peer, and its role
                    channel.getNodeList().stream().filter(node -> node.getType().getId().equals(NodeType.PEER)).forEach(
                            node -> {
                                MapUtil.MapBuilder peerBuilder = new MapUtil.MapBuilder();

                                channel.getChannelPeerRoleList().stream().filter(peerRole -> peerRole.getNode().getId().equals(node.getId())).forEach(
                                        peerRole -> {
                                            peerBuilder.put(peerRole.getPeerRole().getCode(), "true");
                                        }
                                );
                                builder.put(node.getName(), peerBuilder.into_map());
                            }
                    );

                    builder.put(channel.getName(), channelBuilder.into_map());
                }
        );

        return builder;
    }

    private static MapUtil.MapBuilder initOrgs(HfgwUserContext pContext, HyperledgerNetwork pNetwork) throws Exception {
        MapUtil.MapBuilder builder = new MapUtil.MapBuilder();
        pContext.getDAOGroup().getOrganizationDAO().loadOurNodeList(pContext, pNetwork.getOrganizationList(), Collections.emptyMap());

        pNetwork.getOrganizationList().forEach(org -> {
            MapUtil.MapBuilder orgBuilder = new MapUtil.MapBuilder();
            orgBuilder.put("mspid", org.getMspid());

            List<String> peerNames = new ArrayList<>();
            org.getNodeList().stream().filter(node -> node.getType().getId().endsWith(NodeType.PEER)).forEach(
                    node -> {
                        peerNames.add(node.getName());
                    }
            );
            orgBuilder.put("peers", peerNames);
            builder.put(org.getName(), orgBuilder.into_map());
        });
        return builder;
    }

    private static MapUtil.MapBuilder initNodes(HfgwUserContext pContext, HyperledgerNetwork pNetwork, Predicate<Node> filter) throws Exception {
        MapUtil.MapBuilder builder = new MapUtil.MapBuilder();
        pNetwork.getNodeList().stream().filter(filter).forEach(
                node -> {
                    MapUtil.MapBuilder nodeBuilder = MapUtil
                            .put("url", node.getUrl())
                            .put("tlsCACerts", MapUtil.put("pem", node.getTlsCacert()).into_map());
                    MapUtil.MapBuilder grpcBuilder = new MapUtil.MapBuilder();
                    node.getGrpcOptionList().forEach(grpc -> {
                        String name = grpc.getParameterName();
                        String value = grpc.getParameterValue();
                        grpcBuilder.put(name, value);
                    });

                    nodeBuilder.put("grpcOptions", grpcBuilder.into_map());
                    builder.put(node.getName(),
                            nodeBuilder.into_map());
                }
        );
        return builder;
    }

}
