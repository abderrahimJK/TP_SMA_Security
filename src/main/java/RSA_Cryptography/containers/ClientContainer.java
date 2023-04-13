package RSA_Cryptography.containers;

import RSA_Cryptography.CryptoUtils;
import RSA_Cryptography.GenerateRSAKeys;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class ClientContainer {

    public static void main(String[] args) throws StaleProxyException, NoSuchAlgorithmException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(profile.MAIN_HOST, "localhost");
        AgentContainer container = runtime.createAgentContainer(profile);
        String encodedPbk = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMCzhsvuTrf/LMtmSZ/qD+qOnOSGZtBG+VqBH4CX8MYKfdKs14mT8WMSLPyX6orF06rIVfHyybYnPIll32+KHrkCAwEAAQ==";

        AgentController client = container.createNewAgent("client", "RSA_Cryptography.agents.Client", new Object[]{
                encodedPbk
        });
        client.start();
    }
}
