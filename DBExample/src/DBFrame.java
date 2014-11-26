import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class DBFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnQuery = new JButton("Query");
	private final JLabel lblId = new JLabel("Id:");
	private final JLabel lblName = new JLabel("Name: ");
	private final JLabel lblGpa = new JLabel("GPA:");
	private final JLabel lblAge = new JLabel("Age:");
	private final JTextField txtId = new JTextField();
	private final JTextField txtName = new JTextField();
	private final JTextField txtGpa = new JTextField();
	private final JTextField txtAge = new JTextField();
	private final JButton btnInsert = new JButton("Insert");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBFrame frame = new DBFrame();
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
	public DBFrame() {
		txtAge.setBounds(420, 101, 116, 22);
		txtAge.setColumns(10);
		txtGpa.setBounds(420, 72, 116, 22);
		txtGpa.setColumns(10);
		txtName.setBounds(420, 43, 116, 22);
		txtName.setColumns(10);
		txtId.setBounds(420, 14, 116, 22);
		txtId.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(12, 13, 305, 158);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(120, 184, 97, 25);
		
		contentPane.add(btnQuery);
		
		//Load the driver
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblId.setBounds(359, 17, 49, 16);
		
		
		
		contentPane.add(lblId);
		lblName.setBounds(359, 46, 49, 16);
		
		contentPane.add(lblName);
		lblGpa.setBounds(359, 75, 49, 16);
		
		contentPane.add(lblGpa);
		lblAge.setBounds(359, 104, 49, 16);
		
		contentPane.add(lblAge);
		
		contentPane.add(txtId);
		
		contentPane.add(txtName);
		
		contentPane.add(txtGpa);
		
		contentPane.add(txtAge);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnInsert_actionPerformed(arg0);
			}
		});
		btnInsert.setBounds(400, 133, 97, 25);
		
		contentPane.add(btnInsert);
	}
	protected void do_btnQuery_actionPerformed(ActionEvent arg0) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:testSample");
			
			//Create the statement
			stmt = conn.createStatement();
			String query = "select * from student where id > 100";
			
			//Execute the statement
			rs = stmt.executeQuery(query);
			
			//Process the results
			while (rs.next()){
				System.out.println("Error");
				int ID = rs.getInt("ID");
				String nameTemp = rs.getString("StudName");				
				double gpa = rs.getDouble("GPA");
				int age = rs.getInt("Age");
				
				textArea.append(ID + "    " + nameTemp + "     " + gpa + "    " + age + "\n");
				
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
	protected void do_btnInsert_actionPerformed(ActionEvent arg0) {
		Statement stmt = null;
		ResultSet rs = null; //this is ONLY for the duplicate check
		
		try {
			//establish connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:testSample");
			
			//check for duplicates
			stmt = conn.createStatement();
			
			//create the query
			String checkForDupl = "select * from student where student.id = " + txtId.getText().trim();
			
			//run the query
			rs = stmt.executeQuery(checkForDupl);
			if (rs.next())
				System.out.println("No duplicates allowed");
			
			else{
			//create the statement
			//diff type of statement to allow insert/update
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Create the insert statement
			String query = "insert into student values (";
			query = query + txtId.getText().trim() + ", ";
			query = query + "'" + txtName.getText().trim() + "', ";
			query = query + txtGpa.getText().trim() + ", ";
			query = query + txtAge.getText().trim() + ")";
			System.out.println(query);
			
			//execute the statement
			if (stmt.executeUpdate(query) != 0)
				System.out.println("Success");
			else System.out.println("Update failed");
			}		
					
			//close the connection
			conn.close();
			
		}catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		
	}
}
