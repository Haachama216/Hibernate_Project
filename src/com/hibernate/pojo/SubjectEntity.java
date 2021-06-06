package com.hibernate.pojo;

import java.util.Objects;

public class SubjectEntity {
    private int subjectid;
    private  String mamh;
    private String tenmh;
    private int sotinchi;
    private SemesterEntity semester;

    public SubjectEntity() {}

    public SubjectEntity(String mamh, String tenmh, int sotinchi) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotinchi = sotinchi;
    }

    public SubjectEntity(String mamh, String tenmh, int sotinchi, SemesterEntity semester) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotinchi = sotinchi;
        this.semester = semester;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public int getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }

    public SemesterEntity getSemester() {
        return semester;
    }

    public void setSemester(SemesterEntity semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return subjectid == that.subjectid && sotinchi == that.sotinchi && Objects.equals(tenmh, that.tenmh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, tenmh, sotinchi);
    }

}
