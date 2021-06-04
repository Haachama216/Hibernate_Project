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

import com.hibernate.dao.AccountDAO;
import com.hibernate.pojo.Account;

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
		setBounds(100, 100, 267, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Account account = AccountDAO.GetAccount(usernameField.getText(), new String(passwordField.getPassword()));
				if (account == null) {
					JOptionPane.showMessageDialog(login, "Your username or password is incorrect","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(login,"Welcome " + account.getInfo().getName(), "Info", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		panel.add(login);

		JButton register = new JButton("register");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		panel.add(register);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEADING, 10, 10);
		panel_1.setLayout(fl_panel_1);

		JLabel username = new JLabel("Username");
		username.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(username);

		usernameField = new JTextField();
		panel_1.add(usernameField);
		usernameField.setColumns(15);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		panel_1.add(password);

		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		panel_1.add(passwordField);

		JCheckBox showpassword = new JCheckBox("Show password");
		panel_1.add(showpassword);
	}

}
