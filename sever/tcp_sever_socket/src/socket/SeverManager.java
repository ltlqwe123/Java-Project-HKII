package socket;

import model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SeverManager {
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    public SeverManager(){
        try {
            SocketSeverM.newServerSocket(); // new sever socket with port = 2202;
            // RSA
            CryptoRSA.createRSAKey(); // create public key & private key;
            while (true) {
                Socket socket = SocketM.getAccpet();// get accept from client;
                System.out.println(socket);
                if (socket.isConnected()){
                    Thread thread = new Thread(()->{
                        System.out.println("Open new thread...");
                        try {
                            CryptoRSA.sendPublicKey(socket); // send public key to sever;
                            MemberO member = null; // get object
                            try {
                                ois = new ObjectInputStream(socket.getInputStream());
                                member = (MemberO) ois.readObject();
                            }catch (Exception e){
                                throw new RuntimeException(e);
                            }

                            assert member != null;
                            String command = member.getCommand();
                            switch (command) {
                                case "register":
                                    MemberM.Register(socket, member);
                                    break;
                                case "login":
                                    MemberM.Login(socket, member);
                                    break;
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                    thread.start();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
