package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class RankingGeneral {

	private JFrame frame;
	private JTable table;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.setBounds(10, 52, 466, 157);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Ranking general");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 245, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(143, 220, 200, 30);
		panel.add(btnNewButton);
	}

}
