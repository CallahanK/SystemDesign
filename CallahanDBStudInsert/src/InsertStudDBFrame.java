import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertStudDBFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JLabel lblId = new JLabel("Id:");
	private final JLabel lblStudentName = new JLabel("Student Name:");
	private final JLabel lblGpa = new JLabel("GPA: ");
	private final JLabel lblAge = new JLabel("Age: ");
	private final JTextField txtId = new JTextField();
	private final JTextField txtStudName = new JTextField();
	private final JTextField txtGpa = new JTextField();
	private final JTextField txtAge = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnQuery = new JButton("Query");
	private final JButton btnInsert = new JButton("Insert");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertStudDBFrame frame = new InsertStudDBFrame();
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
	public InsertStudDBFrame() {
		txtAge.setBounds(423, 100, 116, 22);
		txtAge.setColumns(10);
		txtGpa.setBounds(423, 71, 116, 22);
		txtGpa.setColumns(10);
		txtStudName.setBounds(423, 42, 116, 22);
		txtStudName.setColumns(10);
		txtId.setBounds(423, 13, 116, 22);
		txtId.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Insert Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(12, 13, 280, 189);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		lblId.setBounds(325, 16, 86, 16);
		
		contentPane.add(lblId);
		lblStudentName.setBounds(325, 45, 86, 16);
		
		contentPane.add(lblStudentName);
		lblGpa.setBounds(325, 74, 86, 16);
		
		contentPane.add(lblGpa);
		lblAge.setBounds(325, 103, 86, 16);
		
		contentPane.add(lblAge);
		
		contentPane.add(txtId);
		
		contentPane.add(txtStudName);
		
		contentPane.add(txtGpa);
		
		contentPane.add(txtAge);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(105, 215, 97, 25);
		
		contentPane.add(btnQuery);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnInsert_actionPerformed(e);
			}
		});
		btnInsert.setBounds(325, 132, 97, 25);
		
		contentPane.add(btnInsert);
		
		//Load the driver
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
		
	protected void do_btnQuery_actionPerformed(ActionEvent arg0) {
		textArea.setText("");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//Establish the connection
			//Connection conn = DriverManager.getConnection("jdbc:odbc:dbInsertStud");
			Connection conn = DriverManager.getConnection("jdbc:odbc:newDB");
			
			//Create the statement
			stmt = conn.createStatement();
			String query = "select id, studname, gpa, age from student where gpa > 2.0";
			System.out.println(query);
			
			//Execute the query
			rs = stmt.executeQuery(query);
			
			//Process the results
			while (rs.next()){
				int id = rs.getInt("ID");
				String studname = rs.getString("StudName");
				double gpa = rs.getDouble("GPA");
				int age = rs.getInt("Age");
				
				textArea.append(id + "    " + studname + "     " + gpa + "    " + age + "\n");	
			}
			
			//Clean up
			rs.close();
			conn.close();
			
			
			
		}catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		
	}
	
	
	
	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		Statement stmt = null;
		ResultSet rs = null; //only for duplicate check
		
		try {
			//Establish connection
			//Connection conn = DriverManager.getConnection("jdbc:odbc:dbInsertStud");
			Connection conn = DriverManager.getConnection("jdbc:odbc:newDB");
			
			//Check for duplicates
			stmt = conn.createStatement();
			
			//Create the query
			String duplicateCheck = "select * from student where id = " + txtId.getText().trim();
			
			//Run the query
			rs = stmt.executeQuery(duplicateCheck);
			if (rs.next()){
				System.out.println("No duplicates allowed");
				
			}	
			else{
			//Create the statement
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Create the insert statement
			String query = "insert into student values (";
			query = query + txtId.getText().trim() + ", ";
			query = query + "'" + txtStudName.getText().trim() + "', ";
			query = query + "'" + txtGpa.getText().trim() + "', ";
			query = query + "'" + txtAge.getText().trim() + "' )";
			System.out.println(query);
				
			//Execute the statement
			if (stmt.executeUpdate(query) != 0)
				System.out.println("Success");
			else System.out.println("Update Failed");
				
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
		
	}
}
