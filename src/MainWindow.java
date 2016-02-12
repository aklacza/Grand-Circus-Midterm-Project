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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainWindow {
	String int2;
	String[] sizes = { "small", "medium", "large" };
	int[] sizePrices = { 1, 2, 3 };

	private JFrame frmGrandCircus;
	private JTextField txtName;
	Customer customer;
	
	Purchase purchase = new Purchase();
	String customer1;
	
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

		// JMenuBar menuBar = new JMenuBar();
		// menuBar.setBounds(0, 0, 428, 31);
		// frmGrandCircus.getContentPane().add(menuBar);
		//
		// JMenu mnCustomer = new JMenu("Customer");
		// menuBar.add(mnCustomer);
		//
		// JMenuItem mntmNew = new JMenuItem("New");
		// mnCustomer.add(mntmNew);
		//
		// JMenuItem mntmExisting = new JMenuItem("Existing");
		// mnCustomer.add(mntmExisting);
		//
		// JMenu mnCoffee = new JMenu("Coffee");
		// menuBar.add(mnCoffee);
		//
		// JMenuItem mntmLight = new JMenuItem("Light");
		// mnCoffee.add(mntmLight);
		//
		// JMenuItem mntmMedium = new JMenuItem("Medium");
		// mnCoffee.add(mntmMedium);
		//
		// JMenuItem mntmDark = new JMenuItem("Dark");
		// mnCoffee.add(mntmDark);
		//
		// JMenu mnSize = new JMenu("Size");
		// menuBar.add(mnSize);
		//
		// JMenuItem mntmSmall = new JMenuItem("Small");
		// mnSize.add(mntmSmall);
		//
		// JMenuItem mntmMedium_1 = new JMenuItem("Medium");
		// mnSize.add(mntmMedium_1);
		//
		// JMenuItem mntmLarge = new JMenuItem("Large");
		// mnSize.add(mntmLarge);

		JLabel lblFlavor = new JLabel("Flavor");
		lblFlavor.setBounds(21, 112, 46, 14);
		frmGrandCircus.getContentPane().add(lblFlavor);

		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(21, 156, 46, 14);
		frmGrandCircus.getContentPane().add(lblSize);

		String[] flavors = { "light", "medium", "bold" };

		JComboBox comboBox = new JComboBox(flavors);
		comboBox.setBounds(77, 95, 161, 31);
		frmGrandCircus.getContentPane().add(comboBox);

		JTextPane txtpnTestText = new JTextPane();
		txtpnTestText.setText("1");
		txtpnTestText.setEditable(false);
		txtpnTestText.setBounds(77, 187, 161, 20);
		frmGrandCircus.getContentPane().add(txtpnTestText);

		JComboBox comboBox_1 = new JComboBox(sizes);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int int1 = comboBox_1.getSelectedIndex() + 1;
				int2 = Integer.toString(int1);
				txtpnTestText.setText(int2);
			}
		});
		comboBox_1.setBounds(77, 137, 161, 36);
		frmGrandCircus.getContentPane().add(comboBox_1);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(21, 193, 46, 14);
		frmGrandCircus.getContentPane().add(lblPrice);

		JTextArea txtrTesttext = new JTextArea();
		txtrTesttext.setRows(3);
		txtrTesttext.setBounds(32, 274, 387, 56);
		frmGrandCircus.getContentPane().add(txtrTesttext);

		JTextPane txtpnSampleText = new JTextPane();
		txtpnSampleText.setEditable(false);
		txtpnSampleText.setBounds(77, 34, 161, 20);
		frmGrandCircus.getContentPane().add(txtpnSampleText);

		JTextPane textPane = new JTextPane();
		textPane.setText("0");
		textPane.setEditable(false);
		textPane.setBounds(77, 341, 161, 20);
		frmGrandCircus.getContentPane().add(textPane);

		JButton btnAddToPurchase = new JButton("Add to purchase");
		btnAddToPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String size = (String) comboBox_1.getSelectedItem();
				String flavor = (String) comboBox.getSelectedItem();

				txtrTesttext.append("Size: " + size + ", flavor: " + flavor + " \n");

				int currentTotal = (int) Integer.valueOf(textPane.getText());
				currentTotal += comboBox_1.getSelectedIndex() + 1;
				String currentTotal1 = Integer.toString(currentTotal);

				textPane.setText(currentTotal1);

				purchase.addCoffee(new Coffee(size, flavor, currentTotal));
				
				
			}
		});
		btnAddToPurchase.setBounds(77, 218, 161, 23);
		frmGrandCircus.getContentPane().add(btnAddToPurchase);

		JLabel lblCurrentPurchase = new JLabel("Current purchase:");
		lblCurrentPurchase.setBounds(22, 257, 118, 14);
		frmGrandCircus.getContentPane().add(lblCurrentPurchase);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 14, 46, 14);
		frmGrandCircus.getContentPane().add(lblName);

		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(77, 11, 161, 20);
		frmGrandCircus.getContentPane().add(txtName);
		txtName.setColumns(10);

		JButton btnAddCustomer = new JButton("Add customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				File cFile = new File("CustomerList.txt");
				Path customerPath = Paths.get("CustomerList.txt");
				File customerFile = customerPath.toFile();

				String name = null;
				Scanner scan = null;
				boolean exists = false;
				try {
					scan = new Scanner(cFile);

					name = txtName.getText();
					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						if (line.equalsIgnoreCase(name)) {
							txtpnSampleText.setText("Customer exists");
							exists = true;
						}
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				
				if (exists == false){
					try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(customerFile, true)))) {
				//		out.println(name);
					} catch (IOException e) {
						System.out.println(e);
					}
					txtpnSampleText.setText("Customer Entered!");
				}
				scan.close();
			}
		});

		btnAddCustomer.setBounds(120, 61, 118, 23);
		frmGrandCircus.getContentPane().add(btnAddCustomer);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 347, 46, 14);
		frmGrandCircus.getContentPane().add(lblTotal);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = txtrTesttext.getText();
				String name = txtName.getText();
				
				Path customerPath = Paths.get("CustomerList.txt");
				File customerFile = customerPath.toFile();
				
				try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(customerFile, true)))) {
					out.println(name);
					out.println(purchase);
					out.println();
				} catch (IOException f) {
					System.out.println(f);
				}
				
				txtpnSampleText.setText("");
				txtrTesttext.setText("");
				textPane.setText("0");
				txtName.setText("Next customer");
				
			}
		});
		btnPay.setBounds(248, 338, 89, 23);
		frmGrandCircus.getContentPane().add(btnPay);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrTesttext.setText("");
				textPane.setText("0");
				txtName.setText("Next customer");
				purchase = new Purchase();
				txtpnSampleText.setText("");
			}
		});
		btnClear.setBounds(260, 218, 89, 23);
		frmGrandCircus.getContentPane().add(btnClear);

	}
}
