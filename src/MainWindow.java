import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow {
	String int2;
	String[] sizes = {"small", "medium", "large"};
	int[] sizePrices = {1, 2, 3};
	
	private JFrame frmGrandCircus;
	private JTextField textField;
	Customer customer;
	Order order ;
	Purchase purchase;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrandCircus = new JFrame();
		frmGrandCircus.setFont(new Font("Dialog", Font.BOLD, 24));
		frmGrandCircus.setTitle("-- GRAND CIRCUS COFFEE SHOP --");
		frmGrandCircus.setBounds(100, 100, 445, 432);
		frmGrandCircus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrandCircus.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 428, 31);
		frmGrandCircus.getContentPane().add(menuBar);
		
		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnCustomer.add(mntmNew);
		
		JMenuItem mntmExisting = new JMenuItem("Existing");
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
		
		JLabel lblFlavor = new JLabel("Flavor");
		lblFlavor.setBounds(21, 112, 46, 14);
		frmGrandCircus.getContentPane().add(lblFlavor);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(21, 156, 46, 14);
		frmGrandCircus.getContentPane().add(lblSize);
		
		String[] flavors = {"light", "medium", "bold"};
		
		JComboBox comboBox = new JComboBox(flavors);
		comboBox.setBounds(77, 95, 161, 31);
		frmGrandCircus.getContentPane().add(comboBox);
		
		JTextPane txtpnTestText = new JTextPane();
		txtpnTestText.setEditable(false);
		txtpnTestText.setBounds(77, 187, 161, 20);
		frmGrandCircus.getContentPane().add(txtpnTestText);
		
		
		JComboBox comboBox_1 = new JComboBox(sizes);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int int1 = comboBox_1.getSelectedIndex()+1;
				int2 = Integer.toString(int1);
				txtpnTestText.setText(int2);
			}
		});
		comboBox_1.setBounds(77, 137, 161, 36);
		frmGrandCircus.getContentPane().add(comboBox_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(21, 193, 46, 14);
		frmGrandCircus.getContentPane().add(lblPrice);
		
		
		
		
		
		JButton btnAddToPurchase = new JButton("Add to purchase");
		btnAddToPurchase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Order order =  new Order(customer,purchase);
				order.toString();
			}
		});
		btnAddToPurchase.setBounds(77, 218, 161, 23);
		frmGrandCircus.getContentPane().add(btnAddToPurchase);
						
		JLabel lblCurrentPurchase = new JLabel("Current purchase:");
		lblCurrentPurchase.setBounds(22, 257, 118, 14);
		frmGrandCircus.getContentPane().add(lblCurrentPurchase);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 42, 46, 14);
		frmGrandCircus.getContentPane().add(lblName);
		
		JTextPane txtpnSampleText = new JTextPane();
		
		txtpnSampleText.setEditable(false);
		txtpnSampleText.setBounds(248, 64, 161, 20);
		frmGrandCircus.getContentPane().add(txtpnSampleText);
	
		
		
		textField = new JTextField();
		
		textField.setBounds(77, 39, 161, 20);
		frmGrandCircus.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				//Customer customer = new Customer(name, 0);
				txtpnSampleText.setText(name);
			}
		});
		
		btnAddCustomer.setBounds(120, 61, 118, 23);
		frmGrandCircus.getContentPane().add(btnAddCustomer);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(77, 341, 161, 20);
		frmGrandCircus.getContentPane().add(textPane);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 347, 46, 14);
		frmGrandCircus.getContentPane().add(lblTotal);
		
		JTextArea textArea = new JTextArea();
		
		
		//		textArea.append(order.toString());
				
			
	
		textArea.setBounds(32, 274, 387, 56);
		frmGrandCircus.getContentPane().add(textArea);
		
		}
}
