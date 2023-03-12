package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorRankingGeneral;
import valueObjects.VOJugadorListado;

import java.awt.Window.Type;
import java.util.ArrayList;

public class RankingGeneral {

	private JFrame frame;
	private JTable table;
	private ControladorRankingGeneral miControlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingGeneral window = new RankingGeneral();
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
	public RankingGeneral() {
		initialize();
		this.miControlador = new ControladorRankingGeneral(this);
		VOJugadorListado[] lista = miControlador.rankingGeneral();
		
		DefaultTableModel modelo = new DefaultTableModel();
		String[] encabezados = {"Nombre", "Codigo", "Puntaje", "Acertadas", "Erradas"};
		modelo.setColumnIdentifiers(encabezados);
		Object[] fila;
		
		for(int i=0;i<lista.length;i++) {
			fila = new Object[5];
			fila[0] = lista[i].getNombre();
			fila[1] = lista[i].getCodigo();
			fila[2] = lista[i].getPuntajeTotal();
			fila[3] = lista[i].getCantPelisAcertadas();
			fila[4] = lista[i].getCantPelisErradas();
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 466, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Ranking general");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 245, 30);
		panel.add(lblNewLabel);
	}

}
