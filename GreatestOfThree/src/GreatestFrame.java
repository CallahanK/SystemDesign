import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

import javax.swing.JLabel;


public class GreatestFrame extends JFrame {

	private JPanel contentPane;
	private final JFormattedTextField ftf1 = new JFormattedTextField();
	private final JFormattedTextField ftf2 = new JFormattedTextField();
	private final JFormattedTextField ftf3 = new JFormattedTextField();

	MaskFormatter maskInt1 = createFormatter("####");
	MaskFormatter maskInt2 = createFormatter("####");
	MaskFormatter maskInt3 = createFormatter("####");
	private final JLabel lblOutput = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GreatestFrame frame = new GreatestFrame();
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
	public GreatestFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Greatest of Three");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ftf1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_ftf1_focusLost(arg0);
			}
		});
		ftf1.setHorizontalAlignment(SwingConstants.TRAILING);
		ftf1.setBounds(12, 55, 80, 22);
		
		contentPane.add(ftf1);
		ftf2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftf2_focusLost(e);
			}
		});
		ftf2.setHorizontalAlignment(SwingConstants.TRAILING);
		ftf2.setBounds(12, 90, 80, 22);
		
		contentPane.add(ftf2);
		ftf3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftf3_focusLost(e);
			}
		});
		ftf3.setHorizontalAlignment(SwingConstants.TRAILING);
		ftf3.setBounds(12, 125, 80, 22);
		
		contentPane.add(ftf3);
		
		maskInt1.setPlaceholderCharacter('0');
		maskInt1.install(ftf1);
		contentPane.add(ftf1);
		
		maskInt2.setPlaceholderCharacter('0');
		maskInt2.install(ftf2);
		contentPane.add(ftf2);
		
		maskInt3.setPlaceholderCharacter('0');
		maskInt3.install(ftf3);
		contentPane.add(ftf3);
		lblOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOutput.setBounds(12, 153, 80, 22);
		
		
		
		
		contentPane.add(lblOutput);
	}
	protected void do_ftf1_focusLost(FocusEvent arg0) {
		lblOutput.setText(getGreatestInt());
	}
	protected void do_ftf2_focusLost(FocusEvent e) {
		lblOutput.setText(getGreatestInt());
	}
	protected void do_ftf3_focusLost(FocusEvent e) {
		lblOutput.setText(getGreatestInt());
	}
	
	private String getGreatestInt(){
		int[] inputInt = new int[3];
		String output = "";
		
		inputInt[0] = Integer.parseInt(ftf1.getText());
		inputInt[1] = Integer.parseInt(ftf2.getText());
		inputInt[2] = Integer.parseInt(ftf3.getText());
		
		Arrays.sort(inputInt);
		output = Integer.toString(inputInt[2]);
		
		return output;
	}
	
	
}
