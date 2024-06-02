package view;

import model.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class loginView extends JFrame {
    private JPanel contentPane, panel_forgetpassword;
    private JTextField txt_account, txt_register_account, txt_forget_account, txt_captcha;
    private JPasswordField passwordField, register_passwordField, register_passwordField2;
    private CardLayout cardLayout;
    public JButton btn_login;
    public JButton btn_register_register;
    private JPanel panel_right;
    private ObjectInputStream ois;
    private Socket socket;


    public loginView() {
        // SWING
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 675, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardLayout = new CardLayout();

        JPanel panel_left = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("C:/Users/THANH LOI/Pictures/anh-dep-2.jpg");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel_left.setBounds(0, 0, 330, 523);
        contentPane.add(panel_left);

        panel_right = new JPanel();
        panel_right.setBounds(330, 0, 330, 523);
        contentPane.add(panel_right);
        panel_right.setLayout(cardLayout);

        JPanel panel_login = new JPanel();
        panel_login.setBounds(10, 10, 310, 503);
        panel_right.add(panel_login, "panel_login");
        panel_login.setLayout(null);
        panel_login.setVisible(true);

        JPanel panel_login2 = new JPanel();
        panel_login2.setBounds(10, 10, 310, 503);
        panel_login2.setBorder(new LineBorder(new Color(70,70,70),1));
        panel_login2.setLayout(null);
        panel_login.add(panel_login2);

        passwordField = new JPasswordField();
        passwordField.setBounds(35, 238, 242, 32);
        panel_login2.add(passwordField);
        passwordField.setBorder(new LineBorder(new Color(150,150,150),1));

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setBounds(35, 205, 242, 32);
        panel_login2.add(lbl_password);
        lbl_password.setForeground(new Color(70,70,70));
        lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 15));

        txt_account = new JTextField();
        txt_account.setBounds(35, 155, 242, 32);
        txt_account.setColumns(10);
        txt_account.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txt_account.setBorder(new LineBorder(new Color(150,150,150), 1));
        panel_login2.add(txt_account);

        JLabel lbl_account = new JLabel("Account");
        lbl_account.setBounds(35, 121, 242, 32);
        panel_login2.add(lbl_account);
        lbl_account.setForeground(new Color(70,70,70));
        lbl_account.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lbl_login = new JLabel("Member Login");
        lbl_login.setBounds(0, 23, 305, 88);
        lbl_login.setForeground(new Color(70,70,70));
        panel_login2.add(lbl_login);
        lbl_login.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbl_login.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lbl_forgotPassword = new JLabel("Forgot password ?");
        lbl_forgotPassword.setForeground(new Color(70,70,70));
        lbl_forgotPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_forgotPassword.setBounds(35, 275, 242, 20);
        panel_login2.add(lbl_forgotPassword);
        lbl_forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_forgotPassword.setForeground(Color.BLUE);
                lbl_forgotPassword.setText("<html><u>Forgot password ?</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_forgotPassword.setText("Forgot password ?");
                lbl_forgotPassword.setForeground(new Color(70,70,70));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_forgetpassword");
                txt_forget_account.setText("");
                txt_captcha.setText("");
            }
        });

        btn_login = new JButton("Login");
        btn_login.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_login.setBounds(35, 328, 115, 45);
        panel_login2.add(btn_login);
        btn_login.setBackground(new Color(60,60,60));
        btn_login.setBorder(null);
        btn_login.setForeground(Color.white);
        btn_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_login.setActionCommand("login");

        JButton btn_register = new JButton("Register");
        btn_register.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_register.setBounds(162, 328, 115, 45);
        panel_login2.add(btn_register);
        btn_register.setBackground(new Color(60,60,60));
        btn_register.setForeground(Color.white);
        btn_register.setBorder(null);
        btn_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_register");
            }
        });

        JPanel panel_register = new JPanel();
        panel_register.setBounds(10, 10, 310, 503);
        panel_right.add(panel_register, "panel_register");
        panel_register.setLayout(null);
        panel_register.setVisible(false);

        JPanel panel_register2 = new JPanel();
        panel_register2.setBounds(10, 10, 310, 503);
        panel_register.add(panel_register2);
        panel_register2.setLayout(null);
        panel_register2.setBorder(new LineBorder(new Color(70,70,70), 1));

        JLabel lbl_register = new JLabel("Create account");
        lbl_register.setBounds(0, 23, 305, 88);
        panel_register2.add(lbl_register);
        lbl_register.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbl_register.setForeground(new Color(70,70,70));
        lbl_register.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lbl_register_account = new JLabel("Account");
        lbl_register_account.setBounds(35, 121, 242, 32);
        lbl_register_account.setForeground(new Color(70,70,70));
        lbl_register_account.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_register2.add(lbl_register_account);

        txt_register_account = new JTextField();
        txt_register_account.setBounds(35, 155, 242, 32);
        txt_register_account.setColumns(10);
        txt_register_account.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txt_register_account.setBorder(new LineBorder(new Color(150,150,150), 1));
        panel_register2.add(txt_register_account);

        register_passwordField = new JPasswordField();
        register_passwordField.setBounds(35, 238, 242, 32);
        panel_register2.add(register_passwordField);
        register_passwordField.setBorder(new LineBorder(new Color(150,150,150),1));

        JLabel lbl_register_password = new JLabel("Password");
        lbl_register_password.setBounds(35, 205, 242, 32);
        panel_register2.add(lbl_register_password);
        lbl_register_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_register_password.setForeground(new Color(70,70,70));

        register_passwordField2 = new JPasswordField();
        register_passwordField2.setBounds(35, 322, 242, 32);
        panel_register2.add(register_passwordField2);
        register_passwordField2.setBorder(new LineBorder(new Color(150,150,150),1));

        JLabel lbl_register_password2 = new JLabel("Re-Password");
        lbl_register_password2.setBounds(35, 288, 242, 32);
        panel_register2.add(lbl_register_password2);
        lbl_register_password2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_register_password2.setForeground(new Color(70,70,70));

        JButton btn_register_login = new JButton("Login");
        btn_register_login.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_register_login.setBounds(35, 400, 115, 45);
        panel_register2.add(btn_register_login);
        btn_register_login.setBackground(new Color(60,60,60));
        btn_register_login.setBorder(null);
        btn_register_login.setForeground(Color.white);
        btn_register_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_register_login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_login");
            }
        });

        JLabel lbl_registertologin = new JLabel("Login ?");
        lbl_registertologin.setBounds(35, 350, 242, 32);
        panel_register2.add(lbl_registertologin);
        lbl_registertologin.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lbl_registertologin.setForeground(new Color(70,70,70));
        lbl_registertologin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_registertologin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_login");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_registertologin.setForeground(Color.blue);
                lbl_registertologin.setText("<html><u>Login ?</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_registertologin.setForeground(new Color(70,70,70));
                lbl_registertologin.setText("Login ?");
            }
        });

        btn_register_register = new JButton("Register");
        btn_register_register.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_register_register.setBounds(162, 400, 115, 45);
        panel_register2.add(btn_register_register);
        btn_register_register.setBackground(new Color(60,60,60));
        btn_register_register.setForeground(Color.white);
        btn_register_register.setBorder(null);
        btn_register_register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_register_register.setActionCommand("register");

        panel_forgetpassword = new JPanel();
        panel_forgetpassword.setBounds(10, 10, 310, 503);
        panel_right.add(panel_forgetpassword, "panel_forgetpassword");
        panel_forgetpassword.setLayout(null);
        panel_forgetpassword.setVisible(false);

        JPanel panel_forgetpassword2 = new JPanel();
        panel_forgetpassword2.setBorder(new LineBorder(new Color(70,70,70),1));
        panel_forgetpassword2.setLayout(null);
        panel_forgetpassword2.setBounds(10, 10, 310, 503);
        panel_forgetpassword.add(panel_forgetpassword2);

        JLabel lbl_forgetpassword = new JLabel("Forget password");
        lbl_forgetpassword.setBounds(0, 23, 305, 88);
        panel_forgetpassword2.add(lbl_forgetpassword);
        lbl_forgetpassword.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbl_forgetpassword.setForeground(new Color(70,70,70));
        lbl_forgetpassword.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lbl_forget_account = new JLabel("Account");
        lbl_forget_account.setBounds(35, 121, 242, 32);
        lbl_forget_account.setForeground(new Color(70,70,70));
        lbl_forget_account.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_forgetpassword2.add(lbl_forget_account);

        txt_forget_account = new JTextField();
        txt_forget_account.setBounds(35, 155, 242, 32);
        txt_forget_account.setColumns(10);
        txt_forget_account.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txt_forget_account.setBorder(new LineBorder(new Color(150,150,150), 1));
        panel_forgetpassword2.add(txt_forget_account);

        txt_captcha = new JTextField();
        txt_captcha.setBounds(35, 238, 242, 32);
        panel_forgetpassword2.add(txt_captcha);
        txt_captcha.setBorder(new LineBorder(new Color(150,150,150),1));
        txt_captcha.setEditable(false);

        JLabel lbl_forget_password = new JLabel("Password");
        lbl_forget_password.setBounds(35, 205, 242, 32);
        panel_forgetpassword2.add(lbl_forget_password);
        lbl_forget_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl_forget_password.setForeground(new Color(70,70,70));

        JButton btn_forgetpassword = new JButton("Accept");
        btn_forgetpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_forgetpassword.setBounds(162, 330, 115, 45);
        panel_forgetpassword2.add(btn_forgetpassword);
        btn_forgetpassword.setBackground(new Color(60,60,60));
        btn_forgetpassword.setForeground(Color.white);
        btn_forgetpassword.setBorder(null);
        btn_forgetpassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton btn_forgetToLogin = new JButton("Back");
        btn_forgetToLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn_forgetToLogin.setBounds(35, 330, 115, 45);
        panel_forgetpassword2.add(btn_forgetToLogin);
        btn_forgetToLogin.setBackground(new Color(60,60,60));
        btn_forgetToLogin.setBorder(null);
        btn_forgetToLogin.setForeground(Color.white);
        btn_forgetToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_forgetToLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_login");
            }
        });

        JLabel lbl_forgetTologin = new JLabel("Create account ?");
        lbl_forgetTologin.setForeground(new Color(70,70,70));
        lbl_forgetTologin.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_forgetTologin.setBounds(35, 275, 242, 20);
        panel_forgetpassword2.add(lbl_forgetTologin);
        lbl_forgetTologin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_forgetTologin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(panel_right, "panel_register");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_forgetTologin.setText("<html><u>Create account ?</u></html>");
                lbl_forgetTologin.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_forgetTologin.setForeground(new Color(70,70,70));
                lbl_forgetTologin.setText("Create account ?");
            }
        });

        this.setVisible(true);
        ConnectSever();
    }
    public void ConnectSever(){
        // Connect to sever
       try{
           socket = ConnectServer.getSocket();
           System.out.println("socket: " + socket);
           CryptoRSA.getPublicKeyToSever(socket);
       }catch (Exception e){
           e.printStackTrace();
           JOptionPane.showConfirmDialog(this, "Disconnected to server",
                   "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
       }
    }
    public void Register(){
        String username = txt_register_account.getText();
        String password = new String(register_passwordField.getPassword());
        String password2 = new String(register_passwordField2.getPassword());
        String command = "register";

        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Username and password cannot be empty",
                    "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (checkLength(username) < 6 || checkLength(password) < 6 || checkLength(password2) < 6) {
            JOptionPane.showConfirmDialog(this, "Username and password must be at least 6 characters",
                    "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (!password.equals(password2)) {
            JOptionPane.showConfirmDialog(this, "Password and re-password must be the same",
                    "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (username.equals(password)) {
            JOptionPane.showConfirmDialog(this, "Username and password must not be the same",
                    "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String usernameEncrypt = CryptoRSA.encryptRSA(username);
        String passwordEncrypt = CryptoRSA.encryptRSA(password);
        MemberO member = new MemberO(usernameEncrypt, passwordEncrypt, command);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(member);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        // Check the response from the server
        String message;
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            message = dis.readUTF();
            System.out.println("Message: " + message);
            if (message.equals("fail")) {
                JOptionPane.showConfirmDialog(this, "Username already exists",
                        "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                clearText_register();
                return;
            }
            if (message.equals("successful")){
                clearText_register();
                JOptionPane.showConfirmDialog(this, "Register successful",
                        "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                cardLayout.show(panel_right, "panel_login");
                clearText_register();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void clearText_register(){
        txt_register_account.setText("");
        register_passwordField.setText("");
        register_passwordField2.setText("");
    }
    private int checkLength(String str){
        int count = 0;
        for (String t : str.split("")){
            if (!t.equals(" ") && !t.equals("\t")) count++;
        }
        return count;
    }
    public void Login(){
        String username = txt_account.getText();
        String password = new String(passwordField.getPassword());
        String command = "login";

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Username and password cannot be empty",
                    "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String usernameEncrypt = CryptoRSA.encryptRSA(username);
        String passwordEncrypt = CryptoRSA.encryptRSA(password);
        MemberO member = new MemberO(usernameEncrypt, passwordEncrypt, command);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(member);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        String message;
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            message = dis.readUTF();
            System.out.println("message: " + message);
            if (message.equals("login successful")) {
                JOptionPane.showConfirmDialog(this, "Login successful",
                        "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                txt_account.setText("");
                passwordField.setText("");
                this.setVisible(false);
                new chatView();
                return;
            }
            if (message.equals("login fail")) {
                JOptionPane.showConfirmDialog(this, "Username and password do not exist",
                        "Message", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                txt_account.setText("");
                passwordField.setText("");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
