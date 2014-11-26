package salvArmy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class CallahanKevinSalvArmy extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnHelp = new JMenu("Help");
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panelPersonal = new JPanel();
	private final JPanel panelHousehold = new JPanel();
	private final JPanel panelFinancial = new JPanel();
	private final JLabel lblFirstName = new JLabel("First Name:");
	private final JLabel lblLastName = new JLabel("Last Name: ");
	private final JLabel lblSs = new JLabel("SS#:");
	private final JLabel lblDob = new JLabel("D.o.B. :");
	private final JLabel lblPhone = new JLabel("Phone #:");
	private final JLabel lblAddress = new JLabel("Address:");
	private final JLabel lblCity = new JLabel("City:");
	private final JLabel lblCounty = new JLabel("County:");
	private final JLabel lblZip = new JLabel("Zip:");
	private final JTextField txtFName = new JTextField();
	private final JTextField txtLName = new JTextField();
	private final JFormattedTextField ftfSSN = new JFormattedTextField();
	private final JComboBox comboDobMonth = new JComboBox();
	private final JFormattedTextField ftfDobDay = new JFormattedTextField();
	private final JFormattedTextField ftfDobYear = new JFormattedTextField();
	private final JFormattedTextField ftfPhoneNumber = new JFormattedTextField();
	private final JTextField txtCity = new JTextField();
	private final JComboBox comboCounty = new JComboBox();
	private final JFormattedTextField ftfZip = new JFormattedTextField();
	private final JLabel lblSpousesFirstName = new JLabel("First Name: ");
	private final JLabel lblSpousesLastName = new JLabel("Last Name: ");
	private final JLabel lblSpousesSSN = new JLabel("SS#:");
	private final JLabel lblSpouseDob = new JLabel("D.o.B. :");
	private final JLabel lblEthnicity = new JLabel("Ethnicity:");
	private final JComboBox comboEthnicity = new JComboBox();
	private final JTextField txtAddress = new JTextField();
	
	MaskFormatter ssnMask = createFormatter("###-##-####");
	MaskFormatter ssnMaskSpouse = createFormatter("###-##-####");
	
	MaskFormatter ssnHousehold1Mask = createFormatter("###-##-####");
	MaskFormatter ssnHousehold2Mask = createFormatter("###-##-####");
	MaskFormatter ssnHousehold3Mask = createFormatter("###-##-####");
	MaskFormatter ssnHousehold4Mask = createFormatter("###-##-####");
	MaskFormatter ssnHousehold5Mask = createFormatter("###-##-####");
	MaskFormatter ssnHousehold6Mask = createFormatter("###-##-####");
	
	MaskFormatter dobDayMask = createFormatter("##");
	MaskFormatter dobYearMask = createFormatter("####");
	
	MaskFormatter dobDayMaskSpouse = createFormatter("##");
	MaskFormatter dobYearMaskSpouse = createFormatter("####");
	
	MaskFormatter currentDayMask = createFormatter("##");
	MaskFormatter currentYearMask = createFormatter("####");
	
	MaskFormatter phoneMask = createFormatter("(###)-###-####");
	
	MaskFormatter addressZipMask = createFormatter("#####");
	
	private double totalIncome = 0;
	private double totalExpenses = 0;
	private double totalNetIncome = 0;
	private final JLabel lblPlaceofEmploy = new JLabel("Place of Employment: ");
	private final JLabel lblUnemploymentLength = new JLabel("Length of Unemployment: ");
	private final JCheckBox checkBoxEmployedSpouse = new JCheckBox("Spouse Currently Employed");
	private final JLabel lblPlaceofEmploySpouse = new JLabel("Spouse's Place of Employment: ");
	private final JLabel lblUnemploymentLengthSpouse = new JLabel("Length of Spouse's Unemployment: ");
	private final JLabel lblIncome = new JLabel("Income: ");
	private final JLabel lblSalary = new JLabel("Salary: ");
	private final JLabel lblUnemployment = new JLabel("Unemployment: ");
	private final JLabel lblTanfafdc = new JLabel("TANF/AFDC: ");
	private final JLabel lblSocialSecurity = new JLabel("Social Security: ");
	private final JLabel lblDisability = new JLabel("Disability: ");
	private final JLabel lblChildSupport = new JLabel("Child Support: ");
	private final JLabel lblUtilityAssistance = new JLabel("Utility Assistance: ");
	private final JLabel lblFoodStamps = new JLabel("Food Stamps: ");
	private final JTextField txtSalary = new JTextField();
	private final JTextField txtUnemployment = new JTextField();
	private final JTextField txtTanf = new JTextField();
	private final JTextField txtSocialSec = new JTextField();
	private final JTextField txtDisability = new JTextField();
	private final JTextField txtChildSupp = new JTextField();
	private final JTextField txtUtilityAssist = new JTextField();
	private final JTextField txtFoodStamps = new JTextField();
	private final JLabel lblExpenses = new JLabel("Expenses:");
	private final JLabel lblRent = new JLabel("Rent: ");
	private final JLabel lblPhoneBill = new JLabel("Phone Bill: ");
	private final JLabel lblGasWater = new JLabel("Gas/ Water:");
	private final JLabel lblLightBill = new JLabel("Light Bill: ");
	private final JLabel lblCarPayment = new JLabel("Car Payment: ");
	private final JLabel lblFurnappliances = new JLabel("Furn./Appliances: ");
	private final JLabel lblCableTv = new JLabel("Cable TV: ");
	private final JLabel lblDoctormed = new JLabel("Doctor/Med. :");
	private final JTextField txtRent = new JTextField();
	private final JTextField txtPhoneBill = new JTextField();
	private final JTextField txtGasWater = new JTextField();
	private final JTextField txtLightBill = new JTextField();
	private final JTextField txtCarPayments = new JTextField();
	private final JTextField txtFurn = new JTextField();
	private final JTextField txtCableTV = new JTextField();
	private final JTextField txtDoctor = new JTextField();
	private final JLabel lblOtherIncome = new JLabel("Other: ");
	private final JLabel lblOtherExpense = new JLabel("Other: ");
	private final JTextField txtOtherExpense = new JTextField();
	private final JTextField txtOtherIncome = new JTextField();
	private final JLabel lblTotalIncome = new JLabel("Total Income: ");
	private final JLabel lblTotalExpenses = new JLabel("Total Expenses: ");
	private final JLabel lblTotalNetIncome = new JLabel("Total Net Income: ");
	private final JTextField txtTotalIncome = new JTextField();
	private final JTextField txtTotalExpenses = new JTextField();
	private final JTextField txtTotalNetIncome = new JTextField();
	private final JLabel lblPresentProblem = new JLabel("Present Problem: ");
	private final JTextArea textAreaProblem = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JCheckBox checkBoxEmployed = new JCheckBox("Currently Employed");
	private final JTextField txtPlaceofEmploy = new JTextField();
	private final JTextField txtPlaceofEmploySpouse = new JTextField();
	private final JComboBox comboBoxUnemployDays = new JComboBox();
	private final JComboBox comboBoxUnemployMonths = new JComboBox();
	private final JComboBox comboBoxUnemployYear = new JComboBox();
	private final JComboBox comboBoxUnemployDaysSpouse = new JComboBox();
	private final JComboBox comboBoxUnemployMonthsSpouse = new JComboBox();
	private final JComboBox comboBoxUnemployYearSpouse = new JComboBox();
	private final JLabel lblSpouseInfo = new JLabel("Spouse Information: ");
	private final JTextField txtFNameSpouse = new JTextField();
	private final JTextField txtLNameSpouse = new JTextField();
	private final JFormattedTextField ftfSSNSpouse = new JFormattedTextField();
	private final JComboBox comboDobMonthSpouse = new JComboBox();
	private final JFormattedTextField ftfDobDaySpouse = new JFormattedTextField();
	private final JFormattedTextField ftfDobYearSpouse = new JFormattedTextField();
	private final JMenuItem mntmStartNewApplication = new JMenuItem("Start New Application");
	private final JLabel lblCurrentDate = new JLabel("Current Date: ");
	private final JComboBox comboBoxCurrentDateMonth = new JComboBox();
	private final JFormattedTextField ftfCurrentDateDay = new JFormattedTextField();
	private final JFormattedTextField ftfCurrentDateYear = new JFormattedTextField();
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JLabel lblNameHousehold = new JLabel("Name:");
	private final JLabel lblHouseDescrip = new JLabel("List anyone in your household, other than you or your spouse:");
	private final JTextField txtHouseholdName1 = new JTextField();
	private final JTextField txtHouseholdName2 = new JTextField();
	private final JTextField txtHouseholdName3 = new JTextField();
	private final JTextField txtHouseholdName4 = new JTextField();
	private final JTextField txtHouseholdName5 = new JTextField();
	private final JTextField txtHouseholdName6 = new JTextField();
	private final JLabel lblHousehold1 = new JLabel("1:");
	private final JLabel lblHousehold2 = new JLabel("2:");
	private final JLabel lblHousehold3 = new JLabel("3:");
	private final JLabel lblHousehold4 = new JLabel("4:");
	private final JLabel lblHousehold5 = new JLabel("5:");
	private final JLabel lblHousehold6 = new JLabel("6:");
	private final JLabel lblHouseholdRelationship = new JLabel("Relationship:");
	private final JComboBox comboBoxRelationship1 = new JComboBox();
	private final JComboBox comboBoxRelationship2 = new JComboBox();
	private final JComboBox comboBoxRelationship3 = new JComboBox();
	private final JComboBox comboBoxRelationship4 = new JComboBox();
	private final JComboBox comboBoxRelationship5 = new JComboBox();
	private final JComboBox comboBoxRelationship6 = new JComboBox();
	private final JLabel lblRelationshipAge = new JLabel("Age:");
	private final JComboBox comboBoxHouseholdAge1 = new JComboBox();
	private final JComboBox comboBoxHouseholdAge2 = new JComboBox();
	private final JComboBox comboBoxHouseholdAge3 = new JComboBox();
	private final JComboBox comboBoxHouseholdAge4 = new JComboBox();
	private final JComboBox comboBoxHouseholdAge5 = new JComboBox();
	private final JComboBox comboBoxHouseholdAge6 = new JComboBox();
	private final JLabel lblHouseholdSocial = new JLabel("SS#:");
	private final JFormattedTextField ftfSSNHousehold1 = new JFormattedTextField();
	private final JFormattedTextField ftfSSNHousehold2 = new JFormattedTextField();
	private final JFormattedTextField ftfSSNHousehold3 = new JFormattedTextField();
	private final JFormattedTextField ftfSSNHousehold4 = new JFormattedTextField();
	private final JFormattedTextField ftfSSNHousehold5 = new JFormattedTextField();
	private final JFormattedTextField ftfSSNHousehold6 = new JFormattedTextField();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CallahanKevinSalvArmy frame = new CallahanKevinSalvArmy();
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
	public CallahanKevinSalvArmy() {
		txtHouseholdName6.setBounds(64, 396, 116, 22);
		txtHouseholdName6.setColumns(10);
		txtHouseholdName5.setBounds(64, 367, 116, 22);
		txtHouseholdName5.setColumns(10);
		txtHouseholdName4.setText("");
		txtHouseholdName4.setBounds(64, 338, 116, 22);
		txtHouseholdName4.setColumns(10);
		txtHouseholdName3.setText("");
		txtHouseholdName3.setBounds(64, 309, 116, 22);
		txtHouseholdName3.setColumns(10);
		txtHouseholdName2.setBounds(64, 280, 116, 22);
		txtHouseholdName2.setColumns(10);
		txtHouseholdName1.setBounds(64, 251, 116, 22);
		txtHouseholdName1.setColumns(10);
		txtLNameSpouse.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtLNameSpouse_focusLost(e);
			}
		});
		txtLNameSpouse.setText("");
		txtLNameSpouse.setBounds(105, 68, 116, 22);
		txtLNameSpouse.setColumns(10);
		txtFNameSpouse.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtFNameSpouse_focusLost(e);
			}
		});
		txtFNameSpouse.setBounds(105, 39, 116, 22);
		txtFNameSpouse.setColumns(10);
		txtPlaceofEmploySpouse.setEnabled(false);
		txtPlaceofEmploySpouse.setBounds(511, 132, 116, 22);
		txtPlaceofEmploySpouse.setColumns(10);
		txtPlaceofEmploy.setEnabled(false);
		txtPlaceofEmploy.setBounds(456, 44, 116, 22);
		txtPlaceofEmploy.setColumns(10);
		txtTotalNetIncome.setEditable(false);
		txtTotalNetIncome.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTotalNetIncome.setText("0");
		txtTotalNetIncome.setBounds(286, 398, 116, 22);
		txtTotalNetIncome.setColumns(10);
		txtTotalExpenses.setEditable(false);
		txtTotalExpenses.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTotalExpenses.setText("0");
		txtTotalExpenses.setBounds(286, 369, 116, 22);
		txtTotalExpenses.setColumns(10);
		txtTotalIncome.setEditable(false);
		txtTotalIncome.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTotalIncome.setText("0");
		txtTotalIncome.setBounds(286, 340, 116, 22);
		txtTotalIncome.setColumns(10);
		txtOtherIncome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtOtherIncome_focusLost(e);
			}
		});
		txtOtherIncome.setText("0");
		txtOtherIncome.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOtherIncome.setBounds(138, 271, 116, 22);
		txtOtherIncome.setColumns(10);
		txtOtherExpense.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtOtherExpense_focusLost(e);
			}
		});
		txtOtherExpense.setText("0");
		txtOtherExpense.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOtherExpense.setBounds(422, 271, 116, 22);
		txtOtherExpense.setColumns(10);
		txtDoctor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtDoctor_focusLost(e);
			}
		});
		txtDoctor.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDoctor.setText("0");
		txtDoctor.setBounds(422, 242, 116, 22);
		txtDoctor.setColumns(10);
		txtCableTV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtCableTV_focusLost(e);
			}
		});
		txtCableTV.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCableTV.setText("0");
		txtCableTV.setBounds(422, 213, 116, 22);
		txtCableTV.setColumns(10);
		txtFurn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtFurn_focusLost(e);
			}
		});
		txtFurn.setHorizontalAlignment(SwingConstants.TRAILING);
		txtFurn.setText("0");
		txtFurn.setBounds(422, 184, 116, 22);
		txtFurn.setColumns(10);
		txtCarPayments.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtCarPayments_focusLost(e);
			}
		});
		txtCarPayments.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCarPayments.setText("0");
		txtCarPayments.setBounds(422, 155, 116, 22);
		txtCarPayments.setColumns(10);
		txtLightBill.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtLightBill_focusLost(e);
			}
		});
		txtLightBill.setHorizontalAlignment(SwingConstants.TRAILING);
		txtLightBill.setText("0");
		txtLightBill.setBounds(422, 126, 116, 22);
		txtLightBill.setColumns(10);
		txtGasWater.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtGasWater_focusLost(e);
			}
		});
		txtGasWater.setHorizontalAlignment(SwingConstants.TRAILING);
		txtGasWater.setText("0");
		txtGasWater.setBounds(422, 97, 116, 22);
		txtGasWater.setColumns(10);
		txtPhoneBill.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtPhoneBill_focusLost(e);
			}
		});
		txtPhoneBill.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPhoneBill.setText("0");
		txtPhoneBill.setBounds(422, 68, 116, 22);
		txtPhoneBill.setColumns(10);
		txtRent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtRent_focusLost(e);
			}
		});
		txtRent.setHorizontalAlignment(SwingConstants.TRAILING);
		txtRent.setText("0");
		txtRent.setBounds(422, 39, 116, 22);
		txtRent.setColumns(10);
		txtFoodStamps.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtFoodStamps_focusLost(e);
			}
		});
		txtFoodStamps.setHorizontalAlignment(SwingConstants.TRAILING);
		txtFoodStamps.setText("0");
		txtFoodStamps.setBounds(138, 242, 116, 22);
		txtFoodStamps.setColumns(10);
		txtUtilityAssist.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtUtilityAssist_focusLost(e);
			}
		});
		txtUtilityAssist.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUtilityAssist.setText("0");
		txtUtilityAssist.setBounds(138, 213, 116, 22);
		txtUtilityAssist.setColumns(10);
		txtChildSupp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtChildSupp_focusLost(e);
			}
		});
		txtChildSupp.setHorizontalAlignment(SwingConstants.TRAILING);
		txtChildSupp.setText("0");
		txtChildSupp.setBounds(138, 184, 116, 22);
		txtChildSupp.setColumns(10);
		txtDisability.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtDisability_focusLost(e);
			}
		});
		txtDisability.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDisability.setText("0");
		txtDisability.setBounds(138, 155, 116, 22);
		txtDisability.setColumns(10);
		txtSocialSec.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtSocialSec_focusLost(e);
			}
		});
		txtSocialSec.setHorizontalAlignment(SwingConstants.TRAILING);
		txtSocialSec.setText("0");
		txtSocialSec.setBounds(138, 126, 116, 22);
		txtSocialSec.setColumns(10);
		txtTanf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtTanf_focusLost(e);
			}
		});
		txtTanf.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTanf.setText("0");
		txtTanf.setBounds(138, 97, 116, 22);
		txtTanf.setColumns(10);
		txtUnemployment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_txtUnemployment_focusLost(arg0);
			}
		});
		txtUnemployment.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUnemployment.setText("0");
		txtUnemployment.setBounds(138, 68, 116, 22);
		txtUnemployment.setColumns(10);
		txtSalary.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtSalary_focusLost(e);
			}
		});
		txtSalary.setHorizontalAlignment(SwingConstants.TRAILING);
		txtSalary.setText("0");
		txtSalary.setBounds(138, 39, 116, 22);
		txtSalary.setColumns(10);
		txtAddress.setBounds(99, 187, 116, 22);
		txtAddress.setColumns(10);
		txtCity.setBounds(99, 216, 116, 22);
		txtCity.setColumns(10);
		txtLName.setToolTipText("Input last name, letters only");
		txtLName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtLName_focusLost(e);
			}
		});
		txtLName.setBounds(99, 39, 116, 22);
		txtLName.setColumns(10);
		txtFName.setToolTipText("Input first name, letters only");
		txtFName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_txtFName_focusLost(e);
			}
		});
		txtFName.setBounds(99, 10, 116, 22);
		txtFName.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Client Assistance Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 540);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmStartNewApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmStartNewApplication_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmStartNewApplication);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 726, 463);
		
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("Personal Information", null, panelPersonal, null);
		panelPersonal.setLayout(null);
		lblFirstName.setBounds(12, 13, 75, 16);
		
		panelPersonal.add(lblFirstName);
		lblLastName.setBounds(12, 42, 75, 16);
		
		panelPersonal.add(lblLastName);
		lblSs.setBounds(12, 71, 75, 16);
		
		panelPersonal.add(lblSs);
		lblDob.setBounds(12, 100, 75, 16);
		
		panelPersonal.add(lblDob);
		lblPhone.setBounds(12, 161, 75, 16);
		
		panelPersonal.add(lblPhone);
		lblAddress.setBounds(12, 190, 75, 16);
		
		panelPersonal.add(lblAddress);
		lblCity.setBounds(12, 219, 75, 16);
		
		panelPersonal.add(lblCity);
		lblCounty.setBounds(12, 248, 75, 16);
		
		panelPersonal.add(lblCounty);
		lblZip.setBounds(12, 277, 75, 16);
		
		panelPersonal.add(lblZip);
		
		panelPersonal.add(txtFName);
		
		panelPersonal.add(txtLName);
		ftfSSN.setBounds(99, 68, 116, 22);
		
		panelPersonal.add(ftfSSN);
		ssnMask.setPlaceholderCharacter('#');
		ssnMask.install(ftfSSN);
		panelPersonal.add(ftfSSN);
		
		
		comboDobMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January ", "February ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December"}));
		comboDobMonth.setBounds(99, 97, 75, 22);
		
		panelPersonal.add(comboDobMonth);
		ftfDobDay.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfDobDay_focusLost(e);
			}
		});
		ftfDobDay.setBounds(186, 97, 27, 22);
		
		dobDayMask.install(ftfDobDay);
		panelPersonal.add(ftfDobDay);
		ftfDobYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfDobYear_focusLost(e);
			}
		});
		ftfDobYear.setBounds(225, 97, 36, 22);
		
		dobYearMask.install(ftfDobYear);
		panelPersonal.add(ftfDobYear);
		
		ftfPhoneNumber.setBounds(99, 158, 116, 22);
		phoneMask.install(ftfPhoneNumber);
		panelPersonal.add(ftfPhoneNumber);
		
		panelPersonal.add(txtCity);
		comboCounty.setModel(new DefaultComboBoxModel(new String[] {"", "Albany County", "Allegany County", "Bronx County", "Broome County", "Cattaraugus County", "Cayuga County", "Chautauqua County", "Chemung County", "Chenango County", "Clinton County", "Columbia County", "Cortland County", "Delaware County", "Dutchess County", "Erie County", "Essex County", "Franklin County", "Fulton County", "Genesee County", "Greene County", "Hamilton County", "Herkimer County", "Jefferson County", "Kings County (Brooklyn)", "Lewis County", "Livingston County", "Madison County", "Monroe County", "Montgomery County", "Nassau County", "New York County (Manhattan)", "Niagara County", "Oneida County", "Onondaga County", "Ontario County", "Orange County", "Orleans County", "Oswego County", "Otsego County", "Putnam County", "Queens County", "Rensselaer County", "Richmond County (Staten Island)", "Rockland County", "Saint Lawrence County", "Saratoga County", "Schenectady County", "Schoharie County", "Schuyler County", "Seneca County", "Steuben County", "Suffolk County", "Sullivan County", "Tioga County", "Tompkins County", "Ulster County", "Warren County", "Washington County", "Wayne County", "Westchester County", "Wyoming County", "Yates County"}));
		comboCounty.setBounds(99, 245, 116, 22);
		
		panelPersonal.add(comboCounty);
		ftfZip.setBounds(99, 274, 43, 22);
		
		addressZipMask.setPlaceholderCharacter('_');
		addressZipMask.install(ftfZip);
		panelPersonal.add(ftfZip);
		lblEthnicity.setBounds(12, 129, 56, 16);
		
		panelPersonal.add(lblEthnicity);
		comboEthnicity.setModel(new DefaultComboBoxModel(new String[] {"", "White", "Black", "Hispanic", "Asian", "Amer. Indian", "Other"}));
		comboEthnicity.setBounds(99, 126, 116, 22);
		
		panelPersonal.add(comboEthnicity);
		
		panelPersonal.add(txtAddress);
		lblPresentProblem.setBounds(293, 13, 116, 16);
		
		panelPersonal.add(lblPresentProblem);
		scrollPane.setBounds(303, 39, 222, 77);
		
		panelPersonal.add(scrollPane);
		scrollPane.setViewportView(textAreaProblem);
		textAreaProblem.setLineWrap(true);
		lblCurrentDate.setBounds(293, 129, 82, 16);
		
		panelPersonal.add(lblCurrentDate);
		comboBoxCurrentDateMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "January ", "February ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December"}));
		comboBoxCurrentDateMonth.setBounds(303, 155, 75, 22);
		
		panelPersonal.add(comboBoxCurrentDateMonth);
		ftfCurrentDateDay.setBounds(390, 155, 27, 22);
		
		currentDayMask.install(ftfCurrentDateDay);
		panelPersonal.add(ftfCurrentDateDay);
		ftfCurrentDateYear.setBounds(429, 155, 36, 22);
		currentYearMask.install(ftfCurrentDateYear);
		panelPersonal.add(ftfCurrentDateYear);
		
		tabbedPane.addTab("Household Information", null, panelHousehold, null);
		panelHousehold.setLayout(null);
		lblSpousesFirstName.setBounds(22, 42, 71, 16);
		
		panelHousehold.add(lblSpousesFirstName);
		lblSpousesLastName.setBounds(22, 71, 71, 16);
		
		panelHousehold.add(lblSpousesLastName);
		lblSpousesSSN.setBounds(22, 100, 71, 16);
		
		panelHousehold.add(lblSpousesSSN);
		lblSpouseDob.setBounds(22, 129, 71, 16);
		
		panelHousehold.add(lblSpouseDob);
		lblPlaceofEmploy.setBounds(293, 47, 151, 16);
		
		panelHousehold.add(lblPlaceofEmploy);
		lblUnemploymentLength.setBounds(293, 76, 151, 16);
		
		panelHousehold.add(lblUnemploymentLength);
		checkBoxEmployedSpouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_checkBoxEmployedSpouse_actionPerformed(e);
			}
		});
		checkBoxEmployedSpouse.setBounds(283, 101, 185, 25);
		
		panelHousehold.add(checkBoxEmployedSpouse);
		lblPlaceofEmploySpouse.setBounds(293, 135, 206, 16);
		
		panelHousehold.add(lblPlaceofEmploySpouse);
		lblUnemploymentLengthSpouse.setBounds(293, 164, 206, 16);
		
		panelHousehold.add(lblUnemploymentLengthSpouse);
		checkBoxEmployed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_checkBoxEmployed_actionPerformed(e);
			}
		});
		checkBoxEmployed.setBounds(279, 13, 151, 25);
		
		panelHousehold.add(checkBoxEmployed);
		
		panelHousehold.add(txtPlaceofEmploy);
		
		panelHousehold.add(txtPlaceofEmploySpouse);
		comboBoxUnemployDays.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxUnemployDays.setBounds(456, 73, 56, 22);
		
		panelHousehold.add(comboBoxUnemployDays);
		comboBoxUnemployMonths.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxUnemployMonths.setBounds(524, 73, 62, 22);
		
		panelHousehold.add(comboBoxUnemployMonths);
		comboBoxUnemployYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		comboBoxUnemployYear.setBounds(596, 73, 56, 22);
		
		panelHousehold.add(comboBoxUnemployYear);
		comboBoxUnemployDaysSpouse.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxUnemployDaysSpouse.setBounds(511, 164, 56, 22);
		
		panelHousehold.add(comboBoxUnemployDaysSpouse);
		comboBoxUnemployMonthsSpouse.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxUnemployMonthsSpouse.setBounds(579, 164, 62, 22);
		
		panelHousehold.add(comboBoxUnemployMonthsSpouse);
		comboBoxUnemployYearSpouse.setModel(new DefaultComboBoxModel(new String[] {"Year", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		comboBoxUnemployYearSpouse.setBounds(651, 164, 56, 22);
		
		panelHousehold.add(comboBoxUnemployYearSpouse);
		lblSpouseInfo.setBounds(12, 13, 121, 16);
		
		panelHousehold.add(lblSpouseInfo);
		
		panelHousehold.add(txtFNameSpouse);
		
		panelHousehold.add(txtLNameSpouse);
		ftfSSNSpouse.setBounds(105, 98, 116, 22);
		
		ssnMaskSpouse.setPlaceholderCharacter('#');
		ssnMaskSpouse.install(ftfSSNSpouse);
		panelHousehold.add(ftfSSNSpouse);
		
		comboDobMonthSpouse.setModel(new DefaultComboBoxModel(new String[] {"Month", "January ", "February ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December"}));
		comboDobMonthSpouse.setBounds(105, 129, 75, 22);
		
		panelHousehold.add(comboDobMonthSpouse);
		ftfDobDaySpouse.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfDobDaySpouse_focusLost(e);
			}
		});
		ftfDobDaySpouse.setBounds(192, 129, 27, 22);
		
		dobDayMaskSpouse.install(ftfDobDaySpouse);
		panelHousehold.add(ftfDobDaySpouse);
		ftfDobYearSpouse.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_ftfDobYearSpouse_focusLost(e);
			}
		});
		
		ftfDobYearSpouse.setBounds(231, 129, 36, 22);
		dobYearMaskSpouse.install(ftfDobYearSpouse);
		panelHousehold.add(ftfDobYearSpouse);
		lblNameHousehold.setBounds(37, 222, 56, 16);
		
		panelHousehold.add(lblNameHousehold);
		lblHouseDescrip.setBounds(22, 193, 359, 16);
		
		panelHousehold.add(lblHouseDescrip);
		
		panelHousehold.add(txtHouseholdName1);
		
		panelHousehold.add(txtHouseholdName2);
		
		panelHousehold.add(txtHouseholdName3);
		
		panelHousehold.add(txtHouseholdName4);
		
		panelHousehold.add(txtHouseholdName5);
		
		panelHousehold.add(txtHouseholdName6);
		lblHousehold1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold1.setBounds(0, 254, 56, 16);
		
		panelHousehold.add(lblHousehold1);
		lblHousehold2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold2.setBounds(0, 283, 56, 16);
		
		panelHousehold.add(lblHousehold2);
		lblHousehold3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold3.setBounds(0, 312, 56, 16);
		
		panelHousehold.add(lblHousehold3);
		lblHousehold4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold4.setBounds(0, 341, 56, 16);
		
		panelHousehold.add(lblHousehold4);
		lblHousehold5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold5.setBounds(0, 370, 56, 16);
		
		panelHousehold.add(lblHousehold5);
		lblHousehold6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHousehold6.setBounds(0, 399, 56, 16);
		
		panelHousehold.add(lblHousehold6);
		lblHouseholdRelationship.setBounds(194, 222, 104, 16);
		
		panelHousehold.add(lblHouseholdRelationship);
		comboBoxRelationship1.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship1.setBounds(204, 251, 81, 23);
		
		panelHousehold.add(comboBoxRelationship1);
		comboBoxRelationship2.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship2.setBounds(204, 280, 81, 23);
		
		panelHousehold.add(comboBoxRelationship2);
		comboBoxRelationship3.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship3.setBounds(204, 309, 81, 23);
		
		panelHousehold.add(comboBoxRelationship3);
		comboBoxRelationship4.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship4.setBounds(204, 338, 81, 23);
		
		panelHousehold.add(comboBoxRelationship4);
		comboBoxRelationship5.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship5.setBounds(204, 367, 81, 23);
		
		panelHousehold.add(comboBoxRelationship5);
		comboBoxRelationship6.setModel(new DefaultComboBoxModel(new String[] {"", "Child", "Grandchild", "Sibling", "Parent", "Grandparent", "Extended Family", "Other"}));
		comboBoxRelationship6.setBounds(204, 396, 81, 23);
		
		panelHousehold.add(comboBoxRelationship6);
		lblRelationshipAge.setBounds(306, 222, 56, 16);
		
		panelHousehold.add(lblRelationshipAge);
		comboBoxHouseholdAge1.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge1.setBounds(316, 251, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge1);
		comboBoxHouseholdAge2.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge2.setBounds(316, 280, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge2);
		comboBoxHouseholdAge3.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge3.setBounds(316, 309, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge3);
		comboBoxHouseholdAge4.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge4.setBounds(316, 338, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge4);
		comboBoxHouseholdAge5.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge5.setBounds(316, 367, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge5);
		comboBoxHouseholdAge6.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		comboBoxHouseholdAge6.setBounds(316, 396, 46, 22);
		
		panelHousehold.add(comboBoxHouseholdAge6);
		lblHouseholdSocial.setBounds(374, 222, 56, 16);
		
		panelHousehold.add(lblHouseholdSocial);
		
		ftfSSNHousehold1.setBounds(384, 251, 116, 22);
		ssnHousehold1Mask.setPlaceholderCharacter('#');
		ssnHousehold1Mask.install(ftfSSNHousehold1);
		panelHousehold.add(ftfSSNHousehold1);
		
		ftfSSNHousehold2.setBounds(384, 280, 116, 22);
		ssnHousehold2Mask.setPlaceholderCharacter('#');
		ssnHousehold2Mask.install(ftfSSNHousehold2);
		panelHousehold.add(ftfSSNHousehold2);
		
		ftfSSNHousehold3.setBounds(384, 309, 116, 22);
		ssnHousehold3Mask.setPlaceholderCharacter('#');
		ssnHousehold3Mask.install(ftfSSNHousehold3);
		panelHousehold.add(ftfSSNHousehold3);
		
		ftfSSNHousehold4.setBounds(384, 338, 116, 22);
		ssnHousehold4Mask.setPlaceholderCharacter('#');
		ssnHousehold4Mask.install(ftfSSNHousehold4);
		panelHousehold.add(ftfSSNHousehold4);
		
		ftfSSNHousehold5.setBounds(384, 367, 116, 22);
		ssnHousehold5Mask.setPlaceholderCharacter('#');
		ssnHousehold5Mask.install(ftfSSNHousehold5);
		panelHousehold.add(ftfSSNHousehold5);
		
		ftfSSNHousehold6.setBounds(384, 396, 116, 22);
		ssnHousehold6Mask.setPlaceholderCharacter('#');
		ssnHousehold6Mask.install(ftfSSNHousehold6);
		panelHousehold.add(ftfSSNHousehold6);
		
		tabbedPane.addTab("Financial Information", null, panelFinancial, null);
		panelFinancial.setLayout(null);
		lblIncome.setToolTipText("Of anyone in your household, including yourself");
		lblIncome.setBounds(12, 13, 56, 16);
		
		panelFinancial.add(lblIncome);
		lblSalary.setBounds(22, 42, 104, 16);
		
		panelFinancial.add(lblSalary);
		lblUnemployment.setBounds(22, 71, 104, 16);
		
		panelFinancial.add(lblUnemployment);
		lblTanfafdc.setBounds(22, 100, 104, 16);
		
		panelFinancial.add(lblTanfafdc);
		lblSocialSecurity.setBounds(22, 129, 104, 16);
		
		panelFinancial.add(lblSocialSecurity);
		lblDisability.setBounds(22, 158, 104, 16);
		
		panelFinancial.add(lblDisability);
		lblChildSupport.setBounds(22, 187, 104, 16);
		
		panelFinancial.add(lblChildSupport);
		lblUtilityAssistance.setBounds(22, 216, 104, 16);
		
		panelFinancial.add(lblUtilityAssistance);
		lblFoodStamps.setBounds(22, 245, 104, 16);
		
		panelFinancial.add(lblFoodStamps);
		
		panelFinancial.add(txtSalary);
		
		panelFinancial.add(txtUnemployment);
		
		panelFinancial.add(txtTanf);
		
		panelFinancial.add(txtSocialSec);
		
		panelFinancial.add(txtDisability);
		
		panelFinancial.add(txtChildSupp);
		
		panelFinancial.add(txtUtilityAssist);
		
		panelFinancial.add(txtFoodStamps);
		lblExpenses.setToolTipText("Monthly of each");
		lblExpenses.setBounds(290, 13, 72, 16);
		
		panelFinancial.add(lblExpenses);
		lblRent.setBounds(300, 42, 110, 16);
		
		panelFinancial.add(lblRent);
		lblPhoneBill.setBounds(300, 71, 110, 16);
		
		panelFinancial.add(lblPhoneBill);
		lblGasWater.setBounds(300, 100, 110, 16);
		
		panelFinancial.add(lblGasWater);
		lblLightBill.setBounds(300, 129, 110, 16);
		
		panelFinancial.add(lblLightBill);
		lblCarPayment.setBounds(300, 158, 110, 16);
		
		panelFinancial.add(lblCarPayment);
		lblFurnappliances.setBounds(300, 187, 110, 16);
		
		panelFinancial.add(lblFurnappliances);
		lblCableTv.setBounds(300, 216, 110, 16);
		
		panelFinancial.add(lblCableTv);
		lblDoctormed.setBounds(300, 245, 110, 16);
		
		panelFinancial.add(lblDoctormed);
		
		panelFinancial.add(txtRent);
		
		panelFinancial.add(txtPhoneBill);
		
		panelFinancial.add(txtGasWater);
		
		panelFinancial.add(txtLightBill);
		
		panelFinancial.add(txtCarPayments);
		
		panelFinancial.add(txtFurn);
		
		panelFinancial.add(txtCableTV);
		
		panelFinancial.add(txtDoctor);
		lblOtherIncome.setBounds(22, 274, 56, 16);
		
		panelFinancial.add(lblOtherIncome);
		lblOtherExpense.setBounds(300, 274, 56, 16);
		
		panelFinancial.add(lblOtherExpense);
		
		panelFinancial.add(txtOtherExpense);
		
		panelFinancial.add(txtOtherIncome);
		lblTotalIncome.setBounds(160, 343, 116, 16);
		
		panelFinancial.add(lblTotalIncome);
		lblTotalExpenses.setBounds(160, 372, 116, 16);
		
		panelFinancial.add(lblTotalExpenses);
		lblTotalNetIncome.setBounds(160, 401, 116, 16);
		
		panelFinancial.add(lblTotalNetIncome);
		
		panelFinancial.add(txtTotalIncome);
		
		panelFinancial.add(txtTotalExpenses);
		
		panelFinancial.add(txtTotalNetIncome);
	}
	protected void do_ftfDobDay_focusLost(FocusEvent e) {
		int tempDobDay = Integer.parseInt(ftfDobDay.getText());
		if(tempDobDay < 1 || tempDobDay > 31){
			JOptionPane.showMessageDialog(this,
				    "Input valid day",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			ftfDobDay.setText("");
			ftfDobDay.grabFocus();
		}
	}
	protected void do_ftfDobYear_focusLost(FocusEvent e) {
		int tempDobYear = Integer.parseInt(ftfDobYear.getText());
		if(tempDobYear < 1900){
			JOptionPane.showMessageDialog(this,
				    "Input valid year",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			ftfDobYear.setText("");
			ftfDobYear.grabFocus();
		}
	}
	protected void do_txtFName_focusLost(FocusEvent e) {
		if (!txtFName.getText().matches("[a-zA-Z]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid first name",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtFName.setText("");
			txtFName.grabFocus();
		}
	}
	protected void do_txtLName_focusLost(FocusEvent e) {
		if (!txtLName.getText().matches("[a-zA-Z]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid last name",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtLName.setText("");
			txtLName.grabFocus();
		}
	}
	
	private void checkInput(JTextField tempField){
		tempField.setForeground(Color.BLACK);
		if (!tempField.getText().matches("[-0-9.]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid number",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			tempField.setText("0");
			tempField.grabFocus();
		}
		double tempInput = Double.parseDouble(tempField.getText());
		if (tempInput < 0){
			tempField.setForeground(Color.RED);
		}
	}
	
	private void calculateTotalIncome(){
		totalIncome = Double.parseDouble(txtSalary.getText()) + 
					  Double.parseDouble(txtUnemployment.getText()) + 
					  Double.parseDouble(txtTanf.getText()) + 
					  Double.parseDouble(txtSocialSec.getText()) + 
					  Double.parseDouble(txtDisability.getText()) + 
					  Double.parseDouble(txtChildSupp.getText()) + 
					  Double.parseDouble(txtUtilityAssist.getText()) + 
					  Double.parseDouble(txtFoodStamps.getText()) + 
					  Double.parseDouble(txtOtherIncome.getText());
		txtTotalIncome.setText(Double.toString(totalIncome));
		checkInput(txtTotalIncome);
	}
	
	private void calculateTotalExpenses(){
		totalExpenses = Double.parseDouble(txtRent.getText()) + 
				  Double.parseDouble(txtPhoneBill.getText()) + 
				  Double.parseDouble(txtGasWater.getText()) + 
				  Double.parseDouble(txtLightBill.getText()) + 
				  Double.parseDouble(txtCarPayments.getText()) + 
				  Double.parseDouble(txtFurn.getText()) + 
				  Double.parseDouble(txtCableTV.getText()) + 
				  Double.parseDouble(txtDoctor.getText()) + 
				  Double.parseDouble(txtOtherExpense.getText());
	txtTotalExpenses.setText(Double.toString(totalExpenses));
	checkInput(txtTotalExpenses);
		
	}
	
	private void calculateTotalNetIncome(){
		totalNetIncome = totalIncome + totalExpenses;
		txtTotalNetIncome.setText(Double.toString(totalNetIncome));
		checkInput(txtTotalNetIncome);
	}
	
	private void calculateAllTotals(){
		calculateTotalIncome();
		calculateTotalExpenses();
		calculateTotalNetIncome();
	}
	
	protected void do_txtSalary_focusLost(FocusEvent e) {
		checkInput(txtSalary);
		calculateAllTotals();
	}
	protected void do_txtUnemployment_focusLost(FocusEvent arg0) {
		checkInput(txtUnemployment);
		calculateAllTotals();
	}
	protected void do_txtTanf_focusLost(FocusEvent e) {
		checkInput(txtTanf);
		calculateAllTotals();
	}
	protected void do_txtSocialSec_focusLost(FocusEvent e) {
		checkInput(txtSocialSec);
		calculateAllTotals();
	}
	protected void do_txtDisability_focusLost(FocusEvent e) {
		checkInput(txtDisability);
		calculateAllTotals();
	}
	protected void do_txtChildSupp_focusLost(FocusEvent e) {
		checkInput(txtChildSupp);
		calculateAllTotals();
	}
	protected void do_txtUtilityAssist_focusLost(FocusEvent e) {
		checkInput(txtUtilityAssist);
		calculateAllTotals();
	}
	protected void do_txtFoodStamps_focusLost(FocusEvent e) {
		checkInput(txtFoodStamps);
		calculateAllTotals();
	}
	protected void do_txtOtherIncome_focusLost(FocusEvent e) {
		checkInput(txtOtherIncome);
		calculateAllTotals();
	}
	protected void do_txtRent_focusLost(FocusEvent e) {
		checkInput(txtRent);
		calculateAllTotals();
	}
	protected void do_txtPhoneBill_focusLost(FocusEvent e) {
		checkInput(txtPhoneBill);
		calculateAllTotals();
	}
	protected void do_txtGasWater_focusLost(FocusEvent e) {
		checkInput(txtGasWater);
		calculateAllTotals();
	}
	protected void do_txtLightBill_focusLost(FocusEvent e) {
		checkInput(txtLightBill);
		calculateAllTotals();
	}
	protected void do_txtCarPayments_focusLost(FocusEvent e) {
		checkInput(txtCarPayments);
		calculateAllTotals();
	}
	protected void do_txtFurn_focusLost(FocusEvent e) {
		checkInput(txtFurn);
		calculateAllTotals();
	}
	protected void do_txtCableTV_focusLost(FocusEvent e) {
		checkInput(txtCableTV);
		calculateAllTotals();
	}
	protected void do_txtDoctor_focusLost(FocusEvent e) {
		checkInput(txtDoctor);
		calculateAllTotals();
	}
	protected void do_txtOtherExpense_focusLost(FocusEvent e) {
		checkInput(txtOtherExpense);
		calculateAllTotals();
	}
	protected void do_checkBoxEmployed_actionPerformed(ActionEvent e) {
		if (checkBoxEmployed.isSelected()){
			txtPlaceofEmploy.setEnabled(true);
			
			comboBoxUnemployDays.setEnabled(false);
			comboBoxUnemployMonths.setEnabled(false);
			comboBoxUnemployYear.setEnabled(false);
		}
		if (!checkBoxEmployed.isSelected()){
			txtPlaceofEmploy.setEnabled(false);
			
			comboBoxUnemployDays.setEnabled(true);
			comboBoxUnemployMonths.setEnabled(true);
			comboBoxUnemployYear.setEnabled(true);
		}
		
	}
	protected void do_checkBoxEmployedSpouse_actionPerformed(ActionEvent e) {
		if (checkBoxEmployedSpouse.isSelected()){
			txtPlaceofEmploySpouse.setEnabled(true);
			
			comboBoxUnemployDaysSpouse.setEnabled(false);
			comboBoxUnemployMonthsSpouse.setEnabled(false);
			comboBoxUnemployYearSpouse.setEnabled(false);
		}
		if (!checkBoxEmployedSpouse.isSelected()){
			txtPlaceofEmploySpouse.setEnabled(false);
			
			comboBoxUnemployDaysSpouse.setEnabled(true);
			comboBoxUnemployMonthsSpouse.setEnabled(true);
			comboBoxUnemployYearSpouse.setEnabled(true);
		}
	}
	protected void do_ftfDobDaySpouse_focusLost(FocusEvent e) {
		int tempDobDaySpouse = Integer.parseInt(ftfDobDaySpouse.getText());
		if(tempDobDaySpouse < 1 || tempDobDaySpouse > 31){
			JOptionPane.showMessageDialog(this,
				    "Input valid day",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			ftfDobDaySpouse.setText("");
			ftfDobDaySpouse.grabFocus();
		}
	}
	protected void do_ftfDobYearSpouse_focusLost(FocusEvent e) {
		int tempDobYearSpouse = Integer.parseInt(ftfDobYearSpouse.getText());
		if(tempDobYearSpouse < 1900){
			JOptionPane.showMessageDialog(this,
				    "Input valid year",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			ftfDobYearSpouse.setText("");
			ftfDobYearSpouse.grabFocus();
		}
	}
	protected void do_txtFNameSpouse_focusLost(FocusEvent e) {
		if (!txtFNameSpouse.getText().matches("[a-zA-Z]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid first name",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtFNameSpouse.setText("");
			txtFNameSpouse.grabFocus();
		}
	}
	protected void do_txtLNameSpouse_focusLost(FocusEvent e) {
		if (!txtLNameSpouse.getText().matches("[a-zA-Z]+")){
			JOptionPane.showMessageDialog(this,
				    "Input valid last name",
				    "Invalid Value",
				    JOptionPane.WARNING_MESSAGE);
			txtLNameSpouse.setText("");
			txtLNameSpouse.grabFocus();
		}
	}
	protected void do_mntmStartNewApplication_actionPerformed(ActionEvent e) {
		CallahanKevinSalvArmy newApp = new CallahanKevinSalvArmy();
		newApp.setVisible(true);
		this.dispose();
	}
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
