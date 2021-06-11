package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.pojo.GiaovuAccountEntity;

public class Register extends JFrame {
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nameField;
	private JTextField facultyField;
	private JTextField phoneField;
	private JTextField emailField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private GiaovuAccountEntity selectedAccount;
	private int selectedRow;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Register(JTable table, GiaovuAccountEntity selectedAccount,int selectedRow) {
		this.table = table;
		this.selectedRow = selectedRow;
		this.selectedAccount = selectedAccount;
		
		setResizable(false);
		setBounds(100, 100, 312, 368);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.insets = new Insets(0, 0, 5, 5);
		gbc_username.anchor = GridBagConstraints.WEST;
		gbc_username.gridx = 0;
		gbc_username.gridy = 0;
		panel.add(username, gbc_username);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			usernameField.setText(selectedAccount.getUsername());
		}
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridwidth = 3;
		gbc_usernameField.insets = new Insets(10, 5, 10, 5);
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		panel.add(usernameField, gbc_usernameField);
		usernameField.setColumns(15);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.anchor = GridBagConstraints.WEST;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 0;
		gbc_password.gridy = 1;
		panel.add(password, gbc_password);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			passwordField.setText(selectedAccount.getPassword());
		}
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(5, 5, 10, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		panel.add(passwordField, gbc_passwordField);
		passwordField.setColumns(15);
		
		JLabel name = new JLabel("T\u00EAn");
		name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.WEST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.gridx = 0;
		gbc_name.gridy = 2;
		panel.add(name, gbc_name);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			nameField.setText(selectedAccount.getName());
		}
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridwidth = 3;
		gbc_nameField.insets = new Insets(5, 5, 10, 5);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 2;
		panel.add(nameField, gbc_nameField);
		nameField.setColumns(15);
		
		JLabel faculty = new JLabel("Khoa");
		faculty.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_faculty = new GridBagConstraints();
		gbc_faculty.anchor = GridBagConstraints.WEST;
		gbc_faculty.insets = new Insets(0, 0, 5, 5);
		gbc_faculty.gridx = 0;
		gbc_faculty.gridy = 3;
		panel.add(faculty, gbc_faculty);
		
		facultyField = new JTextField();
		facultyField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			facultyField.setText(selectedAccount.getFaculty());
		}
		GridBagConstraints gbc_facultyField = new GridBagConstraints();
		gbc_facultyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_facultyField.gridwidth = 3;
		gbc_facultyField.insets = new Insets(5, 5, 10, 5);
		gbc_facultyField.gridx = 1;
		gbc_facultyField.gridy = 3;
		panel.add(facultyField, gbc_facultyField);
		facultyField.setColumns(15);
		
		JLabel gender = new JLabel("Gi\u1EDBi t\u00EDnh");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.anchor = GridBagConstraints.WEST;
		gbc_gender.insets = new Insets(0, 0, 5, 5);
		gbc_gender.gridx = 0;
		gbc_gender.gridy = 4;
		panel.add(gender, gbc_gender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.BOLD, 12));
		male.setActionCommand(male.getText());
		buttonGroup.add(male);
		GridBagConstraints gbc_male = new GridBagConstraints();
		gbc_male.insets = new Insets(0, 0, 5, 5);
		gbc_male.gridx = 1;
		gbc_male.gridy = 4;
		panel.add(male, gbc_male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Times New Roman", Font.BOLD, 12));
		female.setActionCommand(female.getText());
		buttonGroup.add(female);
		GridBagConstraints gbc_female = new GridBagConstraints();
		gbc_female.insets = new Insets(0, 0, 5, 5);
		gbc_female.gridx = 2;
		gbc_female.gridy = 4;
		panel.add(female, gbc_female);
		if (selectedAccount != null) {
			buttonGroup.setSelected(
					switch(selectedAccount.getGender()) {
						case "Male" -> male.getModel();
						case "Female" -> female.getModel();
						default -> null;
					},
					true
			);
		}
		
		JLabel phonenumber = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		phonenumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_phonenumber = new GridBagConstraints();
		gbc_phonenumber.anchor = GridBagConstraints.WEST;
		gbc_phonenumber.insets = new Insets(0, 0, 5, 5);
		gbc_phonenumber.gridx = 0;
		gbc_phonenumber.gridy = 5;
		panel.add(phonenumber, gbc_phonenumber);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			phoneField.setText(selectedAccount.getPhonenumber());
		}
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridwidth = 3;
		gbc_phoneField.insets = new Insets(5, 5, 10, 5);
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 5;
		panel.add(phoneField, gbc_phoneField);
		phoneField.setColumns(15);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.anchor = GridBagConstraints.WEST;
		gbc_email.insets = new Insets(0, 0, 0, 5);
		gbc_email.gridx = 0;
		gbc_email.gridy = 6;
		panel.add(email, gbc_email);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		if (selectedAccount != null) {
			emailField.setText(selectedAccount.getEmail());
		}
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridwidth = 3;
		gbc_emailField.insets = new Insets(5, 5, 10, 5);
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 6;
		panel.add(emailField, gbc_emailField);
		emailField.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton register = new JButton("Add/Update");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedAccount == null) {
					GiaovuAccountEntity account = new GiaovuAccountEntity();
					account.setUsername(usernameField.getText());
					account.setPassword(passwordField.getText());
					account.setName(nameField.getText());
					account.setFaculty(facultyField.getText());
					account.setPhonenumber(phoneField.getText());
					account.setEmail(emailField.getText());
					account.setGender(buttonGroup.getSelection().getActionCommand());
					GiaovuAccountDAO.Save(account);
					if (table != null) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
						table.setRowSorter(null);
						table.setRowSorter(sorter);
						model.addRow(new Object[]{
								account.getGiaovuid(), account.getUsername(),
								account.getPassword(), account.getName(),
								account.getFaculty(), account.getGender(),
								account.getPhonenumber(), account.getEmail()
						});
					}
				}
				else {
					selectedAccount.setUsername(usernameField.getText());
					selectedAccount.setPassword(passwordField.getText());
					selectedAccount.setName(nameField.getText());
					selectedAccount.setFaculty(facultyField.getText());
					selectedAccount.setGender(buttonGroup.getSelection().getActionCommand());
					selectedAccount.setPhonenumber(phoneField.getText());
					selectedAccount.setEmail(emailField.getText());
					GiaovuAccountDAO.Update(selectedAccount);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
					table.setRowSorter(null);
					table.setRowSorter(sorter);
					model.setValueAt(selectedAccount.getUsername(),selectedRow,1);
					model.setValueAt(selectedAccount.getPassword(), selectedRow,2);
					model.setValueAt(selectedAccount.getName(),selectedRow,3);
					model.setValueAt(selectedAccount.getFaculty(),selectedRow,4);
					model.setValueAt(selectedAccount.getGender(),selectedRow,5);
					model.setValueAt(selectedAccount.getPhonenumber(),selectedRow,6);
					model.setValueAt(selectedAccount.getEmail(),selectedRow,7);
				}
				dispose();
			}
		});
		panel_1.add(register);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(cancel);

	}
}
