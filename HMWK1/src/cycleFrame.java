//Kevin Callahan

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class cycleFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblFirst = new JLabel("First");
	private final JLabel lblSecond = new JLabel("Second");
	private final JLabel lblThird = new JLabel("Third");
	private final JButton btnCycle = new JButton("Cycle");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cycleFrame frame = new cycleFrame();
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
	public cycleFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Kevin Callahan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFirst.setBounds(94, 37, 56, 16);
		
		contentPane.add(lblFirst);
		lblSecond.setBounds(94, 73, 56, 16);
		
		contentPane.add(lblSecond);
		lblThird.setBounds(94, 113, 56, 16);
		
		contentPane.add(lblThird);
		btnCycle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCycle_actionPerformed(e);
			}
		});
		btnCycle.setBounds(94, 155, 97, 25);
		
		contentPane.add(btnCycle);
	}

	protected void do_btnCycle_actionPerformed(ActionEvent e) {
		String temp2 = lblSecond.getText();
		lblSecond.setText(lblFirst.getText());
		lblFirst.setText(lblThird.getText());
		lblThird.setText(temp2);
	}
}
