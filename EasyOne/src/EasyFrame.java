import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EasyFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHello = new JLabel("Hello");
	private final JLabel lblGoodbye = new JLabel("Goodbye");
	private final JButton btnFlashHello = new JButton("Flash Hello");
	private final JButton btnFlashGoodbye = new JButton("Flash Goodbye");
	private final JLabel lblSpringIsHere = new JLabel("Spring is Here!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasyFrame frame = new EasyFrame();
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
	public EasyFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHello.setBounds(74, 57, 56, 16);
		
		contentPane.add(lblHello);
		lblGoodbye.setBounds(74, 102, 56, 16);
		
		contentPane.add(lblGoodbye);
		btnFlashHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFlashHello_actionPerformed(arg0);
			}
		});
		btnFlashHello.setBounds(183, 53, 115, 25);
		
		contentPane.add(btnFlashHello);
		btnFlashGoodbye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFlashGoodbye_actionPerformed(e);
			}
		});
		btnFlashGoodbye.setBounds(183, 98, 115, 25);
		
		contentPane.add(btnFlashGoodbye);
		lblSpringIsHere.setBounds(74, 160, 56, 16);
		
		contentPane.add(lblSpringIsHere);
	}
	protected void do_btnFlashHello_actionPerformed(ActionEvent arg0) {
		lblHello.setVisible(!lblHello.isVisible());
	}
	protected void do_btnFlashGoodbye_actionPerformed(ActionEvent e) {
		lblGoodbye.setVisible(!lblGoodbye.isVisible());
	}
}
