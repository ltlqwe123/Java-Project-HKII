package model;

import javax.crypto.Cipher;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Base64;

public class CryptoRSA {
    private static PublicKey publicKey = null;

    public static void setPublicKey(PublicKey publicKey) {
        CryptoRSA.publicKey = publicKey;
    }

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public static void getPublicKeyToSever(Socket socket){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            setPublicKey((PublicKey) ois.readObject());
            if (publicKey == null){
                System.out.println("Public key is null");
            }else System.out.println("Get Public Key ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String encryptRSA(String data) {
        String result = null;
        try {
            Cipher cipherRSA = Cipher.getInstance("RSA");
            cipherRSA.init(Cipher.ENCRYPT_MODE, getPublicKey());

            byte[] encryptResult = cipherRSA.doFinal(data.getBytes());
            result = Base64.getEncoder().encodeToString(encryptResult);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
