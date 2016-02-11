import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToGand = new JTextArea();
		txtrWelcomeToGand.setForeground(new Color(255, 255, 255));
		txtrWelcomeToGand.setBackground(new Color(153, 102, 0));
		txtrWelcomeToGand.setWrapStyleWord(true);
		txtrWelcomeToGand.setLineWrap(true);
		txtrWelcomeToGand.setFont(new Font("Monospaced", Font.BOLD, 28));
		txtrWelcomeToGand.setText("Welcome to Grand Circus          Java Shop");
		txtrWelcomeToGand.setBounds(0, 0, 428, 140);
		frame.getContentPane().add(txtrWelcomeToGand);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/// WELCOME SCREEN ENTER BUTTON
				
			}
		});
		btnEnter.setBounds(144, 148, 115, 29);
		frame.getContentPane().add(btnEnter);
	}

}
