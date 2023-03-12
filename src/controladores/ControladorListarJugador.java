package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.DiccionarioVacioException;
import gui.ListarJugador;
import valueObjects.VOJugadorListado;

public class ControladorListarJugador {
	private ICapaLogica fachada;
	private ListarJugador ventana;
	
	private final String errorCon = "Error de conexion";
	public ControladorListarJugador(ListarJugador ventana) {
		this.ventana = ventana;
		try {
			Properties p = new Properties();
			String nomArch = "src/config/config.properties";
			p.load(new FileInputStream(nomArch));
			String servidor = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + servidor + ":" + puerto + "/fachada";
	
			fachada = (ICapaLogica) Naming.lookup(ruta);
			ventana.setVisible(true);
		} catch (IOException | NotBoundException e) {
			ventana.mensajeError(errorCon, false);
		}
	
	}
	
	public ArrayList <VOJugadorListado> listarJugadores () {
		ArrayList <VOJugadorListado> jugadores = null;
		
		try {
			jugadores = fachada.listarJugadores();
		} catch (DiccionarioVacioException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
		return jugadores;
	}
}