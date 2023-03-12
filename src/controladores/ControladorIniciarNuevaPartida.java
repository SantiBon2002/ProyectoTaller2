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
import excepciones.HayPartidaEnCursoException;
import excepciones.NoHayPeliculasParaAdivinarException;
import gui.IniciarNuevaPartida;
import gui.PartidaGui;
import valueObjects.VOJugadorSimple;

public class ControladorIniciarNuevaPartida {
	private ICapaLogica fachada;
	private IniciarNuevaPartida ventana;
	private VOJugadorSimple voj;
	
	private final String errorCon = "Error de conexion";
	public ControladorIniciarNuevaPartida(IniciarNuevaPartida ventana, VOJugadorSimple voj) {
		this.ventana = ventana;
		this.ventana.setControlador(this);
		this.voj = voj;
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
	
	public void iniciarPartida () {
		try {
			fachada.iniciarPartida(voj);
			PartidaGui parti = new PartidaGui();
			ControladorPartida cParti = new ControladorPartida(parti, voj);
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (CodigoIncorrectoException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (NoHayPeliculasParaAdivinarException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (HayPartidaEnCursoException e) {
			PartidaGui parti = new PartidaGui();
			ControladorPartida cParti = new ControladorPartida(parti, voj);
			//ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
	}
}