package com.hibernate.pojo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class CourseRegisSessionEntity {
    private int courseRegisId;
    private String ngaybatdau;
    private String ngaykethuc;
    private SemesterEntity semester;
    private Set<CourseEntity> courseList;

    public CourseRegisSessionEntity() {
        courseList = new LinkedHashSet<>();
    }

    public CourseRegisSessionEntity(String ngaybatdau, String ngaykethuc,
                                    SemesterEntity semester, Set<CourseEntity> courseList) {
        this.ngaybatdau = ngaybatdau;
        this.ngaykethuc = ngaykethuc;
        this.semester = semester;
        this.courseList = courseList;
    }

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
        CourseRegisSessionEntity that = (CourseRegisSessionEntity) o;
        return courseRegisId == that.courseRegisId && Objects.equals(ngaybatdau, that.ngaybatdau) && Objects.equals(ngaykethuc, that.ngaykethuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseRegisId, ngaybatdau, ngaykethuc);
    }
}
