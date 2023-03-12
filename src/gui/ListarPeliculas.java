package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorListarPeliculas;
import valueObjects.VOPelicula;

import java.awt.Window.Type;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class ListarPeliculas {

	private JFrame frame;
	private ControladorListarPeliculas miControlador;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPeliculas window = new ListarPeliculas();
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
	public ListarPeliculas() {
		initialize();
		this.miControlador = new ControladorListarPeliculas(this);
		
		ArrayList<VOPelicula> peli = miControlador.listarPeliculas();
		
		if(peli!=null) {
			DefaultTableModel modelo = new DefaultTableModel();
			String[] encabezados = {"Titulo", "Descripcion"};
			modelo.setColumnIdentifiers(encabezados);
			Object[] fila;
		
			for(int i = 0 ;i<peli.size();i++) {
				fila = new Object[2];
				fila[0] = peli.get(i).getTitulo();
				fila[1] = peli.get(i).getDescripcion();
				modelo.addRow(fila);
			}
			table.setModel(modelo);
		}
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar películas");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 245, 30);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 466, 200);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
}
