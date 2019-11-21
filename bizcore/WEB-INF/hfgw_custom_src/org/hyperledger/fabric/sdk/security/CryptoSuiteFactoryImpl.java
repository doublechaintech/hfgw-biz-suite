package org.hyperledger.fabric.sdk.security;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.helper.Config;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class CryptoSuiteFactoryImpl implements CryptoSuiteFactory {
    private static final Config config = Config.getConfig();
    private static final int SECURITY_LEVEL = config.getSecurityLevel();
    private static final String HASH_ALGORITHM = config.getHashAlgorithm();

    private CryptoSuiteFactoryImpl() {

    }

    private static final CryptoSuiteFactoryImpl INSTANCE = new CryptoSuiteFactoryImpl();
    public static synchronized CryptoSuiteFactoryImpl instance() {
        return INSTANCE;
    }

    private static final Map<Properties, CryptoSuite> cache = new ConcurrentHashMap<>();

    @Override
    public CryptoSuite getCryptoSuite(Properties properties) throws CryptoException, InvalidArgumentException {

        CryptoSuite ret = cache.get(properties);
        if (ret == null) {
            try {
                CryptoPrimitives cp = new CryptoSuiteImpl();
                cp.setProperties(properties);
                cp.init();
                ret = cp;
            } catch (Exception e) {
                throw new CryptoException(e.getMessage(), e);
            }

            cache.put(properties, ret);

        }

        return ret;

    }

    @Override
    public CryptoSuite getCryptoSuite() throws CryptoException, InvalidArgumentException {

        Properties properties = new Properties();
        properties.put(Config.SECURITY_LEVEL, SECURITY_LEVEL);
        properties.put(Config.HASH_ALGORITHM, HASH_ALGORITHM);

        return getCryptoSuite(properties);
    }
}
