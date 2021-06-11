package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class StudentDAO {
    public static StudentEntity Get(int studentid) {
        StudentEntity student = null;
        try {
            Session session = HibernateUtil.GetSession();
            student = (StudentEntity) session.get(StudentEntity.class,studentid);
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static StudentEntity Get(String username, String password) {
        StudentEntity student = null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            Query query = session.createQuery("from StudentEntity " +
                    "where username = :username and password = :password");
            query.setParameter("username", username).setParameter("password", password);
            student = (StudentEntity) query.uniqueResult();
        }
        finally {
            assert session != null;
            session.close();
        }
        return student;
    }
    public static Set<CourseEntity> GetCourseList(int studentid) {
        Set<CourseEntity> list = null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            StudentEntity student = session.get(StudentEntity.class, studentid);
            list = student.getCourseList();
            //unproxy this project
            list.size();
        }
        finally {
            assert session != null;
            session.close();
        }
        return list;
    }
    public static List<StudentEntity> GetAll() {
        List<StudentEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from StudentEntity ");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void Save(StudentEntity student) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Update(StudentEntity student) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(StudentEntity student) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
