package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controladores.ControladorRegistrarJugador;
import valueObjects.VOJugadorSimple;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class RegistrarJugador {

	private JFrame frame;
	private JTextField txtFieldCodigo;
	private JTextField txtFieldNombre;
	private ControladorRegistrarJugador miControlador;

	/**
	 * Create the application.
	 */
	public void setVisible (boolean b) 
	{	frame.setVisible(b);	}
	
	public RegistrarJugador() {
		this.initialize();
		this.miControlador = new ControladorRegistrarJugador(this);
	}
	
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
		
		JLabel lblTitulo = new JLabel("Registrar jugador");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTitulo.setBounds(10, 11, 256, 30);
		panel.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombre.setBounds(10, 69, 102, 25);
		panel.add(lblNombre);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCodigo.setBounds(10, 118, 102, 25);
		panel.add(lblCodigo);
		
		txtFieldCodigo = new JTextField();
		txtFieldCodigo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldCodigo.setBounds(100, 121, 300, 25);
		panel.add(txtFieldCodigo);
		txtFieldCodigo.setColumns(10);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldNombre.setColumns(10);
		txtFieldNombre.setBounds(100, 72, 300, 25);
		panel.add(txtFieldNombre);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtFieldCodigo.getText());
				VOJugadorSimple voj = new VOJugadorSimple(txtFieldNombre.getText(), codigo);
				miControlador.registrarJugador(voj);
			}
		});
		btnConfirmar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnConfirmar.setBounds(250, 222, 150, 30);
		panel.add(btnConfirmar);
		
		
	}
}
