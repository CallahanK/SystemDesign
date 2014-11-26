import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;

import javax.swing.Timer;


public class groupFrame extends JFrame {

	private JPanel contentPane;
	private final JRadioButton rdbtnOne = new JRadioButton("One");
	private final JRadioButton rdbtnTwo = new JRadioButton("Two");
	private final JRadioButton rdbtnThree = new JRadioButton("Three");
	private final JRadioButton rdbtnFour = new JRadioButton("Four");
	private final ButtonGroup buttonGroupRadio = new ButtonGroup();
	private final JCheckBox chckbxFirst = new JCheckBox("First");
	private final JCheckBox chckbxSecond = new JCheckBox("Second");
	private final JCheckBox chckbxThird = new JCheckBox("Third");
	private final JLabel lblRadioValue = new JLabel("Radio Value:");
	private final JLabel lblCheckboxValue = new JLabel("Checkbox Value:");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JSlider sliderNumbers = new JSlider();
	private final JLabel lblSlider = new JLabel("");
	private final JSpinner spinnerNumber = new JSpinner();
	private final JLabel lblSpinnerValue = new JLabel("Spinner Value: ");
	private final JTextField txtFieldNumber = new JTextField();
	private final JButton btnGo = new JButton("Go!");
	private final JToggleButton tglbtnStartProgress = new JToggleButton("Start Progress");
	private final JProgressBar progressBar = new JProgressBar();
	
	private String tempToggleName = "Stop Progress";
	private String tempDirection = "Reverse";
	
	private static final int DELAY = 300;
	private int timerCounter = 0;
	
