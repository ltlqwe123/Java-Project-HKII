package main;

import controller.ChatController;
import view.loginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            loginView viewClient = new loginView();
            new ChatController(viewClient);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
