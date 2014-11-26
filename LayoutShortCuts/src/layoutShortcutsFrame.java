import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class layoutShortcutsFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHello = new JLabel("Hello");
	private final JLabel lblSecondLabel = new JLabel("Second Label");
	private final JLabel lblAnother = new JLabel("Another");
	private final JButton btnFirst = new JButton("First");
	private final JButton btnSecondButton = new JButton("Second Button");
	private final JButton btnQuestion = new JButton("?");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					layoutShortcutsFrame frame = new layoutShortcutsFrame();
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
	public layoutShortcutsFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Layout Shortcuts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHello.setBounds(45, 13, 56, 16);
		
		contentPane.add(lblHello);
		lblSecondLabel.setBounds(45, 47, 95, 16);
		
		contentPane.add(lblSecondLabel);
		lblAnother.setBounds(117, 13, 56, 16);
		
		contentPane.add(lblAnother);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFirst_actionPerformed(arg0);
			}
		});
		btnFirst.setBounds(12, 182, 137, 25);
		
		contentPane.add(btnFirst);
		btnSecondButton.setEnabled(false);
		btnSecondButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSecondButton_actionPerformed(e);
			}
		});
		btnSecondButton.setBounds(229, 182, 137, 25);
		
		contentPane.add(btnSecondButton);
		btnQuestion.setBounds(161, 182, 56, 25);
		
		contentPane.add(btnQuestion);
	}
	protected void do_btnFirst_actionPerformed(ActionEvent arg0) {
		btnQuestion.setEnabled(!btnQuestion.isEnabled());
		btnSecondButton.setEnabled(!btnSecondButton.isEnabled());
		btnFirst.setEnabled(!btnFirst.isEnabled());
	}
	protected void do_btnSecondButton_actionPerformed(ActionEvent e) {
		btnQuestion.setEnabled(!btnQuestion.isEnabled());
		btnSecondButton.setEnabled(!btnSecondButton.isEnabled());
		btnFirst.setEnabled(!btnFirst.isEnabled());
	}
}
