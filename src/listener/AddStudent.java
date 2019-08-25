package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JTextField;

import dialog.AddStudentDialog;

import object.Student;
import manage.ManageStudent;

public class AddStudent implements ActionListener {
	private JTextField MSSV;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtCMND;
	private AddStudentDialog dialog;
	private ButtonGroup buttonGroup;

	public AddStudent(JTextField MSSV, JTextField txtName, ButtonGroup buttonGroup, JTextField txtCMND) {
		this.MSSV = MSSV;
		this.txtName = txtName;
		this.buttonGroup = buttonGroup;
		this.txtCMND = txtCMND;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {

			Student student = new Student();
			ManageStudent manageStudent = new ManageStudent();

			String student_gender = "0";

			if (this.buttonGroup.getSelection().getActionCommand() == "male") {
				student_gender = "1";
			}

			student.insertStudent(this.MSSV.getText(), this.txtName.getText(), student_gender, this.txtCMND.getText());
			manageStudent.addStudent(student);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
