package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controladores.ControladorIniciarNuevaPartida;
import controladores.ControladorPartida;
import valueObjects.VOJugadorSimple;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class PartidaGui {

	private JFrame frame;
	private ControladorPartida miControlador;
	private JLabel lblPuntaje;
	private JLabel lblTxtAdivinado;
	private JTextField txtFieldInput;
	private JTextPane txtpaneDesc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidaGui window = new PartidaGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PartidaGui() {
		initialize();
		//this.miControlador = new ControladorPartida(this);
	}

	public void setVisible (boolean b) 
	{	frame.setVisible(b);	}
	
	public void mensajeError (String e, boolean exit, boolean correcto) {
		int input = 0;
		if (correcto == false) {
			input = JOptionPane.showOptionDialog(null, e, "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE,
					null, null, null);
		} else {
			input = JOptionPane.showOptionDialog(null, e, "Correcto", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE, null, null, null);
		}
		if (input == JOptionPane.OK_OPTION && exit)
			frame.dispose();
	}
	
	public void setControlador (ControladorPartida c) {
		miControlador = c;
	}
	
	public void actualizarTxtAdivinado (String txtAdivinado) {
		lblTxtAdivinado.setText(txtAdivinado);
	}
	
	public void actualizarPuntaje (String txtPuntaje) {
		lblPuntaje.setText(txtPuntaje);
	}
	public void setDesc(String txt) {
		txtpaneDesc.setText(txt);
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
		
		lblPuntaje = new JLabel("");
		lblPuntaje.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPuntaje.setBounds(10, 11, 49, 30);
		panel.add(lblPuntaje);
		
		lblTxtAdivinado = new JLabel("");
		lblTxtAdivinado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAdivinado.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		lblTxtAdivinado.setBounds(10, 52, 466, 35);
		panel.add(lblTxtAdivinado);
		
		JButton btnIngresarLetra = new JButton("Ingresar letra");
		btnIngresarLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.ingresarLetra(txtFieldInput.getText());
				txtFieldInput.setText("");
			}
		});
		btnIngresarLetra.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnIngresarLetra.setBounds(40, 222, 190, 30);
		panel.add(btnIngresarLetra);
		
		JButton btnAdivinarPelicula = new JButton("Adivinar película");
		btnAdivinarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.arriesgarPelicula(txtFieldInput.getText());
				txtFieldInput.setText("");
			}
		});
		btnAdivinarPelicula.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAdivinarPelicula.setBounds(256, 222, 190, 30);
		panel.add(btnAdivinarPelicula);
		
		txtFieldInput = new JTextField();
		txtFieldInput.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldInput.setBounds(40, 186, 406, 25);
		panel.add(txtFieldInput);
		txtFieldInput.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 98, 406, 77);
		panel.add(scrollPane);
		
		txtpaneDesc = new JTextPane();
		txtpaneDesc.setEditable(false);
		scrollPane.setViewportView(txtpaneDesc);
		
		
	}
}
