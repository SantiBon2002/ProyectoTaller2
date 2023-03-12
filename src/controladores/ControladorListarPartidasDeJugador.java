package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.ElementoNoExisteEnDiccException;
import gui.ListarPartidasDeJugador;
import valueObjects.VOPartida;

public class ControladorListarPartidasDeJugador {
	private ICapaLogica fachada;
	private ListarPartidasDeJugador ventana;
	
	private final String errorCon = "Error de conexion";
	public ControladorListarPartidasDeJugador(ListarPartidasDeJugador ventana) {
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
	
	public VOPartida[] listarPartidasDeJugador (String nombre) {
		VOPartida[] partidas = null;
		try {
			partidas = fachada.listarPartidasDeJugador(nombre);
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
		return partidas;
	}
}