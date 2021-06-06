package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.gui.tablemodel.GiaovuAccountModel;
import com.hibernate.pojo.GiaovuAccountEntity;

public class MainFrame extends JFrame {
	private GiaovuAccountEntity logged_account;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nameField;
	private JTextField facultyField;
	private JTextField phoneField;
	private JTextField emailField;
	private JRadioButton male;
	private JRadioButton female;
	private JTable giaovuAccountTable;
	/**
	 * Launch the application.
	 */
	
	/**male
	 * Create the frame.
	 */
	public MainFrame(GiaovuAccountEntity logged_account) {
		this.logged_account = logged_account;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 735);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel giaovu = new JPanel();
		tabbedPane.addTab("Gi\u00E1o V\u1EE5", null, giaovu, null);
		giaovu.setLayout(new BorderLayout(0, 0));
		

		
		JScrollPane scrollPane = new JScrollPane();
		giaovu.add(scrollPane, BorderLayout.CENTER);
		
		giaovuAccountTable = new JTable();
		giaovuAccountTable.setModel(new GiaovuAccountModel());
		scrollPane.setViewportView(giaovuAccountTable);

		JPanel ButtonFunctions = new JPanel();
		giaovu.add(ButtonFunctions, BorderLayout.EAST);
		GridBagLayout gbl_ButtonFunctions = new GridBagLayout();
		gbl_ButtonFunctions.columnWidths = new int[]{0, 0};
		gbl_ButtonFunctions.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ButtonFunctions.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ButtonFunctions.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ButtonFunctions.setLayout(gbl_ButtonFunctions);

		JButton giaovuAddButton = new JButton("Add");
		giaovuAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GiaovuAccountModel model = (GiaovuAccountModel) giaovuAccountTable.getModel();
				Register frame = new Register(model);
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_giaovuAddButton = new GridBagConstraints();
		gbc_giaovuAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuAddButton.insets = new Insets(5, 5, 5, 5);
		gbc_giaovuAddButton.gridx = 0;
		gbc_giaovuAddButton.gridy = 0;
		ButtonFunctions.add(giaovuAddButton, gbc_giaovuAddButton);

		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		ButtonFunctions.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton giaovuDeleteButton = new JButton("Delete");
		giaovuDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = giaovuAccountTable.getSelectedRow();
				GiaovuAccountModel model = (GiaovuAccountModel) giaovuAccountTable.getModel();
				model.DeleteRow(row);
			}
		});
		GridBagConstraints gbc_giaovuDeleteButton = new GridBagConstraints();
		gbc_giaovuDeleteButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuDeleteButton.insets = new Insets(5, 5, 5, 5);
		gbc_giaovuDeleteButton.gridx = 0;
		gbc_giaovuDeleteButton.gridy = 2;
		ButtonFunctions.add(giaovuDeleteButton, gbc_giaovuDeleteButton);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		
		JPanel westPanel = new JPanel();
		getContentPane().add(westPanel, BorderLayout.WEST);
		GridBagLayout gbl_westPanel = new GridBagLayout();
		gbl_westPanel.columnWidths = new int[]{0, 0};
		gbl_westPanel.rowHeights = new int[]{0, 0, 0};
		gbl_westPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_westPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		westPanel.setLayout(gbl_westPanel);
		
		JPanel giaovuInfo = new JPanel();
		giaovuInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin Gi\u00E1o V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_giaovuInfo = new GridBagConstraints();
		gbc_giaovuInfo.weighty = 1.0;
		gbc_giaovuInfo.weightx = 1.0;
		gbc_giaovuInfo.insets = new Insets(0, 0, 5, 10);
		gbc_giaovuInfo.fill = GridBagConstraints.BOTH;
		gbc_giaovuInfo.gridx = 0;
		gbc_giaovuInfo.gridy = 0;
		westPanel.add(giaovuInfo, gbc_giaovuInfo);
		GridBagLayout gbl_giaovuInfo = new GridBagLayout();
		gbl_giaovuInfo.columnWidths = new int[]{0, 0, 0, 0};
		gbl_giaovuInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_giaovuInfo.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_giaovuInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		giaovuInfo.setLayout(gbl_giaovuInfo);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 T\u00EAn");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		giaovuInfo.add(lblNewLabel, gbc_lblNewLabel);
		
		nameField = new JTextField();
		nameField.setText(logged_account.getName());
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(20, 30, 10, 5);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		giaovuInfo.add(nameField, gbc_textField);
		nameField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Khoa");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		giaovuInfo.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		facultyField = new JTextField(logged_account.getFaculty());
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(10, 30, 10, 5);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		giaovuInfo.add(facultyField, gbc_textField_1);
		facultyField.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110i\u1EC7n Tho\u1EA1i");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		giaovuInfo.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		phoneField = new JTextField(logged_account.getPhonenumber());
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 30, 10, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		giaovuInfo.add(phoneField, gbc_textField_2);
		phoneField.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		giaovuInfo.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		emailField = new JTextField(logged_account.getEmail());
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(10, 30, 10, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		giaovuInfo.add(emailField, gbc_textField_3);
		emailField.setColumns(20);
		
		male = new JRadioButton("Male");
		male.setActionCommand(male.getText());
		buttonGroup.add(male);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 5;
		giaovuInfo.add(male, gbc_rdbtnNewRadioButton);
		
		female = new JRadioButton("Female");
		female.setActionCommand(female.getText());
		buttonGroup.add(female);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 5;
		giaovuInfo.add(female, gbc_rdbtnNewRadioButton_1);

		SetSelectedButton(logged_account.getSex());

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 6;
		giaovuInfo.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logged_account.setName(nameField.getText());
				logged_account.setFaculty(facultyField.getText());
				logged_account.setSex(buttonGroup.getSelection().getActionCommand());
				logged_account.setPhonenumber(phoneField.getText());
				logged_account.setEmail(emailField.getText());
				GiaovuAccountDAO.Update(logged_account);
				giaovuAccountTable.setModel(new GiaovuAccountModel());
				JOptionPane.showMessageDialog(null,"New information has been updated"
				,"Successfully",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel_6.add(edit);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_6.add(horizontalGlue_1);
		
		JButton change_password = new JButton("Change password");
		change_password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePassword frame = new ChangePassword(logged_account,giaovuAccountTable);
				frame.setVisible(true);
			}
		});
		panel_6.add(change_password);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_6.add(horizontalGlue);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_6.add(logout);
	}

	private void SetSelectedButton(String sex) {
		if (sex.equals("Male")) {
			buttonGroup.setSelected(male.getModel(),true);
		}
		else {
			buttonGroup.setSelected(female.getModel(), true);
		}
	}
}
