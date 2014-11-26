import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MoveFrame extends JFrame {

	private JPanel contentPane;
	private final JButton btnMove = new JButton("Right");
	private final JLabel lblThing = new JLabel("thing");
	private final JLabel lblMove = new JLabel("Move");
	private final JButton btnUp = new JButton("Up");
	private final JButton btnDown = new JButton("Down");
	private final JButton btnLeft = new JButton("Left");
	private final JButton btnNw = new JButton("NW");
	private final JButton btnSw = new JButton("SW");
	private final JButton btnNe = new JButton("NE");
	private final JButton btnSe = new JButton("SE");
	private final JLabel lblSize = new JLabel("Size:");
	private final JButton btnHeight = new JButton("Height +");
	private final JButton btnHeight_1 = new JButton("Height -");
	private final JButton btnWidth = new JButton("Width +");
	private final JButton btnWidth_1 = new JButton("Width -");
	private final JButton btnGrow = new JButton("Grow");
	private final JButton btnShrink = new JButton("Shrink");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoveFrame frame = new MoveFrame();
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
	public MoveFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Move It!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnMove_actionPerformed(arg0);
			}
		});
		btnMove.setBounds(540, 47, 70, 25);
		
		contentPane.add(btnMove);
		lblMove.setBounds(474, 51, 38, 16);
		
		contentPane.add(lblMove);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUp_actionPerformed(e);
			}
		});
		btnUp.setBounds(458, 13, 70, 25);
		
		contentPane.add(btnUp);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDown_actionPerformed(e);
			}
		});
		btnDown.setBounds(458, 80, 70, 25);
		
		contentPane.add(btnDown);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLeft_actionPerformed(e);
			}
		});
		btnLeft.setBounds(376, 47, 70, 25);
		
		contentPane.add(btnLeft);
		btnNw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNw_actionPerformed(e);
			}
		});
		btnNw.setBounds(376, 13, 70, 25);
		
		contentPane.add(btnNw);
		btnSw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSw_actionPerformed(e);
			}
		});
		btnSw.setBounds(376, 80, 70, 25);
		
		contentPane.add(btnSw);
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNe_actionPerformed(e);
			}
		});
		btnNe.setBounds(540, 13, 70, 25);
		
		contentPane.add(btnNe);
		btnSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSe_actionPerformed(e);
			}
		});
		btnSe.setBounds(540, 80, 70, 25);
		
		contentPane.add(btnSe);
		lblSize.setBounds(404, 143, 56, 16);
		
		contentPane.add(lblSize);
		btnHeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHeight_actionPerformed(e);
			}
		});
		btnHeight.setBounds(513, 172, 97, 25);
		
		contentPane.add(btnHeight);
		btnHeight_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHeight_1_actionPerformed(e);
			}
		});
		btnHeight_1.setBounds(513, 210, 97, 25);
		
		contentPane.add(btnHeight_1);
		btnWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWidth_actionPerformed(e);
			}
		});
		btnWidth.setBounds(404, 172, 97, 25);
		
		contentPane.add(btnWidth);
		btnWidth_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWidth_1_actionPerformed(e);
			}
		});
		btnWidth_1.setBounds(404, 210, 97, 25);
		
		contentPane.add(btnWidth_1);
		lblThing.setBackground(new Color(0, 139, 139));
		lblThing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThing.setOpaque(true);
		lblThing.setBounds(71, 47, 70, 70);
		
		contentPane.add(lblThing);
		btnGrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGrow_actionPerformed(e);
			}
		});
		btnGrow.setBounds(404, 271, 97, 25);
		
		contentPane.add(btnGrow);
		btnShrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnShrink_actionPerformed(e);
			}
		});
		btnShrink.setBounds(513, 271, 97, 25);
		
		contentPane.add(btnShrink);
	}

	protected void do_btnMove_actionPerformed(ActionEvent arg0) {
		lblThing.setLocation(lblThing.getX() + 5, lblThing.getY());
	}
	protected void do_btnUp_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX(), lblThing.getY() - 5);
	}
	protected void do_btnDown_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX(), lblThing.getY() + 5);
	}
	protected void do_btnLeft_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX() - 5, lblThing.getY());
	}
	protected void do_btnNe_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX() + 5, lblThing.getY() - 5);
	}
	protected void do_btnSe_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX() + 5, lblThing.getY() + 5);
	}
	protected void do_btnSw_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX() - 5, lblThing.getY() + 5);
	}
	protected void do_btnNw_actionPerformed(ActionEvent e) {
		lblThing.setLocation(lblThing.getX() - 5, lblThing.getY() - 5);
	}
	protected void do_btnHeight_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth(), lblThing.getHeight() + 2);
	}
	protected void do_btnHeight_1_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth(), lblThing.getHeight() - 2);
	}
	protected void do_btnWidth_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth() + 2, lblThing.getHeight());
	}
	protected void do_btnWidth_1_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth() - 2, lblThing.getHeight());
	}
	protected void do_btnGrow_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth() + 2, lblThing.getHeight() + 2);
	}
	protected void do_btnShrink_actionPerformed(ActionEvent e) {
		lblThing.setSize(lblThing.getWidth() - 2, lblThing.getHeight() - 2);
	}
}
