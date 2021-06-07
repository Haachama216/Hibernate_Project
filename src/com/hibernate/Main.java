package com.hibernate;

import com.hibernate.gui.LoginGUI;
import com.hibernate.gui.TableTest;
import com.hibernate.pojo.Account;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.SubjectEntity;
import com.hibernate.pojo.ThongTinGiaoVu;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        Account acc = AccountDAO.GetAccount("MakiseEmi","winhung216");
//        ThongTinGiaoVu userinfo = new ThongTinGiaoVu("Phạm Quốc Hưng","Công Nghệ Thông Tin",
//                "0945875639","quchngp@gmail.com");
//        userinfo.setAccount(acc);
//        acc.setInfo(userinfo);
//        AccountDAO.UpdateAccount(acc);
//    	try {
//    		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                }
//            }
//    	}
//    	catch (Exception e) {
//    	    e.printStackTrace();
//        }
////        JFrame frame = new MainFrame();
////        frame.setVisible(true);
////    }
//        LoginGUI loginframe = new LoginGUI();
//        loginframe.setVisible(true);
//        Session session = HibernateUtil.GetSession();
//        SemesterEntity semester = new SemesterEntity("HK1","2020-2021","21/05","1/6");
//        Set<SubjectEntity> subjectList = new HashSet<SubjectEntity>();
//        subjectList.add(new SubjectEntity("DSA123","CTDL&GT",4,semester));
//        subjectList.add(new SubjectEntity("OOP345","LTHDT",4,semester));
//        subjectList.add(new SubjectEntity("DTB456","Database",4,semester));
//        semester.setSubjectSet(subjectList);
//        session.beginTransaction();
//        session.save(semester);
//        session.getTransaction().commit();

        try {
    		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HibernateUtil.BuildSessionFactory();
                LoginGUI frame = new LoginGUI();
                frame.setVisible(true);
            }
        });
    }
}
