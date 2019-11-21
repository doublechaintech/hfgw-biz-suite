package org.hyperledger.fabric.sdk.security;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.security.CryptoPrimitives;

import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;

public class CryptoSuiteImpl extends CryptoPrimitives {
    public CryptoSuiteImpl() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    }

    @Override
    public boolean verify(byte[] pemCertificate, String signatureAlgorithm, byte[] signature, byte[] plainText) throws CryptoException {
        signatureAlgorithm = (String) getField("DEFAULT_SIGNATURE_ALGORITHM");
        return super.verify(pemCertificate, signatureAlgorithm, signature, plainText);
    }


    public Object getField(String name){
        try {
            Field declaredField = CryptoPrimitives.class.getDeclaredField(name);
            declaredField.setAccessible(true);
            return declaredField.get(this);
        }catch (Exception e){
            return  null;
        }
    }


    @Override
    public byte[] sign(PrivateKey key, byte[] data) throws CryptoException {

        if (key instanceof ECPrivateKey){
            return super.sign(key, data);
        }

        return sign0(key, data);
    }

    public byte[] sign0(PrivateKey key, byte[] data) throws CryptoException {
        try {
            Signature sig = getField("SECURITY_PROVIDER") == null ? Signature.getInstance((String) getField("DEFAULT_SIGNATURE_ALGORITHM")) :
                    Signature.getInstance((String) getField("DEFAULT_SIGNATURE_ALGORITHM"), (Provider) getField("SECURITY_PROVIDER"));
            sig.initSign(key);
            sig.update(data);
            byte[] signature = sig.sign();
            return signature;
        }catch (Exception e){
            throw new CryptoException(e.getMessage());
        }
    }
}
