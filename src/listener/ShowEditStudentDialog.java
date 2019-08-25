package listener;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import dialog.EditStudentDialog;
import manage.ManageStudent;
import object.Student;

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
			
//			System.out.print(this.jtStudent.getValueAt(this.jtStudent.getSelectedRow(), 0));
			
			Integer id = (Integer) this.jtStudent.getValueAt(this.jtStudent.getSelectedRow(), 0);
			
			ManageStudent mng_student = new ManageStudent();
			Student data = mng_student.getStudent();
			
			
			System.out.print(data.getMSSV());
			
			JDialog dialog = new JDialog();

			GroupLayout groupLayout = new GroupLayout(dialog.getContentPane());

			dialog.setLayout(groupLayout);

			JLabel lblMSSV = new JLabel("MSSV");
			JTextField MSSV = new JTextField();
			MSSV.setText(data.getMSSV());
			
			JLabel lblName = new JLabel("Name");
			JTextField txtName = new JTextField();
			txtName.setText(data.getName());
			
			JLabel lblGender = new JLabel("Gender");
			JRadioButton radio_male = new JRadioButton("Male");    
			JRadioButton radio_female = new JRadioButton("Female");    
			ButtonGroup buttonGroup = new ButtonGroup();    
			buttonGroup.add(radio_male);buttonGroup.add(radio_female);    
			
			JLabel lblCMND = new JLabel("CMND");
			JTextField txtCMND = new JTextField();
			txtCMND.setText(data.getCMND());
			
			JButton btnSubmit = new JButton();
			JLabel lblbutton = new JLabel("button");
//			btnSubmit.addActionListener(new AddStudent(MSSV, txtName, txtGender, txtCMND));

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
//									                  .addComponent(radio_female))
									              .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//										                  .addComponent(radio_male)
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
						);
			
			
			
			dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setSize(300, 300);
			dialog.setVisible(true);
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
