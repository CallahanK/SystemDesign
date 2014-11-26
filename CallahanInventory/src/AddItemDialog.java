import java.awt.BorderLayout;
import java.awt.Color;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;


public class AddItemDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JLabel lblItemId = new JLabel("Item Id:");
	private final JLabel lblItemName = new JLabel("Item Name:");
	private final JLabel lblCategory = new JLabel("Category: ");
	private final JLabel lblWholesalePrice = new JLabel("Wholesale Price:");
	private final JLabel lblRetailPrice = new JLabel("Retail Price:");
	private final JLabel lblQoh = new JLabel("QoH:");
	private final JLabel lblMinQuant = new JLabel("MinQuant:");
	private final JLabel lblClerk = new JLabel("Clerk:");
	private final JTextField txtItemId = new JTextField();
	private final JTextField txtItemName = new JTextField();
	private final JComboBox comboBox = new JComboBox();
	private final JTextField txtWholesalePrice = new JTextField();
	private final JTextField txtRetailPrice = new JTextField();
	private final JTextField txtQoh = new JTextField();
	private final JTextField txtMinQuant = new JTextField();
	private final JTextField txtClerk = new JTextField();
	private final JLabel lblPleaseInputItem = new JLabel("Please input item information:");

	private String queryInsert = "";
	private String insertedItemId = "";
	private String insertedItemName = "";
	
	private Boolean attemptInsert = false;
	
	private final JLabel label = new JLabel("$");
	private final JLabel label_1 = new JLabel("$");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddItemDialog dialog = new AddItemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddItemDialog() {
		jbInit();
	}
	private void jbInit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddItemDialog.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setTitle("Add Item");
		setResizable(false);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setBounds(100, 100, 253, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblItemId.setBounds(12, 45, 96, 16);
		
		contentPanel.add(lblItemId);
		lblItemName.setBounds(12, 74, 96, 16);
		
		contentPanel.add(lblItemName);
		lblCategory.setBounds(12, 103, 96, 16);
		
		contentPanel.add(lblCategory);
		lblWholesalePrice.setBounds(12, 132, 96, 16);
		
		contentPanel.add(lblWholesalePrice);
		lblRetailPrice.setBounds(12, 161, 96, 16);
		
		contentPanel.add(lblRetailPrice);
		lblQoh.setBounds(12, 190, 96, 16);
		
		contentPanel.add(lblQoh);
		lblMinQuant.setBounds(12, 219, 96, 16);
		
		contentPanel.add(lblMinQuant);
		lblClerk.setBounds(12, 251, 96, 16);
		
		contentPanel.add(lblClerk);
		txtItemId.setHorizontalAlignment(SwingConstants.TRAILING);
		txtItemId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txtItemId_focusLost(arg0);
			}
		});
		txtItemId.setColumns(10);
		txtItemId.setBounds(120, 42, 116, 22);
		
		contentPanel.add(txtItemId);
		txtItemName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtItemName_focusLost(e);
			}
		});
		txtItemName.setText("");
		txtItemName.setColumns(10);
		txtItemName.setBounds(120, 71, 116, 22);
		
		contentPanel.add(txtItemName);
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_comboBox_focusLost(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Dairy", "Meat", "Frozen", "Canned", "Produce", "Beverage", "Paper", "Snack", "Cereal", "Other"}));
		comboBox.setBounds(120, 100, 116, 22);
		
		contentPanel.add(comboBox);
		txtWholesalePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		txtWholesalePrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtWholesalePrice_focusLost(e);
			}
		});
		txtWholesalePrice.setColumns(10);
		txtWholesalePrice.setBounds(130, 129, 106, 22);
		
		contentPanel.add(txtWholesalePrice);
		txtRetailPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		txtRetailPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtRetailPrice_focusLost(e);
			}
		});
		txtRetailPrice.setColumns(10);
		txtRetailPrice.setBounds(130, 158, 106, 22);
		
		contentPanel.add(txtRetailPrice);
		txtQoh.setHorizontalAlignment(SwingConstants.TRAILING);
		txtQoh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtQoh_focusLost(e);
			}
		});
		txtQoh.setColumns(10);
		txtQoh.setBounds(120, 187, 116, 22);
		
		contentPanel.add(txtQoh);
		txtMinQuant.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMinQuant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtMinQuant_focusLost(e);
			}
		});
		txtMinQuant.setColumns(10);
		txtMinQuant.setBounds(120, 216, 116, 22);
		
		contentPanel.add(txtMinQuant);
		txtClerk.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtClerk_focusLost(e);
			}
		});
		txtClerk.setColumns(10);
		txtClerk.setBounds(120, 248, 116, 22);
		
		contentPanel.add(txtClerk);
		lblPleaseInputItem.setBounds(12, 13, 224, 16);
		
		contentPanel.add(lblPleaseInputItem);
		label.setBounds(120, 132, 7, 16);
		
		contentPanel.add(label);
		label_1.setBounds(120, 161, 7, 16);
		
		contentPanel.add(label_1);
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
	
	public String getQueryInsert(){
		return queryInsert;
	}
	
	public String getInsertItemId(){
		return insertedItemId;
	}
	
	public String getInsertItemName(){
		return insertedItemName;
	}
	
	public Boolean isAttemptingInsert(){
		return attemptInsert;
	}
	
	protected void do_okButton_actionPerformed(ActionEvent e) {
		if(isFormCompleted()){		
		
		insertedItemId = txtItemId.getText().trim();
		insertedItemName = txtItemName.getText().trim();	
			
		queryInsert = "insert into inventory values (";
		queryInsert = queryInsert + insertedItemId + ", ";
		queryInsert = queryInsert + "'" + insertedItemName + "', ";
		queryInsert = queryInsert + "'" + comboBox.getSelectedItem().toString().trim()  + "', ";
		queryInsert = queryInsert + txtWholesalePrice.getText().trim() + ", ";
		queryInsert = queryInsert + txtRetailPrice.getText().trim() + ", ";
		queryInsert = queryInsert + txtQoh.getText().trim() + ", ";
		queryInsert = queryInsert + txtMinQuant.getText().trim() + ", ";
		queryInsert = queryInsert + "'" + txtClerk.getText().trim() + "' )";
		
		//System.out.println(queryInsert);
		
		this.setVisible(false);
		}
		
		else{
			JOptionPane.showMessageDialog(this,
				    "Please complete all inputs.",
				    "Incomplete Form",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		attemptInsert = true;
	}
	
	private Boolean isFormCompleted(){
		Boolean completed = true;
		
		if(txtItemId.getText().isEmpty())
			completed = false;
		if(txtItemName.getText().isEmpty())
			completed = false;
		if(comboBox.getSelectedIndex() <= 0)
			completed = false;
		if(txtWholesalePrice.getText().isEmpty())
			completed = false;
		if(txtRetailPrice.getText().isEmpty())
			completed = false;
		if(txtQoh.getText().isEmpty())
			completed = false;
		if(txtMinQuant.getText().isEmpty())
			completed = false;
		if(txtClerk.getText().isEmpty())
			completed = false;		
		
		return completed;
	}
	
	private void checkIntInput(JTextField tempField){
		if (!tempField.getText().matches("[0-9]+")){
			JOptionPane.showMessageDialog(this,
				    "Please input a valid positive integer.",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			tempField.setText("0");
			tempField.grabFocus();
		}
		else if( Integer.parseInt(tempField.getText()) > 99999){
			JOptionPane.showMessageDialog(this,
				    "Please input an integer less than 99999.",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			tempField.setText("0");
			tempField.grabFocus();
		}
	}
	
	private void checkDoubleInput(JTextField tempField){
		if (!tempField.getText().matches("[0-9]+.?[0-9]{0,2}")){
			JOptionPane.showMessageDialog(this,
				    "Please input a valid positive dollar amount.",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			//tempField.setText("0.00");
			tempField.grabFocus();
		}
		else if( Double.parseDouble(tempField.getText()) > 99999){
			JOptionPane.showMessageDialog(this,
				    "Please input an amount less than 99999.",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			//tempField.setText("0");
			tempField.grabFocus();
		}
	}
	
	protected void do_txtItemId_focusLost(FocusEvent arg0) {
		checkIntInput(txtItemId);
	}
	protected void do_txtItemName_focusLost(FocusEvent e) {
		if (!txtItemName.getText().matches("[a-zA-Z0-9 -]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid item name",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtItemName.setText("");
			txtItemName.grabFocus();
		}
	}
	protected void do_comboBox_focusLost(FocusEvent e) {
		if (comboBox.getSelectedIndex() <= 0){
			JOptionPane.showMessageDialog(this,
				    "Please select a category",
				    "Invalid Selection",
				    JOptionPane.WARNING_MESSAGE);
		}
		
	}
	protected void do_txtWholesalePrice_focusLost(FocusEvent e) {
		checkDoubleInput(txtWholesalePrice);
	}
	protected void do_txtRetailPrice_focusLost(FocusEvent e) {
		checkDoubleInput(txtRetailPrice);
	}
	protected void do_txtQoh_focusLost(FocusEvent e) {
		checkIntInput(txtQoh);
	}
	protected void do_txtMinQuant_focusLost(FocusEvent e) {
		checkIntInput(txtMinQuant);
	}
	protected void do_txtClerk_focusLost(FocusEvent e) {
		if (!txtClerk.getText().matches("[a-zA-Z ']+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid clerk",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtClerk.setText("");
			txtClerk.grabFocus();
		}
	}
}
