package RSA_Cryptography.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Client extends Agent {

    @Override
    protected void setup() {

        String encodedPbk = (String) getArguments()[0];

        String message = "Hello seller";
        try {
            byte [] decodedPbk = Base64.getDecoder().decode(encodedPbk);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedPbk));

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] cryptedMsg = cipher.doFinal(message.getBytes());
            String encodedMsg = Base64.getEncoder().encodeToString(cryptedMsg);

            System.out.println(Arrays.toString(cryptedMsg));
            System.out.println(encodedMsg);

            ACLMessage msg = new ACLMessage(7);
            msg.addReceiver(new AID("server", AID.ISLOCALNAME));
            msg.setContent(encodedMsg);

            send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
