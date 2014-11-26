import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dialog.ModalityType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.SystemColor;


public class AddLabDialog extends JDialog {

	private static final int PROGRAM_LENGTH_WEEKS = 23;
	
	private static final String[] LAB_NAMES_ARRAY = {"Hematology", "Blood Bank", "Clinical Chemistry", "Clinical Microbiology", "Urinalysis", "Outpatient Phlebotomy", "Inpatient Phlebotomy"};
	private static final int[] LAB_NUMBERS_ARRAY = {5, 5, 5, 6, 1, 1, 3};
	
	private JCheckBox[] hematologyArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] bloodArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] chemistryArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] microbiologyArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] urinalysisArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] outpatientArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	private JCheckBox[] inpatientArray = new JCheckBox[PROGRAM_LENGTH_WEEKS];
	
	private JCheckBox[][] allLabsArray = { hematologyArray, bloodArray, chemistryArray, microbiologyArray, urinalysisArray, outpatientArray, inpatientArray };
	
	private final JPanel contentPanel = new JPanel();
	private final JPanel panelHematology = new JPanel();
	private final JPanel panelBlood = new JPanel();
	private final JPanel panelChemistry = new JPanel();
	private final JPanel panelMicrobiology = new JPanel();
	private final JPanel panelUrinalysis = new JPanel();
	private final JPanel panelOutpatient = new JPanel();
	private final JPanel panelInpatient = new JPanel();
	private final JLabel lblHematology = new JLabel("Hematology:");
	private final JLabel lblBloodBank = new JLabel("Blood Bank:");
	private final JLabel lblClinicalChemistry = new JLabel("<html> Clinical <br>Chemistry:");
	private final JLabel lblClinicalMicrobiology = new JLabel("<html> Clinical <br>Microbiology:");
	private final JLabel lblUrinalysis = new JLabel("Urinalysis:");
	private final JLabel lblOutpatientPhlebotomy = new JLabel("<html> Outpatient <br>Phlebotomy:");
	private final JLabel lblInpatientPhlebotomy = new JLabel("<html> Inpatient <br> \r\nPhlebotomy:");
	private final JCheckBox chkSelectHematology = new JCheckBox("");
	private final JCheckBox chkSelectBlood = new JCheckBox("");
	private final JCheckBox chkSelectChemistry = new JCheckBox("");
	private final JCheckBox chkSelectMicrobiology = new JCheckBox("");
	private final JCheckBox chkSelectUrinalysis = new JCheckBox("");
	private final JCheckBox chkSelectOutpatient = new JCheckBox("");
	private final JCheckBox chkSelectInpatient = new JCheckBox("");
	private final JLabel lblWeeks = new JLabel("      1        2        3        4        5        6        7        8        9       10     11      12      13     14      15     16      17      18      19     20      21     22      23");
	private final JLabel lblSelectAllDeselect = new JLabel("<html>Select All/ <br> Deselect All");
	private final JLabel lblWeeks_1 = new JLabel("Weeks:");
	private final JLabel lblHospitals = new JLabel("Hospitals:");
	private final JComboBox comboBox = new JComboBox();
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblBackgroundColor = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddLabDialog dialog = new AddLabDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddLabDialog() {
		jbInit();
	}
	private void jbInit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				do_this_componentShown(arg0);
			}
		});
		setTitle("Add Labs");
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setBounds(100, 100, 896, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(131, 131, 10, 323);
		
		contentPanel.add(separator_1);
		{
			JLabel lblPleaseInputLab = new JLabel("Please select a hospital then choose weeks:");
			lblPleaseInputLab.setBounds(12, 13, 315, 16);
			contentPanel.add(lblPleaseInputLab);
		}
		panelHematology.setBackground(SystemColor.control);
		panelHematology.setBounds(133, 131, 730, 35);
		
		contentPanel.add(panelHematology);
		panelHematology.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(hematologyArray, panelHematology);
		panelBlood.setBackground(SystemColor.control);
		
		panelBlood.setBounds(133, 179, 730, 35);
		
		contentPanel.add(panelBlood);
		panelBlood.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(bloodArray, panelBlood);
		panelChemistry.setBackground(SystemColor.control);
		
		panelChemistry.setBounds(133, 227, 730, 35);
		
		contentPanel.add(panelChemistry);
		panelChemistry.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(chemistryArray, panelChemistry);
		panelMicrobiology.setBackground(SystemColor.control);
		
		panelMicrobiology.setBounds(133, 275, 730, 35);
		
		contentPanel.add(panelMicrobiology);
		panelMicrobiology.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(microbiologyArray, panelMicrobiology);
		panelUrinalysis.setBackground(SystemColor.control);
		
		panelUrinalysis.setBounds(133, 323, 730, 35);
		
		contentPanel.add(panelUrinalysis);
		panelUrinalysis.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(urinalysisArray, panelUrinalysis);
		panelOutpatient.setBackground(SystemColor.control);
		
		panelOutpatient.setBounds(133, 371, 730, 35);
		
		contentPanel.add(panelOutpatient);
		panelOutpatient.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(outpatientArray, panelOutpatient);
		panelInpatient.setBackground(SystemColor.control);
		
		panelInpatient.setBounds(133, 419, 730, 35);
		
		contentPanel.add(panelInpatient);
		panelInpatient.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		createWeekChecks(inpatientArray, panelInpatient);
		lblHematology.setVerticalAlignment(SwingConstants.TOP);
		
		lblHematology.setBounds(12, 131, 76, 35);
		
		contentPanel.add(lblHematology);
		lblBloodBank.setVerticalAlignment(SwingConstants.TOP);
		lblBloodBank.setBounds(12, 179, 76, 35);
		
		contentPanel.add(lblBloodBank);
		lblClinicalChemistry.setVerticalAlignment(SwingConstants.TOP);
		lblClinicalChemistry.setBounds(12, 227, 76, 35);
		
		contentPanel.add(lblClinicalChemistry);
		lblClinicalMicrobiology.setVerticalAlignment(SwingConstants.TOP);
		lblClinicalMicrobiology.setBounds(12, 275, 76, 35);
		
		contentPanel.add(lblClinicalMicrobiology);
		lblUrinalysis.setVerticalAlignment(SwingConstants.TOP);
		lblUrinalysis.setBounds(12, 323, 76, 16);
		
		contentPanel.add(lblUrinalysis);
		lblOutpatientPhlebotomy.setVerticalAlignment(SwingConstants.TOP);
		lblOutpatientPhlebotomy.setBounds(12, 371, 76, 35);
		
		contentPanel.add(lblOutpatientPhlebotomy);
		lblInpatientPhlebotomy.setVerticalAlignment(SwingConstants.TOP);
		lblInpatientPhlebotomy.setBounds(12, 418, 76, 35);
		
		contentPanel.add(lblInpatientPhlebotomy);
		chkSelectHematology.setVerticalAlignment(SwingConstants.TOP);
		chkSelectHematology.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectHematology_actionPerformed(e);
			}
		});
		chkSelectHematology.setBounds(100, 131, 25, 35);
		
		contentPanel.add(chkSelectHematology);
		chkSelectBlood.setVerticalAlignment(SwingConstants.TOP);
		chkSelectBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectBlood_actionPerformed(e);
			}
		});
		chkSelectBlood.setBounds(100, 179, 25, 35);
		
		contentPanel.add(chkSelectBlood);
		chkSelectChemistry.setVerticalAlignment(SwingConstants.TOP);
		chkSelectChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectChemistry_actionPerformed(e);
			}
		});
		chkSelectChemistry.setBounds(100, 227, 25, 35);
		
		contentPanel.add(chkSelectChemistry);
		chkSelectMicrobiology.setVerticalAlignment(SwingConstants.TOP);
		chkSelectMicrobiology.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectMicrobiology_actionPerformed(e);
			}
		});
		chkSelectMicrobiology.setBounds(100, 275, 25, 35);
		
		contentPanel.add(chkSelectMicrobiology);
		chkSelectUrinalysis.setVerticalAlignment(SwingConstants.TOP);
		chkSelectUrinalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectUrinalysis_actionPerformed(e);
			}
		});
		chkSelectUrinalysis.setBounds(100, 323, 25, 35);
		
		contentPanel.add(chkSelectUrinalysis);
		chkSelectOutpatient.setVerticalAlignment(SwingConstants.TOP);
		chkSelectOutpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectOutpatient_actionPerformed(e);
			}
		});
		chkSelectOutpatient.setBounds(100, 371, 25, 35);
		
		contentPanel.add(chkSelectOutpatient);
		chkSelectInpatient.setVerticalAlignment(SwingConstants.TOP);
		chkSelectInpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chkSelectInpatient_actionPerformed(e);
			}
		});
		chkSelectInpatient.setBounds(100, 419, 25, 35);
		
		contentPanel.add(chkSelectInpatient);
		lblWeeks.setBounds(133, 102, 730, 16);
		
		contentPanel.add(lblWeeks);
		lblSelectAllDeselect.setBounds(65, 87, 76, 35);
		
		contentPanel.add(lblSelectAllDeselect);
		lblWeeks_1.setBounds(443, 73, 56, 16);
		
		contentPanel.add(lblWeeks_1);
		lblHospitals.setBounds(12, 42, 56, 16);
		
		contentPanel.add(lblHospitals);
		comboBox.setToolTipText("All labs selected will be added to this hospital.");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_actionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", ""}));
		comboBox.setBounds(80, 42, 115, 22);
		
		contentPanel.add(comboBox);
		lblBackgroundColor.setBackground(SystemColor.textHighlightText);
		lblBackgroundColor.setBounds(134, 93, 735, 368);
		lblBackgroundColor.setOpaque(true);
		
		contentPanel.add(lblBackgroundColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Update Labs");
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
				JButton cancelButton = new JButton("Exit");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_cancelButton_actionPerformed(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		//Load the driver
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	private void createWeekChecks(JCheckBox[] tempArray, JPanel tempPanel){
		for (int i = 0; i < tempArray.length; i++){

			tempArray[i] = new JCheckBox(""); // create a JCheckBox with no text
	        
			tempArray[i].setName(Integer.toString(i+1)); //sets name to location in the array
	        
			tempPanel.add(tempArray[i]);
		}
		tempPanel.validate();
	}
	
	private void selectAllChecks(JCheckBox[] tempArray, JCheckBox tempCheck){
		for(JCheckBox checkInArray : tempArray){
			checkInArray.setSelected(tempCheck.isSelected());
		}
	}
	
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_okButton_actionPerformed(ActionEvent arg0) {
		Statement stmt = null;
		Boolean deleteSuccessfull = false;
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String deleteQuery = "delete * from labs where hospitalname = '" + comboBox.getSelectedItem() + "'";
			stmt.executeUpdate(deleteQuery);
			
			conn.close();
			
			deleteSuccessfull = true;
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		
		
		if (deleteSuccessfull){
			try {
				//Establish connection
				Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
				
				//Create the statement
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				//Create the insert statements
				
				for(int i = 0; i < 7; i++){
					for(int j = 0; j < 23; j++){
						JCheckBox checkInArray = allLabsArray[i][j];
						String tempQuery = "insert into labs values ";
						
						if (allLabsArray[i][j].isSelected()){
							tempQuery = tempQuery + "('" + LAB_NAMES_ARRAY[i] + "', ";
							tempQuery = tempQuery + checkInArray.getName() + ", ";
							tempQuery = tempQuery + LAB_NUMBERS_ARRAY[i] + ", ";
							tempQuery = tempQuery + "'" + comboBox.getSelectedItem() + "' )";
							System.out.println(tempQuery);
							
							//Execute the statement
							if (stmt.executeUpdate(tempQuery) != 0)
								System.out.println("Success");
							else System.out.println("Update Failed");
							
						}  
					}
				}
				
				JOptionPane.showMessageDialog(this, "The lab(s) have been successfully updated for " + comboBox.getSelectedItem(),
						  "Update Successful", JOptionPane.INFORMATION_MESSAGE);
				
					
				//Close the connection
				conn.close();
				
				
						
			}catch (SQLException ex) {
				System.out.println("SQL Exception:   " + ex.getMessage());
				System.out.println("SQL State:   " + ex.getSQLState());
				System.out.println("Vendor Error:   " + ex.getErrorCode());
				ex.printStackTrace();
			}
		
		}
	}
	
	private void setAllSelectAll(Boolean tempBool){
		chkSelectHematology.setSelected(tempBool);
		chkSelectBlood.setSelected(tempBool);
		chkSelectChemistry.setSelected(tempBool);
		chkSelectMicrobiology.setSelected(tempBool);
		chkSelectUrinalysis.setSelected(tempBool);
		chkSelectOutpatient.setSelected(tempBool);
		chkSelectInpatient.setSelected(tempBool);
	}
	
	protected void do_chkSelectHematology_actionPerformed(ActionEvent e) {
		selectAllChecks(hematologyArray, chkSelectHematology);
	}
	protected void do_chkSelectBlood_actionPerformed(ActionEvent e) {
		selectAllChecks(bloodArray, chkSelectBlood);
	}
	protected void do_chkSelectChemistry_actionPerformed(ActionEvent e) {
		selectAllChecks(chemistryArray, chkSelectChemistry);
	}
	protected void do_chkSelectMicrobiology_actionPerformed(ActionEvent e) {
		selectAllChecks(microbiologyArray, chkSelectMicrobiology);
	}
	protected void do_chkSelectUrinalysis_actionPerformed(ActionEvent e) {
		selectAllChecks(urinalysisArray, chkSelectUrinalysis);
	}
	protected void do_chkSelectOutpatient_actionPerformed(ActionEvent e) {
		selectAllChecks(outpatientArray, chkSelectOutpatient);
	}
	protected void do_chkSelectInpatient_actionPerformed(ActionEvent e) {
		selectAllChecks(inpatientArray, chkSelectInpatient);
	}
	protected void do_this_componentShown(ComponentEvent arg0) {
			Statement stmt = null;
			ResultSet rs = null;
			String[] populateComboArray = new String[0];
			
			try{
				//Establish the connection
				Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
				
				//Create the statement
				stmt = conn.createStatement();
				
				
				//Execute the statement
				String query = "select hospitalname from hospitals";
				System.out.println(query);
				rs = stmt.executeQuery(query);
				
				ArrayList<String> populateComboList = new ArrayList<String>();
				
				//Process the results
				while (rs.next()){
					String tempHospitalName = rs.getString("HospitalName");
					populateComboList.add(tempHospitalName);
				}
				
				populateComboArray = populateComboList.toArray(new String[populateComboList.size()]);
				
				//Clean up
				rs.close();
				conn.close();
				
			} catch (SQLException ex) {
				System.out.println("SQL Exception:   " + ex.getMessage());
				System.out.println("SQL State:   " + ex.getSQLState());
				System.out.println("Vendor Error:   " + ex.getErrorCode());
				ex.printStackTrace();
			}
			
		
		comboBox.setModel(new DefaultComboBoxModel(populateComboArray));
		contentPanel.add(comboBox);
	}
	protected void do_comboBox_actionPerformed(ActionEvent e) {
		setAllSelectAll(false);
		
		System.out.println(comboBox.getSelectedItem());
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 23; j++){
				JCheckBox checkInArray = allLabsArray[i][j];
				checkInArray.setSelected(false);
			}  
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			//Create the statement
			stmt = conn.createStatement();
			
			
			//Execute the statement
			String query = "select labname, weeknumber from labs where hospitalname = '" + comboBox.getSelectedItem() + "'";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			
			//Process the results
			while (rs.next()){
				String tempLabName = rs.getString("LabName");
				int tempWeekNumber = rs.getInt("WeekNumber");
				
				for (int i = 0; i < 7; i++){
					if (tempLabName.equals(LAB_NAMES_ARRAY[i]) ){
						allLabsArray[i][tempWeekNumber-1].setSelected(true);
						
					}
				}
				
			}
			
			
			//Clean up
			rs.close();
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
	}
}
