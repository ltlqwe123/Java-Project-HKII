package model;

import java.io.Serializable;
import java.sql.Date;

public class MemberO implements Serializable {
    private String username;
    private String password;
    private String chatname;
    private String gender;
    private Date dayofbirth;
    private String create_acc;
    private String avatar;
    private String command;

    public MemberO(String username, String password, String command){
        this.username = username;
        this.password = password;
        this.command = command;
    }
    public MemberO(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setChatname(String chatname) {
        this.chatname = chatname;
    }

    public void setCreate_acc(String create_acc) {
        this.create_acc = create_acc;
    }

    public void setDayofbirth(Date dayofbirth) {
        this.dayofbirth = dayofbirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Date getDayofbirth() {
        return dayofbirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getChatname() {
        return chatname;
    }

    public String getCreate_acc() {
        return create_acc;
    }

    public String getGender() {
        return gender;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "MemberO{" +
                "username='" + username + '\n' +
                ", password='" + password + "}\n";
    }
}
