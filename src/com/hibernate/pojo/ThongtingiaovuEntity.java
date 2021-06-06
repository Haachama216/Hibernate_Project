package com.hibernate.pojo;

import java.util.Objects;

public class ThongtingiaovuEntity {
    private int id;
    private String name;
    private String faculty;
    private String email;
    private String phonenumber;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThongtingiaovuEntity that = (ThongtingiaovuEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(faculty, that.faculty) && Objects.equals(email, that.email) && Objects.equals(phonenumber, that.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, faculty, email, phonenumber);
    }
}
