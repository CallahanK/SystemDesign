import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;


public class MotionFrame extends JFrame {

	private static final int DELAY = 25;
	Class metaObject = this.getClass();
	
	
	
	private JPanel contentPane;
	private final JButton btnGo = new JButton("Right");
	private final JLabel lblThing = new JLabel("Thing");
	
	
	
	Timer timerRight = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	rightAction();
        }
	});
	
	Timer timerLeft = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	leftAction();
        }
	});
	
	Timer timerUp = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	upAction();
        }
	});
	
	Timer timerDown = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	downAction();
        }
	});
	
	Timer timerTaller = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	growTaller();
        }
	});
	
	Timer timerShorter = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	growShorter();
        }
	});
	
	Timer timerWider = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	growWider();
        }
	});
	
	Timer timerThinner = new Timer(DELAY, new ActionListener() {
	    
	    public void actionPerformed(ActionEvent e) {
	    	growThinner();
	    }
	});
	
	private final JButton btnUp = new JButton("Up");
	private final JButton btnDown = new JButton("Down");
	private final JButton btnLeft = new JButton("Left");
	private final JLabel lblGo = new JLabel("Go");
	private final JButton btnTaller = new JButton("Taller");
	private final JButton btnShorter = new JButton("Shorter");
	private final JButton btnWider = new JButton("Wider");
	private final JButton btnThinner = new JButton("Thinner");
	private final JButton btnStopAll = new JButton("Stop All");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MotionFrame frame = new MotionFrame();
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
	public MotionFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGo_actionPerformed(arg0);
			}
		});
		btnGo.setBounds(128, 51, 77, 25);
		
		contentPane.add(btnGo);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUp_actionPerformed(e);
			}
		});
		btnUp.setBounds(52, 13, 77, 25);
		
		contentPane.add(btnUp);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDown_actionPerformed(e);
			}
		});
		btnDown.setBounds(52, 89, 77, 25);
		
		contentPane.add(btnDown);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLeft_actionPerformed(e);
			}
		});
		btnLeft.setBounds(12, 51, 77, 25);
		
		contentPane.add(btnLeft);
		lblGo.setBounds(101, 55, 15, 16);
		
		contentPane.add(lblGo);
		btnTaller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTaller_actionPerformed(e);
			}
		});
		btnTaller.setBounds(12, 127, 97, 25);
		
		contentPane.add(btnTaller);
		btnShorter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnShorter_actionPerformed(e);
			}
		});
		btnShorter.setBounds(12, 169, 97, 25);
		
		contentPane.add(btnShorter);
		btnWider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWider_actionPerformed(e);
			}
		});
		btnWider.setBounds(128, 127, 97, 25);
		
		contentPane.add(btnWider);
		btnThinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnThinner_actionPerformed(e);
			}
		});
		btnThinner.setBounds(128, 169, 97, 25);
		
		contentPane.add(btnThinner);
		btnStopAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnStopAll_actionPerformed(arg0);
			}
		});
		btnStopAll.setBounds(71, 207, 97, 25);
		
		contentPane.add(btnStopAll);
		lblThing.setBackground(Color.WHITE);
		lblThing.setOpaque(true);
		lblThing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThing.setBounds(524, 205, 80, 69);
		
		contentPane.add(lblThing);
	}
	
	private void playClip(String tempUrl){
		URL urlSound = metaObject.getResource(tempUrl);
		AudioClip sound = Applet.newAudioClip(urlSound);
		sound.play();
	}
	
	private void rightAction(){
		
		if(lblThing.getX() + lblThing.getWidth() <= contentPane.getX() + contentPane.getWidth()){		
		lblThing.setLocation(lblThing.getX() + 5, lblThing.getY());
		}
		else{
			timerRight.stop();
			timerLeft.start();
			playClip("beep.wav");
		}
		
		
	}
	
	private void leftAction(){
		
		if(lblThing.getX() >= contentPane.getX())		
		lblThing.setLocation(lblThing.getX() - 5, lblThing.getY());
		else{
			timerLeft.stop();
			timerRight.start();
			playClip("beep.wav");
		}
	}
	
	private void upAction(){
	
		if(lblThing.getY() >= contentPane.getY())		
			lblThing.setLocation(lblThing.getX(), lblThing.getY() - 5);
		else{
			timerUp.stop();
			timerDown.start();
			playClip("beep.wav");
		}
	}

	private void downAction(){
	
		if(lblThing.getY() + lblThing.getHeight() <= contentPane.getY() + contentPane.getHeight())		
			lblThing.setLocation(lblThing.getX(), lblThing.getY() + 5);
		else{
			timerDown.stop();
			timerUp.start();
			playClip("beep.wav");
		}
	}

	private void growTaller(){
		
		if(lblThing.getY() + lblThing.getHeight() <= contentPane.getY() + contentPane.getHeight())		
			lblThing.setBounds(lblThing.getX(), lblThing.getY(), lblThing.getWidth(), lblThing.getHeight() + 5);
		else
			timerTaller.stop();
	}
	
	
	private void growShorter(){
		
		if(lblThing.getHeight() >= 5)		
			lblThing.setBounds(lblThing.getX(), lblThing.getY(), lblThing.getWidth(), lblThing.getHeight() - 5);
		else
			timerTaller.stop();
	}
	
	private void growWider(){
		
		if(lblThing.getX() + lblThing.getWidth() <= contentPane.getX() + contentPane.getWidth())		
			lblThing.setBounds(lblThing.getX(), lblThing.getY(), lblThing.getWidth() + 5, lblThing.getHeight());
		else
			timerTaller.stop();
	}
	
	
	private void growThinner(){
		
		if(lblThing.getWidth() >= 6)		
			lblThing.setBounds(lblThing.getX(), lblThing.getY(), lblThing.getWidth() - 5, lblThing.getHeight());
		else
			timerTaller.stop();
	}
	
	private void stopAll(){
		timerRight.stop();
		timerLeft.stop();
		timerUp.stop();
		timerDown.stop();
		timerTaller.stop();
		timerShorter.stop();
		timerWider.stop();
		timerThinner.stop();
	}
	
	private void stopVertMotion(){
		timerUp.stop();
		timerDown.stop();
	}
	
	private void stopHorizontalMotion(){
		timerRight.stop();
		timerLeft.stop();
	}
	
	private void stopAllVertGrowth(){
		timerTaller.stop();
		timerShorter.stop();
	}
	
	private void stopAllHorizontalGrowth(){
		timerWider.stop();
		timerThinner.stop();
	}
	
	protected void do_btnGo_actionPerformed(ActionEvent arg0) {
		stopHorizontalMotion();
		timerRight.start();
	}
	protected void do_btnUp_actionPerformed(ActionEvent e) {
		stopVertMotion();
		timerUp.start();
	}
	protected void do_btnLeft_actionPerformed(ActionEvent e) {
		stopHorizontalMotion();
		timerLeft.start();
	}
	protected void do_btnDown_actionPerformed(ActionEvent e) {
		stopVertMotion();
		timerDown.start();
	}
	protected void do_btnTaller_actionPerformed(ActionEvent e) {
		stopAllVertGrowth();
		timerTaller.start();
	}
	protected void do_btnShorter_actionPerformed(ActionEvent e) {
		stopAllVertGrowth();
		timerShorter.start();
	}
	protected void do_btnWider_actionPerformed(ActionEvent e) {
		stopAllHorizontalGrowth();
		timerWider.start();
	}
	protected void do_btnThinner_actionPerformed(ActionEvent e) {
		stopAllHorizontalGrowth();
		timerThinner.start();
	}
	protected void do_btnStopAll_actionPerformed(ActionEvent arg0) {
		stopAll();
	}
}
