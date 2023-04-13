package AES_Cryptography.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class Buyer extends Agent {

    @Override
    protected void setup() {

        PublicKey publicKey = (PublicKey) getArguments()[0];

        String message = "Hello seller";
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cryptedMsg = cipher.doFinal(message.getBytes());
            String encodedMsg = Base64.getEncoder().encodeToString(cryptedMsg);

            System.out.println(Arrays.toString(cryptedMsg));
            System.out.println(encodedMsg);

            ACLMessage msg = new ACLMessage(7);
            msg.addReceiver(new AID("seller", AID.ISLOCALNAME));
            msg.setContent(encodedMsg);

            send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
