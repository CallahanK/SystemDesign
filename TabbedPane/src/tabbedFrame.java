import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class tabbedFrame extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelFirst = new JPanel();
	private final JLabel lblHello = new JLabel("Hello");
	private final JButton btnGo = new JButton("Go!");
	private final JPanel panelSecond = new JPanel();
	private final JLabel lblGoodbye = new JLabel("Goodbye");
	private final JButton btnShowIt = new JButton("Show It");
	private final JPasswordField passwordField = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabbedFrame frame = new tabbedFrame();
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
	public tabbedFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Tabs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(12, 13, 408, 227);
		
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("First", null, panelFirst, null);
		panelFirst.setLayout(null);
		lblHello.setBounds(72, 41, 138, 25);
		
		panelFirst.add(lblHello);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGo_actionPerformed(arg0);
			}
		});
		btnGo.setBounds(72, 101, 97, 25);
		
		panelFirst.add(btnGo);
		passwordField.setBounds(72, 66, 138, 22);
		
		panelFirst.add(passwordField);
		
		tabbedPane.addTab("Second", null, panelSecond, null);
		panelSecond.setLayout(null);
		lblGoodbye.setBounds(79, 60, 56, 16);
		
		panelSecond.add(lblGoodbye);
		btnShowIt.setBounds(79, 89, 97, 25);
		
		panelSecond.add(btnShowIt);
	}
	protected void do_btnGo_actionPerformed(ActionEvent arg0) {
		String password = "";
		for (Character e : passwordField.getPassword()){
			password = password + e;
		}
		lblHello.setText(password);
	}
}
