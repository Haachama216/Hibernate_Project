package com.hibernate.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hibernate.dao.SemesterDAO;
import com.hibernate.pojo.SemesterEntity;

public class AddSemester extends JFrame {

	private JPanel contentPane;
	private JLabel schoolYear;
	private JTextField schoolyearField;
	private JLabel startDate;
	private JTextField startDateField;
	private JComboBox comboBox;
	private JLabel endDate;
	private JTextField endDateField;
	private JButton apply;
	private JButton cancel;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddSemester(DefaultTableModel model) {
		this.model = model;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 256, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel semesterName = new JLabel("T\u00EAn h\u1ECDc k\u00EC");
		semesterName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_semesterName = new GridBagConstraints();
		gbc_semesterName.insets = new Insets(0, 0, 5, 5);
		gbc_semesterName.anchor = GridBagConstraints.EAST;
		gbc_semesterName.gridx = 0;
		gbc_semesterName.gridy = 0;
		contentPane.add(semesterName, gbc_semesterName);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HK1", "HK2", "HK3"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		schoolYear = new JLabel("N\u0103m h\u1ECDc");
		schoolYear.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_schoolYear = new GridBagConstraints();
		gbc_schoolYear.anchor = GridBagConstraints.EAST;
		gbc_schoolYear.insets = new Insets(0, 0, 5, 5);
		gbc_schoolYear.gridx = 0;
		gbc_schoolYear.gridy = 1;
		contentPane.add(schoolYear, gbc_schoolYear);
		
		schoolyearField = new JTextField();
		GridBagConstraints gbc_schoolyearField = new GridBagConstraints();
		gbc_schoolyearField.anchor = GridBagConstraints.WEST;
		gbc_schoolyearField.insets = new Insets(0, 0, 5, 0);
		gbc_schoolyearField.gridx = 1;
		gbc_schoolyearField.gridy = 1;
		contentPane.add(schoolyearField, gbc_schoolyearField);
		schoolyearField.setColumns(10);
		
		startDate = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		startDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_startDate = new GridBagConstraints();
		gbc_startDate.anchor = GridBagConstraints.EAST;
		gbc_startDate.insets = new Insets(0, 0, 5, 5);
		gbc_startDate.gridx = 0;
		gbc_startDate.gridy = 2;
		contentPane.add(startDate, gbc_startDate);
		
		startDateField = new JTextField();
		GridBagConstraints gbc_startDateField = new GridBagConstraints();
		gbc_startDateField.anchor = GridBagConstraints.WEST;
		gbc_startDateField.insets = new Insets(0, 0, 5, 0);
		gbc_startDateField.gridx = 1;
		gbc_startDateField.gridy = 2;
		contentPane.add(startDateField, gbc_startDateField);
		startDateField.setColumns(10);
		
		endDate = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");
		endDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_endDate = new GridBagConstraints();
		gbc_endDate.anchor = GridBagConstraints.EAST;
		gbc_endDate.insets = new Insets(0, 0, 5, 5);
		gbc_endDate.gridx = 0;
		gbc_endDate.gridy = 3;
		contentPane.add(endDate, gbc_endDate);
		
		endDateField = new JTextField();
		GridBagConstraints gbc_endDateField = new GridBagConstraints();
		gbc_endDateField.insets = new Insets(0, 0, 5, 0);
		gbc_endDateField.anchor = GridBagConstraints.WEST;
		gbc_endDateField.gridx = 1;
		gbc_endDateField.gridy = 3;
		contentPane.add(endDateField, gbc_endDateField);
		endDateField.setColumns(10);
		
		apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SemesterEntity semester = new SemesterEntity();
					semester.setTenhk(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
					semester.setNamhoc(schoolyearField.getText());
					semester.setNgaybatdau(startDateField.getText());
					semester.setNgayketthuc(endDateField.getText());
					SemesterDAO.Save(semester);
					model.addRow(new Object[] {
							semester.getHk_id(), semester.getTenhk(),
							semester.getNamhoc(), semester.getNgaybatdau(),
							semester.getNgayketthuc()
					});
				}
				catch(NullPointerException exception) {
					exception.printStackTrace();
				}
				finally {
					dispose();
				}
			}
		});
		apply.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_apply = new GridBagConstraints();
		gbc_apply.anchor = GridBagConstraints.EAST;
		gbc_apply.insets = new Insets(10, 0, 0, 5);
		gbc_apply.gridx = 0;
		gbc_apply.gridy = 4;
		contentPane.add(apply, gbc_apply);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_cancel = new GridBagConstraints();
		gbc_cancel.insets = new Insets(10, 0, 0, 0);
		gbc_cancel.gridx = 1;
		gbc_cancel.gridy = 4;
		contentPane.add(cancel, gbc_cancel);
	}

}
