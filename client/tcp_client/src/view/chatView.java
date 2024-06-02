package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class chatView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_timkiem;
    private JTextField txt_chat;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    chatView frame = new chatView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public chatView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 675, 558);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_left = new JPanel();
        panel_left.setBackground(new Color(240, 240, 240));
        panel_left.setBorder(null);
        panel_left.setBounds(0, 0, 250, 520);
        contentPane.add(panel_left);
        panel_left.setLayout(null);

        JLabel lbl_doanchat_panel = new JLabel("Đoạn chat");
        lbl_doanchat_panel.setForeground(new Color(128, 128, 128));
        lbl_doanchat_panel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbl_doanchat_panel.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_doanchat_panel.setBounds(10, 5, 230, 30);
        panel_left.add(lbl_doanchat_panel);

        txt_timkiem = new JTextField();
        txt_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txt_timkiem.setForeground(new Color(126, 126, 126));
        txt_timkiem.setText("Tìm kiếm");
        txt_timkiem.setBounds(10, 40, 230, 30);
        panel_left.add(txt_timkiem);
        txt_timkiem.setColumns(10);

        JPanel panel_change_form = new JPanel();
        panel_change_form.setBounds(10, 80, 230, 59);
        panel_left.add(panel_change_form);
        panel_change_form.setLayout(null);

        JLabel lbl_picFriend = new JLabel("Pic Friend");
        lbl_picFriend.setBounds(10, 10, 101, 39);
        panel_change_form.add(lbl_picFriend);

        JLabel lbl_pciGroup = new JLabel("Pic Group");
        lbl_pciGroup.setBounds(121, 10, 99, 39);
        panel_change_form.add(lbl_pciGroup);

        JPanel panel_friend = new JPanel();
        panel_friend.setBorder(new LineBorder(new Color(0, 64, 0)));
        panel_friend.setBounds(10, 149, 230, 361);
        panel_left.add(panel_friend);
        panel_friend.setLayout(null);

        JPanel panel_group = new JPanel();
        panel_group.setBorder(new LineBorder(new Color(255, 0, 0)));
        panel_group.setBounds(10, 149, 230, 361);
        panel_left.add(panel_group);

        JPanel panel_chat = new JPanel();
        panel_chat.setBackground(new Color(255, 255, 255));
        panel_chat.setBorder(null);
        panel_chat.setBounds(255, 0, 405, 520);
        contentPane.add(panel_chat);
        panel_chat.setLayout(null);

        JPanel panel_chat_top = new JPanel();
        panel_chat_top.setBounds(0, 0, 405, 74);
        panel_chat.add(panel_chat_top);
        panel_chat_top.setLayout(null);

        JPanel panel_chatmiddle = new JPanel();
        panel_chatmiddle.setBackground(new Color(255, 255, 255));
        panel_chatmiddle.setBounds(0, 84, 405, 253);
        panel_chat.add(panel_chatmiddle);

        JPanel panel_chatbot = new JPanel();
        panel_chatbot.setBounds(0, 384, 405, 136);
        panel_chat.add(panel_chatbot);
        panel_chatbot.setLayout(null);

        txt_chat = new JTextField();
        txt_chat.setBounds(0, 347, 310, 33);
        panel_chat.add(txt_chat);
        txt_chat.setColumns(10);

        JButton btn_send = new JButton("New button");
        btn_send.setBounds(315, 347, 85, 33);
        panel_chat.add(btn_send);

        setVisible(true);
    }
}
