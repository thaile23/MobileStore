package com.example.mobilestore.Model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long userID;

    @Column(nullable = false, length = 30, name = "username")
    private String userName;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, name = "user_type")
    private Integer userType;

    public User(Long userID, String userName, String Password, Integer userType) {
        this.userID = userID;
        this.userName = userName;
        this.password = Password;
        this.userType = userType;
    }

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + userID +
                ", Username='" + userName + '\'' +
                ", Password='" + password + '\'' +
                ", TypeOfUserID='" + userType + '\'' +
                '}';
    }
}
