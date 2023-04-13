package RSA_Cryptography.containers;

import RSA_Cryptography.GenerateRSAKeys;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class ServerContainer {

    public static void main(String[] args) throws NoSuchAlgorithmException, StaleProxyException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(profile.MAIN_HOST, "localhost");
        AgentContainer container = runtime.createAgentContainer(profile);
        String encodedPbk = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAwLOGy+5Ot/8sy2ZJn+oP6o6c5IZm0Eb5WoEfgJfwxgp90qzXiZPxYxIs/JfqisXTqshV8fLJtic8iWXfb4oeuQIDAQABAkAw33dhEmQxo0zLm3oxzi3SOfBNv06lJVMJorUIKsD8oOze6+kv9Qb1DR5H7zIOiws5eewZ9V+mbvAGUVMW0AWHAiEA4vYkLD7WAAE4NkkW+X3r0/kzIlIb8CqatmJ0wN3NyrsCIQDZWztfsc6d2YWSivlv7wo5qGav7Qp1lz7E3TNfFcXnGwIhAJ8wQ5jhDdp9AH9a7olZ3+ISxOHKs5vVViSclAV+zUvnAiAdOABxSsvFuHoWSwxhGbc8LQEw4SKo0B4mBL5lJ94kxQIgM6TShXBDGBmbAhG4UdHIl8PigNgSFeFCGbqClN5cVv8=";

        AgentController server = container.createNewAgent("server", "RSA_Cryptography.agents.Server", new Object[]{
                encodedPbk
        });
        server.start();
    }
}
