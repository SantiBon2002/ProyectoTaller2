package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorVisualizarPartida;
import valueObjects.VOJugadorSimple;
import valueObjects.VOPartida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class VisualizarPartida {

	private JFrame frame;
	private JTable table;
	private JTextField txtFieldNombre;
	private ControladorVisualizarPartida miControlador;
	private JTextField txtFieldCodigo;
	private DefaultTableModel modelo;
	
	/**
	 * Create the application.
	 */
	public VisualizarPartida() {
		initialize();
		this.miControlador = new ControladorVisualizarPartida(this);
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
	
	public void rellenarTabla (VOJugadorSimple voj) {
		VOPartida part = miControlador.actualizarPartida(voj);
		
		if(part != null) {
			Object[] fila = new Object[6];
			fila[0] = part.getIdPartida();
			fila[1] = part.getPuntaje();
			fila[2] = part.getPeliculaAAdivinar().getTitulo();
			fila[3] = part.getTextoAdivinado();
			fila[4] = part.getFinalizada();
			fila[5] = part.getAcertada();
			modelo.addRow(fila);
			table.setModel(modelo);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 466, 61);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modelo = new DefaultTableModel();
		String[] encabezados = {"ID", "Puntaje", "Titulo", "textAdivinado", "Finalizada?", "Acertada?"};
		modelo.setColumnIdentifiers(encabezados);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JLabel lblTitulo = new JLabel("Visualizar partida de un jugador");
		lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTitulo.setBounds(10, 11, 405, 30);
		panel.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombre.setBounds(10, 73, 75, 25);
		panel.add(lblNombre);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldNombre.setBounds(95, 73, 200, 25);
		panel.add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtFieldCodigo.getText());
				VOJugadorSimple voj = new VOJugadorSimple(txtFieldNombre.getText(), codigo);
				rellenarTabla(voj);
			}
		});
		btnActualizar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnActualizar.setBounds(95, 222, 290, 30);
		panel.add(btnActualizar);
		
		txtFieldCodigo = new JTextField();
		txtFieldCodigo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtFieldCodigo.setColumns(10);
		txtFieldCodigo.setBounds(95, 107, 200, 25);
		panel.add(txtFieldCodigo);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCodigo.setBounds(10, 107, 75, 25);
		panel.add(lblCodigo);
	}
}
