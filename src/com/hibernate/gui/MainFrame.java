package com.hibernate.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

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
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.hibernate.dao.ClassDAO;
import com.hibernate.dao.CourseDAO;
import com.hibernate.dao.CourseRegisSessionDAO;
import com.hibernate.dao.GiaovuAccountDAO;
import com.hibernate.dao.SemesterDAO;
import com.hibernate.dao.StudentDAO;
import com.hibernate.dao.SubjectDAO;
import com.hibernate.pojo.ClassEntity;
import com.hibernate.pojo.CourseEntity;
import com.hibernate.pojo.CourseRegisSessionEntity;
import com.hibernate.pojo.GiaovuAccountEntity;
import com.hibernate.pojo.SemesterEntity;
import com.hibernate.pojo.StudentEntity;
import com.hibernate.pojo.SubjectEntity;

public class MainFrame extends JFrame {
	private GiaovuAccountEntity logged_account = null;
	private LoginGUI.CurrentSemester currentSemester;
	private SemesterEntity setSemester = null;
	private ClassEntity selectedClass = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nameField;
	private JTextField facultyField;
	private JTextField phoneField;
	private JTextField emailField;
	private JRadioButton male;
	private JRadioButton female;
	private JTable giaovuAccountTable;
	private JTextField giaovuSearchField;
	private JTable semesterTable;
	private JTable subjectTable;
	private JTextField subjectSearchField;
	private JPanel AddCourseRegis;
	private JTable courseRegisTable;
	private JTextField courseRegisStartDateField;
	private JTextField courseRegisEndDateField;
	private JTable coursetable;
	private JTextField courseSearchField;
	private JTable classTable;
	private JTable studentTable;
	private JTextField studentSearchField;
	private JTextField classNameField;
	private JPanel addClassPane;
	/**
	 * Launch the application.
	 */
	
	/**male
	 * Create the frame.
	 */
	public MainFrame(GiaovuAccountEntity logged_account, LoginGUI.CurrentSemester currentSemester) {
		this.logged_account = logged_account;
		this.currentSemester = currentSemester;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 735);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		//Giaovu tab
		JPanel giaovu = new JPanel();
		tabbedPane.addTab("Gi\u00E1o V\u1EE5", null, giaovu, null);
		giaovu.setLayout(new BorderLayout(0, 0));
		
		JPanel giaovu_CenterPane = new JPanel();
		giaovu.add(giaovu_CenterPane, BorderLayout.CENTER);
		GridBagLayout gbl_giaovu_CenterPane = new GridBagLayout();
		gbl_giaovu_CenterPane.columnWidths = new int[]{0, 0};
		gbl_giaovu_CenterPane.rowHeights = new int[]{0, 0, 0};
		gbl_giaovu_CenterPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_giaovu_CenterPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		giaovu_CenterPane.setLayout(gbl_giaovu_CenterPane);
		
		JPanel giaovu_TopPane = new JPanel();
		GridBagConstraints gbc_giaovu_TopPane = new GridBagConstraints();
		gbc_giaovu_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_giaovu_TopPane.fill = GridBagConstraints.BOTH;
		gbc_giaovu_TopPane.gridx = 0;
		gbc_giaovu_TopPane.gridy = 0;
		giaovu_CenterPane.add(giaovu_TopPane, gbc_giaovu_TopPane);
		giaovu_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel giaovuFunctions = new JPanel();
		giaovu_TopPane.add(giaovuFunctions, BorderLayout.SOUTH);
		GridBagLayout gbl_giaovuFunctions = new GridBagLayout();
		gbl_giaovuFunctions.columnWidths = new int[]{42, 232, 48, 65, 62, 0};
		gbl_giaovuFunctions.rowHeights = new int[]{29, 0};
		gbl_giaovuFunctions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_giaovuFunctions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		giaovuFunctions.setLayout(gbl_giaovuFunctions);
		
		JLabel giaovuSearch = new JLabel("Search");
		giaovuSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_giaovuSearch = new GridBagConstraints();
		gbc_giaovuSearch.anchor = GridBagConstraints.WEST;
		gbc_giaovuSearch.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuSearch.gridx = 0;
		gbc_giaovuSearch.gridy = 0;
		giaovuFunctions.add(giaovuSearch, gbc_giaovuSearch);
		
