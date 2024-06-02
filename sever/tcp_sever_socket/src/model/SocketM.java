package model;

import java.io.IOException;
import java.net.*;

public class SocketM {
    private static Socket socket;
    private static int port = 2202;

    public static Socket getAccpet() {
        try {
            socket = SocketSeverM.getServerSocket().accept();
            System.out.println("Client is connected to sever...");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return socket;
    }
    public static void close(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPort() {
        return port;
    }

    public static Socket getSocket() {
        return socket;
    }
}
