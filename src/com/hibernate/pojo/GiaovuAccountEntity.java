package com.hibernate.pojo;

import java.util.Objects;

public class GiaovuAccountEntity {
    private int giaovuid;
    private String username;
    private String password;
    private String name;
    private String faculty;
    private String sex;
    private String phonenumber;
    private String email;

    public GiaovuAccountEntity() {}

    public GiaovuAccountEntity(int giaovuid, String username, String password, String name,
                               String faculty, String sex, String phonenumber, String email) {
        this.giaovuid = giaovuid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.faculty = faculty;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public GiaovuAccountEntity(Object[] data) {
        this.giaovuid = (int) data[0];
        this.username = data[1].toString();
        this.password = data[2].toString();
        this.name = data[3].toString();
        this.faculty = data[4].toString();
        this.sex = data[5].toString();
        this.phonenumber = data[6].toString();
        this.email = data[7].toString();
    }
    public int getGiaovuid() {
        return giaovuid;
    }

    public void setGiaovuid(int giaovuid) {
        this.giaovuid = giaovuid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovuAccountEntity that = (GiaovuAccountEntity) o;
        return giaovuid == that.giaovuid && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(name, that.name) && Objects.equals(faculty, that.faculty) && Objects.equals(sex, that.sex) && Objects.equals(phonenumber, that.phonenumber) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giaovuid, username, password, name, faculty, sex, phonenumber, email);
    }
}
