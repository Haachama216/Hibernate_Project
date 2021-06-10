package com.hibernate.pojo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ClassEntity {
    private int classid;
    private String classname;
    private int tongsinhvien;
    private int tongsinhvienNam;
    private int tongsinhvienNu;
    private Set<StudentEntity> studentList;

    public ClassEntity() {
        studentList = new LinkedHashSet<StudentEntity>();
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getTongsinhvien() {
        tongsinhvien = studentList.size();
        return tongsinhvien;
    }

    public void setTongsinhvien(int tongsinhvien) {
        this.tongsinhvien = tongsinhvien;
    }

    public int getTongsinhvienNam() {
        tongsinhvienNam = 0;
        for (StudentEntity student : studentList) {
            if (student.getGioitinh().equals("Male"))
                ++tongsinhvienNam;
        }
        return tongsinhvienNam;
    }

    public void setTongsinhvienNam(int tongsinhvienNam) {
        this.tongsinhvienNam = tongsinhvienNam;
    }

    public int getTongsinhvienNu() {
        tongsinhvienNu = 0;
        for (StudentEntity student : studentList) {
            if (student.getGioitinh().equals("Female"))
                ++tongsinhvienNu;
        }
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
