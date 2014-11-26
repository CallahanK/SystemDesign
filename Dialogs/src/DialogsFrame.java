import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DialogsFrame extends JFrame {

	private JPanel contentPane;
	private final JTextField txtInput = new JTextField();
	private final JButton btnShow = new JButton("Show");
	private final JLabel lblOutput = new JLabel("");
	private final JButton btnExit = new JButton("Exit");
	private final JButton btnPlain = new JButton("Plain");
	private final JButton btnWarning = new JButton("Warning");
	private final JButton btnCentered = new JButton("Centered");
	private final JButton btnButtons = new JButton("Buttons");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogsFrame frame = new DialogsFrame();
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
	public DialogsFrame() {
		txtInput.setBounds(70, 45, 116, 22);
		txtInput.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Callahan - Dialogs");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(txtInput);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnShow_actionPerformed(arg0);
			}
		});
		btnShow.setBounds(70, 95, 116, 25);
		
		contentPane.add(btnShow);
		lblOutput.setBounds(70, 133, 116, 22);
		
		contentPane.add(lblOutput);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnExit_actionPerformed(e);
			}
		});
		btnExit.setBounds(70, 180, 116, 25);
		
		contentPane.add(btnExit);
		btnPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPlain_actionPerformed(e);
			}
		});
		btnPlain.setBounds(275, 44, 97, 25);
		
		contentPane.add(btnPlain);
		btnWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWarning_actionPerformed(e);
			}
		});
		btnWarning.setBounds(275, 82, 97, 25);
		
		contentPane.add(btnWarning);
		btnCentered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCentered_actionPerformed(e);
			}
		});
		btnCentered.setBounds(275, 120, 97, 25);
		
		contentPane.add(btnCentered);
		btnButtons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnButtons_actionPerformed(e);
			}
		});
		btnButtons.setBounds(275, 158, 97, 25);
		
		contentPane.add(btnButtons);
	}
	protected void do_btnShow_actionPerformed(ActionEvent arg0) {
		if (txtInput.getText().isEmpty() ){
			JOptionPane.showMessageDialog(this,
				    "Please enter a value",
				    "Empty Text Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		lblOutput.setText(txtInput.getText());
	}
	protected void do_btnExit_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_btnPlain_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Get me an icon",
			    "A plain message",
			    JOptionPane.PLAIN_MESSAGE);
	}
	protected void do_btnCentered_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,
			    "Center of the screen");
	}
	protected void do_btnWarning_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Careful.",
			    "Inane warning",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	//http://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
	protected void do_btnButtons_actionPerformed(ActionEvent e) {
		Object[] options = {"Option 1",
                "Option 2",
                "Option 3"};
			int n = JOptionPane.showOptionDialog(this,
			"Pick one "
			+ "below",
			"Multiple Buttons",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[2]);

	}
}
