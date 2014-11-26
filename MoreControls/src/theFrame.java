import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class theFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblCallahansPizzeria = new JLabel("Callahan's Pizzeria");
	private final JLabel lblName = new JLabel("Name:");
	private final JLabel lblSize = new JLabel("Size:");
	private final JTextField textFieldName = new JTextField();
	private final JComboBox comboBoxSize = new JComboBox();
	private final JButton btnPlaceOrder = new JButton("Place Order");
	private final JTextArea textAreaOrder = new JTextArea();
	private final JLabel lblToppings = new JLabel("Toppings:");
	private final JScrollPane scrollPaneToppings = new JScrollPane();
	private final JList listToppings = new JList();
	private final JScrollPane scrollPane = new JScrollPane();

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
		textFieldName.setBounds(77, 66, 116, 22);
		textFieldName.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Kevin Callahan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCallahansPizzeria.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
		lblCallahansPizzeria.setForeground(Color.RED);
		lblCallahansPizzeria.setBounds(12, 13, 181, 40);
		
		contentPane.add(lblCallahansPizzeria);
		lblName.setBounds(12, 66, 56, 16);
		
		contentPane.add(lblName);
		lblSize.setBounds(12, 111, 56, 16);
		
		contentPane.add(lblSize);
		
		contentPane.add(textFieldName);
		comboBoxSize.setModel(new DefaultComboBoxModel(new String[] {"Individual", "Small", "Medium", "Large", "Extra Large"}));
		comboBoxSize.setBounds(77, 108, 116, 22);
		comboBoxSize.setSelectedIndex(-1);
		
		contentPane.add(comboBoxSize);
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPlaceOrder_actionPerformed(arg0);
			}
		});
		btnPlaceOrder.setBounds(62, 239, 131, 25);
		
		contentPane.add(btnPlaceOrder);
		lblToppings.setBounds(12, 148, 68, 16);
		
		contentPane.add(lblToppings);
		scrollPaneToppings.setBounds(77, 151, 116, 75);
		
		contentPane.add(scrollPaneToppings);
		listToppings.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese", "Black olives", "Green peppers", "Pineapple", "Spinach"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPaneToppings.setViewportView(listToppings);
		scrollPane.setBounds(205, 48, 215, 216);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textAreaOrder);
		textAreaOrder.setLineWrap(true);
	}
	
	
	//add list of 10 toppings
	//ability to choose multiple toppings
	protected void do_btnPlaceOrder_actionPerformed(ActionEvent arg0) {
		
		Object [] selToppings = listToppings.getSelectedValues();
		for(Object e : selToppings)	{
			System.out.println(e);
		}
				
		textAreaOrder.append("Hello " + textFieldName.getText() + ".\n You have ordered a(n) " + comboBoxSize.getSelectedItem() + " pie. \n");
		//System.out.println(listToppings.getSelectedValuesList().toString());
		textAreaOrder.append("You have added " + listToppings.getSelectedValuesList().toString().substring(1, listToppings.getSelectedValuesList().toString().length() - 1 ) + "as the topping(s). \n \n");
		textFieldName.setText("");
		comboBoxSize.setSelectedIndex(-1);
		listToppings.clearSelection();
		
	}
}
