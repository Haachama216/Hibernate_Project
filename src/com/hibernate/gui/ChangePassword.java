package com.hibernate.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.pojo.GiaovuAccountEntity;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JCheckBox showpass;
	private JButton apply;
	private JButton cancle;

	private GiaovuAccountEntity account;
	private JTable giaovuTable;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChangePassword(GiaovuAccountEntity account, JTable table) {
		this.account = account;
		giaovuTable = table;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 309, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel old = new JLabel("Old password");
		old.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_old = new GridBagConstraints();
		gbc_old.insets = new Insets(0, 0, 5, 5);
		gbc_old.gridx = 0;
		gbc_old.gridy = 0;
		contentPane.add(old, gbc_old);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 0;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel newPass = new JLabel("New password");
		newPass.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_newPass = new GridBagConstraints();
		gbc_newPass.insets = new Insets(0, 0, 5, 5);
		gbc_newPass.gridx = 0;
		gbc_newPass.gridy = 1;
		contentPane.add(newPass, gbc_newPass);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(15);
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 1;
		contentPane.add(passwordField_1, gbc_passwordField_1);
		
		JLabel retype = new JLabel("Re-type");
		retype.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_retype = new GridBagConstraints();
		gbc_retype.insets = new Insets(0, 0, 5, 5);
		gbc_retype.gridx = 0;
		gbc_retype.gridy = 2;
		contentPane.add(retype, gbc_retype);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(15);
		GridBagConstraints gbc_passwordField_2 = new GridBagConstraints();
		gbc_passwordField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_2.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_2.gridx = 1;
		gbc_passwordField_2.gridy = 2;
		contentPane.add(passwordField_2, gbc_passwordField_2);
		
		showpass = new JCheckBox("Show password");
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpass.isSelected()) {
					passwordField.setEchoChar('\0');
					passwordField_1.setEchoChar('\0');
					passwordField_2.setEchoChar('\0');
				}
				else {
					passwordField.setEchoChar('*');
					passwordField_1.setEchoChar('*');
					passwordField_2.setEchoChar('*');
				}
			}
		});
		GridBagConstraints gbc_showpass = new GridBagConstraints();
		gbc_showpass.insets = new Insets(0, 0, 5, 5);
		gbc_showpass.gridx = 0;
		gbc_showpass.gridy = 3;
		contentPane.add(showpass, gbc_showpass);
		
		apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setPassword(new String(passwordField_1.getPassword()));
				GiaovuAccountDAO.Update(account);
				List<GiaovuAccountEntity> list = GiaovuAccountDAO.GetAll();
				DefaultTableModel model = new DefaultTableModel();
				TableRowSorter<DefaultTableModel>  sorter = new TableRowSorter<>(model);
				model.setColumnIdentifiers(new Object[]{
						"id","Username","Password","Name",
						"Faculty","Gender","Phone number", "Email"});
				for (GiaovuAccountEntity acc : list) {
					model.addRow(new Object[]{
							acc.getGiaovuid(), acc.getUsername(),
							acc.getPassword(), acc.getName(),
							acc.getFaculty(), acc.getGender(),
							acc.getPhonenumber(), acc.getEmail()
					});
				}
				giaovuTable.setModel(model);
				giaovuTable.setRowSorter(null);
				giaovuTable.setRowSorter(sorter);
				JOptionPane.showMessageDialog(null,"Your password has been updated",
						"Successfully",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		apply.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_apply = new GridBagConstraints();
		gbc_apply.insets = new Insets(0, 0, 0, 5);
		gbc_apply.gridx = 0;
		gbc_apply.gridy = 4;
		contentPane.add(apply, gbc_apply);
		
		cancle = new JButton("Cancel");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_cancle = new GridBagConstraints();
		gbc_cancle.gridx = 1;
		gbc_cancle.gridy = 4;
		contentPane.add(cancle, gbc_cancle);
	}

}
