package AES_Cryptography.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Base64;

public class Seller extends Agent {

    @Override
    protected void setup() {

        PrivateKey privateKey = (PrivateKey) getArguments()[0];

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receivedMsg = receive();
                if(receivedMsg != null ){

                    String encodedMsg = receivedMsg.getContent();
                    byte[] cryptedMsg = Base64.getDecoder().decode(encodedMsg);

                    try{

                        Cipher cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.DECRYPT_MODE, privateKey);
                        byte [] decryptedMsg = cipher.doFinal(cryptedMsg);
                        System.out.println(" Seller : "+Arrays.toString(decryptedMsg));
                        String encodedDMsg = Base64.getEncoder().encodeToString(decryptedMsg);
                        System.out.println(encodedDMsg);
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
