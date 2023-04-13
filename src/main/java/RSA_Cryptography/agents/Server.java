package RSA_Cryptography.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.XECPrivateKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Server extends Agent {

    @Override
    protected void setup() {

        String encodedPrk = (String) getArguments()[0];

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receivedMsg = receive();
                if(receivedMsg != null ){

                    String encodedMsg = receivedMsg.getContent();
                    byte[] cryptedMsg = Base64.getDecoder().decode(encodedMsg);

                    try{
                        byte [] decodedPrk = Base64.getDecoder().decode(encodedPrk);
                        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrk));
                        Cipher cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.DECRYPT_MODE, privateKey);
                        byte [] decryptedMsg = cipher.doFinal(cryptedMsg);
                        System.out.println(new String(decryptedMsg));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    block();
                }
            }
        });
    }
}
