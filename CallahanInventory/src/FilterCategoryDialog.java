import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;


public class FilterCategoryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String outputDisplay = "";
	private String outputQuery = "";
	
	private final JList<String> listCategory = new JList<String>();
	private final JTextArea txtrSelectOneOr = new JTextArea();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FilterCategoryDialog dialog = new FilterCategoryDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FilterCategoryDialog() {
		jbInit();
	}
	private void jbInit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FilterCategoryDialog.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		setResizable(false);
		setModal(true);
		setTitle("Filter By Category");
		setBounds(100, 100, 266, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			//JList<String> listCategory = new JList<String>();
			listCategory.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			listCategory.setModel(new AbstractListModel<String>() {
				String[] values = new String[] {"Dairy", "Meat", "Frozen", "Canned", "Produce", "Beverage", "Paper", "Snack", "Cereal", "Other"};
				public int getSize() {
					return values.length;
				}
				public String getElementAt(int index) {
					return values[index];
				}
			});
			listCategory.setBounds(187, 13, 64, 190);
			contentPanel.add(listCategory);
		}
		txtrSelectOneOr.setWrapStyleWord(true);
		txtrSelectOneOr.setLineWrap(true);
		txtrSelectOneOr.setText("Select one or more categories.\r\nOnly items with one of the matching categories will be displayed.");
		txtrSelectOneOr.setBackground(SystemColor.menu);
		txtrSelectOneOr.setBounds(12, 13, 164, 190);
		
		contentPanel.add(txtrSelectOneOr);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_okButton_actionPerformed(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_cancelButton_actionPerformed(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		if (listCategory.isSelectionEmpty()){
			JOptionPane.showMessageDialog(this,
				    "Please make a selection.",
				    "Empty selection",
				    JOptionPane.WARNING_MESSAGE);
		}
		else{
			Object[] selectCategories = listCategory.getSelectedValuesList().toArray();
			
			outputDisplay = outputDisplay + selectCategories[0];
			
			outputQuery = "AND ( category = '" + selectCategories[0] + "'"; 
			
			for (int i = 1; i < selectCategories.length; i++){
				outputQuery = outputQuery + " or category = '" + selectCategories[i] + "'";
				outputDisplay = outputDisplay + " or " + selectCategories[i];
			}
			outputQuery = outputQuery + " )";
			//System.out.println(outputQuery);
			//System.out.println(outputDisplay);
			this.setVisible(false);
		}
	}
	
	public String getDisplayOutput(){
		return outputDisplay;
	}
	
	public String getQueryOutput(){
		return outputQuery;
	}
	
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
