package qqsrx.spring.boot.minidouban.domain;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String gender;
    private Date registerDate;
    private boolean isAdmin;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
