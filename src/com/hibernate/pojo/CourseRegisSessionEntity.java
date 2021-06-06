package com.hibernate.pojo;

import java.util.Objects;

public class CourseRegisSessionEntity {
    private int courseRegisId;
    private String ngaybatdau;
    private String ngaykethuc;
    private SemesterEntity semester;
    public int getCourseRegisId() {
        return courseRegisId;
    }

    public void setCourseRegisId(int courseRegisId) {
        this.courseRegisId = courseRegisId;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgaykethuc() {
        return ngaykethuc;
    }

    public void setNgaykethuc(String ngaykethuc) {
        this.ngaykethuc = ngaykethuc;
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
        CourseRegisSessionEntity that = (CourseRegisSessionEntity) o;
        return courseRegisId == that.courseRegisId && Objects.equals(ngaybatdau, that.ngaybatdau) && Objects.equals(ngaykethuc, that.ngaykethuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegisId, ngaybatdau, ngaykethuc);
    }
}
