package fabric;

import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.TransactionEventException;
import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric.sdk.security.CryptoSuiteFactoryImpl;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.hyperledger.fabric.sdk.helper.Config.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setProperty(DEFAULT_CRYPTO_SUITE_FACTORY,  CryptoSuiteFactoryImpl.class.getName());
        HFClient client = HFClient.createNewInstance();
        Properties p = new Properties();
        p.setProperty(ASYMMETRIC_KEY_TYPE, "RSA");
        p.setProperty(SIGNATURE_ALGORITHM, "sha256WithRSA");
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite(p));

        final Reader pemReader = new FileReader("/Users/jackytian/git/hyperledger-fabric/data/skynet/users/skynet-client/msp/keystore/skynet-client.key");
        final PEMKeyPair pemPair ;
        try (PEMParser pemParser = new PEMParser(pemReader)) {
            pemPair = (PEMKeyPair) pemParser.readObject();
        }

        File certFile = new File("/Users/jackytian/git/hyperledger-fabric/data/skynet/users/skynet-client/msp/signcerts/skynet-client.pem");
        String cert = Files.lines(certFile.toPath()).collect(Collectors.joining("\n"));

        client.setUserContext(new User() {
            @Override
            public String getName() {
                return "skynet-client";
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
//                return null;
                try {
                    return new X509Enrollment(new JcaPEMKeyConverter().getPrivateKey(pemPair.getPrivateKeyInfo()), cert);
                } catch (PEMException pE) {
                    pE.printStackTrace();
                }
                return null;
            }

            @Override
            public String getMspId() {
                return "skynet";
            }
        } );

        NetworkConfig config = NetworkConfig.fromJsonFile(new File("/Users/jackytian/git/fabric-sdk-java/src/test/fixture/sdkintegration/network_configs/network-config.json"));


        Channel channel = client.loadChannelFromConfig("mytestchannel", config);
        final ChaincodeID chaincodeID = ChaincodeID.newBuilder().setName("sacc")
                .setVersion("1").build();


        channel.initialize();

        TransactionProposalRequest setRequest = (TransactionProposalRequest) client.newTransactionProposalRequest().setFcn("set").setArgs("mytestKey1", "hello world");
        setRequest.setChaincodeID(chaincodeID);

        Collection<ProposalResponse> transactionPropResp = channel.sendTransactionProposalToEndorsers(setRequest, new Channel.DiscoveryOptions());

        for (ProposalResponse response : transactionPropResp) {
            if (response.getStatus() != ProposalResponse.Status.SUCCESS || !response.isVerified()) {
                throw new Exception("Failed status bad endorsement");
            }
        }



        channel.sendTransaction(transactionPropResp).exceptionally(e -> {
            if (e instanceof TransactionEventException) {
                BlockEvent.TransactionEvent te = ((TransactionEventException) e).getTransactionEvent();
                if (te != null) {
                    throw new AssertionError(format("Transaction with txid %s failed. %s", te.getTransactionID(), e.getMessage()), e);
                }
            }

            throw new AssertionError(format("failed with %s exception %s", e.getClass().getName(), e.getMessage()), e);

        }).get(120 , TimeUnit.SECONDS);

        QueryByChaincodeRequest transactionRequest = (QueryByChaincodeRequest) client.newQueryProposalRequest().setFcn("get").setArgs("mytestKey");
        transactionRequest.setChaincodeID(chaincodeID);

        System.out.println(channel.queryByChaincode(transactionRequest).iterator().next().getProposalResponse().getPayload().toStringUtf8());

    }
}
