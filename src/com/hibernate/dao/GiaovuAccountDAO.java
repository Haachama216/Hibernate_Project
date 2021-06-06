package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.GiaovuAccountEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GiaovuAccountDAO {
    public static GiaovuAccountEntity Get(String username, String password) {
        GiaovuAccountEntity account = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from GiaovuAccountEntity " +
                    "where username = :username and password = :password");
            query.setParameter("username", username).setParameter("password", password);

            account = (GiaovuAccountEntity) query.uniqueResult();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static List<GiaovuAccountEntity> GetAll() {
        List<GiaovuAccountEntity> list = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("from GiaovuAccountEntity");
            list = query.getResultList();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }
     public static void Save(GiaovuAccountEntity account) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
     }
     public static void Update(GiaovuAccountEntity account) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
     }
     public static void Delete(GiaovuAccountEntity account) {
        try {
            Session session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(account);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
     }
}
