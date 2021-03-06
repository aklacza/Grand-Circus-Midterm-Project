import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow2 {

	Customer cust;
	Order order;
	private JFrame frmGrandCircus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2();
					window.frmGrandCircus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrandCircus = new JFrame();
		frmGrandCircus.setFont(new Font("Dialog", Font.BOLD, 24));
		frmGrandCircus.setTitle("-- GRAND CIRCUS COFFEE SHOP --");
		frmGrandCircus.setBounds(100, 100, 450, 300);
		frmGrandCircus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrandCircus.getContentPane().setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 428, 31);
		frmGrandCircus.getContentPane().add(menuBar);
		
		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = null;
				int noOfCoffees = 0;
				cust = new Customer(name,noOfCoffees);
				cust.toString();
			}
		});
		mnCustomer.add(mntmNew);
		
		JMenuItem mntmExisting = new JMenuItem("Existing");
		mntmExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = null;
				int noOfCoffees = 0;
				cust = new Customer(name,noOfCoffees);// do customer validations here
				cust.toString();
				
			}
		});
		mnCustomer.add(mntmExisting);
		
		JMenu mnCoffee = new JMenu("Coffee");
		menuBar.add(mnCoffee);
		
		JMenuItem mntmLight = new JMenuItem("Light");
		mnCoffee.add(mntmLight);
		
		JMenuItem mntmMedium = new JMenuItem("Medium");
		mnCoffee.add(mntmMedium);
		
		JMenuItem mntmDark = new JMenuItem("Dark");
		mnCoffee.add(mntmDark);
		
		JMenu mnSize = new JMenu("Size");
		menuBar.add(mnSize);
		
		JMenuItem mntmSmall = new JMenuItem("Small");
		mnSize.add(mntmSmall);
		
		JMenuItem mntmMedium_1 = new JMenuItem("Medium");
		mnSize.add(mntmMedium_1);
		
		JMenuItem mntmLarge = new JMenuItem("Large");
		mnSize.add(mntmLarge);
	}

}
