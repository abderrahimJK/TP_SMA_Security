# Security in Multi-Agent Systems

## Part I : message flow cryptography using RSA algorithm

In this part we have used an asymmetric algorithm to persuade we need to generate keys

This code generates a pair of RSA keys, then pass them to the corresponding agent
in Base64-encoded format.
```agsl
    KeyPair keyPair = CryptoUtils.generateRSAKeys();
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();

    String encodedPbK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
    String encodedPrK = Base64.getEncoder().encodeToString(privateKey.getEncoded());
```

![alt text](https://github.com/abderrahimJK/TP_SMA_Security/blob/main/src/main/resources/images/img.png)
### Client Agent

after Retrieve the encoded public key from the command-line arguments

    String encodedPbk = (String) getArguments()[0];

To simulate communication flow we defined a message to be sent (*Hello server*), them decode the public key from the Base64-encoded string.
next step is to Generate a PublicKey object from the decoded public key to encrypt the message using the public key.
finally send the message after encode the encrypted message in Base64 format with ACLMessage Object.

![alt text](https://github.com/abderrahimJK/TP_SMA_Security/blob/main/src/main/resources/images/img_1.png)

### Server Agent

the server agent is in listening mode to read any message came from client, but as we know the message is encrypted, so we need first to retrieve the private key from argument that we have passed to the server from the container

    String encodedPrk = (String) getArguments()[0];

Steps decrypt the message:

- Decode the encrypted message from the received ACL message
```agsl
    String encodedMsg = receivedMsg.getContent();
    byte[] cryptedMsg = Base64.getDecoder().decode(encodedMsg);
```
- Decode the private key from the Base64-encoded string
```agsl
    byte [] decodedPrk = Base64.getDecoder().decode(encodedPrk);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrk));
```
- Finally, decrypt the message using the private key:
```agsl
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    byte [] decryptedMsg = cipher.doFinal(cryptedMsg);
    System.out.println(new String(decryptedMsg));
```

![alt text](https://github.com/abderrahimJK/TP_SMA_Security/blob/main/src/main/resources/images/img_2.png)
## Part II : message flow cryptography using AES algorithm

