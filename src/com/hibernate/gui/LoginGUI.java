package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.pojo.GiaovuAccountEntity;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton login;
	private JButton register;
	private JPanel panel_1;
	private JLabel username;
	private JLabel password;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 212);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				GiaovuAccountEntity account = GiaovuAccountDAO.Get(username,password);
				if (account == null) {
					JOptionPane.showMessageDialog(null,
							"Your username or password is not correct, please try again","Login error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					MainFrame mainframe = new MainFrame(account);
					mainframe.setVisible(true);
				}
			}
		});
		buttonPanel.add(login);

		JButton register = new JButton("register");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register(null,null,-1);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		buttonPanel.add(register);

		JPanel loginPanel = new JPanel();
		contentPane.add(loginPanel, BorderLayout.CENTER);
		FlowLayout fl_loginPanel = new FlowLayout(FlowLayout.LEADING, 10, 10);
		loginPanel.setLayout(fl_loginPanel);

		JLabel username = new JLabel("Username");
		username.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(username);

		usernameField = new JTextField();
		loginPanel.add(usernameField);
		usernameField.setColumns(15);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		loginPanel.add(password);

		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		loginPanel.add(passwordField);

		JCheckBox showpassword = new JCheckBox("Show password");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpassword.isSelected())
					passwordField.setEchoChar('\0');
				else
					passwordField.setEchoChar('*');
			}
		});
		loginPanel.add(showpassword);
	}

}
