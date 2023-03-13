package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorRegistrarPelicula;
import valueObjects.VOPelicula;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class RegistrarPelicula {

	private JFrame frame;
	private JTextField txtFieldTitulo;
	private ControladorRegistrarPelicula miControlador;
	private JTextArea txtAreaDescripcion;

	/**
	 * Create the application.
	 */
	public RegistrarPelicula() {
		initialize();
		this.miControlador = new ControladorRegistrarPelicula(this);
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
		frame.setBounds(100, 100, 500, 300);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registrar pelicula");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTitulo.setBounds(10, 11, 256, 30);
		panel.add(lblTitulo);
		
		JLabel lblTituloPeli = new JLabel("Titulo");
		lblTituloPeli.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTituloPeli.setBounds(10, 69, 102, 25);
		panel.add(lblTituloPeli);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblDescripcion.setBounds(10, 118, 102, 25);
		panel.add(lblDescripcion);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VOPelicula peli = new VOPelicula(txtFieldTitulo.getText(), txtAreaDescripcion.getText());
				miControlador.registrarPelicula(peli);
			}
		});
		btnConfirmar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnConfirmar.setBounds(260, 222, 150, 30);
		panel.add(btnConfirmar);
		
		txtFieldTitulo = new JTextField();
		txtFieldTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldTitulo.setColumns(10);
		txtFieldTitulo.setBounds(110, 69, 300, 25);
		panel.add(txtFieldTitulo);
		
		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtAreaDescripcion.setBounds(110, 121, 300, 90);
		panel.add(txtAreaDescripcion);
	}
}
