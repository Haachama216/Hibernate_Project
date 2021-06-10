package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.CourseDAO;
import com.hibernate.dao.SemesterDAO;
import com.hibernate.dao.SubjectDAO;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.SubjectEntity;

public class AddNewCourse extends JFrame {

	private JPanel contentPane;
	private JTextField codeField;
	private JTextField subjectNameField;
	private JTextField creditsField;
	private JTextField teacherNameField;
	private JTextField roomField;
	private JTable subjectTable;
	private SemesterEntity setSemester;
	private SubjectEntity selectedSubject;
	private DefaultTableModel courseModel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddNewCourse(SemesterEntity setSemester, DefaultTableModel courseModel) {
		this.setSemester = setSemester;
		this.courseModel = courseModel;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 376, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel mainPane = new JPanel();
		contentPane.add(mainPane, "Main panel");
		GridBagLayout gbl_mainPane = new GridBagLayout();
		gbl_mainPane.columnWidths = new int[]{0, 0, 0};
		gbl_mainPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		JLabel subjectCode = new JLabel("M\u00E3 m\u00F4n h\u1ECDc");
		subjectCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_subjectCode = new GridBagConstraints();
		gbc_subjectCode.insets = new Insets(0, 0, 5, 5);
		gbc_subjectCode.anchor = GridBagConstraints.EAST;
		gbc_subjectCode.gridx = 0;
		gbc_subjectCode.gridy = 0;
		mainPane.add(subjectCode, gbc_subjectCode);
		
		codeField = new JTextField();
		GridBagConstraints gbc_codeField = new GridBagConstraints();
		gbc_codeField.anchor = GridBagConstraints.WEST;
		gbc_codeField.insets = new Insets(5, 5, 5, 0);
		gbc_codeField.gridx = 1;
		gbc_codeField.gridy = 0;
		mainPane.add(codeField, gbc_codeField);
		codeField.setColumns(15);
		
		JLabel subjectName = new JLabel("T\u00EAn m\u00F4n h\u1ECDc");
		subjectName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_subjectName = new GridBagConstraints();
		gbc_subjectName.anchor = GridBagConstraints.EAST;
		gbc_subjectName.insets = new Insets(5, 5, 5, 5);
		gbc_subjectName.gridx = 0;
		gbc_subjectName.gridy = 1;
		mainPane.add(subjectName, gbc_subjectName);
		
		subjectNameField = new JTextField();
		GridBagConstraints gbc_subjectNameField = new GridBagConstraints();
		gbc_subjectNameField.anchor = GridBagConstraints.WEST;
		gbc_subjectNameField.insets = new Insets(5, 5, 5, 0);
		gbc_subjectNameField.gridx = 1;
		gbc_subjectNameField.gridy = 1;
		mainPane.add(subjectNameField, gbc_subjectNameField);
		subjectNameField.setColumns(20);
		
		JLabel credits = new JLabel("S\u1ED1 t\u00EDn ch\u1EC9");
		credits.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_credits = new GridBagConstraints();
		gbc_credits.anchor = GridBagConstraints.EAST;
		gbc_credits.insets = new Insets(5, 5, 5, 5);
		gbc_credits.gridx = 0;
		gbc_credits.gridy = 2;
		mainPane.add(credits, gbc_credits);
		
		creditsField = new JTextField();
		GridBagConstraints gbc_creditsField = new GridBagConstraints();
		gbc_creditsField.insets = new Insets(5, 5, 5, 0);
		gbc_creditsField.anchor = GridBagConstraints.WEST;
		gbc_creditsField.gridx = 1;
		gbc_creditsField.gridy = 2;
		mainPane.add(creditsField, gbc_creditsField);
		creditsField.setColumns(5);
		
		JButton chooseSubject = new JButton("Choose subject");
		chooseSubject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane,"Choose subject panel");
			}
		});
		chooseSubject.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_chooseSubject = new GridBagConstraints();
		gbc_chooseSubject.insets = new Insets(5, 5, 5, 0);
		gbc_chooseSubject.gridwidth = 2;
		gbc_chooseSubject.gridx = 0;
		gbc_chooseSubject.gridy = 3;
		mainPane.add(chooseSubject, gbc_chooseSubject);
		
		JLabel teacher = new JLabel("Gi\u00E1o vi\u00EAn l\u00FD thuy\u1EBFt");
		teacher.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_teacher = new GridBagConstraints();
		gbc_teacher.anchor = GridBagConstraints.EAST;
		gbc_teacher.insets = new Insets(5, 5, 5, 5);
		gbc_teacher.gridx = 0;
		gbc_teacher.gridy = 4;
		mainPane.add(teacher, gbc_teacher);
		
		teacherNameField = new JTextField();
		GridBagConstraints gbc_teacherNameField = new GridBagConstraints();
		gbc_teacherNameField.anchor = GridBagConstraints.WEST;
		gbc_teacherNameField.insets = new Insets(5, 5, 5, 0);
		gbc_teacherNameField.gridx = 1;
		gbc_teacherNameField.gridy = 4;
		mainPane.add(teacherNameField, gbc_teacherNameField);
		teacherNameField.setColumns(20);
		
		JLabel roomName = new JLabel("T\u00EAn ph\u00F2ng h\u1ECDc");
		roomName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_roomName = new GridBagConstraints();
		gbc_roomName.insets = new Insets(5, 5, 5, 5);
		gbc_roomName.anchor = GridBagConstraints.EAST;
		gbc_roomName.gridx = 0;
		gbc_roomName.gridy = 5;
		mainPane.add(roomName, gbc_roomName);
		
		roomField = new JTextField();
		GridBagConstraints gbc_roomField = new GridBagConstraints();
		gbc_roomField.anchor = GridBagConstraints.WEST;
		gbc_roomField.insets = new Insets(5, 5, 5, 0);
		gbc_roomField.gridx = 1;
		gbc_roomField.gridy = 5;
		mainPane.add(roomField, gbc_roomField);
		roomField.setColumns(10);
		
		JLabel day = new JLabel("Th\u1EE9:");
		day.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_day = new GridBagConstraints();
		gbc_day.insets = new Insets(5, 5, 5, 5);
		gbc_day.anchor = GridBagConstraints.EAST;
		gbc_day.gridx = 0;
		gbc_day.gridy = 6;
		mainPane.add(day, gbc_day);
		
		JComboBox dayComboBox = new JComboBox();
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"hai", "ba", "t\u01B0", "n\u0103m", "s\u00E1u", "b\u1EA3y", "ch\u1EE7 nh\u1EADt"}));
		GridBagConstraints gbc_dayComboBox = new GridBagConstraints();
		gbc_dayComboBox.anchor = GridBagConstraints.WEST;
		gbc_dayComboBox.insets = new Insets(5, 5, 5, 0);
		gbc_dayComboBox.gridx = 1;
		gbc_dayComboBox.gridy = 6;
		mainPane.add(dayComboBox, gbc_dayComboBox);
		
		JLabel ca = new JLabel("Ca:");
		ca.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_ca = new GridBagConstraints();
		gbc_ca.insets = new Insets(5, 5, 5, 5);
		gbc_ca.anchor = GridBagConstraints.EAST;
		gbc_ca.gridx = 0;
		gbc_ca.gridy = 7;
		mainPane.add(ca, gbc_ca);
		
		JComboBox timeComboBox = new JComboBox();
		timeComboBox.setModel(new DefaultComboBoxModel(new String[] {"7:30-9:30", "9:30-11:30", "13:30-15:30", "15:30-7:30"}));
		GridBagConstraints gbc_timeComboBox = new GridBagConstraints();
		gbc_timeComboBox.anchor = GridBagConstraints.WEST;
		gbc_timeComboBox.insets = new Insets(5, 5, 5, 0);
		gbc_timeComboBox.gridx = 1;
		gbc_timeComboBox.gridy = 7;
		mainPane.add(timeComboBox, gbc_timeComboBox);
		
		JLabel maximumSlot = new JLabel("S\u1ED1 slot t\u1ED1i \u0111a");
		maximumSlot.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_maximumSlot = new GridBagConstraints();
		gbc_maximumSlot.insets = new Insets(5, 5, 5, 5);
		gbc_maximumSlot.anchor = GridBagConstraints.EAST;
		gbc_maximumSlot.gridx = 0;
		gbc_maximumSlot.gridy = 8;
		mainPane.add(maximumSlot, gbc_maximumSlot);
		
		JTextField slotField = new JTextField();
		slotField.setColumns(5);
		GridBagConstraints gbc_slotField = new GridBagConstraints();
		gbc_slotField.fill = GridBagConstraints.NONE;
		gbc_slotField.insets = new Insets(5,5,5,0);
		gbc_slotField.anchor = GridBagConstraints.WEST;
		gbc_slotField.gridx = 1;
		gbc_slotField.gridy = 8;
		mainPane.add(slotField,gbc_slotField);
		
		JButton apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CourseEntity course = new CourseEntity();
					course.setSubject(selectedSubject);
					course.setCourseRegis(setSemester.getCourseRegisSessionEntity());
					course.setTeacher(teacherNameField.getText());
					course.setRoom(roomField.getText());
					if (dayComboBox.getSelectedItem().toString().equals("chủ nhật"))
						course.setDay(dayComboBox.getSelectedItem().toString());
					else
						course.setDay("Thứ " + dayComboBox.getSelectedItem().toString());
					course.setTime(timeComboBox.getSelectedItem().toString());
					course.setMaxSlot(Integer.parseInt(slotField.getText()));
					CourseDAO.Save(course);
					courseModel.addRow(new Object[]{
							course.getCourseid(), selectedSubject.getMamh(),
							selectedSubject.getTenmh(), selectedSubject.getSotinchi(),
							course.getTeacher(), course.getRoom(),
							course.getDay(), course.getTime(),
							course.getMaxSlot()
					});
				}
				catch (NullPointerException | NumberFormatException exception) {
					exception.printStackTrace();
				}
				finally {
					dispose();
				}
			}
		});
		apply.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_apply = new GridBagConstraints();
		gbc_apply.anchor = GridBagConstraints.EAST;
		gbc_apply.insets = new Insets(0, 0, 0, 5);
		gbc_apply.gridx = 0;
		gbc_apply.gridy = 10;
		mainPane.add(apply, gbc_apply);
		
		JButton cancelMainPane = new JButton("Cancel");
		cancelMainPane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelMainPane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_cancelMainPane = new GridBagConstraints();
		gbc_cancelMainPane.gridx = 1;
		gbc_cancelMainPane.gridy = 10;
		mainPane.add(cancelMainPane, gbc_cancelMainPane);

		
		JPanel chooseSubjectPane = new JPanel();
		contentPane.add(chooseSubjectPane, "Choose subject panel");
		chooseSubjectPane.setLayout(new BorderLayout(0, 0));
		
		JPanel TablePane = new JPanel();
		chooseSubjectPane.add(TablePane, BorderLayout.CENTER);
		TablePane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		TablePane.add(scrollPane, BorderLayout.CENTER);
		
		subjectTable = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"id","Subject code", "Subject name", "Credits"
				}
		);
		Set<SubjectEntity> list = SemesterDAO.GetSubjectsList(setSemester.getHk_id());
		for (SubjectEntity subject : list) {
			model.addRow(new Object[]{
					subject.getSubjectid(),
					subject.getMamh(), subject.getTenmh(),
					subject.getSotinchi()
			});
		}
		subjectTable.setModel(model);
		subjectTable.setShowVerticalLines(true);
		subjectTable.setShowHorizontalLines(true);
		subjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(subjectTable);
		
		JPanel ButtonsPane = new JPanel();
		chooseSubjectPane.add(ButtonsPane, BorderLayout.SOUTH);
		
		JButton select = new JButton("Select");
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = subjectTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
				selectedSubject = SubjectDAO.Get((int) model.getValueAt(selectedRow,0));
				codeField.setText(selectedSubject.getMamh());
				codeField.setEditable(false);
				subjectNameField.setText(selectedSubject.getTenmh());
				subjectNameField.setEditable(false);
				creditsField.setText(String.valueOf(selectedSubject.getSotinchi()));
				creditsField.setEditable(false);
				CardLayout cards = (CardLayout) contentPane.getLayout();
				cards.show(contentPane,"Main panel");
			}
		});
		select.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		ButtonsPane.add(select);
		
		JButton chooseSubjectCancelButton = new JButton("Cancel");
		chooseSubjectCancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) contentPane.getLayout();
				cards.next(contentPane);
			}
		});
		chooseSubjectCancelButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		ButtonsPane.add(chooseSubjectCancelButton);

	}
}
