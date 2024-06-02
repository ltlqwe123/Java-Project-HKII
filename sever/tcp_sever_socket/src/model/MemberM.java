package model;

import dao.DAOMember;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MemberM {
    private static DataOutputStream dos;

    public static void Register(Socket socket, MemberO member){
        boolean same = false;
        String username = CryptoRSA.DecryptRSA(member.getUsername());
        String password = CryptoRSA.DecryptRSA(member.getPassword());

        ArrayList<MemberO> listAccount = DAOMember.selectedAccount();
        for (MemberO m : listAccount) {
            if (m.getUsername().equals(username)) {
                same = true;
                break;
            }
        }
        String message;
        if (!same){
            MemberO newMember = new MemberO(username, password);
            DAOMember.insert(newMember);
            try {
                message = "successful";
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(message);
                dos.flush();
                System.out.println("Message: " + message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                message = "fail";
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(message);
                dos.flush();
                System.out.println("Message: " + message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void Login(Socket socket, MemberO member){
        boolean same = false;
        String username = CryptoRSA.DecryptRSA(member.getUsername());
        String password = CryptoRSA.DecryptRSA(member.getPassword());

        ArrayList<MemberO> listAccount = DAOMember.selectedAccount();
        for (MemberO m : listAccount) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
                same = true;
                break;
            }
        }

        try {
            if (same){
                System.out.println("login successful");
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("login successful");
                dos.flush();
            }else {
                System.out.println("login fail");
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("login fail");
                dos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
