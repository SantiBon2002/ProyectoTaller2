package controladores;

import gui.Inicio;
import gui.LoginUsuario;
import gui.MenuAdmin;

public class ControladorInicio {
	private Inicio ventana;
	
	public ControladorInicio(Inicio ventana) {
		this.ventana = ventana;
		ventana.setVisible(true);
	}
	
	public void loguearse () {
		ventana.setVisible(false);
		new LoginUsuario();
	}
	
	public void menuAdmin () {
		ventana.setVisible(false);
		new MenuAdmin();
	}
}
