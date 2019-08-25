package dialog;

import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
		JRadioButton radio_male = new JRadioButton("Male");    
		radio_male.setActionCommand("male");
		JRadioButton radio_female = new JRadioButton("Female");
		radio_male.setActionCommand("female");
		ButtonGroup buttonGroup = new ButtonGroup();    
		buttonGroup.add(radio_male);buttonGroup.add(radio_female);    
		
		JLabel lblCMND = new JLabel("CMND");
		JTextField txtCMND = new JTextField();
		
		JButton btnSubmit = new JButton();
		JLabel lblbutton = new JLabel("button");
		btnSubmit.addActionListener(new AddStudent(MSSV, txtName, buttonGroup, txtCMND));

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		groupLayout.setHorizontalGroup(
					groupLayout.createSequentialGroup()
						.addGroup(
								groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(lblMSSV)
									.addComponent(lblName)
									.addComponent(lblGender)
									.addComponent(lblCMND)
									.addComponent(lblbutton)
								)
						.addGroup(
								groupLayout.createParallelGroup()
									.addComponent(MSSV)
									.addComponent(txtName)
									.addGroup(groupLayout.createSequentialGroup()
								              .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								                  .addComponent(radio_male))
//								                  .addComponent(radio_female))
								              .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//									                  .addComponent(radio_male)
									                  .addComponent(radio_female))
								              )
									.addComponent(txtCMND)
									.addComponent(btnSubmit)
								)
				);

		groupLayout.setVerticalGroup(
					groupLayout.createSequentialGroup()
						.addGroup(
								groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(lblMSSV)
									.addComponent(MSSV)
								)
						.addGroup(
								groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(txtName)
								)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblGender)
						        .addGroup(groupLayout.createSequentialGroup()
						            .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						                .addComponent(radio_male)
						                .addComponent(radio_female))
						            )
						           
						        )
						.addGroup(
								groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblCMND)
								.addComponent(txtCMND)
								)
						.addGroup(
								groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblbutton)
								.addComponent(btnSubmit)
								)
//						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
					);
		
		
		
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 300);
		dialog.setVisible(true);

	}

	public void test() {
		System.out.print("adasda");
	}
}