	//Creates timer, runs test loop
	Timer swingTimer = new Timer(DELAY, new ActionListener(){

	    @Override
	    public void actionPerformed(ActionEvent e){
	        timerAction();
	        }
	    });
	private final JSlider sliderProgress = new JSlider();
	private final JToggleButton tglbtnForward = new JToggleButton("Forward");
	private final JLabel lblProgressSpeed = new JLabel("Progress Speed");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					groupFrame frame = new groupFrame();
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
	public groupFrame() {
		txtFieldNumber.setBounds(9, 215, 116, 22);
		txtFieldNumber.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Groups");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonGroupRadio.add(rdbtnOne);
		rdbtnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnOne_actionPerformed(arg0);
			}
		});
		rdbtnOne.setBounds(47, 64, 127, 25);
		
		contentPane.add(rdbtnOne);
		buttonGroupRadio.add(rdbtnTwo);
		rdbtnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_rdbtnTwo_actionPerformed(arg0);
			}
		});
		rdbtnTwo.setBounds(47, 94, 127, 25);
		
		contentPane.add(rdbtnTwo);
		buttonGroupRadio.add(rdbtnThree);
		rdbtnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnThree_actionPerformed(e);
			}
		});
		rdbtnThree.setBounds(47, 124, 127, 25);
		
		contentPane.add(rdbtnThree);
		buttonGroupRadio.add(rdbtnFour);
		rdbtnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnFour_actionPerformed(e);
			}
		});
		rdbtnFour.setBounds(47, 154, 127, 25);
		
		contentPane.add(rdbtnFour);
		chckbxFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxFirst_actionPerformed(e);
			}
		});
		chckbxFirst.setBounds(188, 64, 113, 25);
		
		contentPane.add(chckbxFirst);
		chckbxSecond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_chckbxSecond_actionPerformed(arg0);
			}
		});
		chckbxSecond.setBounds(188, 94, 113, 25);
		
		contentPane.add(chckbxSecond);
		chckbxThird.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxThird_actionPerformed(e);
			}
		});
		chckbxThird.setBounds(188, 124, 113, 25);
		
		contentPane.add(chckbxThird);
		lblRadioValue.setToolTipText("This is the tool text");
		lblRadioValue.setBounds(12, 30, 113, 25);
		
		contentPane.add(lblRadioValue);
		lblCheckboxValue.setBounds(188, 30, 232, 25);
		
		contentPane.add(lblCheckboxValue);
		sliderNumbers.setMinimum(-150);
		sliderNumbers.setMaximum(150);
		sliderNumbers.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				do_slider_stateChanged(arg0);
			}
		});
		sliderNumbers.setMinorTickSpacing(5);
		sliderNumbers.setMajorTickSpacing(20);
		sliderNumbers.setPaintLabels(true);
		sliderNumbers.setPaintTicks(true);
		sliderNumbers.setBounds(12, 250, 408, 52);
		
		contentPane.add(sliderNumbers);
		lblSlider.setBounds(215, 215, 66, 25);
		
		contentPane.add(lblSlider);
		spinnerNumber.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spinner_stateChanged(e);
			}
		});
		spinnerNumber.setBounds(302, 192, 85, 32);
		
		contentPane.add(spinnerNumber);
		lblSpinnerValue.setBounds(302, 154, 118, 25);
		
		contentPane.add(lblSpinnerValue);
		
		contentPane.add(txtFieldNumber);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGo_actionPerformed(arg0);
			}
		});
		btnGo.setBounds(137, 212, 66, 25);
		
		contentPane.add(btnGo);
		tglbtnStartProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_tglbtnStartProgress_actionPerformed(arg0);
			}
		});
		tglbtnStartProgress.setBounds(12, 355, 137, 25);
		
		contentPane.add(tglbtnStartProgress);
		progressBar.setStringPainted(true);
		progressBar.setBounds(12, 393, 408, 47);
		
		contentPane.add(progressBar);
		
		
		swingTimer.setInitialDelay(2 * DELAY); //sets delay

	    swingTimer.start();
		sliderProgress.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_sliderProgress_stateChanged(e);
			}
		});
		sliderProgress.setMinorTickSpacing(125);
		sliderProgress.setMajorTickSpacing(250);
		sliderProgress.setPaintLabels(true);
		sliderProgress.setPaintTicks(true);
		sliderProgress.setMaximum(1000);
		sliderProgress.setBounds(161, 328, 259, 52);
		sliderProgress.setValue(DELAY);
		progressBar.setValue(0);
		
		contentPane.add(sliderProgress);
		tglbtnForward.setSelected(true);
		tglbtnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_tglbtnForward_actionPerformed(arg0);
			}
		});
		tglbtnForward.setBounds(12, 328, 137, 25);
		
		contentPane.add(tglbtnForward);
		lblProgressSpeed.setBounds(181, 304, 120, 25);
		
		contentPane.add(lblProgressSpeed);
	}
	//make work by button group
	//make check selection work individually
	//make work by check group
	
	protected void do_rdbtnOne_actionPerformed(ActionEvent arg0) {
		lblRadioValue.setText("Radio Value: " + rdbtnOne.getText());
		
		int quartileSize = (sliderNumbers.getMaximum()-sliderNumbers.getMinimum())/4 ;
		sliderNumbers.setValue(sliderNumbers.getMinimum() + (quartileSize * 0) );
	}
	protected void do_rdbtnTwo_actionPerformed(ActionEvent arg0) {
		lblRadioValue.setText("Radio Value: " + rdbtnTwo.getText());
		
		int quartileSize = (sliderNumbers.getMaximum()-sliderNumbers.getMinimum())/4 ;
		sliderNumbers.setValue(sliderNumbers.getMinimum() + (quartileSize * 1) );
	}
	
	protected void do_rdbtnThree_actionPerformed(ActionEvent e) {
		lblRadioValue.setText("Radio Value: " + rdbtnThree.getText());
		
		int quartileSize = (sliderNumbers.getMaximum()-sliderNumbers.getMinimum())/4 ;
		sliderNumbers.setValue(sliderNumbers.getMinimum() + (quartileSize * 2) );
	}
	protected void do_rdbtnFour_actionPerformed(ActionEvent e) {
		lblRadioValue.setText("Radio Value: " + rdbtnFour.getText());
		
		int quartileSize = (sliderNumbers.getMaximum()-sliderNumbers.getMinimum())/4 ;
		sliderNumbers.setValue(sliderNumbers.getMinimum() + (quartileSize * 3) );
	}
	
	public void setCheckLabel(JLabel tempLabel){
		String temp = "";
		if (chckbxFirst.isSelected()){
			temp = temp + chckbxFirst.getText() + " ";
		}
		if (chckbxSecond.isSelected()){
			temp = temp + chckbxSecond.getText() + " ";
		}
		if (chckbxThird.isSelected()){
			temp = temp + chckbxThird.getText() + " ";
		}
		tempLabel.setText("Checkbox Value(s): " + temp);
	}
	
	protected void do_chckbxFirst_actionPerformed(ActionEvent e) {
		setCheckLabel(lblCheckboxValue);
	}
	protected void do_chckbxSecond_actionPerformed(ActionEvent arg0) {
		setCheckLabel(lblCheckboxValue);
	}
	protected void do_chckbxThird_actionPerformed(ActionEvent e) {
		setCheckLabel(lblCheckboxValue);
	}
	protected void do_slider_stateChanged(ChangeEvent arg0) {
		lblSlider.setText(Integer.toString(sliderNumbers.getValue()));
	}
	protected void do_spinner_stateChanged(ChangeEvent e) {
		lblSpinnerValue.setText("Spinner Value: " + spinnerNumber.getValue().toString());
	}
	protected void do_btnGo_actionPerformed(ActionEvent arg0) {
		sliderNumbers.setValue(Integer.parseInt(txtFieldNumber.getText()));
	}
	protected void do_tglbtnStartProgress_actionPerformed(ActionEvent arg0) {
		String tempToggle = tglbtnStartProgress.getText();
		tglbtnStartProgress.setText(tempToggleName);
		tempToggleName = tempToggle;
	}
	
	private void timerAction(){
		if (tglbtnStartProgress.isSelected() && tglbtnForward.isSelected() ){
		timerCounter++;
		progressBar.setValue(timerCounter);
		}
		
		if (tglbtnStartProgress.isSelected() && !(tglbtnForward.isSelected())){
			timerCounter--;
			progressBar.setValue(timerCounter);
		}
		
		if (timerCounter > progressBar.getMaximum()){
			timerCounter = progressBar.getMinimum();
		}
		
		if (timerCounter < progressBar.getMinimum()){
			timerCounter = progressBar.getMaximum();
		}
		
	}
	protected void do_sliderProgress_stateChanged(ChangeEvent arg0) {
		int i = (int) sliderProgress.getValue();
		swingTimer.setDelay(i);
	}
	
	protected void do_tglbtnForward_actionPerformed(ActionEvent arg0) {
		String temp = tglbtnForward.getText();
		tglbtnForward.setText(tempDirection);
		tempDirection = temp;
	}
}
