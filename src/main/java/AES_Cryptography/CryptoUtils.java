package AES_Cryptography;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {


    public static KeyPair generateRSAKeys() throws NoSuchAlgorithmException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(512);
        return generator.generateKeyPair();

    }
}
