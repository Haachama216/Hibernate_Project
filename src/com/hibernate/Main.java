package com.hibernate;

import com.hibernate.dao.SubjectDAO;
import com.hibernate.gui.AddNewCourse;
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