		giaovuSearchField = new JTextField();
		giaovuSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				Filter(giaovuSearchField,giaovuAccountTable);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Filter(giaovuSearchField,giaovuAccountTable);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Filter(giaovuSearchField,giaovuAccountTable);
			}
		});
		giaovuSearchField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_giaovuSearchField = new GridBagConstraints();
		gbc_giaovuSearchField.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuSearchField.gridx = 1;
		gbc_giaovuSearchField.gridy = 0;
		giaovuFunctions.add(giaovuSearchField, gbc_giaovuSearchField);
		giaovuSearchField.setColumns(20);
				
		JButton giaovuAddButton = new JButton("Add");
		giaovuAddButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_giaovuAddButton = new GridBagConstraints();
		gbc_giaovuAddButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuAddButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuAddButton.gridx = 2;
		gbc_giaovuAddButton.gridy = 0;
		giaovuFunctions.add(giaovuAddButton, gbc_giaovuAddButton);
		giaovuAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
				Register frame = new Register(giaovuAccountTable,null,-1);
				frame.setVisible(true);
			}
		});
		
		JButton giaovuUpdateButton = new JButton("Update");
		giaovuUpdateButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_giaovuUpdateButton = new GridBagConstraints();
		gbc_giaovuUpdateButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuUpdateButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuUpdateButton.gridx = 3;
		gbc_giaovuUpdateButton.gridy = 0;
		giaovuFunctions.add(giaovuUpdateButton, gbc_giaovuUpdateButton);
		giaovuUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = giaovuAccountTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = giaovuAccountTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
					GiaovuAccountEntity selectedAccount = GiaovuAccountDAO.Get((String) model.getValueAt(selectedRow, 1)
							, (String) model.getValueAt(selectedRow, 2));
					Register frame = new Register(giaovuAccountTable, selectedAccount, selectedRow);
					frame.setVisible(true);
				}
			}
		});

		JButton giaovuDeleteButton = new JButton("Delete");
		giaovuDeleteButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_giaovuDeleteButton = new GridBagConstraints();
		gbc_giaovuDeleteButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_giaovuDeleteButton.insets = new Insets(0, 5, 5, 5);
		gbc_giaovuDeleteButton.gridx = 4;
		gbc_giaovuDeleteButton.gridy = 0;
		giaovuFunctions.add(giaovuDeleteButton, gbc_giaovuDeleteButton);
		giaovuDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = giaovuAccountTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = giaovuAccountTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) giaovuAccountTable.getModel();
					GiaovuAccountEntity account = GiaovuAccountDAO.Get((String) model.getValueAt(selectedRow, 1),
							(String) model.getValueAt(selectedRow, 2));
					GiaovuAccountDAO.Delete(account);
					model.removeRow(selectedRow);
				}
			}
		});
		
		//Giao vu table data
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		giaovu_CenterPane.add(scrollPane, gbc_scrollPane);
		
		giaovuAccountTable = new JTable();
		LoadDataIntoTable(new GiaovuAccountEntity(), giaovuAccountTable);
		scrollPane.setViewportView(giaovuAccountTable);

		


		//Semester tab
		JPanel semester = new JPanel();
		tabbedPane.addTab("H\u1ECDc k\u00EC", null, semester, null);
		semester.setLayout(new BorderLayout(0, 0));
		
		JPanel semester_CenterPane = new JPanel();
		semester.add(semester_CenterPane, BorderLayout.CENTER);
		GridBagLayout gbl_semester_CenterPane = new GridBagLayout();
		gbl_semester_CenterPane.columnWidths = new int[]{0, 0};
		gbl_semester_CenterPane.rowHeights = new int[]{0, 0, 0};
		gbl_semester_CenterPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_semester_CenterPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		semester_CenterPane.setLayout(gbl_semester_CenterPane);
		
		JPanel semester_TopPane = new JPanel();
		GridBagConstraints gbc_semester_TopPane = new GridBagConstraints();
		gbc_semester_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_semester_TopPane.fill = GridBagConstraints.BOTH;
		gbc_semester_TopPane.gridx = 0;
		gbc_semester_TopPane.gridy = 0;
		semester_CenterPane.add(semester_TopPane, gbc_semester_TopPane);
		semester_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel semesterFunction = new JPanel();
		semester_TopPane.add(semesterFunction, BorderLayout.SOUTH);
		GridBagLayout gbl_semesterFunction = new GridBagLayout();
		gbl_semesterFunction.columnWidths = new int[]{0, 0, 0, 0};
		gbl_semesterFunction.rowHeights = new int[]{0, 0};
		gbl_semesterFunction.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_semesterFunction.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		semesterFunction.setLayout(gbl_semesterFunction);
		
		JButton semesterAddButton = new JButton("Add");
		semesterAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
				AddSemester frame = new AddSemester(semesterTable);
				frame.setVisible(true);
			}
		});
		semesterAddButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_semesterAddButton = new GridBagConstraints();
		gbc_semesterAddButton.insets = new Insets(0, 5, 0, 5);
		gbc_semesterAddButton.gridx = 0;
		gbc_semesterAddButton.gridy = 0;
		semesterFunction.add(semesterAddButton, gbc_semesterAddButton);
		
		JButton semesterSetButton = new JButton("Set");
		semesterSetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = semesterTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "You need to select a row first",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = semesterTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
					setSemester = SemesterDAO.Get((int) model.getValueAt(selectedRow, 0));
					currentSemester.SetsetSemester(setSemester);
					if (setSemester.getCourseRegisSessionEntity() == null) {
						AddCourseRegis.setVisible(true);
					} else {
						AddCourseRegis.setVisible(false);
						LoadDataIntoTable(new CourseEntity(), coursetable);
					}
					JOptionPane.showMessageDialog(null, "Set semester successfully",
							null, JOptionPane.INFORMATION_MESSAGE);
					LoadDataIntoTable(new SubjectEntity(), subjectTable);
				}
			}
		});
		
				semesterSetButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
				GridBagConstraints gbc_semesterSetButton = new GridBagConstraints();
				gbc_semesterSetButton.insets = new Insets(0, 5, 0, 5);
				gbc_semesterSetButton.gridx = 1;
				gbc_semesterSetButton.gridy = 0;
				semesterFunction.add(semesterSetButton, gbc_semesterSetButton);
		
		JButton semesterDeleteButton = new JButton("Delete");
		semesterDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = semesterTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = semesterTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) semesterTable.getModel();
					SemesterEntity semester = SemesterDAO.Get((int) model.getValueAt(selectedRow, 0));
					SemesterDAO.Delete(semester);
					semesterTable.setRowSorter(null);
					semesterTable.setRowSorter(GetNewSorter(model));
					model.removeRow(selectedRow);
					DefaultTableModel subjectmodel = (DefaultTableModel) subjectTable.getModel();
					subjectmodel.setRowCount(0);
				}
			}
		});
		
				semesterDeleteButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
				GridBagConstraints gbc_semesterDeleteButton = new GridBagConstraints();
				gbc_semesterDeleteButton.insets = new Insets(0, 5, 0, 0);
				gbc_semesterDeleteButton.gridx = 2;
				gbc_semesterDeleteButton.gridy = 0;
				semesterFunction.add(semesterDeleteButton, gbc_semesterDeleteButton);
		
		JScrollPane semesterScrollPane = new JScrollPane();
		GridBagConstraints gbc_semesterScrollPane = new GridBagConstraints();
		gbc_semesterScrollPane.fill = GridBagConstraints.BOTH;
		gbc_semesterScrollPane.gridx = 0;
		gbc_semesterScrollPane.gridy = 1;
		semester_CenterPane.add(semesterScrollPane, gbc_semesterScrollPane);


		//Semester data table
		semesterTable = new JTable();
		LoadDataIntoTable(new SemesterEntity(), semesterTable);
		semesterScrollPane.setViewportView(semesterTable);
		
		
		
		
		
		//subject tab
		JPanel subject = new JPanel();
		tabbedPane.addTab("M\u00F4n h\u1ECDc", null, subject, null);
		subject.setLayout(new BorderLayout(0, 0));
		
		JPanel subject_CenterPane = new JPanel();
		subject.add(subject_CenterPane, BorderLayout.CENTER);
		GridBagLayout gbl_subject_CenterPane = new GridBagLayout();
		gbl_subject_CenterPane.columnWidths = new int[]{0, 0};
		gbl_subject_CenterPane.rowHeights = new int[]{0, 0, 0};
		gbl_subject_CenterPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_subject_CenterPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		subject_CenterPane.setLayout(gbl_subject_CenterPane);
		
		JPanel subject_TopPane = new JPanel();
		GridBagConstraints gbc_subject_TopPane = new GridBagConstraints();
		gbc_subject_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_subject_TopPane.fill = GridBagConstraints.BOTH;
		gbc_subject_TopPane.gridx = 0;
		gbc_subject_TopPane.gridy = 0;
		subject_CenterPane.add(subject_TopPane, gbc_subject_TopPane);
		subject_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel subjectFunctions = new JPanel();
		subject_TopPane.add(subjectFunctions, BorderLayout.SOUTH);
		GridBagLayout gbl_subjectFunctions = new GridBagLayout();
		gbl_subjectFunctions.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_subjectFunctions.rowHeights = new int[]{0, 0};
		gbl_subjectFunctions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_subjectFunctions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		subjectFunctions.setLayout(gbl_subjectFunctions);
		
		JLabel subjectSearch = new JLabel("Search");
		subjectSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_subjectSearch = new GridBagConstraints();
		gbc_subjectSearch.insets = new Insets(0, 0, 0, 5);
		gbc_subjectSearch.anchor = GridBagConstraints.EAST;
		gbc_subjectSearch.gridx = 0;
		gbc_subjectSearch.gridy = 0;
		subjectFunctions.add(subjectSearch, gbc_subjectSearch);
		
		subjectSearchField = new JTextField();
		subjectSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				Filter(subjectSearchField,subjectTable);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Filter(subjectSearchField,subjectTable);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Filter(subjectSearchField,subjectTable);
			}
		});
		subjectSearchField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_subjectSearchField = new GridBagConstraints();
		gbc_subjectSearchField.insets = new Insets(0, 0, 0, 5);
		gbc_subjectSearchField.gridx = 1;
		gbc_subjectSearchField.gridy = 0;
		subjectFunctions.add(subjectSearchField, gbc_subjectSearchField);
		subjectSearchField.setColumns(20);
		
		JButton subjectAddButton = new JButton("Add");
		subjectAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
				AddUpdateSubject frame = new AddUpdateSubject(setSemester,subjectTable,-1,null);
				frame.setVisible(true);
			}
		});
		subjectAddButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_subjectAddButton = new GridBagConstraints();
		gbc_subjectAddButton.insets = new Insets(0, 0, 0, 5);
		gbc_subjectAddButton.gridx = 2;
		gbc_subjectAddButton.gridy = 0;
		subjectFunctions.add(subjectAddButton, gbc_subjectAddButton);
		
		JButton subjectUpdateButton = new JButton("Update");
		subjectUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
				int selectedRow = subjectTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = subjectTable.convertRowIndexToModel(selectedRow);
					SubjectEntity selectedSubject = SubjectDAO.Get((int) model.getValueAt(selectedRow, 0));
					AddUpdateSubject frame = new AddUpdateSubject(setSemester, subjectTable, selectedRow, selectedSubject);
					frame.setVisible(true);
				}
			}
		});
		subjectUpdateButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_subjectUpdateButton = new GridBagConstraints();
		gbc_subjectUpdateButton.insets = new Insets(0, 0, 0, 5);
		gbc_subjectUpdateButton.gridx = 3;
		gbc_subjectUpdateButton.gridy = 0;
		subjectFunctions.add(subjectUpdateButton, gbc_subjectUpdateButton);
		
		JButton subjectDeleteButton = new JButton("Delete");
		subjectDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = subjectTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = subjectTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
					subjectTable.setRowSorter(null);
					subjectTable.setRowSorter(sorter);
					SubjectEntity selectedSubject = SubjectDAO.Get((int) model.getValueAt(selectedRow, 0));
					SubjectDAO.Delete(selectedSubject);
					model.removeRow(selectedRow);
				}
			}
		});
		subjectDeleteButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_subjectDeleteButton = new GridBagConstraints();
		gbc_subjectDeleteButton.gridx = 4;
		gbc_subjectDeleteButton.gridy = 0;
		subjectFunctions.add(subjectDeleteButton, gbc_subjectDeleteButton);
		
		JScrollPane subjectScrollPane = new JScrollPane();
		GridBagConstraints gbc_subjectScrollPane = new GridBagConstraints();
		gbc_subjectScrollPane.fill = GridBagConstraints.BOTH;
		gbc_subjectScrollPane.gridx = 0;
		gbc_subjectScrollPane.gridy = 1;
		subject_CenterPane.add(subjectScrollPane, gbc_subjectScrollPane);
		
		
		
		//subject table data
		subjectTable = new JTable(new DefaultTableModel(
				new Object[][]{},
				new Object[]{"id", "Subject code", "Subject name", "Credits"}
		));
		subjectTable.setShowVerticalLines(true);
		subjectTable.setShowHorizontalLines(true);

		subjectScrollPane.setViewportView(subjectTable);
		
		JPanel classTab = new JPanel();
		tabbedPane.addTab("L\u1EDBp h\u1ECDc", null, classTab, null);
		classTab.setLayout(new CardLayout(0, 0));
		
		JPanel classCard = new JPanel();
		classCard.setBorder(new TitledBorder(null, "L\u1EDBp h\u1ECDc", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		classTab.add(classCard, "Class Card");
		GridBagLayout gbl_classCard = new GridBagLayout();
		gbl_classCard.columnWidths = new int[]{0, 0};
		gbl_classCard.rowHeights = new int[]{0, 0, 0};
		gbl_classCard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_classCard.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		classCard.setLayout(gbl_classCard);
		
		JPanel classCard_TopPane = new JPanel();
		GridBagConstraints gbc_classCard_TopPane = new GridBagConstraints();
		gbc_classCard_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_classCard_TopPane.fill = GridBagConstraints.BOTH;
		gbc_classCard_TopPane.gridx = 0;
		gbc_classCard_TopPane.gridy = 0;
		classCard.add(classCard_TopPane, gbc_classCard_TopPane);
		classCard_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel classCard_ButtonFunctions = new JPanel();
		classCard_TopPane.add(classCard_ButtonFunctions, BorderLayout.SOUTH);
		GridBagLayout gbl_classCard_ButtonFunctions = new GridBagLayout();
		gbl_classCard_ButtonFunctions.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_classCard_ButtonFunctions.rowHeights = new int[]{0, 0};
		gbl_classCard_ButtonFunctions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_classCard_ButtonFunctions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		classCard_ButtonFunctions.setLayout(gbl_classCard_ButtonFunctions);
		
		JButton classCardAddButton = new JButton("Add");
		classCardAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addClassPane.setVisible(true);
			}
		});
		classCardAddButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_classCardAddButton = new GridBagConstraints();
		gbc_classCardAddButton.insets = new Insets(5, 5, 5, 5);
		gbc_classCardAddButton.gridx = 0;
		gbc_classCardAddButton.gridy = 0;
		classCard_ButtonFunctions.add(classCardAddButton, gbc_classCardAddButton);
		
		JButton classCardDeleteButton = new JButton("Delete");
		classCardDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = classTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = subjectTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) classTable.getModel();
					TableRowSorter<DefaultTableModel> sorter = GetNewSorter(model);
					classTable.setRowSorter(null);
					classTable.setRowSorter(sorter);
					ClassEntity classEntity = ClassDAO.Get((int) model.getValueAt(selectedRow, 0));
					ClassDAO.Delete(classEntity);
					model.removeRow(selectedRow);
				}
			}
		});
		classCardDeleteButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_classCardDeleteButton = new GridBagConstraints();
		gbc_classCardDeleteButton.insets = new Insets(5, 5, 5, 5);
		gbc_classCardDeleteButton.gridx = 1;
		gbc_classCardDeleteButton.gridy = 0;
		classCard_ButtonFunctions.add(classCardDeleteButton, gbc_classCardDeleteButton);

		//selected class

		JButton studentListButton = new JButton("Students in the selected class");
		studentListButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = classTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected", JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = classTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) classTable.getModel();
					selectedClass = ClassDAO.Get((int) model.getValueAt(selectedRow,0));
					CardLayout cards = (CardLayout) classTab.getLayout();
					cards.show(classTab,"Student Card");
					LoadDataIntoTable(new StudentEntity(),studentTable);
				}
			}
		});
		studentListButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_studentListButton = new GridBagConstraints();
		gbc_studentListButton.insets = new Insets(5, 5, 5, 5);
		gbc_studentListButton.gridx = 2;
		gbc_studentListButton.gridy = 0;
		classCard_ButtonFunctions.add(studentListButton, gbc_studentListButton);
		
		addClassPane = new JPanel();
		addClassPane.setBorder(new TitledBorder(null, "Th\u00EAm l\u1EDBp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addClassPane.setVisible(false);
		classCard_TopPane.add(addClassPane, BorderLayout.WEST);
		GridBagLayout gbl_addClassPane = new GridBagLayout();
		gbl_addClassPane.columnWidths = new int[]{0, 0};
		gbl_addClassPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_addClassPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_addClassPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addClassPane.setLayout(gbl_addClassPane);
		
		JLabel className = new JLabel("T\u00EAn l\u1EDBp");
		className.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_className = new GridBagConstraints();
		gbc_className.insets = new Insets(0, 0, 5, 0);
		gbc_className.gridx = 0;
		gbc_className.gridy = 1;
		addClassPane.add(className, gbc_className);
		
		classNameField = new JTextField();
		classNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_classNameField = new GridBagConstraints();
		gbc_classNameField.insets = new Insets(0, 0, 5, 0);
		gbc_classNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_classNameField.gridx = 0;
		gbc_classNameField.gridy = 2;
		addClassPane.add(classNameField, gbc_classNameField);
		classNameField.setColumns(10);
		
		JButton classApplyButton = new JButton("Apply");
		classApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassEntity classEntity = new ClassEntity();
				classEntity.setClassname(classNameField.getText());
				DefaultTableModel model = (DefaultTableModel) classTable.getModel();
				TableRowSorter<DefaultTableModel> sorter = GetNewSorter(model);
				classTable.setRowSorter(null);
				classTable.setRowSorter(sorter);
				ClassDAO.Save(classEntity);
				model.addRow(new Object[]{
						classEntity.getClassid(), classEntity.getClassname(),
						classEntity.getTongsinhvien(),
						classEntity.getTongsinhvienNam(), classEntity.getTongsinhvienNu()
				});
				classNameField.setText("");
				addClassPane.setVisible(false);
			}
		});
		classApplyButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_classApplyButton = new GridBagConstraints();
		gbc_classApplyButton.gridx = 0;
		gbc_classApplyButton.gridy = 3;
		addClassPane.add(classApplyButton, gbc_classApplyButton);
		
		JScrollPane class_ScrollPane = new JScrollPane();
		GridBagConstraints gbc_class_ScrollPane = new GridBagConstraints();
		gbc_class_ScrollPane.fill = GridBagConstraints.BOTH;
		gbc_class_ScrollPane.gridx = 0;
		gbc_class_ScrollPane.gridy = 1;
		classCard.add(class_ScrollPane, gbc_class_ScrollPane);



		//Class data table
		classTable = new JTable( new DefaultTableModel(
				new Object[][]{},
				new Object[]{"id", "Class name", "Total students", "Male students", "Female students"}
		));
		LoadDataIntoTable(new ClassEntity(), classTable);
		class_ScrollPane.setViewportView(classTable);
		
		JPanel studentCard = new JPanel();
		studentCard.setBorder(new TitledBorder(null, "Sinh vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		classTab.add(studentCard, "Student Card");
		GridBagLayout gbl_studentCard = new GridBagLayout();
		gbl_studentCard.columnWidths = new int[]{0, 0};
		gbl_studentCard.rowHeights = new int[]{0, 0, 0};
		gbl_studentCard.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_studentCard.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		studentCard.setLayout(gbl_studentCard);
		
		JPanel student_TopPane = new JPanel();
		GridBagConstraints gbc_student_TopPane = new GridBagConstraints();
		gbc_student_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_student_TopPane.fill = GridBagConstraints.BOTH;
		gbc_student_TopPane.gridx = 0;
		gbc_student_TopPane.gridy = 0;
		studentCard.add(student_TopPane, gbc_student_TopPane);
		student_TopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel studentFunctions = new JPanel();
		student_TopPane.add(studentFunctions, BorderLayout.SOUTH);
		GridBagLayout gbl_studentFunctions = new GridBagLayout();
		gbl_studentFunctions.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_studentFunctions.rowHeights = new int[]{0, 0};
		gbl_studentFunctions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_studentFunctions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		studentFunctions.setLayout(gbl_studentFunctions);
		
		JLabel studentSearch = new JLabel("Search");
		studentSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_studentSearch = new GridBagConstraints();
		gbc_studentSearch.insets = new Insets(5, 5, 0, 5);
		gbc_studentSearch.anchor = GridBagConstraints.EAST;
		gbc_studentSearch.gridx = 0;
		gbc_studentSearch.gridy = 0;
		studentFunctions.add(studentSearch, gbc_studentSearch);
		
		studentSearchField = new JTextField();
		studentSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				Filter(studentSearchField,studentTable);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Filter(studentSearchField,studentTable);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Filter(studentSearchField,studentTable);
			}
		});
		studentSearchField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_studetnSearchField = new GridBagConstraints();
		gbc_studetnSearchField.insets = new Insets(0, 0, 0, 5);
		gbc_studetnSearchField.anchor = GridBagConstraints.WEST;
		gbc_studetnSearchField.gridx = 1;
		gbc_studetnSearchField.gridy = 0;
		studentFunctions.add(studentSearchField, gbc_studetnSearchField);
		studentSearchField.setColumns(20);
		
		JButton studentAddButton = new JButton("Add");
		studentAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
				AddUpdateStudent frame = new AddUpdateStudent(studentTable, classTable, selectedClass, null, -1);
				frame.setVisible(true);
			}
		});
		studentAddButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_studentAddButton = new GridBagConstraints();
		gbc_studentAddButton.insets = new Insets(0, 0, 0, 5);
		gbc_studentAddButton.gridx = 2;
		gbc_studentAddButton.gridy = 0;
		studentFunctions.add(studentAddButton, gbc_studentAddButton);
		
		JButton studentUpdateButton = new JButton("Update");
		studentUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected", JOptionPane.ERROR_MESSAGE);
				else {
					selectedRow = studentTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
					StudentEntity selectedStudent = StudentDAO.Get((int) model.getValueAt(selectedRow,0));
					AddUpdateStudent frame = new AddUpdateStudent(studentTable,classTable,selectedClass,selectedStudent,selectedRow);
					frame.setVisible(true);
					LoadDataIntoTable(new ClassEntity(),classTable);
				}
			}
		});
		studentUpdateButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_studentUpdateButton = new GridBagConstraints();
		gbc_studentUpdateButton.insets = new Insets(0, 0, 0, 5);
		gbc_studentUpdateButton.gridx = 3;
		gbc_studentUpdateButton.gridy = 0;
		studentFunctions.add(studentUpdateButton, gbc_studentUpdateButton);
		
		JButton studentDeleteButton = new JButton("Delete");
		studentDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected", JOptionPane.ERROR_MESSAGE);
				else {
					selectedRow = studentTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
					TableRowSorter<DefaultTableModel> sorter = GetNewSorter(model);
					studentTable.setRowSorter(null);
					studentTable.setRowSorter(sorter);
					StudentEntity student = StudentDAO.Get((int) model.getValueAt(selectedRow,0));
					StudentDAO.Delete(student);
					model.removeRow(selectedRow);
					LoadDataIntoTable(new ClassEntity(),classTable);
				}
			}
		});
		studentDeleteButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_studentDeleteButton = new GridBagConstraints();
		gbc_studentDeleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_studentDeleteButton.gridx = 4;
		gbc_studentDeleteButton.gridy = 0;
		studentFunctions.add(studentDeleteButton, gbc_studentDeleteButton);
		
		JButton returnButton = new JButton("Return to class list");
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) classTab.getLayout();
				cards.show(classTab, "Class Card");
			}
		});
		
		JButton resetPassword = new JButton("Reset password");
		resetPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = studentTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Selected a row first",
							"None of row selected", JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = studentTable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
					StudentEntity student = StudentDAO.Get((int) model.getValueAt(selectedRow,0));
					student.setPassword("password");
					StudentDAO.Update(student);
					JOptionPane.showMessageDialog(null,"Reset password successfully",
							"Successfully",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		resetPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_resetPassword = new GridBagConstraints();
		gbc_resetPassword.insets = new Insets(5, 5, 5, 5);
		gbc_resetPassword.gridx = 5;
		gbc_resetPassword.gridy = 0;
		studentFunctions.add(resetPassword, gbc_resetPassword);
		returnButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_returnButton = new GridBagConstraints();
		gbc_returnButton.insets = new Insets(5, 5, 5, 5);
		gbc_returnButton.gridx = 6;
		gbc_returnButton.gridy = 0;
		studentFunctions.add(returnButton, gbc_returnButton);
		
		JScrollPane studentScrollPane = new JScrollPane();
		GridBagConstraints gbc_studentScrollPane = new GridBagConstraints();
		gbc_studentScrollPane.fill = GridBagConstraints.BOTH;
		gbc_studentScrollPane.gridx = 0;
		gbc_studentScrollPane.gridy = 1;
		studentCard.add(studentScrollPane, gbc_studentScrollPane);
		
		studentTable = new JTable(new DefaultTableModel(
				new Object[][]{},
				new Object[]{"id", "MSSV", "Student name", "Gender", "Class"}
		));
		studentScrollPane.setViewportView(studentTable);
		
		
		
		
		
		//Course Registration Tab
		JPanel courseRegistration = new JPanel();
		tabbedPane.addTab("K\u00EC \u0111\u0103ng k\u00ED h\u1ECDc ph\u1EA7n", null, courseRegistration, null);
		GridBagLayout gbl_courseRegistration = new GridBagLayout();
		gbl_courseRegistration.columnWidths = new int[]{0, 0};
		gbl_courseRegistration.rowHeights = new int[]{0, 0, 0};
		gbl_courseRegistration.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_courseRegistration.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		courseRegistration.setLayout(gbl_courseRegistration);
		
		JPanel courseRegis_TopPane = new JPanel();
		GridBagConstraints gbc_courseRegis_TopPane = new GridBagConstraints();
		gbc_courseRegis_TopPane.insets = new Insets(0, 0, 5, 0);
		gbc_courseRegis_TopPane.fill = GridBagConstraints.BOTH;
		gbc_courseRegis_TopPane.gridx = 0;
		gbc_courseRegis_TopPane.gridy = 0;
		courseRegistration.add(courseRegis_TopPane, gbc_courseRegis_TopPane);
		courseRegis_TopPane.setLayout(new BorderLayout(0, 0));
		
		AddCourseRegis = new JPanel();
		AddCourseRegis.setBorder(new TitledBorder(null, "Th\u00EAm k\u00EC \u0111\u0103ng k\u00ED h\u1ECDc ph\u1EA7n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		courseRegis_TopPane.add(AddCourseRegis, BorderLayout.CENTER);
		GridBagLayout gbl_AddCourseRegis = new GridBagLayout();
		gbl_AddCourseRegis.columnWidths = new int[]{0, 0, 0};
		gbl_AddCourseRegis.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_AddCourseRegis.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_AddCourseRegis.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddCourseRegis.setLayout(gbl_AddCourseRegis);
		
		JLabel courseRegisStartDate = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		courseRegisStartDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_courseRegisStartDate = new GridBagConstraints();
		gbc_courseRegisStartDate.insets = new Insets(0, 5, 5, 5);
		gbc_courseRegisStartDate.anchor = GridBagConstraints.EAST;
		gbc_courseRegisStartDate.gridx = 0;
		gbc_courseRegisStartDate.gridy = 1;
		AddCourseRegis.add(courseRegisStartDate, gbc_courseRegisStartDate);
		
		courseRegisStartDateField = new JTextField();
		GridBagConstraints gbc_courseRegisStartDateField = new GridBagConstraints();
		gbc_courseRegisStartDateField.anchor = GridBagConstraints.WEST;
		gbc_courseRegisStartDateField.insets = new Insets(5, 5, 5, 0);
		gbc_courseRegisStartDateField.gridx = 1;
		gbc_courseRegisStartDateField.gridy = 1;
		AddCourseRegis.add(courseRegisStartDateField, gbc_courseRegisStartDateField);
		courseRegisStartDateField.setColumns(10);
		
		JLabel courseRegisEndDate = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");
		courseRegisEndDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_courseRegisEndDate = new GridBagConstraints();
		gbc_courseRegisEndDate.anchor = GridBagConstraints.EAST;
		gbc_courseRegisEndDate.insets = new Insets(5, 5, 5, 5);
		gbc_courseRegisEndDate.gridx = 0;
		gbc_courseRegisEndDate.gridy = 2;
		AddCourseRegis.add(courseRegisEndDate, gbc_courseRegisEndDate);
		
		courseRegisEndDateField = new JTextField();
		GridBagConstraints gbc_courseRegisEndDateField = new GridBagConstraints();
		gbc_courseRegisEndDateField.insets = new Insets(5, 5, 5, 0);
		gbc_courseRegisEndDateField.anchor = GridBagConstraints.WEST;
		gbc_courseRegisEndDateField.gridx = 1;
		gbc_courseRegisEndDateField.gridy = 2;
		AddCourseRegis.add(courseRegisEndDateField, gbc_courseRegisEndDateField);
		courseRegisEndDateField.setColumns(10);
		
		JButton courseRegisApplyButton = new JButton("Apply");
		courseRegisApplyButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		courseRegisApplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CourseRegisSessionEntity c = new CourseRegisSessionEntity();
				c.setSemester(setSemester);
				c.setNgaybatdau(courseRegisStartDateField.getText());
				c.setNgaykethuc(courseRegisEndDateField.getText());
				setSemester.setCourseRegisSessionEntity(c);
				SemesterDAO.Update(setSemester);
				DefaultTableModel model = (DefaultTableModel) courseRegisTable.getModel();
				TableRowSorter<DefaultTableModel> sorter = GetNewSorter(model);
				courseRegisTable.setRowSorter(null);
				courseRegisTable.setRowSorter(sorter);
				model.addRow(new Object[] {
						c.getCourseRegisId(), c.getSemester().getTenhk(),
						c.getSemester().getNamhoc(), c.getNgaybatdau(),
						c.getNgaykethuc()
				});
				courseRegisStartDateField.setText("");
				courseRegisEndDateField.setText("");
				AddCourseRegis.setVisible(false);
			}
		});
		GridBagConstraints gbc_courseRegisApplyButton = new GridBagConstraints();
		gbc_courseRegisApplyButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseRegisApplyButton.gridwidth = 2;
		gbc_courseRegisApplyButton.gridx = 0;
		gbc_courseRegisApplyButton.gridy = 3;
		AddCourseRegis.add(courseRegisApplyButton, gbc_courseRegisApplyButton);
		
		JScrollPane courseRegis_ScrollPane = new JScrollPane();
		GridBagConstraints gbc_courseRegis_ScrollPane = new GridBagConstraints();
		gbc_courseRegis_ScrollPane.fill = GridBagConstraints.BOTH;
		gbc_courseRegis_ScrollPane.gridx = 0;
		gbc_courseRegis_ScrollPane.gridy = 1;
		courseRegistration.add(courseRegis_ScrollPane, gbc_courseRegis_ScrollPane);



		//course regis data table
		courseRegisTable = new JTable(new DefaultTableModel());
		LoadDataIntoTable(new CourseRegisSessionEntity(), courseRegisTable);
		courseRegis_ScrollPane.setViewportView(courseRegisTable);





		//course tab
		JPanel courses = new JPanel();
		tabbedPane.addTab("H\u1ECDc ph\u1EA7n", null, courses, null);
		courses.setLayout(new BorderLayout(0, 0));
		
		JPanel courses_Centerpane = new JPanel();
		courses.add(courses_Centerpane, BorderLayout.CENTER);
		GridBagLayout gbl_courses_Centerpane = new GridBagLayout();
		gbl_courses_Centerpane.columnWidths = new int[]{0, 0};
		gbl_courses_Centerpane.rowHeights = new int[]{0, 0, 0};
		gbl_courses_Centerpane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_courses_Centerpane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		courses_Centerpane.setLayout(gbl_courses_Centerpane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		courses_Centerpane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel courseSearch = new JLabel("Search");
		courseSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_courseSearch = new GridBagConstraints();
		gbc_courseSearch.insets = new Insets(0, 5, 5, 5);
		gbc_courseSearch.anchor = GridBagConstraints.EAST;
		gbc_courseSearch.gridx = 0;
		gbc_courseSearch.gridy = 0;
		panel_1.add(courseSearch, gbc_courseSearch);
		
		courseSearchField = new JTextField();
		courseSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				Filter(courseSearchField,coursetable);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				Filter(courseSearchField,coursetable);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Filter(courseSearchField,coursetable);
			}
		});
		courseSearchField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_courseSearchField = new GridBagConstraints();
		gbc_courseSearchField.insets = new Insets(0, 5, 5, 5);
		gbc_courseSearchField.anchor = GridBagConstraints.WEST;
		gbc_courseSearchField.gridx = 1;
		gbc_courseSearchField.gridy = 0;
		panel_1.add(courseSearchField, gbc_courseSearchField);
		courseSearchField.setColumns(20);
		
		JButton courseAddButton = new JButton("Add");
		courseAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewCourse frame = new AddNewCourse(setSemester,coursetable);
				frame.setVisible(true);
			}
		});
		courseAddButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_courseAddButton = new GridBagConstraints();
		gbc_courseAddButton.insets = new Insets(5, 5, 5, 5);
		gbc_courseAddButton.gridx = 2;
		gbc_courseAddButton.gridy = 0;
		panel_1.add(courseAddButton, gbc_courseAddButton);
		
		JButton courseDeleteButton = new JButton("Delete");
		courseDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = coursetable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null,"Select a row first",
							"None of row selected",JOptionPane.ERROR_MESSAGE);
				}
				else {
					selectedRow = coursetable.convertRowIndexToModel(selectedRow);
					DefaultTableModel model = (DefaultTableModel) coursetable.getModel();
					TableRowSorter<DefaultTableModel> sorter = GetNewSorter(model);
					coursetable.setRowSorter(null);
					coursetable.setRowSorter(sorter);
					CourseEntity course = CourseDAO.Get((int) model.getValueAt(selectedRow, 0));
					CourseDAO.Delete(course);
					model.removeRow(selectedRow);
				}
			}
		});
		courseDeleteButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_courseDeleteButton = new GridBagConstraints();
		gbc_courseDeleteButton.insets = new Insets(5, 5, 5, 5);
		gbc_courseDeleteButton.gridx = 3;
		gbc_courseDeleteButton.gridy = 0;
		panel_1.add(courseDeleteButton, gbc_courseDeleteButton);
		
		JButton studentList = new JButton("Students in course");
		studentList.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		GridBagConstraints gbc_studentList = new GridBagConstraints();
		gbc_studentList.insets = new Insets(5, 5, 5, 5);
		gbc_studentList.gridx = 4;
		gbc_studentList.gridy = 0;
		panel_1.add(studentList, gbc_studentList);
		
		JScrollPane course_ScrollPane = new JScrollPane();
		GridBagConstraints gbc_course_ScrollPane = new GridBagConstraints();
		gbc_course_ScrollPane.fill = GridBagConstraints.BOTH;
		gbc_course_ScrollPane.gridx = 0;
		gbc_course_ScrollPane.gridy = 1;
		courses_Centerpane.add(course_ScrollPane, gbc_course_ScrollPane);


		//course table data
		coursetable = new JTable(new DefaultTableModel(
				new Object[][]{},
				new Object[] {"id", "Subject code", "Subject name", "Credits", "Teacher name",
				"Room", "Day", "Time", "Slot"}
				));

		course_ScrollPane.setViewportView(coursetable);
		
		
		
		JPanel westPanel = new JPanel();
		getContentPane().add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		//Giao vu info pane
		JPanel giaovuInfo = new JPanel();
		giaovuInfo.setBorder(new TitledBorder(null, "Th\u00F4ng tin Gi\u00E1o V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		westPanel.add(giaovuInfo);
		GridBagLayout gbl_giaovuInfo = new GridBagLayout();
		gbl_giaovuInfo.columnWidths = new int[]{0, 0, 0, 0};
		gbl_giaovuInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_giaovuInfo.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_giaovuInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		giaovuInfo.setLayout(gbl_giaovuInfo);
		
		JLabel nameLable = new JLabel("H\u1ECD v\u00E0 T\u00EAn");
		GridBagConstraints gbc_nameLable = new GridBagConstraints();
		gbc_nameLable.insets = new Insets(20, 0, 5, 5);
		gbc_nameLable.gridx = 0;
		gbc_nameLable.gridy = 0;
		giaovuInfo.add(nameLable, gbc_nameLable);
		
		nameField = new JTextField();
		nameField.setText(logged_account.getName());
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(20, 30, 10, 5);
		gbc_nameField.anchor = GridBagConstraints.WEST;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		giaovuInfo.add(nameField, gbc_nameField);
		nameField.setColumns(20);
		
		JLabel facultyLabel = new JLabel("Khoa");
		GridBagConstraints gbc_facultyLabel = new GridBagConstraints();
		gbc_facultyLabel.insets = new Insets(5, 0, 5, 5);
		gbc_facultyLabel.gridx = 0;
		gbc_facultyLabel.gridy = 1;
		giaovuInfo.add(facultyLabel, gbc_facultyLabel);
		
		facultyField = new JTextField(logged_account.getFaculty());
		GridBagConstraints gbc_facultyField = new GridBagConstraints();
		gbc_facultyField.insets = new Insets(10, 30, 10, 5);
		gbc_facultyField.anchor = GridBagConstraints.WEST;
		gbc_facultyField.fill = GridBagConstraints.HORIZONTAL;
		gbc_facultyField.gridx = 1;
		gbc_facultyField.gridy = 1;
		giaovuInfo.add(facultyField, gbc_facultyField);
		facultyField.setColumns(20);
		
		JLabel phoneLabel = new JLabel("\u0110i\u1EC7n Tho\u1EA1i");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 2;
		giaovuInfo.add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField(logged_account.getPhonenumber());
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(10, 30, 10, 5);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 2;
		giaovuInfo.add(phoneField, gbc_phoneField);
		phoneField.setColumns(20);
		
		JLabel emailLabel = new JLabel("Email");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 3;
		giaovuInfo.add(emailLabel, gbc_emailLabel);
		
		emailField = new JTextField(logged_account.getEmail());
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(10, 30, 10, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 3;
		giaovuInfo.add(emailField, gbc_emailField);
		emailField.setColumns(20);
		
		male = new JRadioButton("Male");
		male.setActionCommand(male.getText());
		buttonGroup.add(male);
		GridBagConstraints gbc_maleRadioButoon = new GridBagConstraints();
		gbc_maleRadioButoon.insets = new Insets(0, 0, 5, 5);
		gbc_maleRadioButoon.gridx = 0;
		gbc_maleRadioButoon.gridy = 5;
		giaovuInfo.add(male, gbc_maleRadioButoon);
		
		female = new JRadioButton("Female");
		female.setActionCommand(female.getText());
		buttonGroup.add(female);
		GridBagConstraints gbc_femaleRadioButton = new GridBagConstraints();
		gbc_femaleRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_femaleRadioButton.gridx = 1;
		gbc_femaleRadioButton.gridy = 5;
		giaovuInfo.add(female, gbc_femaleRadioButton);

		SetSelectedButton(logged_account.getGender());

		JPanel buttonFunctionsPane = new JPanel();
		GridBagConstraints gbc_buttonFunctionsPane = new GridBagConstraints();
		gbc_buttonFunctionsPane.gridwidth = 2;
		gbc_buttonFunctionsPane.insets = new Insets(0, 0, 5, 5);
		gbc_buttonFunctionsPane.fill = GridBagConstraints.BOTH;
		gbc_buttonFunctionsPane.gridx = 0;
		gbc_buttonFunctionsPane.gridy = 6;
		giaovuInfo.add(buttonFunctionsPane, gbc_buttonFunctionsPane);
		buttonFunctionsPane.setLayout(new BoxLayout(buttonFunctionsPane, BoxLayout.X_AXIS));
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logged_account.setName(nameField.getText());
				logged_account.setFaculty(facultyField.getText());
				logged_account.setGender(buttonGroup.getSelection().getActionCommand());
				logged_account.setPhonenumber(phoneField.getText());
				logged_account.setEmail(emailField.getText());
				GiaovuAccountDAO.Update(logged_account);
				LoadDataIntoTable(new GiaovuAccountEntity(), giaovuAccountTable);
				JOptionPane.showMessageDialog(null,"New information has been updated"
				,"Successfully",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonFunctionsPane.add(edit);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		buttonFunctionsPane.add(horizontalGlue_1);
		
		JButton change_password = new JButton("Change password");
		change_password.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePassword frame = new ChangePassword(logged_account,giaovuAccountTable);
				frame.setVisible(true);
			}
		});
		buttonFunctionsPane.add(change_password);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		buttonFunctionsPane.add(horizontalGlue);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonFunctionsPane.add(logout);
	}

	private void SetSelectedButton(String gender) {
		if (gender.equals("Male")) {
			buttonGroup.setSelected(male.getModel(),true);
		}
		else {
			buttonGroup.setSelected(female.getModel(), true);
		}
	}



	//Additional functions
	private TableRowSorter<DefaultTableModel> GetNewSorter(DefaultTableModel model) {
		return new TableRowSorter<DefaultTableModel>(model);
	}
	private void Filter(JTextField FilterField, JTable table) {
		RowFilter<DefaultTableModel,Object> rowFilter = null;
		try {
			rowFilter = RowFilter.regexFilter(FilterField.getText());
		}
		catch (PatternSyntaxException e) {
			e.printStackTrace();
		}
		TableRowSorter<DefaultTableModel> sorter = (TableRowSorter) table.getRowSorter();
		sorter.setRowFilter(rowFilter);
	}

	private void LoadDataIntoTable(Object obj , JTable table) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				Object  obj = getValueAt(0,columnIndex);
				if (obj == null)
					return Object.class;
				return obj.getClass();
			}
		};
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		if (obj instanceof GiaovuAccountEntity) {
			List<GiaovuAccountEntity> list = GiaovuAccountDAO.GetAll();
			model.setColumnIdentifiers(new Object[]{
					"id", "Username", "Password", "Name",
					"Faculty", "Gender", "Phone number", "Email"});
			for (GiaovuAccountEntity acc : list) {
				model.addRow(new Object[]{
						acc.getGiaovuid(), acc.getUsername(),
						acc.getPassword(), acc.getName(),
						acc.getFaculty(), acc.getGender(),
						acc.getPhonenumber(), acc.getEmail()
				});
			}
		}
		else if (obj instanceof SemesterEntity) {
			List<SemesterEntity> list = SemesterDAO.GetAll();
			model.setColumnIdentifiers(new Object[] {
					"id", "Semester name", "Years", "Start date", "End date"
			});
			for (SemesterEntity semester : list) {
				model.addRow(new Object[]{
						semester.getHk_id(), semester.getTenhk(),
						semester.getNamhoc(), semester.getNgaybatdau(),
						semester.getNgayketthuc()
				});
			}
		}
		else if (obj instanceof SubjectEntity) {
			Set<SubjectEntity> list = SemesterDAO.GetSubjectsList(setSemester.getHk_id());
			model.setColumnIdentifiers(new Object[]{
					"id", "Subject code", "Subject name", "Credits"
			});
			for (SubjectEntity subject : list) {
				model.addRow(new Object[] {
						subject.getSubjectid(), subject.getMamh(),
						subject.getTenmh(), subject.getSotinchi()
				});
			}
		}
		else if (obj instanceof ClassEntity) {
			List<ClassEntity> list = ClassDAO.GetAll();
			model.setColumnIdentifiers(new Object[]{
					"id", "Class name", "Total students",
					"Male students", "Female students"
			});
			for (ClassEntity classEntity : list) {
				model.addRow(new Object[]{
						classEntity.getClassid(), classEntity.getClassname(),
						classEntity.getTongsinhvien(),
						classEntity.getTongsinhvienNam(), classEntity.getTongsinhvienNu()
				});
			}
		}
		else if (obj instanceof StudentEntity) {
			Set<StudentEntity> list = selectedClass.getStudentList();
			model.setColumnIdentifiers(new Object[]{
					"id", "MSSV", "Student name", "Gender", "Class"
			});
			for (StudentEntity student : list) {
				model.addRow(new Object[]{
						student.getStudentid(), student.getMssv(),
						student.getTenhs(), student.getGioitinh(),
						student.getClassEntity().getClassname()
				});
			}
		}
		else if (obj instanceof CourseRegisSessionEntity) {
			List<CourseRegisSessionEntity> list = CourseRegisSessionDAO.GetAll();
			model.setColumnIdentifiers(new Object[]{
					"id", "Semester", "School year", "Start date", "End date"
			});
			for (CourseRegisSessionEntity it : list) {
				SemesterEntity semester = SemesterDAO.Get(it.getCourseRegisId());
				model.addRow(new Object[]{
						it.getCourseRegisId(), semester.getTenhk(),
						semester.getNamhoc(), it.getNgaybatdau(),
						it.getNgaykethuc()
				});
			}
		}
		else if (obj instanceof CourseEntity) {
			Set<CourseEntity> list = CourseRegisSessionDAO.GetCourseList(setSemester.getHk_id());
			model.setColumnIdentifiers(new Object[]{
					"id", "Subject code", "Subject name", "Credits", "Teacher name", "Room",
					"Day", "Time", "Slot"
			});
			for (CourseEntity course : list) {
				model.addRow(new Object[]{
						course.getCourseid(),
						course.getSubject().getMamh(), course.getSubject().getTenmh(),
						course.getSubject().getSotinchi(), course.getTeacher(),
						course.getRoom(), course.getDay(), course.getTime(), course.getMaxSlot()
				});
			}
		}
		table.setRowSorter(null);
		table.setModel(model);
		table.setRowSorter(sorter);
	}
}