import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class theFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHello = new JLabel("Hello");
	private final JLabel lblGoodbye = new JLabel("Goodbye");
	private final JButton btnClickMe = new JButton("Click Me");
	private final JButton btnCycle = new JButton("Cycle");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theFrame frame = new theFrame();
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
	public theFrame() {
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
		lblHello.setForeground(Color.RED);
		lblHello.setFont(new Font("Trebuchet MS", Font.ITALIC, 19));
		lblHello.setBounds(131, 55, 81, 35);
		
		contentPane.add(lblHello);
		lblGoodbye.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblGoodbye.setForeground(Color.BLUE);
		lblGoodbye.setBounds(131, 103, 117, 33);
		
		contentPane.add(lblGoodbye);
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClickMe_actionPerformed(arg0);
			}
		});
		btnClickMe.setBounds(131, 156, 97, 25);
		
		contentPane.add(btnClickMe);
		btnCycle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCycle_actionPerformed(e);
			}
		});
		btnCycle.setBounds(131, 194, 97, 25);
		
		contentPane.add(btnCycle);
	}
	protected void do_btnClickMe_actionPerformed(ActionEvent arg0) {
		lblHello.setText("Kevin");
	}
	protected void do_btnCycle_actionPerformed(ActionEvent e) {
		String temp = lblHello.getText();
		lblHello.setText(lblGoodbye.getText());
		lblGoodbye.setText(temp);
	}
}
