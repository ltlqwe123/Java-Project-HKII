package model;

import javax.crypto.Cipher;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class CryptoRSA {
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static ObjectOutputStream oos;
    public static void createRSAKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void sendPublicKey(Socket socket){
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(getPublicKey());
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        CryptoRSA.privateKey = privateKey;
    }

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        CryptoRSA.publicKey = publicKey;
    }

    public static String DecryptRSA(String data){
        String result = null;
        try {
            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.DECRYPT_MODE, getPrivateKey());

            byte[] bytes = cipherRSA.doFinal(Base64.getDecoder().decode(data));

            result = new String(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
