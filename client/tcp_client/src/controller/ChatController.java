package controller;

import view.loginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatController implements ActionListener{
    private final loginView viewClient;
    public ChatController(loginView loginClient){
        this.viewClient = loginClient;
        getAcction();
    }
    public void getAcction(){
        viewClient.btn_login.addActionListener(this);
        viewClient.btn_register_register.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println("Command: " + src);
        if (src.equals("register")){
            viewClient.Register();
        }else if (src.equals("login")) {
            viewClient.Login();
        }
    }
}
