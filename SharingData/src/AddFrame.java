import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblFirst = new JLabel("First:");
	private final JLabel lblSecond = new JLabel("Second:");
	private final JLabel lblThird = new JLabel("Third: ");
	private final JTextField txtAdd1 = new JTextField();
	private final JTextField txtAdd2 = new JTextField();
	private final JTextField txtAdd3 = new JTextField();
	private final JButton btnDone = new JButton("Done");

	private String val1 = "";
	private String val2 = "";
	private String val3 = "";
	
	private Item updateItem;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public AddFrame() {
		txtAdd3.setBounds(153, 118, 116, 22);
		txtAdd3.setColumns(10);
		txtAdd2.setBounds(153, 89, 116, 22);
		txtAdd2.setColumns(10);
		txtAdd1.setBounds(153, 60, 116, 22);
		txtAdd1.setColumns(10);
		jbInit();
	}
	public AddFrame(Item myItem) {
		txtAdd3.setBounds(153, 118, 116, 22);
		txtAdd3.setColumns(10);
		txtAdd2.setBounds(153, 89, 116, 22);
		txtAdd2.setColumns(10);
		txtAdd1.setBounds(153, 60, 116, 22);
		txtAdd1.setColumns(10);
		
		val1 = myItem.getFirstValue();
		val2 = myItem.getSecondValue();
		val3 = myItem.getThirdValue();
		
		txtAdd1.setText(val1);
		txtAdd2.setText(val2);
		txtAdd3.setText(val3);
		
		jbInit();
		
	}
	private void jbInit() {
		setTitle("Add Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 380, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFirst.setBounds(85, 63, 56, 16);
		
		contentPane.add(lblFirst);
		lblSecond.setBounds(85, 92, 56, 16);
		
		contentPane.add(lblSecond);
		lblThird.setBounds(85, 121, 56, 16);
		
		contentPane.add(lblThird);
		
		contentPane.add(txtAdd1);
		
		contentPane.add(txtAdd2);
		
		contentPane.add(txtAdd3);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnDone_actionPerformed(arg0);
			}
		});
		btnDone.setBounds(95, 153, 97, 25);
		
		contentPane.add(btnDone);
	}

	public Item getItem(){
		return updateItem;
	}
	
	protected void do_btnDone_actionPerformed(ActionEvent arg0) {
		updateItem = new Item(txtAdd1.getText(), txtAdd2.getText(), txtAdd3.getText());
		this.dispose();
	}
}
