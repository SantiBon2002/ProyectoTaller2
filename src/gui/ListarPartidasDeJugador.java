package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorListarPartidasDeJugador;
import valueObjects.VOPartida;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListarPartidasDeJugador {

	private JFrame frame;
	private JTextField txtFieldNombre;
	private ControladorListarPartidasDeJugador miControlador;
	private JTable table;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPartidasDeJugador window = new ListarPartidasDeJugador();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarPartidasDeJugador() {
		initialize();
		this.miControlador = new ControladorListarPartidasDeJugador(this);
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
	
	public void rellenarTabla (String nom) {
		VOPartida[] part = miControlador.listarPartidasDeJugador(nom);
		
		if(part != null) {
			Object[] fila;
			
			for(int i = 0 ;i<part.length;i++) {
				fila = new Object[6];
				fila[0] = part[i].getIdPartida();
				fila[1] = part[i].getPuntaje();
				fila[2] = part[i].getPeliculaAAdivinar().getTitulo();
				fila[3] = part[i].getTextoAdivinado();
				fila[4] = part[i].getFinalizada();
				fila[5] = part[i].getAcertada();
				
				modelo.addRow(fila);
			}
			table.setModel(modelo);
		} else {
			mensajeError("El jugador no tiene ninguna partida aún", false);
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
		
		JLabel lblNewLabel = new JLabel("Listar partidas de un jugador");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 358, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombre.setBounds(10, 57, 75, 25);
		panel.add(lblNombre);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldNombre.setBounds(95, 57, 200, 25);
		panel.add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rellenarTabla(txtFieldNombre.getText());
			}
		});
		btnListar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnListar.setBounds(316, 54, 160, 30);
		panel.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 466, 159);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modelo = new DefaultTableModel();
		String[] encabezados = {"Numero", "Puntaje", "Titulo", "textAdivinado", "Finalizada?", "Acertada?"};
		modelo.setColumnIdentifiers(encabezados);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}
}
