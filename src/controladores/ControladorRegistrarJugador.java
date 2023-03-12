package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.ElementoYaExisteEnDiccException;
import excepciones.NoAlfanumericoException;
import gui.RegistrarJugador;
import valueObjects.VOJugadorSimple;

public class ControladorRegistrarJugador {
	private ICapaLogica fachada;
	private RegistrarJugador ventana;
	
	private final String errorCon = "Error de conexion";
	private final String exito = "Ingresado correctamente";
	
	public ControladorRegistrarJugador(RegistrarJugador ventana) {
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
	
	public void registrarJugador(VOJugadorSimple voj) {
		try {
			fachada.registrarJugador(voj);
			ventana.mensajeError(exito, true);
		}
		catch(ElementoYaExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false);
		}
		catch(NoAlfanumericoException e) {
			ventana.mensajeError(e.getMensaje(), false);
		}
		catch(RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
	}
	
	
}
