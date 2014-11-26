import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ScrollPaneConstants;


public class MainQueryFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item");
	private final JSeparator separator = new JSeparator();
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JCheckBoxMenuItem chckbxmntmByRetailPrice = new JCheckBoxMenuItem("By Retail Price");
	private final JCheckBoxMenuItem chckbxmntmByCategory = new JCheckBoxMenuItem("By Category");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTextArea textAreaOutput = new JTextArea();
	private final JButton btnUpdate = new JButton("Update");
	private final JLabel lblSortType = new JLabel("No Sort Selected");
	private final JLabel lblFilterType = new JLabel("Retail Filter: None Category Filter: None");
	private final JScrollPane scrollPane = new JScrollPane();

	private Boolean isUpdateSuccess = false;
	private Boolean insertDuplicate = false;
	
	private static String querySelectFrom = "select itemid, itemname, category, wholesaleprice, retailprice, qoh, minquant, clerk from inventory ";
	private String queryOrderBy = "";
	private String queryWhere = "";
	private String queryCategory = "";
	private String queryRetail = "";
	
	private String displayCategory = "";
	private String displayRetail = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainQueryFrame frame = new MainQueryFrame();
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
	public MainQueryFrame() {
		jbInit();
		runQuery();
	}
	private void jbInit() {
		setTitle("Callahan - Inventory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuBar.setBounds(0, 0, 732, 30);
		
		contentPane.add(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddItem_actionPerformed(e);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(separator);
		
		mnTools.add(mnSetSort);
		
		mnSetSort.add(mnByName);
		buttonGroup.add(rdbtnmntmNameAscending);
		rdbtnmntmNameAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmNameAscending_actionPerformed(e);
			}
		});
		
		mnByName.add(rdbtnmntmNameAscending);
		buttonGroup.add(rdbtnmntmNameDescending);
		rdbtnmntmNameDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmNameDescending_actionPerformed(e);
			}
		});
		
		mnByName.add(rdbtnmntmNameDescending);
		
		mnSetSort.add(mnByRetailPrice);
		buttonGroup.add(rdbtnmntmRetailAscending);
		rdbtnmntmRetailAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmRetailAscending_actionPerformed(e);
			}
		});
		
		mnByRetailPrice.add(rdbtnmntmRetailAscending);
		buttonGroup.add(rdbtnmntmRetailDescending);
		rdbtnmntmRetailDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmRetailDescending_actionPerformed(e);
			}
		});
		
		mnByRetailPrice.add(rdbtnmntmRetailDescending);
		
		mnSetSort.add(mnByCategory);
		buttonGroup.add(rdbtnmntmCategoryAscending);
		rdbtnmntmCategoryAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmCategoryAscending_actionPerformed(e);
			}
		});
		
		mnByCategory.add(rdbtnmntmCategoryAscending);
		buttonGroup.add(rdbtnmntmCategoryDescending);
		rdbtnmntmCategoryDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmCategoryDescending_actionPerformed(e);
			}
		});
		
		mnByCategory.add(rdbtnmntmCategoryDescending);
		buttonGroup.add(rdbtnmntmNone);
		rdbtnmntmNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnmntmNone_actionPerformed(e);
			}
		});
		rdbtnmntmNone.setSelected(true);
		
		mnSetSort.add(rdbtnmntmNone);
		
		mnTools.add(mnSetFilter);
		chckbxmntmByRetailPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxmntmByRetailPrice_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(chckbxmntmByRetailPrice);
		chckbxmntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxmntmByCategory_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(chckbxmntmByCategory);
		
		menuBar.add(mnHelp);
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmUpdate_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmUpdate);
		mntmAddItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddItem_1_actionPerformed(e);
			}
		});
		
		mnHelp.add(separator_2);
		
		mnHelp.add(mntmAddItem_1);
		mntmSetSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSetSort_actionPerformed(e);
			}
		});
		
		mnHelp.add(separator_1);
		
		mnHelp.add(mntmSetSort);
		mntmSetFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSetFilter_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmSetFilter);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 87, 710, 328);
		
		contentPane.add(scrollPane);
		textAreaOutput.setText("   ID Item Name             Category  Wholesale  Retail    QOH   Min   Clerk  \r\n   -- ---------             --------  ---------  ------    ---   ---   -----  ");
		textAreaOutput.setFont(new Font("Courier New", Font.PLAIN, 12));
		scrollPane.setViewportView(textAreaOutput);
		textAreaOutput.setEditable(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnUpdate_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(623, 420, 97, 25);
		
		contentPane.add(btnUpdate);
		lblSortType.setBounds(0, 424, 393, 16);
		
		contentPane.add(lblSortType);
		lblFilterType.setBounds(0, 437, 611, 16);
		
		contentPane.add(lblFilterType);
		lblCompanyInventory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCompanyInventory.setBounds(10, 43, 217, 31);
		
		contentPane.add(lblCompanyInventory);
		
		
		//Load the driver
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
		
	}
	
	
	
	
	private final JMenu mnByName = new JMenu("By Name");
	private final JMenu mnByRetailPrice = new JMenu("By Retail Price");
	private final JMenu mnByCategory = new JMenu("By Category");
	private final JRadioButtonMenuItem rdbtnmntmNameAscending = new JRadioButtonMenuItem("Ascending");
	private final JRadioButtonMenuItem rdbtnmntmRetailAscending = new JRadioButtonMenuItem("Ascending");
	private final JRadioButtonMenuItem rdbtnmntmCategoryAscending = new JRadioButtonMenuItem("Ascending");
	private final JRadioButtonMenuItem rdbtnmntmNameDescending = new JRadioButtonMenuItem("Descending");
	private final JRadioButtonMenuItem rdbtnmntmRetailDescending = new JRadioButtonMenuItem("Descending");
	private final JRadioButtonMenuItem rdbtnmntmCategoryDescending = new JRadioButtonMenuItem("Descending");
	private final JRadioButtonMenuItem rdbtnmntmNone = new JRadioButtonMenuItem("None");
	private final JLabel lblCompanyInventory = new JLabel("Company Inventory:");
	private final JMenuItem mntmUpdate = new JMenuItem("Update");
	private final JMenuItem mntmAddItem_1 = new JMenuItem("Add Item");
	private final JMenuItem mntmSetSort = new JMenuItem("Set Sort");
	private final JMenuItem mntmSetFilter = new JMenuItem("Set Filter");
	private final JSeparator separator_1 = new JSeparator();
	private final JSeparator separator_2 = new JSeparator();
	
	
	
	private void runQuery(){
		textAreaOutput.setText("");
		textAreaOutput.append("   ID Item Name             Category  Wholesale  Retail    QOH   Min   Clerk  \n");
		textAreaOutput.append("   -- ---------             --------  ---------  ------    ---   ---   -----  \n");
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			//Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:CallahanDatabase");
			
			//Create the statement
			stmt = conn.createStatement();
			
			
			//Execute the statement
			String query = querySelectFrom + queryWhere + queryOrderBy + " ;";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			//Process the results
			while (rs.next()){
				int tempItemId = rs.getInt("ItemID");
				String tempItemName = rs.getString("ItemName");
				String tempCategory = rs.getString("Category");
				double tempWholesalePrice = rs.getDouble("WholesalePrice");
				double tempRetailPrice = rs.getDouble("RetailPrice");
				int tempQoh = rs.getInt("QOH");
				int tempMinQuant = rs.getInt("MinQuant");
				String tempClerk = rs.getString("Clerk");
				
				
				
				String formattedOutput = String.format("%5d %-21s %-9s $%6.2f %2s $%6.2f %5d %5d %1s %-20s \n", tempItemId, tempItemName, tempCategory, tempWholesalePrice, " ", tempRetailPrice, tempQoh, tempMinQuant, "", tempClerk);
				textAreaOutput.append(formattedOutput);
			
			}
			
			
			//Clean up
			rs.close();
			conn.close();
			
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
	}
	
	private Boolean runInsertQuery(String tempItemId, String tempItemName, String tempQuery) {
		Statement stmt = null;
		ResultSet rs = null; //only for duplicate check
		
		try {
			//Establish connection
			Connection conn = DriverManager.getConnection("jdbc:odbc:CallahanDatabase");
			
			//Check for duplicates
			stmt = conn.createStatement();
			
			//Create the query
			String duplicateCheck = "select * from inventory where itemid = " + tempItemId + " or itemname = '" + tempItemName + " ' ";
			
			//Run the query
			rs = stmt.executeQuery(duplicateCheck);
			if (rs.next()){
				insertDuplicate = true;
				isUpdateSuccess = false;
			}
			else{
			//Create the statement
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Create the insert statement
			String query = tempQuery;
			System.out.println(query);
				
			//Execute the statement
			if (stmt.executeUpdate(query) != 0)
				isUpdateSuccess = true;
			else isUpdateSuccess = false;
				
			//Close the connection
			rs.close();
			conn.close();
			
			}
					
		}catch (SQLException ex) {
			System.out.println("SQL Exception:   " + ex.getMessage());
			System.out.println("SQL State:   " + ex.getSQLState());
			System.out.println("Vendor Error:   " + ex.getErrorCode());
			ex.printStackTrace();
		}
		
		return isUpdateSuccess;
	}
	
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		int exitChoice = JOptionPane.showConfirmDialog(
		    this,
		    "Are you sure you want to exit?",
		    "Confirm Exit",
		    JOptionPane.YES_NO_OPTION);
		if (exitChoice == JOptionPane.YES_OPTION){
		this.dispose();
		}
	}
	protected void do_mntmAddItem_actionPerformed(ActionEvent e) {
		AddItemDialog dialogInsert = new AddItemDialog();
		dialogInsert.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dialogInsert.setVisible(true);
		
		Boolean tempIsSuccess = runInsertQuery(dialogInsert.getInsertItemId(), dialogInsert.getInsertItemName(), dialogInsert.getQueryInsert());
		Boolean attemptInsert = dialogInsert.isAttemptingInsert();
		
		while (insertDuplicate && !tempIsSuccess && attemptInsert){
			JOptionPane.showMessageDialog(this,
				    "Please fix duplicate.",
				    "Duplicate Data",
				    JOptionPane.WARNING_MESSAGE);
			dialogInsert.setVisible(true);
			tempIsSuccess = runInsertQuery(dialogInsert.getInsertItemId(), dialogInsert.getInsertItemName(), dialogInsert.getQueryInsert());
			attemptInsert = dialogInsert.isAttemptingInsert();
		}
		
		if (tempIsSuccess){
			JOptionPane.showMessageDialog(this,
				    "Insert Success.",
				    "Success",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		if (!attemptInsert){
			dialogInsert.dispose();
			JOptionPane.showMessageDialog(this,
				    "Insert Cancelled.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!tempIsSuccess){
			JOptionPane.showMessageDialog(this,
				    "Insert Failed.",
				    "Failure",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		runQuery();
		
		
	}
	private void buildWhere(){
		queryWhere = "where (1=1) " + queryRetail + queryCategory;
		lblFilterType.setText("Retail Filter: " + displayRetail + " Category Filter: " + displayCategory);
		runQuery();
	}
	
	protected void do_chckbxmntmByRetailPrice_actionPerformed(ActionEvent e) {
		if (chckbxmntmByRetailPrice.isSelected()){
			FilterRetailPriceDialog dialogRetail = new FilterRetailPriceDialog();
			dialogRetail.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dialogRetail.setVisible(true);
			
			queryRetail = dialogRetail.getQueryOutput();
			displayRetail = dialogRetail.getDisplayOutput();
		}
		else{
			displayRetail = "none";
			queryRetail = "";
		}	
		buildWhere();
		
	}
	protected void do_chckbxmntmByCategory_actionPerformed(ActionEvent e) {
		if (chckbxmntmByCategory.isSelected()){
			FilterCategoryDialog dialogCategory = new FilterCategoryDialog();
			dialogCategory.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dialogCategory.setVisible(true);
			
			queryCategory = dialogCategory.getQueryOutput();
			displayCategory = dialogCategory.getDisplayOutput();
		}
		else{
			displayCategory = "none";
			queryCategory = "";
		}	
		buildWhere();
		
		
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		runQuery();
	}
	
	protected void do_rdbtnmntmNameAscending_actionPerformed(ActionEvent e) {	
		queryOrderBy = "ORDER BY ItemName asc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	protected void do_rdbtnmntmNameDescending_actionPerformed(ActionEvent e) {
		queryOrderBy = "ORDER BY ItemName desc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	protected void do_rdbtnmntmRetailAscending_actionPerformed(ActionEvent e) {
		queryOrderBy = "ORDER BY RetailPrice asc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	protected void do_rdbtnmntmRetailDescending_actionPerformed(ActionEvent e) {
		queryOrderBy = "ORDER BY RetailPrice desc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	protected void do_rdbtnmntmCategoryAscending_actionPerformed(ActionEvent e) {
		queryOrderBy = "ORDER BY Category asc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	protected void do_rdbtnmntmCategoryDescending_actionPerformed(ActionEvent e) {
		queryOrderBy = "ORDER BY Category desc";
		lblSortType.setText("Sort by " + queryOrderBy.substring(8));
		runQuery();
	}
	
	protected void do_rdbtnmntmNone_actionPerformed(ActionEvent e) {
		queryOrderBy = " ";
		lblSortType.setText("No sort selected");
		runQuery();
	}
	protected void do_mntmUpdate_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Update refreshes the query window keeping all current settings.");
	}
	protected void do_mntmAddItem_1_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Add item opens a dialog to add a new item and then refreshes the query window.");
	}
	protected void do_mntmSetSort_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Set sort sorts the query window data by a specified selection.");
	}
	protected void do_mntmSetFilter_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
			    "Set filter filters the query window data by a specified selection.");
	}
}
