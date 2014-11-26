import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;


public class AddHospitalsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JLabel lblHospitalsName = new JLabel("Hospital Name: ");
	private final JLabel lblStreetAddress = new JLabel("Street Address: ");
	private final JLabel lblCity = new JLabel("City: ");
	private final JLabel lblState = new JLabel("State: ");
	private final JLabel lblZip = new JLabel("Zip: ");
	private final JLabel lblPleaseInputHospital = new JLabel("Please input hospital information:");
	private final JTextField txtHospitalName = new JTextField();
	private final JTextField txtStreetAddress = new JTextField();
	private final JTextField txtCity = new JTextField();
	private final JTextField txtZip = new JTextField();

	private String queryInsert = "";
	private String insertedHospitalName = "";
	private String errorGroup = "";
	
	private Boolean attemptInsert = false;
	
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblErrorName = new JLabel("*");
	private final JLabel lblErrorAddress = new JLabel("*");
	private final JLabel lblErrorCity = new JLabel("*");
	private final JLabel lblErrorState = new JLabel("*");
	private final JLabel lblErrorZip = new JLabel("*");
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddHospitalsDialog dialog = new AddHospitalsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddHospitalsDialog() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Add Hospital");
		setModalityType(ModalityType.DOCUMENT_MODAL);
		txtZip.setToolTipText("Please enter a 5 digit zip code, no special characters.");
		txtZip.setBounds(121, 155, 116, 22);
		txtZip.setColumns(10);
		txtCity.setBounds(121, 97, 116, 22);
		txtCity.setColumns(10);
		txtStreetAddress.setBounds(121, 68, 116, 22);
		txtStreetAddress.setColumns(10);
		txtHospitalName.setToolTipText("Please input a unique hospital name.");
		txtHospitalName.setBounds(121, 39, 116, 22);
		txtHospitalName.setColumns(10);
		setBounds(100, 100, 291, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblHospitalsName.setBounds(12, 42, 97, 16);
		
		contentPanel.add(lblHospitalsName);
		lblStreetAddress.setBounds(12, 71, 97, 16);
		
		contentPanel.add(lblStreetAddress);
		lblCity.setBounds(12, 100, 97, 16);
		
		contentPanel.add(lblCity);
		lblState.setBounds(12, 129, 97, 16);
		
		contentPanel.add(lblState);
		lblZip.setBounds(12, 158, 97, 16);
		
		contentPanel.add(lblZip);
		lblPleaseInputHospital.setBounds(12, 13, 191, 16);
		
		contentPanel.add(lblPleaseInputHospital);
		
		contentPanel.add(txtHospitalName);
		
		contentPanel.add(txtStreetAddress);
		
		contentPanel.add(txtCity);
		
		contentPanel.add(txtZip);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		comboBox.setBounds(121, 126, 116, 22);
		
		contentPanel.add(comboBox);
		lblErrorName.setForeground(Color.RED);
		lblErrorName.setBounds(249, 42, 8, 16);
		lblErrorName.setVisible(false);
		
		contentPanel.add(lblErrorName);
		lblErrorAddress.setForeground(Color.RED);
		lblErrorAddress.setBounds(249, 68, 8, 16);
		lblErrorAddress.setVisible(false);
		
		contentPanel.add(lblErrorAddress);
		lblErrorCity.setForeground(Color.RED);
		lblErrorCity.setBounds(249, 97, 8, 16);
		lblErrorCity.setVisible(false);
		
		contentPanel.add(lblErrorCity);
		lblErrorState.setForeground(Color.RED);
		lblErrorState.setBounds(249, 126, 8, 16);
		lblErrorState.setVisible(false);
		
		contentPanel.add(lblErrorState);
		lblErrorZip.setForeground(Color.RED);
		lblErrorZip.setBounds(249, 155, 8, 16);
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
			
			insertedHospitalName = txtHospitalName.getText().trim();	
				
			queryInsert = "insert into hospitals values (";
			queryInsert = queryInsert + "'" + insertedHospitalName + "', ";
			queryInsert = queryInsert + "'" + txtStreetAddress.getText().trim() + "', ";
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
	
	public String getInsertedHospitalName(){
		String tempInsertedHospitalName = "";
		tempInsertedHospitalName = "where hospitalname = '" + insertedHospitalName + " ' ";
		return tempInsertedHospitalName;
	}
	
	public Boolean isAttemptingInsert(){
		return attemptInsert;
	}
	
	private void resetErrors(){
		lblErrorName.setVisible(false);
		lblErrorAddress.setVisible(false);
		lblErrorCity.setVisible(false);
		lblErrorState.setVisible(false);
		lblErrorZip.setVisible(false);	
	}
	
	private Boolean isFormCompleted(){
		Boolean completed = true;
		resetErrors();
		errorGroup = "Please correct the following errors: ";
		
		if(txtHospitalName.getText().isEmpty() || checkStringInput(txtHospitalName)){
			completed = false;
			lblErrorName.setVisible(true);
			errorGroup = errorGroup + "Hospital Name, "; 
		}
		if(txtStreetAddress.getText().isEmpty() || checkStringInput(txtStreetAddress)){
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
	
}
