package com.hibernate.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.SubjectDAO;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.SubjectEntity;

public class AddUpdateSubject extends JFrame {

	private JPanel contentPane;
	private JTextField codeField;
	private JLabel subjectName;
	private JTextField nameField;
	private JLabel subjectCredits;
	private JPanel panel;
	private JButton apply;
	private JButton cancel;
	private JComboBox comboBox;
	private SemesterEntity setSemester;
	private DefaultTableModel model = null;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public AddUpdateSubject(SemesterEntity setSemester, DefaultTableModel model) {
		this.setSemester = setSemester;
		this.model = model;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 285, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel subjectCode = new JLabel("M\u00E3 m\u00F4n h\u1ECDc");
		subjectCode.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_subjectCode = new GridBagConstraints();
		gbc_subjectCode.anchor = GridBagConstraints.EAST;
		gbc_subjectCode.insets = new Insets(5, 5, 5, 5);
		gbc_subjectCode.gridx = 0;
		gbc_subjectCode.gridy = 0;
		contentPane.add(subjectCode, gbc_subjectCode);
		
		codeField = new JTextField();
		GridBagConstraints gbc_codeField = new GridBagConstraints();
		gbc_codeField.anchor = GridBagConstraints.WEST;
		gbc_codeField.insets = new Insets(5, 10, 5, 0);
		gbc_codeField.gridx = 1;
		gbc_codeField.gridy = 0;
		contentPane.add(codeField, gbc_codeField);
		codeField.setColumns(15);
		
		subjectName = new JLabel("T\u00EAn m\u00F4n h\u1ECDc");
		subjectName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_subjectName = new GridBagConstraints();
		gbc_subjectName.anchor = GridBagConstraints.EAST;
		gbc_subjectName.insets = new Insets(5, 5, 5, 5);
		gbc_subjectName.gridx = 0;
		gbc_subjectName.gridy = 1;
		contentPane.add(subjectName, gbc_subjectName);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.WEST;
		gbc_nameField.insets = new Insets(5, 10, 5, 0);
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(15);
		
		subjectCredits = new JLabel("S\u1ED1 t\u00EDn ch\u1EC9");
		subjectCredits.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_subjectCredits = new GridBagConstraints();
		gbc_subjectCredits.anchor = GridBagConstraints.EAST;
		gbc_subjectCredits.insets = new Insets(5, 5, 5, 5);
		gbc_subjectCredits.gridx = 0;
		gbc_subjectCredits.gridy = 2;
		contentPane.add(subjectCredits, gbc_subjectCredits);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(5, 10, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectEntity newSubject = new SubjectEntity();
				newSubject.setMamh(codeField.getText());
				newSubject.setTenmh(nameField.getText());
				newSubject.setSotinchi((int) comboBox.getSelectedItem());
				newSubject.setSemester(setSemester);
				SubjectDAO.Save(newSubject);
				model.addRow(new Object[] {
						newSubject.getSubjectid(), newSubject.getMamh(),
						newSubject.getTenmh(), newSubject.getSotinchi()
				});
				dispose();
			}
		});
		apply.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		panel.add(apply);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		panel.add(cancel);
	}

}
