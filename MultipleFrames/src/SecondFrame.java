import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SecondFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnLeave = new JButton("Leave");
	private final JButton btnExitAll = new JButton("Exit All");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SecondFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Frame Two");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLeave_actionPerformed(e);
			}
		});
		btnLeave.setBounds(63, 84, 97, 25);
		
		contentPane.add(btnLeave);
		btnExitAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExitAll_actionPerformed(e);
			}
		});
		btnExitAll.setBounds(172, 84, 97, 25);
		
		contentPane.add(btnExitAll);
	}

	protected void do_btnLeave_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	protected void do_btnExitAll_actionPerformed(ActionEvent e) {
		System.exit(EXIT_ON_CLOSE);
	}
}
