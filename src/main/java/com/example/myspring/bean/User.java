package com.example.myspring.bean;

public class User {
    private String userid;
    private String username;
    private String address;

    public User(String userid, String username, String address) {
        this.userid = userid;
        this.username = username;
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String password) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

