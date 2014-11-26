import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class menuFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnEdit = new JMenu("Edit");
	private final JMenu mnNew = new JMenu("New");
	private final JMenuItem mntmOpenFile = new JMenuItem("Open File");
	private final JSeparator separator = new JSeparator();
	private final JMenuItem mntmFirstChoice = new JMenuItem("First Choice");
	private final JMenuItem mntmSecondChoice = new JMenuItem("Second Choice");
	private final JLabel lblMenuChoice = new JLabel("Menu Choice");
	private final JMenuItem mntmClose = new JMenuItem("Close");
	private final JMenuItem mntmCloseAll = new JMenuItem("Close All");
	private final JMenuItem mntmUndoTyping = new JMenuItem("Undo Typing");
	private final JMenuItem mntmRedo = new JMenuItem("Redo");
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmCut = new JMenuItem("Cut");
	private final JMenuItem mntmCopy = new JMenuItem("Copy");
	private final JMenuItem mntmPaste = new JMenuItem("Paste");
	private final JSeparator separator_2 = new JSeparator();
	private final JMenuItem mntmExit = new JMenuItem("Exit");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame frame = new menuFrame();
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
	public menuFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Callahan - Menus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		
		mnFile.add(mnNew);
		mntmFirstChoice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		mntmFirstChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmFirstChoice_actionPerformed(arg0);
			}
		});
		
		mnNew.add(mntmFirstChoice);
		mntmSecondChoice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		mntmSecondChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmSecondChoice_actionPerformed(e);
			}
		});
		
		mnNew.add(mntmSecondChoice);
		
		mnFile.add(mntmOpenFile);
		
		mnFile.add(separator);
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		
		mnFile.add(mntmClose);
		mntmCloseAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		mnFile.add(mntmCloseAll);
		
		mnFile.add(separator_2);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmExit_actionPerformed(e);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnEdit);
		mntmUndoTyping.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmUndoTyping);
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmRedo);
		
		mnEdit.add(separator_1);
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmCut);
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmCopy);
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		mnEdit.add(mntmPaste);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblMenuChoice.setBounds(168, 87, 166, 30);
		
		contentPane.add(lblMenuChoice);
	}
	protected void do_mntmFirstChoice_actionPerformed(ActionEvent arg0) {
		lblMenuChoice.setText(mntmFirstChoice.getText());
	}
	protected void do_mntmSecondChoice_actionPerformed(ActionEvent e) {
		lblMenuChoice.setText(mntmSecondChoice.getText());
	}
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		System.exit(EXIT_ON_CLOSE);
	}
}
