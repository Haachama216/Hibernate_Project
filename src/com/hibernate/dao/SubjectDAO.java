package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.SubjectEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SubjectDAO {
    public static SubjectEntity Get(int subjectid) {
        SubjectEntity subject = null;
        try {
            Session session = HibernateUtil.GetSession();
            subject = (SubjectEntity) session.get(SubjectEntity.class,subjectid);
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public static List<SubjectEntity> GetAll() {
        List<SubjectEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from SubjectEntity ");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void Save(SubjectEntity subject) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Update(SubjectEntity subject) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(subject);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(SubjectEntity subject) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
