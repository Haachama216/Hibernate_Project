package com.hibernate.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

public class CourseEntity {
    private int courseid;
    private SubjectEntity subject;
    private String teacher;
    private String room;
    private String day;
    private String time;
    private int maxSlot;
    private CourseRegisSessionEntity courseRegis;
    private Set<StudentEntity> studentList;

    public CourseEntity() {
        studentList = new LinkedHashSet<>();
    }

    public CourseEntity(String teacher, String room, String day, String time, int maxSlot) {
        this.teacher = teacher;
        this.room = room;
        this.day = day;
        this.time = time;
        this.maxSlot = maxSlot;
    }

    public CourseEntity(SubjectEntity subject, String teacher, String room,
                        String day, String time, int maxSlot, Set<StudentEntity> studentList) {
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.day = day;
        this.time = time;
        this.maxSlot = maxSlot;
        this.studentList = studentList;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    public CourseRegisSessionEntity getCourseRegis() {
        return courseRegis;
    }

    public void setCourseRegis(CourseRegisSessionEntity courseRegis) {
        this.courseRegis = courseRegis;
    }

    public Set<StudentEntity> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<StudentEntity> studentList) {
        this.studentList = studentList;
    }
}
