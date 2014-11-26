import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
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
import javax.swing.JScrollPane;


public class SpringbreakDBFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JButton btnQuery = new JButton("Query");
	private final JLabel lblCourseId = new JLabel("Course Id:");
	private final JLabel lblCourseName = new JLabel("Course Name:");
	private final JLabel lblLocation = new JLabel("Location:");
	private final JLabel lblMeetingTimes = new JLabel("Meeting Times:");
	private final JTextField txtCID = new JTextField();
	private final JTextField txtCName = new JTextField();
	private final JTextField txtCLocation = new JTextField();
	private final JTextField txtCTimes = new JTextField();
	private final JButton btnInsert = new JButton("Insert");
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpringbreakDBFrame frame = new SpringbreakDBFrame();
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
	public SpringbreakDBFrame() {
		txtCTimes.setBounds(402, 100, 116, 22);
		txtCTimes.setColumns(10);
		txtCLocation.setBounds(402, 71, 116, 22);
		txtCLocation.setColumns(10);
		txtCName.setBounds(402, 42, 116, 22);
		txtCName.setColumns(10);
		txtCID.setBounds(402, 13, 116, 22);
		txtCID.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan SpringBreak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(12, 13, 249, 185);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(77, 211, 97, 25);
		
		contentPane.add(btnQuery);
		lblCourseId.setBounds(293, 16, 97, 16);
		
		contentPane.add(lblCourseId);
		lblCourseName.setBounds(293, 45, 97, 16);
		
		contentPane.add(lblCourseName);
		lblLocation.setBounds(293, 74, 97, 16);
		
		contentPane.add(lblLocation);
		lblMeetingTimes.setBounds(293, 103, 97, 16);
		
		contentPane.add(lblMeetingTimes);
		
		contentPane.add(txtCID);
		
		contentPane.add(txtCName);
		
		contentPane.add(txtCLocation);
		
		contentPane.add(txtCTimes);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnInsert_actionPerformed(e);
			}
		});
		btnInsert.setBounds(351, 132, 97, 25);
		
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
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:springbreak");
			
			//Create the statement
			stmt = conn.createStatement();
			String query = "select student.id, student.studname, student.gpa, student.age from student, course, enrollment where student.id = enrollment.id and enrollment.cid = course.cid and course.cname = 'Systems Design' "; 
			
			//Execute the statement
			rs = stmt.executeQuery(query);
			
			//Process the results
			while (rs.next()){
				int id = rs.getInt("ID");
				String name = rs.getString("StudName");
				double gpa = rs.getDouble("GPA");
				int age = rs.getInt("Age");
				
				textArea.append(id + "    " + name + "     " + gpa + "    " + age + "\n");				
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
	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		Statement stmt = null;
		ResultSet rs = null; //only for duplicate check
		
		try {
			//Establish connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:springbreak");
			
			//Check for duplicates
			stmt = conn.createStatement();
			
			//Create the query
			String duplicateCheck = "select * from course where course.cid = " + txtCID.getText().trim();
			
			//Run the query
			rs = stmt.executeQuery(duplicateCheck);
			if (rs.next())
				System.out.println("No duplicates allowed");
			else{
			//Create the statement
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Create the insert statement
			String query = "insert into course values (";
			query = query + txtCID.getText().trim() + ", ";
			query = query + "'" + txtCName.getText().trim() + "', ";
			query = query + "'" + txtCLocation.getText().trim() + "', ";
			query = query + "'" + txtCTimes.getText().trim() + "' )";
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
