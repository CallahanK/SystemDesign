import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FirstNewFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblThisIsThe = new JLabel("This is the first new Frame");
	private final JButton btnLeave = new JButton("Leave");
	private final JButton btnFrameTwo = new JButton("Frame 2");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FirstNewFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("New Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblThisIsThe.setBounds(122, 74, 154, 28);
		
		contentPane.add(lblThisIsThe);
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLeave_actionPerformed(e);
			}
		});
		btnLeave.setBounds(122, 115, 97, 25);
		
		contentPane.add(btnLeave);
		btnFrameTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFrameTwo_actionPerformed(e);
			}
		});
		btnFrameTwo.setBounds(122, 153, 97, 25);
		
		contentPane.add(btnFrameTwo);
	}

	protected void do_btnLeave_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	protected void do_btnFrameTwo_actionPerformed(ActionEvent e) {
		SecondFrame secondFrame = new SecondFrame();
		secondFrame.setVisible(true);
	}
}
