package RSA_Cryptography;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRSAKeys {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair = CryptoUtils.generateRSAKeys();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String encodedPbK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String encodedPrK = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        System.out.println("PR key");
        System.out.println(encodedPrK);
        System.out.println("PR key");
        System.out.println(encodedPbK);

    }
}
