package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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
