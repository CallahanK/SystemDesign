import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;


public class PictureFrame extends JFrame {

	private static final int DELAY = 25;
	private JPanel contentPane;
	private final JLabel lblSnoopy = new JLabel("");
	Icon thePic = new ImageIcon("snoopy_skates.gif");
	Icon thePicFlip = new ImageIcon("snoopy_skates_flip.gif");
	
	private Boolean motionHorizontal = true;
	private Boolean motionVert = true;
	
	
	Timer timerGo = new Timer(DELAY, new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        	motionAction();
        }
	});
	private final JButton btnGo = new JButton("Go");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PictureFrame frame = new PictureFrame();
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
	public PictureFrame() {
		jbInit();
	}
	private void jbInit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSnoopy.setBounds(97, 79, thePic.getIconHeight(), thePic.getIconWidth());
		lblSnoopy.setIcon(thePic);
		
		contentPane.add(lblSnoopy);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGo_actionPerformed(arg0);
			}
		});
		btnGo.setBounds(12, 13, 97, 25);
		
		contentPane.add(btnGo);
	}
	
	private void motionAction(){
		
		if (motionHorizontal){
			if(lblSnoopy.getX() + lblSnoopy.getWidth() <= contentPane.getX() + contentPane.getWidth()){		
			lblSnoopy.setLocation(lblSnoopy.getX() + 5, lblSnoopy.getY());
			}
			else{
				motionHorizontal = false;
				lblSnoopy.setIcon(thePicFlip);
			}
		}
		else{
			if(lblSnoopy.getX() >= contentPane.getX())		
				lblSnoopy.setLocation(lblSnoopy.getX() - 5, lblSnoopy.getY());
			else{
				motionHorizontal = true;
				lblSnoopy.setIcon(thePic);
			}
		}
		
		if (motionVert){
			if(lblSnoopy.getY() + lblSnoopy.getHeight() <= contentPane.getY() + contentPane.getHeight()){		
			lblSnoopy.setLocation(lblSnoopy.getX(), lblSnoopy.getY() + 5);
			}
			else{
				motionVert = false;
			}
		}
		else{
			if(lblSnoopy.getY() >= contentPane.getY())		
				lblSnoopy.setLocation(lblSnoopy.getX(), lblSnoopy.getY() - 5);
			else{
				motionVert = true;
			}
		}
		
	}
	protected void do_btnGo_actionPerformed(ActionEvent arg0) {
		timerGo.start();
	}
}
