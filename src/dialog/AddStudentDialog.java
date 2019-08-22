package dialog;

import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import listener.AddStudent;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;


public class AddStudentDialog extends JDialog {
	
	public AddStudentDialog() {


		JDialog dialog = new JDialog();

		GroupLayout groupLayout = new GroupLayout(dialog.getContentPane());

		dialog.setLayout(groupLayout);

		JLabel lblMSSV = new JLabel("MSSV");
		JTextField MSSV = new JTextField();
		
		JLabel lblName = new JLabel("Name");
		JTextField txtName = new JTextField();
		
		JLabel lblGender = new JLabel("Gender");
		JTextField txtGender = new JTextField();
		
		JLabel lblCMND = new JLabel("CMND");
		JTextField txtCMND = new JTextField();
		
		JButton btnSubmit = new JButton();
		JLabel lblbutton = new JLabel("button");
		btnSubmit.addActionListener(new AddStudent(MSSV, txtName, txtGender, txtCMND));

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(lblMSSV)
						.addComponent(lblName).addComponent(lblGender).addComponent(lblCMND).addComponent(lblbutton))
				.addGroup(groupLayout.createParallelGroup().addComponent(MSSV).addComponent(txtName)
						.addComponent(txtGender).addComponent(txtCMND).addComponent(btnSubmit)));

		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblMSSV)
						.addComponent(MSSV))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblName)
						.addComponent(txtName))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblGender)
						.addComponent(txtGender))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblCMND)
						.addComponent(txtCMND))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblbutton)
						.addComponent(btnSubmit)));
		
		
		
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 300);
		dialog.setVisible(true);

	}

	public void test() {
		System.out.print("adasda");
	}
}
