import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class FocusFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPositive = new JLabel("Enter a positive number:");
	private final JLabel lblNegative = new JLabel("Enter a negative number: ");
	private final JTextField txtPositive = new JTextField();
	private final JTextField txtNegative = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FocusFrame frame = new FocusFrame();
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
	public FocusFrame() {
		txtNegative.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtNegative_focusLost(e);
			}
		});
		txtNegative.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNegative.setBounds(213, 65, 116, 22);
		txtNegative.setColumns(10);
		txtPositive.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txtPositive_focusLost(arg0);
			}
		});
		txtPositive.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPositive.setBounds(213, 36, 116, 22);
		txtPositive.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Focus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblPositive.setBounds(40, 39, 161, 16);
		
		contentPane.add(lblPositive);
		lblNegative.setBounds(40, 68, 161, 16);
		
		contentPane.add(lblNegative);
		
		contentPane.add(txtPositive);
		
		contentPane.add(txtNegative);
	}
	protected void do_txtPositive_focusLost(FocusEvent arg0) {
		if (!txtPositive.getText().isEmpty()){
			int tempInputInt = Integer.parseInt(txtPositive.getText());
			if (tempInputInt <= 0){
					JOptionPane.showMessageDialog(this,
						    "Please enter a positive number",
						    "Input Warning",
						    JOptionPane.WARNING_MESSAGE);
					txtPositive.grabFocus();
			}
		}
	}
	
	protected void do_txtNegative_focusLost(FocusEvent e) {
		if (!txtNegative.getText().isEmpty()){
			int tempInputInt = Integer.parseInt(txtNegative.getText());
			if (tempInputInt >= 0){
					JOptionPane.showMessageDialog(this,
						    "Please enter a negative number",
						    "Input Warning",
						    JOptionPane.WARNING_MESSAGE);
					txtNegative.grabFocus();
			}
		}
	}
}
