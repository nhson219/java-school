import java.awt.BorderLayout;
import javax.swing.*;
import listener.ShowImportFileStudent;
import listener.ShowImportFileSchedule;
import listener.ShowImportFileScore;

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
		btnImportSchedule.addActionListener(new ShowImportFileSchedule());
		btnImportScore.addActionListener(new ShowImportFileScore());

		
		
		buttonPanel.add(btnImportStudent);
		buttonPanel.add(btnImportSchedule);
		buttonPanel.add(btnImportScore);
		
		f.add(buttonPanel, BorderLayout.NORTH);
		f.add(tp, BorderLayout.CENTER);
		
		f.setSize(800, 500);// 800 width and 500 height
//		f.setLayout(null);// using no layout managers
		f.setVisible(true);

	}
}
