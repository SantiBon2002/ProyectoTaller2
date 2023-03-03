package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Partida {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida window = new Partida();
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
	public Partida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("0000");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 49, 30);
		panel.add(lblNewLabel);
		
		JLabel lblPalabraAAdivinar = new JLabel("PA_A_RA A A_____AR");
		lblPalabraAAdivinar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabraAAdivinar.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
		lblPalabraAAdivinar.setBounds(10, 106, 466, 35);
		panel.add(lblPalabraAAdivinar);
		
		JButton btnNewButton = new JButton("Ingresar letra");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(40, 222, 190, 30);
		panel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Adivinar película");
		btnCancelar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCancelar.setBounds(256, 222, 190, 30);
		panel.add(btnCancelar);
	}

}
