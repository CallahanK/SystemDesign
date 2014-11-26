import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBPracticeFrame extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblCid = new JLabel("CID:");
	private final JLabel lblCname = new JLabel("CName:");
	private final JLabel lblRoom = new JLabel("Room:");
	private final JLabel lblTime = new JLabel("Time:");
	private final JTextField txtCid = new JTextField();
	private final JTextField txtCName = new JTextField();
	private final JTextField txtRoom = new JTextField();
	private final JTextField txtTime = new JTextField();
	private final JButton btnQuery = new JButton("Query");
	private final JButton btnInsert = new JButton("Insert");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBPracticeFrame frame = new DBPracticeFrame();
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
	public DBPracticeFrame() {
		txtTime.setBounds(304, 97, 116, 22);
		txtTime.setColumns(10);
		txtRoom.setBounds(304, 68, 116, 22);
		txtRoom.setColumns(10);
		txtCName.setBounds(304, 39, 116, 22);
		txtCName.setColumns(10);
		txtCid.setBounds(304, 10, 116, 22);
		txtCid.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(12, 13, 215, 227);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		lblCid.setBounds(240, 13, 56, 16);
		
		contentPane.add(lblCid);
		lblCname.setBounds(240, 42, 56, 16);
		
		contentPane.add(lblCname);
		lblRoom.setBounds(240, 71, 56, 16);
		
		contentPane.add(lblRoom);
		lblTime.setBounds(240, 100, 56, 16);
		
		contentPane.add(lblTime);
		
		contentPane.add(txtCid);
		
		contentPane.add(txtCName);
		
		contentPane.add(txtRoom);
		
		contentPane.add(txtTime);
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(246, 215, 81, 25);
		
		contentPane.add(btnQuery);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnInsert_actionPerformed(e);
			}
		});
		btnInsert.setBounds(339, 215, 81, 25);
		
		contentPane.add(btnInsert);
		
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
		
		
		try {
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:dbAlpha");
			
			
			stmt = conn.createStatement();
			
			String query = "select student.id, student.studname, student.gpa from student, course, enrollment where student.id = enrollment.id AND enrollment.cid = course.cid AND cname = 'Calculus I'";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			while (rs.next()){
				int tempId = rs.getInt("ID");
				String tempName = rs.getString("StudName");
				double tempGpa = rs.getDouble("GPA");
				
				textArea.append(String.format("%8d %2s %-12s %2.1f \n", tempId, "", tempName, tempGpa));
			}
			
			rs.close();
			conn.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Vendor Error: " + e.getErrorCode());
			e.printStackTrace();
		}
		
	}
	protected void do_btnInsert_actionPerformed(ActionEvent e) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:dbAlpha");
			
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String query = "select * from course where course.cid = " + txtCid.getText();
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			if (rs.next()){
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				query = "insert into course values ()  ";
				
			}
			
			rs.close();
			conn.close();
			
			
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		
	}
}
