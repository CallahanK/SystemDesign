import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class FilterRetailPriceDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private String outputDisplay = "";
	private String outputQuery = "";
	private final JRadioButton rdbtnGreaterThan = new JRadioButton("Greater than");
	private final JRadioButton rdbtnLessThan = new JRadioButton("Less than");
	private final JRadioButton rdbtnRange = new JRadioButton("Range");
	private final JLabel lblPleaseSelectA = new JLabel("Please select a price filter.");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTextField txtNum1 = new JTextField();
	private final JTextField txtNum2 = new JTextField();
	private final JLabel label = new JLabel("-");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FilterRetailPriceDialog dialog = new FilterRetailPriceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FilterRetailPriceDialog() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Filter By Retail Price");
		setResizable(false);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FilterRetailPriceDialog.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setAlwaysOnTop(true);
		setBounds(100, 100, 433, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		buttonGroup.add(rdbtnGreaterThan);
		rdbtnGreaterThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnGreaterThan_actionPerformed(e);
			}
		});
		rdbtnGreaterThan.setBounds(12, 38, 127, 25);
		
		contentPanel.add(rdbtnGreaterThan);
		buttonGroup.add(rdbtnLessThan);
		rdbtnLessThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnLessThan_actionPerformed(e);
			}
		});
		rdbtnLessThan.setBounds(12, 68, 127, 25);
		
		contentPanel.add(rdbtnLessThan);
		buttonGroup.add(rdbtnRange);
		rdbtnRange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnRange_actionPerformed(e);
			}
		});
		rdbtnRange.setBounds(12, 98, 127, 25);
		
		contentPanel.add(rdbtnRange);
		lblPleaseSelectA.setBounds(12, 13, 151, 16);
		
		contentPanel.add(lblPleaseSelectA);
		txtNum1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txtNum1_focusLost(arg0);
			}
		});
		txtNum1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNum1.setColumns(10);
		txtNum1.setBounds(147, 39, 116, 22);
		
		contentPanel.add(txtNum1);
		txtNum2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtNum2_focusLost(e);
			}
		});
		txtNum2.setEnabled(false);
		txtNum2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNum2.setColumns(10);
		txtNum2.setBounds(293, 39, 116, 22);
		
		contentPanel.add(txtNum2);
		label.setBounds(275, 42, 10, 16);
		
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_okButton_actionPerformed(arg0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_cancelButton_actionPerformed(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void do_okButton_actionPerformed(ActionEvent arg0) {
		if (!rdbtnGreaterThan.isSelected() && !rdbtnLessThan.isSelected() && !rdbtnRange.isSelected()){
			JOptionPane.showMessageDialog(this,
				    "Please make a selection.",
				    "Empty selection",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		if (txtNum1.getText().isEmpty() && !rdbtnRange.isSelected()){
			JOptionPane.showMessageDialog(this,
				    "Please enter a number.",
				    "Empty selection",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		else if (rdbtnRange.isSelected()){
			if (txtNum1.getText().isEmpty() && txtNum2.getText().isEmpty()  &&  rdbtnRange.isSelected()){
				JOptionPane.showMessageDialog(this,
					    "Please enter a range.",
					    "Empty selection",
					    JOptionPane.WARNING_MESSAGE);
			}
			
			if (Double.parseDouble(txtNum1.getText().trim()) > Double.parseDouble(txtNum2.getText().trim())){
				JOptionPane.showMessageDialog(this,
					    "Please enter a valid range.",
					    "Invalid range",
					    JOptionPane.WARNING_MESSAGE);
			}
		
			else {
				outputDisplay = txtNum1.getText() + " - " + txtNum2.getText();
				outputQuery = "AND ( retailprice > " + txtNum1.getText().trim() + " AND retailprice < " + txtNum2.getText().trim() + " )";
				this.setVisible(false);
			}
			
		}
		
		else if (rdbtnGreaterThan.isSelected()){
			outputDisplay = " > " + txtNum1.getText() ;
			outputQuery = "AND ( retailprice > " + txtNum1.getText().trim() + " )";
			this.setVisible(false);
		}
		
		else if (rdbtnLessThan.isSelected()){
			outputDisplay = " < " + txtNum1.getText() ;
			outputQuery = "AND ( retailprice < " + txtNum1.getText().trim() + " )";
			this.setVisible(false);
		}
		
		
	}
	
	public String getDisplayOutput(){
		return outputDisplay;
	}
	
	public String getQueryOutput(){
		return outputQuery;
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
	
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_rdbtnRange_actionPerformed(ActionEvent e) {
		txtNum2.setEnabled(true);
	}
	protected void do_rdbtnLessThan_actionPerformed(ActionEvent e) {
		txtNum2.setEnabled(false);
	}
	protected void do_rdbtnGreaterThan_actionPerformed(ActionEvent e) {
		txtNum2.setEnabled(false);
	}
	protected void do_txtNum1_focusLost(FocusEvent arg0) {
		checkDoubleInput(txtNum1);
	}
	protected void do_txtNum2_focusLost(FocusEvent e) {
		checkDoubleInput(txtNum2);
	}
}
