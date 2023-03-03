package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrarPelicula {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPelicula window = new RegistrarPelicula();
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
	public RegistrarPelicula() {
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
		
		JLabel lblNewLabel = new JLabel("Registrar jugador");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 256, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 69, 102, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 118, 102, 25);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(75, 222, 130, 30);
		panel.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCancelar.setBounds(280, 222, 130, 30);
		panel.add(btnCancelar);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textField.setBounds(100, 121, 300, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(100, 72, 300, 25);
		panel.add(textField_1);
	}

}
