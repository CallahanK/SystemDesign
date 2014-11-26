import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JLabel lblThisIsA = new JLabel("<html>Select one of the options below<br> to delete all records from the table.");
	private final JButton btnDeleteHospitals = new JButton("Delete Hospitals Records");
	private final JButton btnDeleteLabs = new JButton("Delete Labs Records");
	private final JButton btnDeleteStudents = new JButton("Delete Students Records");
	
	private boolean deleteConfirmed = false;
	private int counter = 0;
	private final JButton btnCancel = new JButton("Cancel");

	/**
	 * Create the dialog.
	 */
	public DeleteDialog() {
		jbInit();
	}
	private void jbInit() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Delete");
		setBounds(100, 100, 244, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblThisIsA.setBounds(10, 13, 213, 31);
		
		contentPanel.add(lblThisIsA);
		btnDeleteHospitals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDeleteHospitals_actionPerformed(e);
			}
		});
		btnDeleteHospitals.setBounds(10, 55, 188, 31);
		
		contentPanel.add(btnDeleteHospitals);
		btnDeleteLabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDeleteLabs_actionPerformed(e);
			}
		});
		btnDeleteLabs.setBounds(10, 97, 188, 31);
		
		contentPanel.add(btnDeleteLabs);
		btnDeleteStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDeleteStudents_actionPerformed(e);
			}
		});
		btnDeleteStudents.setBounds(10, 139, 188, 31);
		
		contentPanel.add(btnDeleteStudents);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(126, 196, 97, 25);
		
		contentPanel.add(btnCancel);
	}
	
	private void countRecords(String tableName) {
		counter = 0;
		
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String countQuery = "select * from " + tableName;
			rs = stmt.executeQuery(countQuery);
			
			while (rs.next()) {
				counter++;
			}
			
			conn.close();
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
	}
	
	private void deleteRecords(String tableName) {
		Statement stmt = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			stmt = conn.createStatement();
			
			String deleteQuery = "delete * from " + tableName;
			if (stmt.executeUpdate(deleteQuery) != 0 && deleteConfirmed) {
				JOptionPane.showMessageDialog(this, "The record(s) have been successfully deleted.",
						  "Records Successfully Deleted", JOptionPane.INFORMATION_MESSAGE);
			}
			
			conn.close();
			
			deleteConfirmed = false;
		}
		catch (SQLException ex) {
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
	}
	
	protected void do_btnDeleteHospitals_actionPerformed(ActionEvent e) {
		countRecords("Hospitals");
		
		if (counter > 0) {
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "There are " + counter + " record(s) in the Hospitals table. Are you sure you want to delete all records?",
				    "Confirm Delete Hospitals",
				    JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				countRecords("Labs");
				
				int o = JOptionPane.showConfirmDialog(
					    this,
					    "Clearing the Hospitals table will also delete " + counter +  " record(s) in the Labs table. Do you still wish to continue?",
					    "Confirm Delete Hospitals",
					    JOptionPane.YES_NO_OPTION);
				if (o == JOptionPane.YES_OPTION) {
					//DELETE
					deleteConfirmed = true;
					deleteRecords("Hospitals");
					deleteRecords("Labs");
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Cannot delete records. The Hospitals table is currently empty.",
					  "Empty Table", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	protected void do_btnDeleteLabs_actionPerformed(ActionEvent e) {
		countRecords("Labs");
		
		if (counter > 0) {
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "There are " + counter + " record(s) in the Labs table. Are you sure you want to delete all records?",
				    "Confirm Delete Labs",
				    JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				//DELETE
				deleteConfirmed = true;
				deleteRecords("Labs");
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Cannot delete records. The Labs table is currently empty.",
					  "Empty Table", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	protected void do_btnDeleteStudents_actionPerformed(ActionEvent e) {
		countRecords("Students");
		
		if (counter > 0) {
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "There are " + counter + " record(s) in the Students table. Are you sure you want to delete all records?",
				    "Confirm Delete Students",
				    JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				//DELETE
				deleteConfirmed = true;
				deleteRecords("Students");
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Cannot delete records. The Students table is currently empty.",
					  "Empty Table", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
