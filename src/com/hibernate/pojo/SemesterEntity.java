package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SemesterEntity {

    private int hk_id;
    private String tenhk;
    private String namhoc;
    private String ngaybatdau;
    private String ngayketthuc;
    private Set<SubjectEntity> subjectSet;
    private CourseRegisSessionEntity courseRegisSessionEntity;
    public SemesterEntity() {
        subjectSet = new HashSet<SubjectEntity>();
    }

    public SemesterEntity(String tenhk, String namhoc, String ngaybatdau, String ngayketthuc) {
        this.tenhk = tenhk;
        this.namhoc = namhoc;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public SemesterEntity(Object[] data) {
        this.hk_id = (int) data[0];
        this.tenhk = data[1].toString();
        this.namhoc = data[2].toString();
        this.ngaybatdau = data[3].toString();
        this.ngayketthuc = data[4].toString();
    }

    public int getHk_id() {
        return hk_id;
    }

    public void setHk_id(int hk_id) {
        this.hk_id = hk_id;
    }
    public String getTenhk() {
        return tenhk;
    }

    public void setTenhk(String tenhk) {
        this.tenhk = tenhk;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public Set<SubjectEntity> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<SubjectEntity> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public CourseRegisSessionEntity getCourseRegisSessionEntity() {
        return courseRegisSessionEntity;
    }

    public void setCourseRegisSessionEntity(CourseRegisSessionEntity courseRegisSessionEntity) {
        this.courseRegisSessionEntity = courseRegisSessionEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterEntity that = (SemesterEntity) o;
        return hk_id == that.hk_id && Objects.equals(tenhk, that.tenhk) && Objects.equals(namhoc, that.namhoc) && Objects.equals(ngaybatdau, that.ngaybatdau) && Objects.equals(ngayketthuc, that.ngayketthuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hk_id, tenhk, namhoc, ngaybatdau, ngayketthuc);
    }
}
