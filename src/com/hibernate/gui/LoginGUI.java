package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.dao.StudentDAO;
import com.hibernate.pojo.GiaovuAccountEntity;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.StudentEntity;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private CurrentSemester currentSemester;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 297);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				GiaovuAccountEntity giaovuAccount = null;
				StudentEntity studentAccount = null;
				if (buttonGroup.getSelection().getActionCommand().equals("Giáo vụ")) {
					giaovuAccount = GiaovuAccountDAO.Get(username, password);
					if (giaovuAccount == null)
						JOptionPane.showMessageDialog(null,
								"Your username or password is not correct, please try again", "Login error", JOptionPane.ERROR_MESSAGE);
					else {
						MainFrame mainframe = new MainFrame(giaovuAccount,currentSemester);
						mainframe.setVisible(true);
					}
				}
				else if (buttonGroup.getSelection().getActionCommand().equals("Sinh viên")) {
					studentAccount = StudentDAO.Get(username, password);
					if (studentAccount == null)
						JOptionPane.showMessageDialog(null,
								"Your username or password is not correct, please try again", "Login error", JOptionPane.ERROR_MESSAGE);
					else {
						StudentFrame studentframe = new StudentFrame(currentSemester.GetsetSemester(),studentAccount);
						studentframe.setVisible(true);
					}
				}

			}
		});
		buttonPanel.add(login);

		JButton register = new JButton("register");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register(null, null, -1);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		buttonPanel.add(register);

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(loginPanel, BorderLayout.CENTER);
		GridBagLayout gbl_loginPanel = new GridBagLayout();
		gbl_loginPanel.columnWidths = new int[]{61, 0, 162, 0};
		gbl_loginPanel.rowHeights = new int[]{28, 28, 18, 0, 0, 0, 0};
		gbl_loginPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginPanel.setLayout(gbl_loginPanel);

		JLabel username_1 = new JLabel("Username");
		username_1.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		username_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_username_1 = new GridBagConstraints();
		gbc_username_1.anchor = GridBagConstraints.EAST;
		gbc_username_1.insets = new Insets(5, 5, 5, 5);
		gbc_username_1.gridx = 0;
		gbc_username_1.gridy = 0;
		loginPanel.add(username_1, gbc_username_1);

		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.gridwidth = 2;
		gbc_usernameField.anchor = GridBagConstraints.NORTHWEST;
		gbc_usernameField.insets = new Insets(5, 10, 5, 0);
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		loginPanel.add(usernameField, gbc_usernameField);
		usernameField.setColumns(15);

		JLabel password_1 = new JLabel("Password");
		password_1.setFont(new Font("Cascadia Code", Font.BOLD, 12));
		GridBagConstraints gbc_password_1 = new GridBagConstraints();
		gbc_password_1.anchor = GridBagConstraints.EAST;
		gbc_password_1.insets = new Insets(5, 5, 5, 5);
		gbc_password_1.gridx = 0;
		gbc_password_1.gridy = 1;
		loginPanel.add(password_1, gbc_password_1);

		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.anchor = GridBagConstraints.NORTHWEST;
		gbc_passwordField.insets = new Insets(10, 10, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		loginPanel.add(passwordField, gbc_passwordField);

		JCheckBox showpassword = new JCheckBox("Show password");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpassword.isSelected())
					passwordField.setEchoChar('\0');
				else
					passwordField.setEchoChar('*');
			}
		});
		GridBagConstraints gbc_showpassword = new GridBagConstraints();
		gbc_showpassword.insets = new Insets(5, 5, 5, 0);
		gbc_showpassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_showpassword.gridwidth = 3;
		gbc_showpassword.gridx = 0;
		gbc_showpassword.gridy = 2;
		loginPanel.add(showpassword, gbc_showpassword);

		JRadioButton giaovuButton = new JRadioButton("Gi\u00E1o v\u1EE5");
		giaovuButton.setActionCommand(giaovuButton.getText());
		buttonGroup.add(giaovuButton);
		GridBagConstraints gbc_giaovuButton = new GridBagConstraints();
		gbc_giaovuButton.anchor = GridBagConstraints.EAST;
		gbc_giaovuButton.gridwidth = 2;
		gbc_giaovuButton.insets = new Insets(10, 5, 5, 5);
		gbc_giaovuButton.gridx = 0;
		gbc_giaovuButton.gridy = 3;
		loginPanel.add(giaovuButton, gbc_giaovuButton);

		JRadioButton sinhvienButton = new JRadioButton("Sinh vi\u00EAn");
		sinhvienButton.setActionCommand(sinhvienButton.getText());
		buttonGroup.add(sinhvienButton);
		GridBagConstraints gbc_sinhvienButton = new GridBagConstraints();
		gbc_sinhvienButton.insets = new Insets(10, 5, 5, 0);
		gbc_sinhvienButton.gridx = 2;
		gbc_sinhvienButton.gridy = 3;
		loginPanel.add(sinhvienButton, gbc_sinhvienButton);

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		loginPanel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 5, 0, 5);
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		loginPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);  
	}
	class CurrentSemester {
		private SemesterEntity setSesmer;

		public CurrentSemester() {}

		public void SetsetSemester(SemesterEntity setSesmer) {
			this.setSesmer = setSesmer;
		}
		public SemesterEntity GetsetSemester() {
			return setSesmer;
		}
	}
}
