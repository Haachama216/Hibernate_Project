package com.hibernate.pojo;

public class Account {
    private int AccountID;
    private String username;
    private String password;
    private ThongTinGiaoVu info;

    public Account() {}

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, ThongTinGiaoVu info) {
        this.username = username;
        this.password = password;
        this.info = info;
    }


    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public ThongTinGiaoVu getInfo() {
        return info;
    }

    public void setInfo(ThongTinGiaoVu info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Username: " + username +
                "\nPassword: " + password;
    }
}
