package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassEntity {
    private int classid;
    private int tongsinhvien;
    private int tongsinhvienNam;
    private int tongsinhvienNu;
    private Set<StudentEntity> studentList;

    public ClassEntity() {
        studentList = new HashSet<StudentEntity>();
    }


    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getTongsinhvien() {
        return tongsinhvien;
    }

    public void setTongsinhvien(int tongsinhvien) {
        this.tongsinhvien = tongsinhvien;
    }

    public int getTongsinhvienNam() {
        return tongsinhvienNam;
    }

    public void setTongsinhvienNam(int tongsinhvienNam) {
        this.tongsinhvienNam = tongsinhvienNam;
    }

    public int getTongsinhvienNu() {
        return tongsinhvienNu;
    }

    public void setTongsinhvienNu(int tongsinhvienNu) {
        this.tongsinhvienNu = tongsinhvienNu;
    }

    public Set<StudentEntity> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<StudentEntity> studentList) {
        this.studentList = studentList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassEntity that = (ClassEntity) o;
        return classid == that.classid && tongsinhvien == that.tongsinhvien && tongsinhvienNam == that.tongsinhvienNam && tongsinhvienNu == that.tongsinhvienNu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classid, tongsinhvien, tongsinhvienNam, tongsinhvienNu);
    }
}
