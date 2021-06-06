package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.SemesterEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SemesterDAO {
    public static SemesterEntity Get(int semesterid) {
        SemesterEntity semester = null;
        try {
            Session session = HibernateUtil.GetSession();
            semester = (SemesterEntity) session.get(SemesterEntity.class,semesterid);
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return semester;
    }

    public static List<SemesterEntity> GetAll() {
        List<SemesterEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from SemesterEntity");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void Save(SemesterEntity semester) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(semester);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Update(SemesterEntity semester) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(semester);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(SemesterEntity semester) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(semester);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
