package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controladores.ControladorInicio;
import controladores.ControladorLoginUsuario;

public class Inicio {

	private JFrame frame;
	private ControladorInicio miControlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
		miControlador = new ControladorInicio(this);
	}
	
	public void setVisible (boolean b) 
	{	frame.setVisible(b);	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Inicio");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 264, 30);
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel.add(lblTitulo);
		
		JButton btnMenuAdmin = new JButton("Menu administrador");
		btnMenuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.menuAdmin();
			}
		});
		btnMenuAdmin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnMenuAdmin.setBounds(10, 52, 264, 30);
		panel.add(btnMenuAdmin);
		
		JButton btnLoguearseParaJugar = new JButton("Loguearse para jugar");
		btnLoguearseParaJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.loguearse();
			}
		});
		btnLoguearseParaJugar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLoguearseParaJugar.setBounds(10, 93, 264, 30);
		panel.add(btnLoguearseParaJugar);
	}
}
