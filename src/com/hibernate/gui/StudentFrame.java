package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.HibernateUtil;
import com.hibernate.dao.CourseDAO;
import com.hibernate.dao.CourseRegisSessionDAO;
import com.hibernate.dao.StudentDAO;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.CourseRegisSessionEntity;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.StudentEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StudentFrame extends JFrame {
	private SemesterEntity setSemester;
	private StudentEntity loggedAccount;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField mssvField;
	private JTextField classField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable courseTable;
	private JTable registeredCoursesTable;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public StudentFrame(SemesterEntity setSemester,StudentEntity loggedAccount) {
		this.setSemester = setSemester;
		this.loggedAccount = loggedAccount;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1163, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel westPane = new JPanel();
		contentPane.add(westPane, BorderLayout.WEST);
		GridBagLayout gbl_westPane = new GridBagLayout();
		gbl_westPane.columnWidths = new int[]{0, 0};
		gbl_westPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_westPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_westPane.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		westPane.setLayout(gbl_westPane);
		
		JPanel studentInfoPane = new JPanel();
		studentInfoPane.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		GridBagConstraints gbc_studentInfoPane = new GridBagConstraints();
		gbc_studentInfoPane.insets = new Insets(0, 0, 5, 0);
		gbc_studentInfoPane.fill = GridBagConstraints.BOTH;
		gbc_studentInfoPane.gridx = 0;
		gbc_studentInfoPane.gridy = 0;
		westPane.add(studentInfoPane, gbc_studentInfoPane);
		GridBagLayout gbl_studentInfoPane = new GridBagLayout();
		gbl_studentInfoPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_studentInfoPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_studentInfoPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_studentInfoPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		studentInfoPane.setLayout(gbl_studentInfoPane);
		
		JLabel mssv = new JLabel("MSSV");
		mssv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_mssv = new GridBagConstraints();
		gbc_mssv.anchor = GridBagConstraints.EAST;
		gbc_mssv.insets = new Insets(20, 10, 10, 5);
		gbc_mssv.gridx = 0;
		gbc_mssv.gridy = 0;
		studentInfoPane.add(mssv, gbc_mssv);
		
		mssvField = new JTextField();
		mssvField.setText(loggedAccount.getMssv());
		mssvField.setEditable(false);
		mssvField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_mssvField = new GridBagConstraints();
		gbc_mssvField.anchor = GridBagConstraints.WEST;
		gbc_mssvField.gridwidth = 2;
		gbc_mssvField.insets = new Insets(20, 10, 10, 10);
		gbc_mssvField.gridx = 1;
		gbc_mssvField.gridy = 0;
		studentInfoPane.add(mssvField, gbc_mssvField);
		mssvField.setColumns(15);
		
		JLabel studentName = new JLabel("H\u1ECD T\u00EAn");
		studentName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_studentName = new GridBagConstraints();
		gbc_studentName.anchor = GridBagConstraints.EAST;
		gbc_studentName.insets = new Insets(10, 10, 10, 5);
		gbc_studentName.gridx = 0;
		gbc_studentName.gridy = 1;
		studentInfoPane.add(studentName, gbc_studentName);
		
		nameField = new JTextField();
		nameField.setText(loggedAccount.getTenhs());
		nameField.setEditable(false);
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.WEST;
		gbc_nameField.gridwidth = 2;
		gbc_nameField.insets = new Insets(10, 10, 10, 10);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		studentInfoPane.add(nameField, gbc_nameField);
		nameField.setColumns(15);
		
		JLabel gender = new JLabel("Gi\u1EDBi t\u00EDnh");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.anchor = GridBagConstraints.EAST;
		gbc_gender.insets = new Insets(20, 5, 10, 5);
		gbc_gender.gridx = 0;
		gbc_gender.gridy = 2;
		studentInfoPane.add(gender, gbc_gender);
		
		JRadioButton maleRButton = new JRadioButton("Male");
		buttonGroup.add(maleRButton);
		GridBagConstraints gbc_maleRButton = new GridBagConstraints();
		gbc_maleRButton.anchor = GridBagConstraints.WEST;
		gbc_maleRButton.insets = new Insets(20, 25, 10, 5);
		gbc_maleRButton.gridx = 1;
		gbc_maleRButton.gridy = 2;
		studentInfoPane.add(maleRButton, gbc_maleRButton);
		
		JRadioButton femaleRButton = new JRadioButton("Female");
		buttonGroup.add(femaleRButton);
		GridBagConstraints gbc_femaleRButton = new GridBagConstraints();
		gbc_femaleRButton.insets = new Insets(20, 0, 10, 0);
		gbc_femaleRButton.gridx = 2;
		gbc_femaleRButton.gridy = 2;
		studentInfoPane.add(femaleRButton, gbc_femaleRButton);
		buttonGroup.setSelected(switch(loggedAccount.getGioitinh()) {
					case "Male" -> maleRButton.getModel();
					case "Female" -> femaleRButton.getModel();
					default -> null;
				},
					true
		);

		JLabel classLabel = new JLabel("L\u1EDBp");
		classLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_classLabel = new GridBagConstraints();
		gbc_classLabel.anchor = GridBagConstraints.EAST;
		gbc_classLabel.insets = new Insets(20, 5, 5, 5);
		gbc_classLabel.gridx = 0;
		gbc_classLabel.gridy = 3;
		studentInfoPane.add(classLabel, gbc_classLabel);
		
		classField = new JTextField();
		classField.setText(loggedAccount.getClassEntity().getClassname());
		classField.setEditable(false);
		GridBagConstraints gbc_classField = new GridBagConstraints();
		gbc_classField.anchor = GridBagConstraints.WEST;
		gbc_classField.gridwidth = 2;
		gbc_classField.insets = new Insets(20, 10, 5, 0);
		gbc_classField.gridx = 1;
		gbc_classField.gridy = 3;
		studentInfoPane.add(classField, gbc_classField);
		classField.setColumns(10);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_logout = new GridBagConstraints();
		gbc_logout.fill = GridBagConstraints.HORIZONTAL;
		gbc_logout.insets = new Insets(0, 0, 5, 5);
		gbc_logout.gridx = 1;
		gbc_logout.gridy = 5;
		studentInfoPane.add(logout, gbc_logout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel courseList = new JPanel();
		tabbedPane.addTab("Danh s\u00E1ch c\u00E1c h\u1ECDc ph\u1EA7n", null, courseList, null);
		GridBagLayout gbl_courseList = new GridBagLayout();
		gbl_courseList.columnWidths = new int[]{0, 0};
		gbl_courseList.rowHeights = new int[]{0, 0, 0};
		gbl_courseList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_courseList.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		courseList.setLayout(gbl_courseList);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		courseList.add(scrollPane, gbc_scrollPane);


		//course table data
		courseTable = new JTable();
		courseTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"id", "Subject code", "Subject name", "Credits", "Teacher", "Room", "Day", "Time", "Slot", ""
			}
		) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Object obj = getValueAt(0,columnIndex);
				if (obj == null)
					return Object.class;
				return obj.getClass();
			}
		});
		LoadCourseData();
		scrollPane.setViewportView(courseTable);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.TRAILING);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		courseList.add(panel_1, gbc_panel_1);
		
		JButton RegisterButton = new JButton("\u0110\u0103ng k\u00FD");
		RegisterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel courseModel = (DefaultTableModel) courseTable.getModel();
				DefaultTableModel registeredCourseModel = (DefaultTableModel) registeredCoursesTable.getModel();
				CourseEntity course = null;
				Set<CourseEntity> list = StudentDAO.GetCourseList(loggedAccount.getStudentid());
				for (int i = 0; i < courseModel.getRowCount(); ++i) {
					if ((Boolean) courseModel.getValueAt(i,9) == true) {
						course = CourseDAO.Get((int) courseModel.getValueAt(i,0));
						if (list.size() == 8) {
							JOptionPane.showMessageDialog(null,"Đăng ký quá môn cho phép",
									"Register error",JOptionPane.ERROR_MESSAGE);
							break;
						}
						list.add(course);
						registeredCourseModel.addRow(new Object[]{
								course.getCourseid(), course.getSubject().getMamh(),
								course.getSubject().getTenmh(), course.getSubject().getSotinchi(),
								course.getTeacher(), course.getRoom(), course.getDay(),
								course.getTime(), course.getMaxSlot(), Boolean.FALSE
						});
					}
				}
				loggedAccount.setCourseList(list);
				StudentDAO.Update(loggedAccount);
				JOptionPane.showMessageDialog(null,"Đăng ký thành công","Successfully",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		RegisterButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel_1.add(RegisterButton);
		
		JPanel registeredCourses = new JPanel();
		tabbedPane.addTab("Danh  s\u00E1ch h\u1ECDc ph\u1EA7n \u0111\u00E3 \u0111\u0103ng k\u00ED", null, registeredCourses, null);
		GridBagLayout gbl_registeredCourses = new GridBagLayout();
		gbl_registeredCourses.columnWidths = new int[]{0, 0};
		gbl_registeredCourses.rowHeights = new int[]{0, 0, 0};
		gbl_registeredCourses.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_registeredCourses.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		registeredCourses.setLayout(gbl_registeredCourses);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		registeredCourses.add(scrollPane_1, gbc_scrollPane_1);



		//Registered course table data
		registeredCoursesTable = new JTable();
		LoadRegisterdCourseData();
		scrollPane_1.setViewportView(registeredCoursesTable);



		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		registeredCourses.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 5));
		
		JButton cancelRegisterCourse = new JButton("Hu\u1EF7 \u0111\u0103ng k\u00FD");
		cancelRegisterCourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) registeredCoursesTable.getModel();
				Set<CourseEntity> list = StudentDAO.GetCourseList(loggedAccount.getStudentid());
				Query query = null;
				loggedAccount.setCourseList(list);
				for (int i = model.getRowCount()-1; i >= 0; --i) {
					if ((Boolean) model.getValueAt(i,9) == true) {
						CourseEntity course = CourseDAO.Get((int) model.getValueAt(i,0));
						Set<StudentEntity> studentList = CourseDAO.GetStudentList(course.getCourseid());
						course.setStudentList(studentList);
						loggedAccount.removeCourse(course);
						//delete row from join table
						String sqlQuery = "delete from course_student where studentid = :studentid and courseid = :courseid";
						Session session = HibernateUtil.GetSession();
						session.beginTransaction();
						query = session.createSQLQuery(sqlQuery);
						query.setParameter("studentid",loggedAccount.getStudentid()).setParameter("courseid",course.getCourseid());
						query.executeUpdate();
						session.getTransaction().commit();
						session.close();
						//
						model.removeRow(i);
					}
				}
				StudentDAO.Update(loggedAccount);
				JOptionPane.showMessageDialog(null,"Huỷ đăng ký thành công","Successfully",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		cancelRegisterCourse.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel.add(cancelRegisterCourse);
	}
	private void LoadCourseData() {
		CourseRegisSessionEntity c = CourseRegisSessionDAO.Get(setSemester.getHk_id());
		Set<CourseEntity> courses = CourseRegisSessionDAO.GetCourseList(c.getCourseRegisId());
		DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
		for (CourseEntity course : courses) {
			model.addRow(new Object[]{
					course.getCourseid(),
					course.getSubject().getMamh(), course.getSubject().getTenmh(),
					course.getSubject().getSotinchi(), course.getTeacher(),
					course.getRoom(), course.getDay(), course.getTime(),
					course.getMaxSlot(), Boolean.FALSE
			});
		}
		courseTable.setModel(model);
	}
	private void LoadRegisterdCourseData() {
		Set<CourseEntity> list = StudentDAO.GetCourseList(loggedAccount.getStudentid());
		DefaultTableModel model = new DefaultTableModel(
				new Object[][]{},
				new Object[]{"id", "Subject code", "Subject name", "Credits",
						"Teacher", "Room", "Day", "Time", "Slot", ""}
		) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Object obj = getValueAt(0,columnIndex);
				if (obj == null)
					return Object.class;
				return obj.getClass();
			}
		};
		for (CourseEntity course : list) {
			model.addRow(new Object[]{
					course.getCourseid(), course.getSubject().getMamh(),
					course.getSubject().getTenmh(), course.getSubject().getSotinchi(),
					course.getTeacher(), course.getRoom(), course.getDay(),
					course.getTime(), course.getMaxSlot(), Boolean.FALSE
			});
		}
		registeredCoursesTable.setModel(model);
	}
}
