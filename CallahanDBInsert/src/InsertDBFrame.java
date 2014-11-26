import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;


public class InsertDBFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JTextField txtQueryName = new JTextField();
	private final JButton btnQuery = new JButton("Query");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblName = new JLabel("Name:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertDBFrame frame = new InsertDBFrame();
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
	public InsertDBFrame() {
		txtQueryName.setBounds(67, 13, 116, 24);
		txtQueryName.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Insert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(12, 50, 280, 190);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		contentPane.add(txtQueryName);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(195, 13, 97, 25);
		
		contentPane.add(btnQuery);
		
		//Load the driver
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblName.setBounds(12, 17, 43, 16);
		
		
		contentPane.add(lblName);
	}
	protected void do_btnQuery_actionPerformed(ActionEvent arg0) {
		textArea.setText("");
		Boolean isNotEnrolled = true;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//Establish connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:newDB");
			
			//Create the statement
			stmt = conn.createStatement();
			String query = "select course.cid, course.cname, course.room, course.time from student, course, enrollment where student.id = enrollment.id and enrollment.cid = course.cid and student.studname = '" + txtQueryName.getText().trim() + "' ";
			System.out.println(query);
			
			//Execute the statement
			rs = stmt.executeQuery(query);
			
			//Process the results
			while (rs.next()){
				isNotEnrolled = false;
				int cid = rs.getInt("CID");
				String cname = rs.getString("CName");
				String room = rs.getString("Room");
				String time = rs.getString("Time");
				
				textArea.append(cid + "    " + cname + "     " + room + "    " + time + "\n");	
			}
			
			if(isNotEnrolled){
				JOptionPane.showMessageDialog(this,
					    txtQueryName.getText() + " is not enrolled in any classes",
					    "Not Enrolled",
					    JOptionPane.WARNING_MESSAGE);
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
}
