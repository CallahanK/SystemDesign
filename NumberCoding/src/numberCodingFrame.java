import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class numberCodingFrame extends JFrame {

	private JPanel contentPane;
	private final JTextField txt1 = new JTextField();
	private final JTextField txt2 = new JTextField();
	private final JSeparator separator = new JSeparator();
	private final JLabel lblOutput = new JLabel("0");
	private final JLabel lblMinus = new JLabel("-");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numberCodingFrame frame = new numberCodingFrame();
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
	public numberCodingFrame() {
		txt2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txt2_focusLost(e);
			}
		});
		txt2.setText("0");
		txt2.setHorizontalAlignment(SwingConstants.TRAILING);
		txt2.setBounds(81, 72, 116, 22);
		txt2.setColumns(10);
		txt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txt1_focusLost(arg0);
			}
		});
		txt1.setHorizontalAlignment(SwingConstants.TRAILING);
		txt1.setText("0");
		txt1.setBounds(81, 37, 116, 22);
		txt1.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Coding");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(txt1);
		
		contentPane.add(txt2);
		separator.setBounds(81, 107, 116, 2);
		
		contentPane.add(separator);
		lblOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOutput.setBounds(81, 122, 116, 22);
		
		contentPane.add(lblOutput);
		lblMinus.setBounds(53, 75, 16, 16);
		
		contentPane.add(lblMinus);
	}
	
	private String getOutput(){
		int temp1 = Integer.parseInt(txt1.getText());
		int temp2 = Integer.parseInt(txt2.getText());
		int tempOutput = 0;
		String output = "";
		
		lblOutput.setForeground(Color.BLACK);
		txt1.setForeground(Color.black);
		txt2.setForeground(Color.black);
		
		
		tempOutput = tempOutput + temp1;
		tempOutput = tempOutput - temp2;
		
		output = Integer.toString(tempOutput);
		
		if (tempOutput < 0){
			lblOutput.setForeground(Color.RED);
		}
		if (temp1 < 0){
			txt1.setForeground(Color.RED);
		}
		if (temp2 < 0){
			txt2.setForeground(Color.RED);
		}
		return output;	
	}
	
	protected void do_txt1_focusLost(FocusEvent arg0) {
		if (txt1.getText().isEmpty()){
			txt1.setText("0");
		}
		lblOutput.setText(getOutput());
		txt1.transferFocus();
	}
	protected void do_txt2_focusLost(FocusEvent e) {
		if (txt2.getText().isEmpty()){
			txt2.setText("0");
		}
		lblOutput.setText(getOutput());
		txt2.transferFocus();
	}
}
