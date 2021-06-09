package com.hibernate.pojo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StudentEntity {
    private int studentid;
    private String username;
    private String password;
    private String tenhs;
    private String gioitinh;
    private ClassEntity classEntity;
    private Set<CourseEntity> courseList;

    public StudentEntity() {
        courseList = new LinkedHashSet<>();
    }

    public StudentEntity(String username, String password, String tenhs, String gioitinh, ClassEntity classEntity) {
        this.username = username;
        this.password = password;
        this.tenhs = tenhs;
        this.gioitinh = gioitinh;
        this.classEntity = classEntity;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
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

    public String getTenhs() {
        return tenhs;
    }

    public void setTenhs(String tenhs) {
        this.tenhs = tenhs;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public Set<CourseEntity> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<CourseEntity> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return studentid == that.studentid && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(tenhs, that.tenhs) && Objects.equals(gioitinh, that.gioitinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, username, password, tenhs, gioitinh);
    }
}
