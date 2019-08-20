package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import dialog.AddStudentDialog;

public class ShowAddStudentDialog implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			AddStudentDialog addStudentDialog = new AddStudentDialog();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
