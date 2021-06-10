package com.hibernate.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.StudentDAO;
import com.hibernate.pojo.ClassEntity;
import com.hibernate.pojo.StudentEntity;

public class AddUpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField mssvField;
	private JLabel studentName;
	private JTextField nameField;
	private JLabel gender;
	private JRadioButton female;
	private JRadioButton male;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton applyButton;
	private JButton cancelButton;
	private DefaultTableModel model;
	private ClassEntity selectedClass;
	private int selectedRow;
	private StudentEntity selectedStudent;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AddUpdateStudent(DefaultTableModel model, ClassEntity selectedClass, StudentEntity selectedStudent, int selectedRow) {
		this.model = model;
		this.selectedClass = selectedClass;
		this.selectedStudent = selectedStudent;
		this.selectedRow = selectedRow;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel mssv = new JLabel("MSSV");
		mssv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_mssv = new GridBagConstraints();
		gbc_mssv.insets = new Insets(5, 0, 5, 5);
		gbc_mssv.anchor = GridBagConstraints.EAST;
		gbc_mssv.gridx = 0;
		gbc_mssv.gridy = 0;
		contentPane.add(mssv, gbc_mssv);
		
		mssvField = new JTextField();
		if (selectedStudent != null)
			mssvField.setText(selectedStudent.getMssv());
		GridBagConstraints gbc_mssvField = new GridBagConstraints();
		gbc_mssvField.gridwidth = 2;
		gbc_mssvField.insets = new Insets(5, 10, 10, 5);
		gbc_mssvField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mssvField.gridx = 1;
		gbc_mssvField.gridy = 0;
		contentPane.add(mssvField, gbc_mssvField);
		mssvField.setColumns(10);
		
		studentName = new JLabel("H\u1ECD T\u00EAn");
		studentName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_studentName = new GridBagConstraints();
		gbc_studentName.anchor = GridBagConstraints.EAST;
		gbc_studentName.insets = new Insets(5, 0, 5, 5);
		gbc_studentName.gridx = 0;
		gbc_studentName.gridy = 1;
		contentPane.add(studentName, gbc_studentName);
		
		nameField = new JTextField();
		if (selectedStudent != null)
			nameField.setText(selectedStudent.getTenhs());
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 2;
		gbc_nameField.insets = new Insets(10, 10, 10, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		gender = new JLabel("Gi\u1EDBi t\u00EDnh");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.insets = new Insets(10, 0, 5, 5);
		gbc_gender.gridx = 0;
		gbc_gender.gridy = 2;
		contentPane.add(gender, gbc_gender);
		
		male = new JRadioButton("Male");
		male.setActionCommand(male.getText());
		buttonGroup.add(male);
		GridBagConstraints gbc_male = new GridBagConstraints();
		gbc_male.anchor = GridBagConstraints.EAST;
		gbc_male.insets = new Insets(10, 10, 5, 5);
		gbc_male.gridx = 1;
		gbc_male.gridy = 2;
		contentPane.add(male, gbc_male);
		
		female = new JRadioButton("Female");
		female.setActionCommand(female.getText());
		buttonGroup.add(female);
		GridBagConstraints gbc_female = new GridBagConstraints();
		gbc_female.insets = new Insets(10, 0, 5, 0);
		gbc_female.gridx = 2;
		gbc_female.gridy = 2;
		contentPane.add(female, gbc_female);
		if (selectedStudent != null) {
			buttonGroup.setSelected(switch (selectedStudent.getGioitinh()) {
						case "Male" -> male.getModel();
						case "Female" -> female.getModel();
						default -> null;
					},
					true
			);
		}
		applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedStudent == null) {
					StudentEntity student = new StudentEntity();
					student.setMssv(mssvField.getText());
					student.setTenhs(nameField.getText());
					student.setGioitinh(buttonGroup.getSelection().getActionCommand());
					student.setUsername(student.getMssv());
					student.setPassword(student.getMssv());
					student.setClassEntity(selectedClass);
					StudentDAO.Save(student);
					model.addRow(new Object[]{
							student.getStudentid(), student.getMssv(),
							student.getTenhs(), student.getGioitinh(),
							student.getClassEntity().getClassname()
					});
				}
				else if (selectedStudent != null && selectedRow != -1) {
					selectedStudent.setMssv(mssvField.getText());
					selectedStudent.setTenhs(nameField.getText());
					selectedStudent.setGioitinh(buttonGroup.getSelection().getActionCommand());
					StudentDAO.Update(selectedStudent);
					model.setValueAt(selectedStudent.getMssv(),selectedRow,1);
					model.setValueAt(selectedStudent.getTenhs(),selectedRow,2);
					model.setValueAt(selectedStudent.getGioitinh(),selectedRow,3);
				}
				dispose();
			}
		});
		applyButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_applyButton = new GridBagConstraints();
		gbc_applyButton.gridwidth = 2;
		gbc_applyButton.insets = new Insets(20, 0, 0, 5);
		gbc_applyButton.gridx = 0;
		gbc_applyButton.gridy = 3;
		contentPane.add(applyButton, gbc_applyButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(20, 0, 0, 0);
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 3;
		contentPane.add(cancelButton, gbc_cancelButton);
	}

}
