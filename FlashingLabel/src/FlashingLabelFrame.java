import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;


public class FlashingLabelFrame extends JFrame {

	private static final int DELAY = 100;
	
	private JPanel contentPane;
	private final JLabel lblFancy = new JLabel("Fancy!");
	private final JButton btnFlash = new JButton("Flash");

	
	
	Timer timer = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
              lblFancy.setVisible(!lblFancy.isVisible());
        }
	});
	private final JSlider slider = new JSlider();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlashingLabelFrame frame = new FlashingLabelFrame();
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
	public FlashingLabelFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFancy.setHorizontalAlignment(SwingConstants.CENTER);
		lblFancy.setForeground(Color.MAGENTA);
		lblFancy.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 30));
		lblFancy.setBounds(24, 13, 396, 101);
		
		contentPane.add(lblFancy);
		btnFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFlash_actionPerformed(arg0);
			}
		});
		btnFlash.setBounds(167, 127, 97, 25);
		
		contentPane.add(btnFlash);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_slider_stateChanged(e);
			}
		});
		slider.setMajorTickSpacing(100);
		slider.setMaximum(1000);
		slider.setMinimum(1);
		slider.setBounds(12, 188, 408, 32);
		
		contentPane.add(slider);
	}
	protected void do_btnFlash_actionPerformed(ActionEvent arg0) {
		if (!timer.isRunning()){
			timer.start();
		}			
		else{
			timer.stop();
			lblFancy.setVisible(true);;
		}
		
	}
	protected void do_slider_stateChanged(ChangeEvent e) {
		timer.setDelay(slider.getMaximum() - slider.getValue());
		lblFancy.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, slider.getValue() / 10));
				
		System.out.println(lblFancy.getFont());
	}
}
