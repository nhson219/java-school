package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import dialog.AddStudentDialog;

import object.Student;
import manage.ManageStudent;

public class EditStudent implements ActionListener {
	private JTextField MSSV;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtCMND;
	private AddStudentDialog dialog;
	
//	public EditStudent(JTextField MSSV, JTextField txtName, JTextField txtGender, JTextField txtCMND) {
//		this.MSSV = MSSV;
//		this.txtName = txtName;
//		this.txtGender = txtGender;
//		this.txtCMND = txtCMND;
//	}
	public EditStudent() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			
//			Student student = new Student();
//			ManageStudent manageStudent = new ManageStudent();
//			student.insertStudent(this.MSSV.getText(), this.txtName.getText(), this.txtGender.getText(), this.txtCMND.getText());
//			manageStudent.addStudent(student);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

