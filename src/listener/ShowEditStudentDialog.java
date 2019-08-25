package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import dialog.EditStudentDialog;

public class ShowEditStudentDialog implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			EditStudentDialog editStudentDialog = new EditStudentDialog();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
