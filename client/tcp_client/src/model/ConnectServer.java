package model;

import java.net.Socket;

public class ConnectServer {
    private static Socket socket;
    private static int port = 2202;
    private static String localhost = "localhost";
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static Socket getSocket() {
        try {
            socket = new Socket(localhost, port);
        }catch (Exception e){
            e.printStackTrace();
        }
        return socket;
    }

    public static String getLocalhost() {
        return localhost;
    }

    public static int getPort() {
        return port;
    }
}

