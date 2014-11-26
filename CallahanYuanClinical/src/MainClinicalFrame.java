import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;


public class MainClinicalFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnShowRecords = new JButton("Show Record(s)...");
	private final JButton btnAddHospital = new JButton("Add Hospital...");
	private final JButton btnAddLab = new JButton("Edit Labs...");
	private final JButton btnAddStudent = new JButton("Add Student...");
	private final JLabel lblThisIsA = new JLabel("Select one of the following options below by clicking on them.");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmShowRecords = new JMenuItem("Show Record(s)...");
	private final JMenuItem mntmAddHospital = new JMenuItem("Add Hospital...");
	private final JMenuItem mntmEditLab = new JMenuItem("Edit Lab...");
	private final JMenuItem mntmAddStudent = new JMenuItem("Add Student...");
	private final JSeparator separator = new JSeparator();
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmAboutThisProgram = new JMenuItem("About this Program...");
	private final JLabel lblClinicalProject = new JLabel("Clinical Management System");
	private final JButton btnDelete = new JButton("Delete...");
	private final JLabel lblShowsAllRecords = new JLabel("Shows all records for Hospitals, Labs, and Students.");
	private final JLabel lblAddsANew = new JLabel("Adds a new Hospital to the database.");
	private final JLabel lblAddsANew_1 = new JLabel("Edits the Labs in the database.");
	private final JLabel lblAddsANew_2 = new JLabel("Adds a new Student to the database.");
	private final JLabel lblDeletesSelectedRecords = new JLabel("Deletes selected record(s) from the database.");

	private Boolean isUpdateSuccess = false;
	private Boolean insertDuplicate = false;
	private final JMenuItem mntmDelete = new JMenuItem("Delete...");
	private final JSeparator separator_2 = new JSeparator();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClinicalFrame frame = new MainClinicalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainClinicalFrame() {
		jbInit();
	}
	private void jbInit() {
		setResizable(false);
		setTitle("CallahanYuanClinical");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 352);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmExit_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnHelp);
		mntmShowRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmShowRecords_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmShowRecords);
		
		mnHelp.add(separator);
		mntmAddHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddHospital_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmAddHospital);
		mntmEditLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddLab_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmEditLab);
		mntmAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddStudent_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmAddStudent);
		
		mnHelp.add(separator_1);
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmDelete_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmDelete);
		
		mnHelp.add(separator_2);
		mntmAboutThisProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAboutThisProgram_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmAboutThisProgram);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnShowRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnShowRecords_actionPerformed(arg0);
			}
		});
		btnShowRecords.setBounds(10, 83, 141, 30);
		
		contentPane.add(btnShowRecords);
		btnAddHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAddHospital_actionPerformed(arg0);
			}
		});
		btnAddHospital.setBounds(10, 124, 141, 30);
		
		contentPane.add(btnAddHospital);
		btnAddLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAddLab_actionPerformed(arg0);
			}
		});
		btnAddLab.setBounds(10, 165, 141, 30);
		
		contentPane.add(btnAddLab);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnAddStudent_actionPerformed(arg0);
			}
		});
		btnAddStudent.setBounds(10, 206, 141, 30);
		
		contentPane.add(btnAddStudent);
		lblThisIsA.setBounds(10, 60, 451, 18);
		
		contentPane.add(lblThisIsA);
		lblClinicalProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinicalProject.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClinicalProject.setBounds(10, 11, 461, 36);
		
		contentPane.add(lblClinicalProject);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnDelete_actionPerformed(arg0);
			}
		});
		btnDelete.setBounds(10, 247, 141, 30);
		
		contentPane.add(btnDelete);
		lblShowsAllRecords.setBounds(161, 91, 310, 14);
		
		contentPane.add(lblShowsAllRecords);
		lblAddsANew.setBounds(161, 132, 310, 14);
		
		contentPane.add(lblAddsANew);
		lblAddsANew_1.setBounds(161, 173, 310, 14);
		
		contentPane.add(lblAddsANew_1);
		lblAddsANew_2.setBounds(161, 214, 310, 14);
		
		contentPane.add(lblAddsANew_2);
		lblDeletesSelectedRecords.setBounds(161, 255, 310, 14);
		
		contentPane.add(lblDeletesSelectedRecords);
		
		//Load the driver
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	private Boolean runInsertSingleItem(String tempTableName, String tempDupCheck, String tempQuery) {
		Statement stmt = null;
		ResultSet rs = null; //only for duplicate check
		//Boolean isUpdateSuccess = false;
		//Boolean insertDuplicate = false;
		
		try {
			//Establish connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:DBconn");
			
			//Check for duplicates
			stmt = conn.createStatement();
			
			//Create the query
			String duplicateCheck = "select * from " +  tempTableName + " " + tempDupCheck;
			System.out.println(duplicateCheck);
			
			//Run the query
			rs = stmt.executeQuery(duplicateCheck);
			if (rs.next()){
				insertDuplicate = true;
				isUpdateSuccess = false;
			}
			else{
			//Create the statement
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Create the insert statement
			String query = tempQuery;
			System.out.println(query);
				
			//Execute the statement
			if (stmt.executeUpdate(query) != 0)
				isUpdateSuccess = true;
			else isUpdateSuccess = false;
				
			//Close the connection
			rs.close();
			conn.close();
			
			}
					
		}catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		return isUpdateSuccess;
	}
	
	protected void do_btnShowRecords_actionPerformed(ActionEvent arg0) {
		ShowRecordsDialog newDialog = new ShowRecordsDialog();
		newDialog.setVisible(true);
	}
	
	protected void do_btnAddHospital_actionPerformed(ActionEvent arg0) {

		AddHospitalsDialog dialogHospitalInsert = new AddHospitalsDialog();
		dialogHospitalInsert.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialogHospitalInsert.setVisible(true);
		
		Boolean tempIsSuccess = runInsertSingleItem("hospitals", dialogHospitalInsert.getInsertedHospitalName(), dialogHospitalInsert.getQueryInsert());
		Boolean attemptInsert = dialogHospitalInsert.isAttemptingInsert();
		
		while (insertDuplicate && !tempIsSuccess && attemptInsert){
			JOptionPane.showMessageDialog(this,
				    "Please fix duplicate.",
				    "Duplicate Data",
				    JOptionPane.WARNING_MESSAGE);
			dialogHospitalInsert.setVisible(true);
			tempIsSuccess = runInsertSingleItem("hospitals", dialogHospitalInsert.getInsertedHospitalName(), dialogHospitalInsert.getQueryInsert());
			attemptInsert = dialogHospitalInsert.isAttemptingInsert();
		}
		
		if (tempIsSuccess){
			dialogHospitalInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Success.",
				    "Success",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		if (!attemptInsert){
			dialogHospitalInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Cancelled.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!tempIsSuccess){
			dialogHospitalInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Failed.",
				    "Failure",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	protected void do_btnAddLab_actionPerformed(ActionEvent arg0) {
		AddLabDialog dialogLabInsert = new AddLabDialog();
		dialogLabInsert.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialogLabInsert.setVisible(true);
	}
	
	protected void do_btnAddStudent_actionPerformed(ActionEvent arg0) {
		AddStudentsDialog dialogStudentInsert = new AddStudentsDialog();
		dialogStudentInsert.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialogStudentInsert.setVisible(true);
		
		Boolean tempIsSuccess = runInsertSingleItem("students", dialogStudentInsert.getInsertedCwid(), dialogStudentInsert.getQueryInsert());
		Boolean attemptInsert = dialogStudentInsert.isAttemptingInsert();
		
		while (insertDuplicate && !tempIsSuccess && attemptInsert){
			JOptionPane.showMessageDialog(this,
				    "Please fix duplicate.",
				    "Duplicate Data",
				    JOptionPane.WARNING_MESSAGE);
			dialogStudentInsert.setVisible(true);
			tempIsSuccess = runInsertSingleItem("students", dialogStudentInsert.getInsertedCwid(), dialogStudentInsert.getQueryInsert());
			attemptInsert = dialogStudentInsert.isAttemptingInsert();
		}
		
		if (tempIsSuccess){
			dialogStudentInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Success.",
				    "Success",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		if (!attemptInsert){
			dialogStudentInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Cancelled.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!tempIsSuccess){
			dialogStudentInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Failed.",
				    "Failure",
				    JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	protected void do_btnDelete_actionPerformed(ActionEvent arg0) {
		DeleteDialog newDialog = new DeleteDialog();
		newDialog.setVisible(true);
	}
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_mntmShowRecords_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this,
			      "Show Records will display records for Hospitals, Labs, and \n"
			    + "Students that have been entered into the database. \n"
			    + "A set of buttons are provided for you to navigate between Hospitals, Labs, and \n"
			    + "Students to view its respective records. \n"
			    + "A list of hospitals is also provided for you in a selection box in order to \n"
			    + "view the records that pertain to the selected hospital. \n \n "
			    + "The records in the Hospitals table are displayed and ordered by their name in \n"
			    + "alphabetical order (A-Z). \n \n"
			    + "The records in the Labs table are displayed and ordered by their week number \n"
			    + "in ascending order (0-9). \n \n "
			    + "The records in the Students table are displayed and ordered by their CWID \n"
			    + "(Campus Wide ID) number in ascending order (0-9).");
	}
	protected void do_mntmAddHospital_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Add Hospitals will allow you to add a new hospital to the database. \n \n"
			    + "You will need to provide the hospital's name, street address, city, state, and 5-digit ZIP code." );
	}
	protected void do_mntmAddLab_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
				"Edit Labs will allow you to edit the labs listed in the database. \n \n"
			    + "You will need to select a hospital and select the weeks each lab is offered." );
	}
	protected void do_mntmAddStudent_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Add Students will allow you to add a new Marist College student to the database. \n \n"
			    + "You will need to provide the student's 8-digit CWID (Campus Wide ID) \n"
			    + "number, first name and last name, street address, city, state, and 5-digit ZIP code.");
	}
	protected void do_mntmDelete_actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this,
			    "Delete will allow you to remove a table from the database. \n \n"
			    + "You will select the table to be deleted and prompted to verify the deletion. \n"
			    + "Warning deleting the Hospitals table will also delete the associated Labs.");
	}
	protected void do_mntmAboutThisProgram_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Clinical Management System \n \n"
			    + "A program built to easily store and track all hospital, lab, and \n"
			    + " student records for the Marist College Medical Technology department. \n \n"
			    + "A Callahan and Yuan Production");
	}
}
