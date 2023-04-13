package RSA_Cryptography.containers;

import RSA_Cryptography.CryptoUtils;
import RSA_Cryptography.GenerateRSAKeys;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class MainContainer {

    public static void main(String[] args) throws ControllerException, NoSuchAlgorithmException {

        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(profile.GUI, "true");
        AgentContainer agentContainer = runtime.createMainContainer(profile);
        agentContainer.start();

//        KeyPair keyPair = CryptoUtils.generateRSAKeys();
//        PrivateKey privateKey = keyPair.getPrivate();
//        PublicKey publicKey = keyPair.getPublic();
//        GenerateRSAKeys.encodedPbK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        GenerateRSAKeys.encodedPrK = Base64.getEncoder().encodeToString(privateKey.getEncoded());

    }
}
