package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.CourseRegisSessionEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class CourseRegisSessionDAO {
    public static CourseRegisSessionEntity Get(int CourseRegisId) {
        CourseRegisSessionEntity courseRegisSessionEntity = null;
        try {
            Session session = HibernateUtil.GetSession();
            courseRegisSessionEntity = session.get(CourseRegisSessionEntity.class,CourseRegisId);
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return courseRegisSessionEntity;
    }

    public static List<CourseRegisSessionEntity> GetAll() {
        List<CourseRegisSessionEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from CourseRegisSessionEntity ");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Set<CourseEntity> GetCourseList(int courseRegisId) {
        Set<CourseEntity> list = null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            CourseRegisSessionEntity c = session.get(CourseRegisSessionEntity.class, courseRegisId);
            list = c.getCourseList();
            //unproxy this object
            list.size();
        }
        finally {
            assert session != null;
            session.close();
        }
        return list;
    }
    public static void Save(CourseRegisSessionEntity c) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Update(CourseRegisSessionEntity c) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(CourseRegisSessionEntity c) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
