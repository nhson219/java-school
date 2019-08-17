import java.awt.BorderLayout;
import javax.swing.*;
import listener.ShowImportFileStudent;
import listener.ShowImportFileSubject;
import listener.ShowImportFileScore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import object.Student;

public class Home {
	public static void main(String[] args) {
		JFrame f = new JFrame();// creating instance of JFrame
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		JPanel subPanelStudent = new JPanel();
		JPanel subPanelSchedule = new JPanel();
		JPanel subPanelScore = new JPanel();

		JTabbedPane tp = new JTabbedPane();
		tp.add("Student", subPanelStudent);
		tp.add("Schedule", subPanelSchedule);
		tp.add("Score", subPanelScore);

		JButton btnImportStudent = new JButton("Import Student");// creating instance of JButton
		JButton btnImportSchedule = new JButton("Import Schedule");// creating instance of JButton
		JButton btnImportScore = new JButton("Import Score");// creating instance of JButton

		btnImportStudent.addActionListener(new ShowImportFileStudent());
		btnImportSchedule.addActionListener(new ShowImportFileSubject());
		btnImportScore.addActionListener(new ShowImportFileScore());

		buttonPanel.add(btnImportStudent);
		buttonPanel.add(btnImportSchedule);
		buttonPanel.add(btnImportScore);

		f.add(buttonPanel, BorderLayout.NORTH);
		f.add(tp, BorderLayout.CENTER);

		f.setSize(800, 500);// 800 width and 500 height
//		f.setLayout(null);// using no layout managers
		f.setVisible(true);

//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Student.class).buildSessionFactory();
//
//		// create a Session
//		Session session = sessionFactory.getCurrentSession();
//
//		try {
//
//			System.out.println("Creating a new Student object...");
//
//			// create the Student object
//			Student student = new Student("123", "test", "1", "male");
//
//			// start a transaction
//			session.beginTransaction();
//
//			// Save the Student object to the database
//			session.save(student);
//
//			System.out.println("Java object saved to the database");
//			// commit the transaction
//			session.getTransaction().commit();
//
//		} finally {
//
//			sessionFactory.close();
//		}

	}
}
