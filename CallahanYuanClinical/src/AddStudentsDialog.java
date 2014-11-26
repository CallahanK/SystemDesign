import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddStudentsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JLabel lblPleaseInputStudents = new JLabel("Please input student's information:");
	private final JLabel lblCwid = new JLabel("CWID:");
	private final JLabel lblFirstName = new JLabel("First Name:");
	private final JLabel lblLastName = new JLabel("Last Name:");
	private final JLabel lblStreetAddress = new JLabel("Street Address:");
	private final JLabel lblCity = new JLabel("City:");
	private final JLabel lblState = new JLabel("State:");
	private final JLabel lblZip = new JLabel("Zip:");
	private final JTextField txtCWID = new JTextField();
	private final JTextField txtFName = new JTextField();
	private final JTextField txtLName = new JTextField();
	private final JTextField txtAddress = new JTextField();
	private final JTextField txtCity = new JTextField();
	private final JComboBox comboBox = new JComboBox();
	private final JTextField txtZip = new JTextField();
	private final JLabel lblErrorCwid = new JLabel("*");
	private final JLabel lblErrorFName = new JLabel("*");
	private final JLabel lblErrorLName = new JLabel("*");
	private final JLabel lblErrorAddress = new JLabel("*");
	private final JLabel lblErrorCity = new JLabel("*");
	private final JLabel lblErrorState = new JLabel("*");
	private final JLabel lblErrorZip = new JLabel("*");

	private String queryInsert = "";
	private String insertedCwid = "";
	private String errorGroup = "";
	
	private Boolean attemptInsert = false;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddStudentsDialog dialog = new AddStudentsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddStudentsDialog() {
		txtZip.setToolTipText("Please enter a 5 digit zip code, no special characters.");
		txtZip.setBounds(114, 213, 116, 22);
		txtZip.setColumns(10);
		txtCity.setBounds(114, 155, 116, 22);
		txtCity.setColumns(10);
		txtAddress.setBounds(114, 126, 116, 22);
		txtAddress.setColumns(10);
		txtLName.setBounds(114, 97, 116, 22);
		txtLName.setColumns(10);
		txtFName.setBounds(114, 68, 116, 22);
		txtFName.setColumns(10);
		txtCWID.setToolTipText("Please enter an 8 digit CWID, no special characters.");
		txtCWID.setBounds(114, 39, 116, 22);
		txtCWID.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Add Student");
		setBounds(100, 100, 290, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblPleaseInputStudents.setBounds(12, 13, 218, 16);
		
		contentPanel.add(lblPleaseInputStudents);
		lblCwid.setBounds(12, 42, 90, 16);
		
		contentPanel.add(lblCwid);
		lblFirstName.setBounds(12, 71, 90, 16);
		
		contentPanel.add(lblFirstName);
		lblLastName.setBounds(12, 100, 90, 16);
		
		contentPanel.add(lblLastName);
		lblStreetAddress.setBounds(12, 129, 90, 16);
		
		contentPanel.add(lblStreetAddress);
		lblCity.setBounds(12, 158, 90, 16);
		
		contentPanel.add(lblCity);
		lblState.setBounds(12, 187, 90, 16);
		
		contentPanel.add(lblState);
		lblZip.setBounds(12, 216, 90, 16);
		
		contentPanel.add(lblZip);
		
		contentPanel.add(txtCWID);
		
		contentPanel.add(txtFName);
		
		contentPanel.add(txtLName);
		
		contentPanel.add(txtAddress);
		
		contentPanel.add(txtCity);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		comboBox.setBounds(114, 184, 116, 22);
		
		contentPanel.add(comboBox);
		
		contentPanel.add(txtZip);
		lblErrorCwid.setForeground(Color.RED);
		lblErrorCwid.setBounds(242, 42, 8, 16);
		lblErrorCwid.setVisible(false);
		
		contentPanel.add(lblErrorCwid);
		lblErrorFName.setForeground(Color.RED);
		lblErrorFName.setBounds(242, 71, 8, 16);
		lblErrorFName.setVisible(false);
		
		contentPanel.add(lblErrorFName);
		lblErrorLName.setForeground(Color.RED);
		lblErrorLName.setBounds(242, 100, 8, 16);
		lblErrorLName.setVisible(false);
		
		contentPanel.add(lblErrorLName);
		lblErrorAddress.setForeground(Color.RED);
		lblErrorAddress.setBounds(242, 129, 8, 16);
		lblErrorAddress.setVisible(false);
		
		contentPanel.add(lblErrorAddress);
		lblErrorCity.setForeground(Color.RED);
		lblErrorCity.setBounds(242, 158, 8, 16);
		lblErrorCity.setVisible(false);
		
		contentPanel.add(lblErrorCity);
		lblErrorState.setForeground(Color.RED);
		lblErrorState.setBounds(242, 187, 8, 16);
		lblErrorState.setVisible(false);
		
		contentPanel.add(lblErrorState);
		lblErrorZip.setForeground(Color.RED);
		lblErrorZip.setBounds(242, 216, 8, 16);
		lblErrorZip.setVisible(false);
		
		contentPanel.add(lblErrorZip);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_okButton_actionPerformed(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_cancelButton_actionPerformed(arg0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent arg0) {
		attemptInsert = false;
		this.setVisible(false);
	}
	protected void do_okButton_actionPerformed(ActionEvent e) {
		if(isFormCompleted()){		
			
			insertedCwid = txtCWID.getText().trim();	
				
			queryInsert = "insert into students values (";
			queryInsert = queryInsert + insertedCwid + ", ";
			queryInsert = queryInsert + "'" + txtFName.getText().trim() + "', ";
			queryInsert = queryInsert + "'" + txtLName.getText().trim() + "', ";
			queryInsert = queryInsert + "'" + txtAddress.getText().trim() + "', ";
			queryInsert = queryInsert + "'" + txtCity.getText().trim() + "', ";
			queryInsert = queryInsert + "'" + comboBox.getSelectedItem().toString().trim()  + "', ";
			queryInsert = queryInsert + "'" + txtZip.getText().trim() + "' )";
			
			System.out.println(queryInsert);
			
			this.setVisible(false);
			}
			
		else{
			JOptionPane.showMessageDialog(this,
				    errorGroup,
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
			attemptInsert = true;
	}
	
	public String getQueryInsert(){
		return queryInsert;
	}
	
	public String getInsertedCwid(){
		String tempInsertedCwid = "";
		tempInsertedCwid = "where cwid = " + insertedCwid;
		return tempInsertedCwid;
	}
	
	public Boolean isAttemptingInsert(){
		return attemptInsert;
	}
	
	private void resetErrors(){
		lblErrorCwid.setVisible(false);
		lblErrorFName.setVisible(false);
		lblErrorLName.setVisible(false);
		lblErrorAddress.setVisible(false);
		lblErrorCity.setVisible(false);
		lblErrorState.setVisible(false);
		lblErrorZip.setVisible(false);	
	}
	
	private Boolean isFormCompleted(){
		Boolean completed = true;
		resetErrors();
		errorGroup = "Please correct the following errors: ";
		
		if(txtCWID.getText().isEmpty() || checkCwid(txtCWID)){
			completed = false;
			lblErrorCwid.setVisible(true);
			errorGroup = errorGroup + "CWID, "; 
		}
		if(txtFName.getText().isEmpty() || checkStringInput(txtFName)){
			completed = false;
			lblErrorFName.setVisible(true);
			errorGroup = errorGroup + "First Name, "; 
		}
		if(txtLName.getText().isEmpty() || checkStringInput(txtLName)){
			completed = false;
			lblErrorLName.setVisible(true);
			errorGroup = errorGroup + "Last Name, "; 
		}
		if(txtAddress.getText().isEmpty() || checkStringInput(txtAddress)){
			completed = false;
			lblErrorAddress.setVisible(true);
			errorGroup = errorGroup + "Street Address, ";
		}
		if(txtCity.getText().isEmpty() || checkStringInput(txtCity)){
			completed = false;
			lblErrorCity.setVisible(true);
			errorGroup = errorGroup + "City, ";
		}
		if(comboBox.getSelectedIndex() <= 0){
			completed = false;
			lblErrorState.setVisible(true);
			errorGroup = errorGroup + "State, ";
		}
		if(txtZip.getText().isEmpty() || checkZip(txtZip)){
			completed = false;	
			lblErrorZip.setVisible(true);
			errorGroup = errorGroup + "Zip ";
		}
		
		
		
		return completed;
	}
	
	private Boolean checkStringInput(JTextField tempField){
		if (!tempField.getText().matches("[a-zA-Z0-9 -'.#]+")){
			return true;
		}
		return false;
	}
	
	private Boolean checkZip(JTextField tempField){
		if (!tempField.getText().matches("[0-9]{5}")){
			return true;
		}
		return false;
	}
	
	private Boolean checkCwid(JTextField tempField){
		if (!tempField.getText().matches("[0-9]{8}")){
			return true;
		}
		return false;
	}
}
