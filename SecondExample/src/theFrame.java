import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class theFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblCmpt = new JLabel("CMPT330 Rulez!");
	private final JButton btnFancy = new JButton("Fancy");
	private final JButton btnFancier = new JButton("Fancier");
	private final JButton btnOnlyOne = new JButton("Only One");
	private final JButton btnOrTheOther = new JButton("Or the Other");
	private final JLabel lblSoDoesDmb = new JLabel("So Does DMB!");

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
		jbInit();
	}
	private void jbInit() {
		setTitle("Kevin Callahan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCmpt.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblCmpt.setForeground(Color.BLUE);
		lblCmpt.setBounds(72, 33, 183, 35);
		
		contentPane.add(lblCmpt);
		btnFancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnFancy_actionPerformed(arg0);
			}
		});
		btnFancy.setBounds(132, 144, 97, 25);
		
		contentPane.add(btnFancy);
		btnFancier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFancier_actionPerformed(e);
			}
		});
		btnFancier.setBounds(132, 198, 97, 25);
		
		contentPane.add(btnFancier);
		btnOnlyOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOnlyOne_actionPerformed(e);
			}
		});
		btnOnlyOne.setBounds(266, 122, 97, 25);
		
		contentPane.add(btnOnlyOne);
		btnOrTheOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOrTheOther_actionPerformed(e);
			}
		});
		btnOrTheOther.setBounds(307, 122, 125, 25);
		btnOrTheOther.setVisible(false);
		
		contentPane.add(btnOrTheOther);
		lblSoDoesDmb.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSoDoesDmb.setBounds(72, 81, 157, 50);
		lblSoDoesDmb.setVisible(false);
		
		contentPane.add(lblSoDoesDmb);
	}
	protected void do_btnFancy_actionPerformed(ActionEvent arg0) {
		lblCmpt.setVisible(!lblCmpt.isVisible());
		
	}
	protected void do_btnOnlyOne_actionPerformed(ActionEvent e) {
		btnOnlyOne.setVisible(false);
		btnOrTheOther.setVisible(true);
	}
	protected void do_btnOrTheOther_actionPerformed(ActionEvent e) {
		btnOnlyOne.setVisible(true);
		btnOrTheOther.setVisible(false);
	}
	protected void do_btnFancier_actionPerformed(ActionEvent e) {
		lblCmpt.setVisible(!lblCmpt.isVisible());
		lblSoDoesDmb.setVisible(!lblSoDoesDmb.isVisible());
	}
}
