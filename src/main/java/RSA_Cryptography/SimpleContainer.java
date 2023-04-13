package RSA_Cryptography;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class SimpleContainer {

    public static void main(String[] args) throws StaleProxyException, NoSuchAlgorithmException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(profile.MAIN_HOST, "localhost");
        AgentContainer container = runtime.createAgentContainer(profile);
        KeyPair keyPair = CryptoUtils.generateRSAKeys();

        AgentController seller = container.createNewAgent("seller", "RSA_Cryptography.agents.Seller", new Object[]{
                keyPair.getPrivate()
        });
        AgentController buyer = container.createNewAgent("buyer", "RSA_Cryptography.agents.Buyer", new Object[]{
                keyPair.getPublic()
        });
        buyer.start();
        seller.start();
    }
}
