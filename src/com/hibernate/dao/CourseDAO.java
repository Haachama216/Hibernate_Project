package com.hibernate.dao;

import com.hibernate.HibernateUtil;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.StudentEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class CourseDAO {
    public static CourseEntity Get(int courseid) {
        CourseEntity course = null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            course = session.get(CourseEntity.class,courseid);
            Hibernate.initialize(course.getSubject().getSubjectid());
            Hibernate.initialize(course.getCourseRegis().getCourseRegisId());
        }
        finally {
            assert session != null;
            session.close();
        }
        return course;
    }

    public static List<CourseEntity> GetAll() {
        List<CourseEntity> list;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            Query query = session.createQuery("from CourseEntity ");
            list = query.getResultList();
        }
        finally {
            assert session != null;
            session.close();
        }
        return list;
    }

    public static Set<StudentEntity> GetStudentList(int courseid) {
        Set<StudentEntity> list =  null;
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            CourseEntity course = session.get(CourseEntity.class,courseid);
            list = course.getStudentList();
            //unproxy this object
            list.size();
        }
        finally {
            assert session != null;
            session.close();
        }
        return list;
    }

    public static void Save(CourseEntity course) {
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
        }
    }

    public static void Update(CourseEntity course) {
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
        }
    }

    public static void Delete(CourseEntity course) {
        Session session = null;
        try {
            session = HibernateUtil.GetSession();
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
        }
    }
}
