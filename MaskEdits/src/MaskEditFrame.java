import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MaskEditFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblSsn = new JLabel("SSN:");
	private final JButton btnShow = new JButton("Show");
	private final JLabel lblSSNOutput = new JLabel("");

	MaskFormatter ssnMask = createFormatter("###-##-####");
	MaskFormatter ssnMask2 = createFormatter("###-##-####");
	MaskFormatter phone1 = createFormatter("(###)-###-####");
	private final JFormattedTextField ftfSSn = new JFormattedTextField();
	private final JLabel lblSsn_1 = new JLabel("SSN2:");
	private final JFormattedTextField ftfSsn2 = new JFormattedTextField();
	private final JLabel lblPhone = new JLabel("Phone: ");
	private final JFormattedTextField ftfPhone = new JFormattedTextField();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaskEditFrame frame = new MaskEditFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter
	
	
	/**
	 * Create the frame.
	 */
	public MaskEditFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Mask");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSsn.setBounds(70, 40, 37, 16);
		
		contentPane.add(lblSsn);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnShow_actionPerformed(arg0);
			}
		});
		btnShow.setBounds(70, 215, 97, 25);
		
		contentPane.add(btnShow);
		lblSSNOutput.setBounds(179, 215, 117, 21);
		
		contentPane.add(lblSSNOutput);
		ftfSSn.setBounds(129, 37, 139, 22);
		
		contentPane.add(ftfSSn);
		ssnMask.setPlaceholderCharacter('?');
		ssnMask.install(ftfSSn);
		contentPane.add(ftfSSn);
		lblSsn_1.setBounds(70, 83, 56, 16);
		
		contentPane.add(lblSsn_1);
		ftfSsn2.setBounds(129, 80, 139, 21);
		
		contentPane.add(ftfSsn2);
		
		ssnMask2.setPlaceholderCharacter('?');
		ssnMask2.install(ftfSsn2);
		contentPane.add(ftfSsn2);
		lblPhone.setBounds(70, 130, 56, 16);
		
		
		contentPane.add(lblPhone);
		ftfPhone.setBounds(129, 128, 139, 20);
		
		contentPane.add(ftfPhone);
		
		phone1.setPlaceholderCharacter('_');
		phone1.install(ftfPhone);
		contentPane.add(ftfPhone);
	}
	protected void do_btnShow_actionPerformed(ActionEvent arg0) {
		lblSSNOutput.setText(ftfSSn.getText());
	}
}
