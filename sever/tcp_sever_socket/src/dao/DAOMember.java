package dao;

import jdbcutil.JDBCUtil;
import model.MemberO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOMember {
    private static String AESKEY = "iloveyou";

    public static ArrayList<MemberO> selectedAccount() {
        ArrayList<MemberO> listMember = new ArrayList<>();
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT\n" +
                    "    CONVERT(AES_DECRYPT(username, ?) USING utf8) AS username,\n" +
                    "    CONVERT(AES_DECRYPT(password, ?) USING utf8) AS password\n" +
                    "FROM chat_community.member;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, AESKEY);
            pst.setString(2, AESKEY);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                MemberO member = new MemberO(username, password);
                listMember.add(member);
            }
            JDBCUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMember;
    }
    public static void insert(MemberO member){
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "INSERT INTO chat_community.member (username, password) VALUES (" +
                    "AES_ENCRYPT(?, ?), AES_ENCRYPT(?, ?));";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, member.getUsername());
            pst.setString(2, AESKEY);
            pst.setString(3, member.getPassword());
            pst.setString(4, AESKEY);
            pst.executeUpdate();

            JDBCUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
