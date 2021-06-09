package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.ClassEntity;
import com.hibernate.pojo.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class ClassDAO {
    public static ClassEntity Get(int classid) {
        ClassEntity classEntity = null;
        try {
            Session session = HibernateUtil.GetSession();
            classEntity = (ClassEntity) session.get(ClassEntity.class,classid);
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return classEntity;
    }

    public static Set<StudentEntity> GetStudentList(int classid) {
        Set<StudentEntity> list = null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            ClassEntity classEntity = session.get(ClassEntity.class, classid);
            list = classEntity.getStudentList();
            //unproxy this object
            list.size();
        }
        finally {
            assert session != null;
            session.close();
        }
        return list;
    }
    public static List<ClassEntity> GetAll() {
        List<ClassEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from ClassEntity ");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void Save(ClassEntity classEntity) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(classEntity);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Update(ClassEntity classEntity) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(classEntity);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(ClassEntity classEntity) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(classEntity);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
