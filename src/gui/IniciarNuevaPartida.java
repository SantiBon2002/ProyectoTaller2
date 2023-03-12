package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladores.ControladorIniciarNuevaPartida;
import valueObjects.VOJugadorSimple;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class IniciarNuevaPartida {

	private JFrame frame;
	private ControladorIniciarNuevaPartida miControlador;
	
	/**
	 * Create the application.
	 */
	public IniciarNuevaPartida() {
		initialize();
		//this.miControlador = new ControladorIniciarNuevaPartida(this, voj);
	}

	public void setControlador (ControladorIniciarNuevaPartida c) {
		miControlador = c;
	}
	
	public void setVisible (boolean b) 
	{	frame.setVisible(b);	}
	
	public void mensajeError (String e, boolean exit) {
		int input = 0;
		if (exit == false) {
			input = JOptionPane.showOptionDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE,
					null, null, null);
		} else {
			input = JOptionPane.showOptionDialog(null, e, "Correcto", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE, null, null, null);
		}

		if (input == JOptionPane.OK_OPTION && exit) {
			frame.dispose();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnIniciarPartida = new JButton("A Jugar!");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.iniciarPartida();
			}
		});
		btnIniciarPartida.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnIniciarPartida.setBounds(126, 105, 180, 40);
		panel.add(btnIniciarPartida);
	}
}
