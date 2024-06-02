package model;

import java.net.ServerSocket;

public class SocketSeverM {
    private static ServerSocket serverSocket;
    public static ServerSocket newServerSocket() {
        try {
            serverSocket = new ServerSocket(SocketM.getPort()); // thì mỗi lần bật sever thì nó cũng tạo 1 severSocket mà
            System.out.println("Sever is running on the port " + SocketM.getPort());
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverSocket;
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }
}
