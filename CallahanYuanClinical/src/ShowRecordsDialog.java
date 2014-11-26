import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;


public class ShowRecordsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textAreaRecords = new JTextArea();
	
	private final JButton btnHospitals = new JButton("Hospitals");
	private final JButton btnStudents = new JButton("Students");
	private final JButton btnLabs = new JButton("Labs");
	private final JLabel lblTableHeader = new JLabel("");
	private final JComboBox comboBoxHospital = new JComboBox();
	private final JLabel lblRecordCount = new JLabel("");
	
	/**
	 * Create the dialog.
	 */
	public ShowRecordsDialog() {
		jbInit();
	}
	private void jbInit() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				do_this_componentShown(arg0);
			}
		});
		setAlwaysOnTop(true);
		setTitle("Show Records");
		setResizable(false);
		setBounds(100, 100, 1056, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblThisIsA = new JLabel("Click one of the following buttons below to view their records.");
		lblThisIsA.setBounds(10, 29, 760, 14);
		contentPanel.add(lblThisIsA);
		btnHospitals.setToolTipText("Show all hospitals sorted by name.");
		
		btnHospitals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHospitals.setEnabled(false);
				btnLabs.setEnabled(true);
				btnStudents.setEnabled(true);
				do_btnHospitals_actionPerformed(e);
			}
		});
		btnHospitals.setBounds(10, 54, 89, 23);
		contentPanel.add(btnHospitals);
		
		btnLabs.setToolTipText("Show all hospitals sorted by lab names.");
	
		btnLabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHospitals.setEnabled(true);
				btnLabs.setEnabled(false);
				btnStudents.setEnabled(true);
				
				do_btnLabs_actionPerformed(e);
			}
		});
		btnLabs.setBounds(111, 54, 89, 23);
		contentPanel.add(btnLabs);
		btnStudents.setToolTipText("Show all hospitals sorted by CWID.");
	
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHospitals.setEnabled(true);
				btnLabs.setEnabled(true);
				btnStudents.setEnabled(false);
				
				do_btnStudents_actionPerformed(e);
			}
		});
		btnStudents.setBounds(208, 54, 89, 23);
		contentPanel.add(btnStudents);
		
		scrollPane.setBounds(10, 100, 1030, 267);
		
		contentPanel.add(scrollPane);
		textAreaRecords.setFont(new Font("Courier New", Font.PLAIN, 11));
		
		scrollPane.setViewportView(textAreaRecords);
		lblTableHeader.setBackground(Color.WHITE);
		lblTableHeader.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblTableHeader.setBounds(10, 84, 1030, 14);
		lblTableHeader.setOpaque(true);
		
		contentPanel.add(lblTableHeader);
		comboBoxHospital.setToolTipText("Show all labs of a particular hospital sorted by name.");
		comboBoxHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBoxHospital_actionPerformed(e);
			}
		});
		comboBoxHospital.setBounds(309, 54, 139, 23);
		
		contentPanel.add(comboBoxHospital);
		lblRecordCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRecordCount.setBounds(847, 49, 193, 28);
		
		contentPanel.add(lblRecordCount);
	}
	
	private String truncate(String field, int maxLength) {
		if (field.length() >= maxLength) {
			field = field.substring(0, maxLength-3) + "...";
		}
		return field;
	}

	protected void do_btnHospitals_actionPerformed(ActionEvent e) {
		textAreaRecords.setText("");
		textAreaRecords.setCaretPosition(0);
		int counter = 0;
		
		ResultSet rs = null;
		Statement stmt = null;
		
		try {

			lblTableHeader.setText("Hospital Name                Street Address               City                         State      ZIP \n");
			
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String showQuery = "select * from Hospitals order by HospitalName asc";
			rs = stmt.executeQuery(showQuery);
			
			while (rs.next()) {
				String hospitalName = rs.getString("HospitalName");
				String streetAddress = rs.getString("StreetAddress");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				
				String formattedRecords = String.format("%-25s %2s %-25s %2s %-25s %2s %-2s %7s %5s",
														truncate(hospitalName, 24), "", truncate(streetAddress, 24), "", truncate(city, 24), "", state, "", zip);
				
				textAreaRecords.append(formattedRecords + "\n");
				counter++;
			}
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		textAreaRecords.setCaretPosition(0);
		lblRecordCount.setText("Record(s) shown: " + counter);
	}
	
	protected void do_btnLabs_actionPerformed(ActionEvent e) {
		textAreaRecords.setText("");
		textAreaRecords.setCaretPosition(0);
		int counter = 0;
		
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			lblTableHeader.setText("Lab Name                     Week #     Length     Hospital Name \n");


			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String showQuery = "select labname, weeknumber, length, hospitalname from Labs order by WeekNumber asc";
			rs = stmt.executeQuery(showQuery);
			
			while (rs.next()) {
				String labName = rs.getString("LabName");
				int weekNumber = rs.getInt("WeekNumber");
				int length = rs.getInt("Length");
				String hospitalName = rs.getString("HospitalName");
				
				String formattedRecords = String.format("%-25s %5s %3d %6s %3d %3s %-25s",
														truncate(labName, 24), "", weekNumber, "", length, "", truncate(hospitalName, 24));
				
				textAreaRecords.append(formattedRecords + "\n");
				counter++;
			}
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		textAreaRecords.setCaretPosition(0);
		lblRecordCount.setText("Record(s) shown: " + counter);
	}
	
	protected void do_btnStudents_actionPerformed(ActionEvent e) {
		textAreaRecords.setText("");
		textAreaRecords.setCaretPosition(0);
		int counter = 0;

		
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			lblTableHeader.setText("CWID         First Name                   Last Name                    Street Address               City                         State     ZIP \n");


			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String showQuery = "select cwid, firstname, lastname, streetaddress, city, state, zip from Students order by CWID asc";
			rs = stmt.executeQuery(showQuery);
			
			while (rs.next()) {
				int cwid = rs.getInt("CWID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String streetAddress = rs.getString("StreetAddress");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				
				String formattedRecords = String.format("%8d %3s %-25s %2s %-25s %2s %-25s %2s %-25s %2s %-2s %6s %5s",
														cwid, "", truncate(firstName, 24), "", truncate(lastName, 24), "", truncate(streetAddress, 24), "", truncate(city, 24), "", state, "", zip);
				
				textAreaRecords.append(formattedRecords + "\n");
				counter++;

			}
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		textAreaRecords.setCaretPosition(0);
		lblRecordCount.setText("Record(s) shown: " + counter);
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
		
	
	comboBoxHospital.setModel(new DefaultComboBoxModel(populateComboArray));
	contentPanel.add(comboBoxHospital);
	}
	protected void do_comboBoxHospital_actionPerformed(ActionEvent e) {
		textAreaRecords.setText("");
		textAreaRecords.setCaretPosition(0);
		int counter = 0;

		
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			lblTableHeader.setText("Lab Name                     Week #     Length     Hospital Name \n");


			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String showQuery = "select labname, weeknumber, length, hospitalname from Labs where hospitalname = '" + comboBoxHospital.getSelectedItem() +  "' order by WeekNumber asc";
			rs = stmt.executeQuery(showQuery);
			
			while (rs.next()) {
				String labName = rs.getString("LabName");
				int weekNumber = rs.getInt("WeekNumber");
				int length = rs.getInt("Length");
				String hospitalName = rs.getString("HospitalName");
				
				String formattedRecords = String.format("%-25s %5s %3d %6s %3d %3s %-25s",
														truncate(labName, 24), "", weekNumber, "", length, "", truncate(hospitalName, 24));
				
				textAreaRecords.append(formattedRecords + "\n");
				counter++;

			}
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		textAreaRecords.setCaretPosition(0);
		lblRecordCount.setText("Record(s) shown: " + counter);
	}
}
