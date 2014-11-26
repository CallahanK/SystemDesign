import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JCheckBox;


public class sumField extends JFrame {

	private JPanel contentPane;
	private final JTextField txt1 = new JTextField();
	private final JTextField txt2 = new JTextField();
	private final JTextField txt3 = new JTextField();
	private final JSeparator separator = new JSeparator();
	private final JTextField txtOutput = new JTextField();
	private final JLabel label = new JLabel("+");
	private final JCheckBox chckbxClearOnFocus = new JCheckBox("Clear on Focus");
	private final JTextField txt4 = new JTextField();
	private final JTextField txt5 = new JTextField();
	private final JLabel lbl1 = new JLabel("");
	private final JLabel lbl2 = new JLabel("");
	private final JLabel lbl3 = new JLabel("");
	private final JLabel lbl4 = new JLabel("");
	private final JLabel lbl5 = new JLabel("");
	private final JLabel lblOutputAlert = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sumField frame = new sumField();
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
	public sumField() {
		txt5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txt5_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				do_txt5_focusGained(arg0);
			}
		});
		txt5.setText("0");
		txt5.setHorizontalAlignment(SwingConstants.TRAILING);
		txt5.setBounds(119, 153, 116, 22);
		txt5.setColumns(10);
		txt4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txt4_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				do_txt4_focusGained(arg0);
			}
		});
		txt4.setHorizontalAlignment(SwingConstants.TRAILING);
		txt4.setText("0");
		txt4.setBounds(119, 118, 116, 22);
		txt4.setColumns(10);
		txtOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOutput.setText("0");
		txtOutput.setEditable(false);
		txtOutput.setBounds(119, 203, 116, 22);
		txtOutput.setColumns(10);
		txtOutput.setFocusable(false);
		txt3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txt3_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_txt3_focusGained(e);
			}
		});
		txt3.setHorizontalAlignment(SwingConstants.TRAILING);
		txt3.setText("0");
		txt3.setBounds(119, 83, 116, 22);
		txt3.setColumns(10);
		txt2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txt2_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_txt2_focusGained(e);
			}
		});
		txt2.setHorizontalAlignment(SwingConstants.TRAILING);
		txt2.setText("0");
		txt2.setBounds(119, 48, 116, 22);
		txt2.setColumns(10);
		txt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txt1_focusLost(arg0);
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				do_txt1_focusGained(arg0);
			}
		});
		txt1.setHorizontalAlignment(SwingConstants.TRAILING);
		txt1.setText("0");
		txt1.setBounds(119, 13, 116, 22);
		txt1.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Sum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(txt1);
		
		contentPane.add(txt2);
		
		contentPane.add(txt3);
		separator.setBounds(119, 188, 116, 2);
		
		contentPane.add(separator);
		
		contentPane.add(txtOutput);
		label.setBounds(99, 156, 8, 16);
		
		contentPane.add(label);
		chckbxClearOnFocus.setBounds(311, 12, 113, 25);
		chckbxClearOnFocus.setFocusable(false);
		
		contentPane.add(chckbxClearOnFocus);
		
		contentPane.add(txt4);
		
		contentPane.add(txt5);
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(247, 16, 56, 16);
		
		contentPane.add(lbl1);
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(247, 51, 56, 16);
		
		contentPane.add(lbl2);
		lbl3.setForeground(Color.RED);
		lbl3.setBounds(247, 86, 56, 16);
		
		contentPane.add(lbl3);
		lbl4.setForeground(Color.RED);
		lbl4.setBounds(247, 121, 56, 16);
		
		contentPane.add(lbl4);
		lbl5.setForeground(Color.RED);
		lbl5.setBounds(247, 156, 56, 16);
		
		contentPane.add(lbl5);
		lblOutputAlert.setForeground(Color.RED);
		lblOutputAlert.setBounds(247, 206, 56, 16);
		
		contentPane.add(lblOutputAlert);
	}
	
	private String getOutput(){
		int temp1 = Integer.parseInt(txt1.getText());
		int temp2 = Integer.parseInt(txt2.getText());
		int temp3 = Integer.parseInt(txt3.getText());
		int temp4 = Integer.parseInt(txt4.getText());
		int temp5 = Integer.parseInt(txt5.getText());
		int tempOutput = 0;
		String output = "";
		
		txtOutput.setForeground(Color.BLACK);
		txt1.setForeground(Color.black);
		txt2.setForeground(Color.black);
		txt3.setForeground(Color.black);
		txt4.setForeground(Color.black);
		txt5.setForeground(Color.black);
		
		lbl1.setText("");
		lbl2.setText("");
		lbl3.setText("");
		lbl4.setText("");
		lbl5.setText("");
		lblOutputAlert.setText("");
		
		tempOutput = tempOutput + temp1;
		tempOutput = tempOutput + temp2;
		tempOutput = tempOutput + temp3;
		tempOutput = tempOutput + temp4;
		tempOutput = tempOutput + temp5;
		
		output = Integer.toString(tempOutput);
		
		if (tempOutput < 0){
			txtOutput.setForeground(Color.RED);
			lblOutputAlert.setText("*");
		}
		if (temp1 < 0){
			txt1.setForeground(Color.RED);
			lbl1.setText("*");
		}
		if (temp2 < 0){
			txt2.setForeground(Color.RED);
			lbl2.setText("*");
		}
		if (temp3 < 0){
			txt3.setForeground(Color.RED);
			lbl3.setText("*");
		}
		if (temp4 < 0){
			txt4.setForeground(Color.RED);
			lbl4.setText("*");
		}
		if (temp5 < 0){
			txt5.setForeground(Color.RED);
			lbl5.setText("*");
		}
		return output;	
	}
	
	protected void do_txt1_focusLost(FocusEvent arg0) {
		if (txt1.getText().isEmpty()){
			txt1.setText("0");
		}
		txtOutput.setText(getOutput());
		txt1.transferFocus();
	}
	
	protected void do_txt2_focusLost(FocusEvent arg0) {
		if (txt2.getText().isEmpty()){
			txt2.setText("0");
		}
		txtOutput.setText(getOutput());
		txt2.transferFocus();
	}
	protected void do_txt3_focusLost(FocusEvent e) {
		if (txt3.getText().isEmpty()){
			txt3.setText("0");
		}
		txtOutput.setText(getOutput());
		txt3.transferFocus();
	}
	protected void do_txt1_focusGained(FocusEvent arg0) {
		if (chckbxClearOnFocus.isSelected()){
		txt1.setText("");
		}
	}
	protected void do_txt2_focusGained(FocusEvent e) {
		if (chckbxClearOnFocus.isSelected()){
		txt2.setText("");
		}
	}
	protected void do_txt3_focusGained(FocusEvent e) {
		if (chckbxClearOnFocus.isSelected()){
		txt3.setText("");
		}
	}
	protected void do_txt4_focusLost(FocusEvent arg0) {
		if (txt4.getText().isEmpty()){
			txt4.setText("0");
		}
		txtOutput.setText(getOutput());
		txt4.transferFocus();
	}
	protected void do_txt5_focusLost(FocusEvent arg0) {
		if (txt5.getText().isEmpty()){
			txt5.setText("0");
		}
		txtOutput.setText(getOutput());
		txt5.transferFocus();
	}
	protected void do_txt4_focusGained(FocusEvent arg0) {
		if (chckbxClearOnFocus.isSelected()){
			txt4.setText("");
		}
	}
	
	protected void do_txt5_focusGained(FocusEvent arg0) {
		if (chckbxClearOnFocus.isSelected()){
			txt5.setText("");
		}
	}
}

