package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.CodigoIncorrectoException;
import excepciones.ElementoNoExisteEnDiccException;
import excepciones.NoHayPartidaEnCursoException;
import gui.VisualizarPartida;
import valueObjects.VOJugadorSimple;
import valueObjects.VOPartida;

public class ControladorVisualizarPartida {
	private ICapaLogica fachada;
	private VisualizarPartida ventana;
	
	private final String errorCon = "Error de conexion";
	
	public ControladorVisualizarPartida(VisualizarPartida ventana) {
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
	
	public VOPartida actualizarPartida (VOJugadorSimple voj) {
		VOPartida partida = null;
		try {
			partida = fachada.verPartidaEnCurso(voj);
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (CodigoIncorrectoException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (NoHayPartidaEnCursoException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
		return partida;
	}
}