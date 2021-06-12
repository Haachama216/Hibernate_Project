package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hibernate.dao.CourseDAO;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.StudentEntity;

public class RegisterdStudentList extends JFrame {

	private JPanel contentPane;
	private JTable registeredStudentTable;
	private JTextField searchField;
	private CourseEntity course;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public RegisterdStudentList(CourseEntity course) {
		this.course = course;

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1036, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn \u0111\u00E3 \u0111\u0103ng k\u00FD h\u1ECDc ph\u1EA7n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(30);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel search = new JLabel("Search");
		search.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(search);
		
		searchField = new JTextField();
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				Filter(searchField,registeredStudentTable);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Filter(searchField,registeredStudentTable);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Filter(searchField,registeredStudentTable);
			}
		});
		searchField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel.add(searchField);
		searchField.setColumns(20);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		panel.add(exitButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		registeredStudentTable = new JTable();
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Object obj = getValueAt(0,columnIndex);
				if (obj == null)
					return Object.class;
				return obj.getClass();
			}
		};
		model.setColumnIdentifiers(new Object[]{
				"MSSV", "Student name", "Subject id", "Subject name", "Teacher", "Day", "Time"
		});
		Set<StudentEntity> studentList = CourseDAO.GetStudentList(course.getCourseid());
		for (StudentEntity student : studentList) {
			model.addRow(new Object[]{
					student.getMssv(), student.getTenhs(), course.getSubject().getMamh(),
					course.getSubject().getTenmh(), course.getTeacher(),
					course.getDay(), course.getTime()
			});
		}
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		registeredStudentTable.setModel(model);
		registeredStudentTable.setRowSorter(sorter);
		scrollPane.setViewportView(registeredStudentTable);
	}
	private void Filter(JTextField searchField, JTable table) {
		TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
		RowFilter<DefaultTableModel,Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(searchField.getText());
		}
		catch (PatternSyntaxException e) {
			e.printStackTrace();
		}
		sorter.setRowFilter(rowFilter);
	}
}
