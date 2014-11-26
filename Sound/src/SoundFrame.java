import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;


public class SoundFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnPlay = new JButton("Play");

	Class metaObject = this.getClass();
	//URL urlSuccess;
	//AudioClip hooray;
	
	
	private int counter = 0;
	
	private final JButton btnBoom = new JButton("BOOM!");
	private final JButton btnBeep = new JButton("beep");
	private final JButton btnPac = new JButton("Pac");
	private final JButton btnCycle = new JButton("Cycle");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoundFrame frame = new SoundFrame();
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
	public SoundFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPlay_actionPerformed(arg0);
			}
		});
		btnPlay.setBounds(12, 13, 97, 25);
		
		contentPane.add(btnPlay);
		btnBoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnBoom_actionPerformed(arg0);
			}
		});
		btnBoom.setBounds(12, 51, 97, 25);
		
		contentPane.add(btnBoom);
		btnBeep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBeep_actionPerformed(e);
			}
		});
		btnBeep.setBounds(12, 89, 97, 25);
		
		contentPane.add(btnBeep);
		btnPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPac_actionPerformed(e);
			}
		});
		btnPac.setBounds(12, 127, 97, 25);
		
		contentPane.add(btnPac);
		btnCycle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCycle_actionPerformed(e);
			}
		});
		btnCycle.setBounds(196, 89, 97, 25);
		
		contentPane.add(btnCycle);
	}
	
	private void playClip(String tempUrl){
		URL urlSuccess = metaObject.getResource(tempUrl);
		AudioClip hooray = Applet.newAudioClip(urlSuccess);
		hooray.play();
	}
	
	protected void do_btnPlay_actionPerformed(ActionEvent arg0) {
		playClip("Success.wav");
	}
	protected void do_btnBoom_actionPerformed(ActionEvent arg0) {
		playClip("BOOM.wav");
	}
	protected void do_btnBeep_actionPerformed(ActionEvent e) {
		playClip("beep.wav");
	}
	protected void do_btnPac_actionPerformed(ActionEvent e) {
		playClip("mspacintro.au");
	}
	protected void do_btnCycle_actionPerformed(ActionEvent e) {
		if (counter%4 == 0){
			playClip("Success.wav");

		}
		else if (counter%4 == 1){
			playClip("BOOM.wav");

		}
		else if (counter%4 == 2){
			playClip("beep.wav");

		}
		else if (counter%4 == 3){
			playClip("mspacintro.au");

		}
		
		counter++;
		
	}
}
