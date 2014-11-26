import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblThisIsThe = new JLabel("This is the main frame");
	private final JButton btnNewFrame = new JButton("New Frame");
	private final JButton btnDontClick = new JButton("Dont Click");
	private final JButton btnSecondFrame = new JButton("Second Frame");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblThisIsThe.setBounds(120, 63, 161, 33);
		
		contentPane.add(lblThisIsThe);
		btnNewFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnNewFrame_actionPerformed(arg0);
			}
		});
		btnNewFrame.setBounds(120, 109, 150, 25);
		
		contentPane.add(btnNewFrame);
		btnDontClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDontClick_actionPerformed(e);
			}
		});
		btnDontClick.setBounds(323, 215, 97, 25);
		
		contentPane.add(btnDontClick);
		btnSecondFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSecondFrame_actionPerformed(e);
			}
		});
		btnSecondFrame.setBounds(120, 147, 150, 25);
		
		contentPane.add(btnSecondFrame);
	}
	protected void do_btnNewFrame_actionPerformed(ActionEvent arg0) {
		FirstNewFrame firstFrame = new FirstNewFrame();
		firstFrame.setVisible(true);
		
	}
	protected void do_btnDontClick_actionPerformed(ActionEvent e) {
		Random randomGenerator = new Random();
		while(true){
			FirstNewFrame firstFrame = new FirstNewFrame();
			firstFrame.setVisible(true);
			int tempX = randomGenerator.nextInt(1500);
			int tempY = randomGenerator.nextInt(1200);
			firstFrame.setBounds(tempX, tempY, 450, 300);
			}
	}
	protected void do_btnSecondFrame_actionPerformed(ActionEvent e) {
		SecondFrame secondFrame = new SecondFrame();
		secondFrame.setVisible(true);
	}
}
