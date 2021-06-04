package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Register extends JFrame {
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nameField;
	private JTextField emailField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Register() {
		setResizable(false);
		setBounds(100, 100, 265, 242);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel username = new JLabel("Username");
		
		usernameField = new JTextField();
		usernameField.setColumns(15);
		
		JLabel password = new JLabel("Password");
		
		passwordField = new JTextField();
		passwordField.setColumns(15);
		
		JLabel name = new JLabel("Name");
		
		nameField = new JTextField();
		nameField.setColumns(15);
		
		JLabel email = new JLabel("Email");
		
		emailField = new JTextField();
		emailField.setColumns(15);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(email, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(name, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(username, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
								.addComponent(password, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(username)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(password)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(name)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(email)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton register = new JButton("Register");
		panel_1.add(register);
		
		JButton cancel = new JButton("Cancel");
		panel_1.add(cancel);

	}
}
