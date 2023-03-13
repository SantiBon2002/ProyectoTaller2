package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import controladores.ControladorMenuAdmin;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdmin {

	private JFrame frame;
	private ControladorMenuAdmin miControlador;

	/**
	 * Create the application.
	 */
	public MenuAdmin() {
		initialize();
		miControlador = new ControladorMenuAdmin(this);
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
	public void setVisible (boolean b) 
	{	frame.setVisible(b);	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 294, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 278, 381);
		frame.getContentPane().add(panel);
		
		JLabel lblTitulo = new JLabel("Menu administrador");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 258, 30);
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		
		JButton btnRegJugador = new JButton("Registrar jugador");
		btnRegJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistrarJugador();
			}
		});
		btnRegJugador.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRegJugador.setBounds(10, 52, 258, 30);
		panel.setLayout(null);
		panel.add(lblTitulo);
		panel.add(btnRegJugador);
		
		JButton btnRegPelicula = new JButton("Añadir película");
		btnRegPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistrarPelicula();
			}
		});
		btnRegPelicula.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRegPelicula.setBounds(10, 93, 258, 30);
		panel.add(btnRegPelicula);
		
		JButton btnLstPartidasDeJugador = new JButton("Listar partidas de un jugador");
		btnLstPartidasDeJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarPartidasDeJugador();
			}
		});
		btnLstPartidasDeJugador.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLstPartidasDeJugador.setBounds(10, 216, 258, 30);
		panel.add(btnLstPartidasDeJugador);
		
		JButton btnVerPartida = new JButton("Ver partida en curso");
		btnVerPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VisualizarPartida();
			}
		});
		btnVerPartida.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnVerPartida.setBounds(10, 257, 258, 30);
		panel.add(btnVerPartida);
		
		JButton btnLstPeliculas = new JButton("Listar peliculas");
		btnLstPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarPeliculas();
			}
		});
		btnLstPeliculas.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLstPeliculas.setBounds(10, 175, 258, 30);
		panel.add(btnLstPeliculas);
		
		JButton btnLstJugadores = new JButton("Listar jugadores");
		btnLstJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarJugador();
			}
		});
		btnLstJugadores.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLstJugadores.setBounds(10, 134, 258, 30);
		panel.add(btnLstJugadores);
		
		JButton btnRanking = new JButton("Ranking general");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RankingGeneral();
			}
		});
		btnRanking.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRanking.setBounds(10, 298, 258, 30);
		panel.add(btnRanking);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.guardarCambios();
			}
		});
		btnGuardarCambios.setBounds(10, 339, 258, 30);
		panel.add(btnGuardarCambios);
		btnGuardarCambios.setFont(new Font("Century Gothic", Font.PLAIN, 16));
	}
}
