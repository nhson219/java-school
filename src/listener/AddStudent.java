package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import dialog.AddStudentDialog;

public class AddStudent implements ActionListener {
	JTextField MSSV;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
//			AddStudentDialog addStudentDialog = new AddStudentDialog();
			
//			 String textFieldValue = MSSV.getText();
			 System.out.print("123");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
