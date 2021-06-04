package com.hibernate.pojo;

public class ThongTinGiaoVu {
    private int id;
    private String name;
    private String faculty;
    private String phoneNumber;
    private String email;
    private Account account;

    public ThongTinGiaoVu() {}

    public ThongTinGiaoVu(String name, String faculty, String phoneNumber, String email) {
        this.name = name;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ThongTinGiaoVu(String name, String faculty, String phoneNumber, String email, Account account) {
        this.name = name;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
