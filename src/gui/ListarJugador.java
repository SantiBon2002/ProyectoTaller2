package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import controladores.ControladorListarJugador;
import valueObjects.VOJugadorListado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Window.Type;
import java.util.ArrayList;

public class ListarJugador {

	private JFrame frame;
	private ControladorListarJugador miControlador;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarJugador window = new ListarJugador();
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
	public ListarJugador() {
		initialize();
		this.miControlador = new ControladorListarJugador(this);
		
		ArrayList<VOJugadorListado> lista = miControlador.listarJugadores();
		
		DefaultTableModel modelo = new DefaultTableModel();
		String[] encabezados = {"Nombre", "Codigo", "Puntaje", "Acertadas", "Erradas"};
		modelo.setColumnIdentifiers(encabezados);
		Object[] fila;
		if(lista != null) 
			for(int i=0;i<lista.size();i++) {
				fila = new Object[5];
				fila[0] = lista.get(i).getNombre();
				fila[1] = lista.get(i).getCodigo();
				fila[2] = lista.get(i).getPuntajeTotal();
				fila[3] = lista.get(i).getCantPelisAcertadas();
				fila[4] = lista.get(i).getCantPelisErradas();
				modelo.addRow(fila);
			}
		table.setModel(modelo);
		
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
		frame.dispose();

	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 500, 300);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar jugadores");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 245, 30);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 466, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
}
