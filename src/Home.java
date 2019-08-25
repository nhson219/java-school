import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import listener.ShowImportFileStudent;
import listener.ShowImportFileSubject;
import listener.ShowAddStudentDialog;
import listener.ShowImportFileScore;
import listener.ShowEditStudentDialog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import object.Student;
import object.Score;
import object.Subject;

public class Home {
	public static void main(String[] args) {
		JFrame f = new JFrame();// creating instance of JFrame
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		JPanel subPanelStudent = new JPanel();
		SpringLayout layout = new SpringLayout();
		subPanelStudent.setLayout(layout);
		JPanel subPanelSchedule = new JPanel();
		subPanelSchedule.setLayout(new BorderLayout());
		JPanel subPanelScore = new JPanel();
		subPanelScore.setLayout(new BorderLayout());

		JPanel buttonPanelLeft = new JPanel();

		JTabbedPane tp = new JTabbedPane();

		JButton btnImportStudent = new JButton("Import Student");// creating instance of JButton
		JButton btnImportSchedule = new JButton("Import Schedule");// creating instance of JButton
		JButton btnImportScore = new JButton("Import Score");// creating instance of JButton
		JButton btnAddStudent = new JButton("Add Student");
		JButton btnEditStudent = new JButton("Edit Student");

		btnImportStudent.addActionListener(new ShowImportFileStudent());
		btnImportSchedule.addActionListener(new ShowImportFileSubject());
		btnImportScore.addActionListener(new ShowImportFileScore());
		btnAddStudent.addActionListener(new ShowAddStudentDialog());
		

		buttonPanel.add(btnImportStudent);
		buttonPanel.add(btnImportSchedule);
		buttonPanel.add(btnImportScore);

		Object[][] tableDataStudent = getDataStudent();
		String columnStudent[] = { "ID", "MSSV", "Họ Tên", "Giới tính ", "CMND" };
		JTable jtStudent = new JTable(tableDataStudent, columnStudent);
		JScrollPane spStudent = new JScrollPane(jtStudent);

		Object[][] tableDataScore = getDataScore();
		String columnScore[] = { "MSSV", "Họ Tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng" };
		JTable jtScore = new JTable(tableDataScore, columnScore);
		System.out.print(jtScore.getSelectedRow());
		JScrollPane spScore = new JScrollPane(jtScore);

		Object[][] tableDataSubject = getDataSubject();
		String columnSchedule[] = { "ID", "Môn học", "Phòng học" };
		JTable jtSchedule = new JTable(tableDataSubject, columnSchedule);
		JScrollPane spSchedule = new JScrollPane(jtSchedule);

		subPanelStudent.add(btnAddStudent);
		subPanelStudent.add(btnEditStudent);
		subPanelStudent.add(spStudent);

		layout.putConstraint(SpringLayout.NORTH, btnAddStudent, 2, SpringLayout.NORTH, subPanelStudent);
		layout.putConstraint(SpringLayout.WEST, btnAddStudent, 2, SpringLayout.NORTH, subPanelStudent);

		layout.putConstraint(SpringLayout.NORTH, btnEditStudent, 2, SpringLayout.NORTH, subPanelStudent);
		layout.putConstraint(SpringLayout.WEST, btnAddStudent, 2, SpringLayout.EAST, btnEditStudent);

		layout.putConstraint(SpringLayout.NORTH, spStudent, 2, SpringLayout.SOUTH, btnAddStudent);
		layout.putConstraint(SpringLayout.WEST, spStudent, 2, SpringLayout.WEST, subPanelStudent);

//		layout.putConstraint(SpringLayout.BASELINE, spStudent);
		
		btnEditStudent.addActionListener(new ShowEditStudentDialog(jtStudent));

		subPanelSchedule.add(spSchedule);
		subPanelScore.add(spScore);

		tp.add("Student", subPanelStudent);
		tp.add("Schedule", subPanelSchedule);
		tp.add("Score", subPanelScore);

//		buttonPanelLeft.add(btnAddStudent);

		f.add(buttonPanel, BorderLayout.NORTH);
		f.add(tp, BorderLayout.CENTER);
		f.add(buttonPanelLeft, BorderLayout.WEST);

		f.setSize(800, 500);// 800 width and 500 height
//		f.setLayout(null);// using no layout managers
		f.setVisible(true);
	}

	public static Object[][] getDataStudent() {
		Student student = new Student();
		List listStudent = student.listStudent();
		Object[][] tableDataStudent = new Object[listStudent.size()][5];

		int index = 0;
		for (Iterator iterator = listStudent.iterator(); iterator.hasNext();) {
			Student currentStudent = (Student) iterator.next();
			tableDataStudent[index][0] = currentStudent.getId();
			tableDataStudent[index][1] = currentStudent.getMSSV();
			tableDataStudent[index][2] = currentStudent.getName();
			tableDataStudent[index][3] = currentStudent.getCMND();
			tableDataStudent[index][4] = currentStudent.getGender();
			// and so forth
			index++;
		}
		return tableDataStudent;
	}

	public static Object[][] getDataScore() {
		Score score = new Score();
		List listScore = score.listScore();
		Object[][] tableDataScore = new Object[listScore.size()][7];

		int indexScore = 0;
		for (Iterator iterator = listScore.iterator(); iterator.hasNext();) {
			Score currentScore = (Score) iterator.next();
			tableDataScore[indexScore][0] = currentScore.getStudent_id();
			tableDataScore[indexScore][1] = currentScore.getName();
			tableDataScore[indexScore][2] = currentScore.getScore_gk();
			tableDataScore[indexScore][3] = currentScore.getScore_ck();
			tableDataScore[indexScore][4] = currentScore.getScore_different();
			tableDataScore[indexScore][5] = currentScore.getScore();
			// and so forth
			indexScore++;
		}
		return tableDataScore;
	}

	public static Object[][] getDataSubject() {
		Subject subject = new Subject();
		List listSubject = subject.listSubject();
		Object[][] tableDataSubject = new Object[listSubject.size()][3];

		int indexSubject = 0;
		for (Iterator iterator = listSubject.iterator(); iterator.hasNext();) {
			Subject currentSubject = (Subject) iterator.next();
			tableDataSubject[indexSubject][0] = currentSubject.getCode();
			tableDataSubject[indexSubject][1] = currentSubject.getName();
			tableDataSubject[indexSubject][2] = currentSubject.getRoom();
			// and so forth
			indexSubject++;
		}
		return tableDataSubject;
	}
}
