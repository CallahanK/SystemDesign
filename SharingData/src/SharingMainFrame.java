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


public class SharingMainFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblValue = new JLabel("Value 1:");
	private final JLabel lblValue_1 = new JLabel("Value 2:");
	private final JLabel lblValue_2 = new JLabel("Value 3:");
	private final JTextField txtVal1 = new JTextField();
	private final JTextField txtVal2 = new JTextField();
	private final JTextField txtVal3 = new JTextField();
	private final JButton btnAdd = new JButton("Add...");
	private final JButton btnUpdate = new JButton("Update");

	private Item myItem;
	private AddFrame addFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SharingMainFrame frame = new SharingMainFrame();
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
	public SharingMainFrame() {
		txtVal3.setBounds(148, 124, 116, 22);
		txtVal3.setColumns(10);
		txtVal2.setBounds(148, 92, 116, 22);
		txtVal2.setColumns(10);
		txtVal1.setBounds(148, 63, 116, 22);
		txtVal1.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Share Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblValue.setBounds(80, 66, 56, 16);
		
		contentPane.add(lblValue);
		lblValue_1.setBounds(80, 95, 56, 16);
		
		contentPane.add(lblValue_1);
		lblValue_2.setBounds(80, 124, 56, 16);
		
		contentPane.add(lblValue_2);
		
		contentPane.add(txtVal1);
		
		contentPane.add(txtVal2);
		
		contentPane.add(txtVal3);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(148, 159, 97, 25);
		
		contentPane.add(btnAdd);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdate_actionPerformed(e);
			}
		});
		btnUpdate.setBounds(257, 159, 97, 25);
		
		contentPane.add(btnUpdate);
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		myItem = new Item(txtVal1.getText(), txtVal2.getText(), txtVal3.getText());
		
		addFrame = new AddFrame(myItem);
		addFrame.setVisible(true);
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent e) {
		txtVal1.setText(addFrame.getItem().getFirstValue());
		txtVal2.setText(addFrame.getItem().getSecondValue());
		txtVal3.setText(addFrame.getItem().getThirdValue());
	}
}
