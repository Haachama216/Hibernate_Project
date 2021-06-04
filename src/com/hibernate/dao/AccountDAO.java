package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.pojo.Account;

import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

public class AccountDAO {
    public static void Insert(Account account) {
        try {
            Session session = HibernateUtil.GetSession();
            Transaction trans = session.beginTransaction();
            session.save(account);
            trans.commit();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static Account GetAccount(String username, String password) {
        Account account = null;
        try {
            Session session = HibernateUtil.GetSession();
            Query query = session.createQuery("select acc from Account acc " +
                    "where acc.username = :username and acc.password = :password");
            query.setParameter("username", username).setParameter("password", password);
            List<Account> list = query.getResultList();
            account = list.iterator().next();
            session.close();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        catch (NoSuchElementException e) {
            account = null;
        }
        return account;
    }
}
