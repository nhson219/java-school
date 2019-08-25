package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;

import dialog.EditStudentDialog;

public class ShowEditStudentDialog implements ActionListener {
	
	public JTable jtStudent;
	
	
	public ShowEditStudentDialog(JTable jtStudent) {
		this.jtStudent = jtStudent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			EditStudentDialog editStudentDialog = new EditStudentDialog();
//			System.out.print(this.jtStudent.getSelectedRow());
//			System.out.print(this.jtStudent.getSelectedColumn());
			
			System.out.print(this.jtStudent.getValueAt(this.jtStudent.getSelectedRow(), 0));
			
			Integer id = (Integer) this.jtStudent.getValueAt(this.jtStudent.getSelectedRow(), 0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
