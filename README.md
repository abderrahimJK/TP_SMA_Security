# Security in Multi-Agent Systems

## Part I : message flow cryptography using RSA algorithm

In this part we have used an asymmetric algorithm to persuade we need to generate publ

This code generates a pair of RSA keys, then pass them to the corresponding agent
in Base64-encoded format.

        KeyPair keyPair = CryptoUtils.generateRSAKeys();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String encodedPbK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String encodedPrK = Base64.getEncoder().encodeToString(privateKey.getEncoded());

![alt text](https://github.com/abderrahimJK/TP_SMA_Security/blob/main/src/main/resources/images/img.png)

## Part II : message flow cryptography using AES algorithm

