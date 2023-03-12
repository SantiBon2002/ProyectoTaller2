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
import gui.IniciarNuevaPartida;
import gui.LoginUsuario;
import valueObjects.VOJugadorSimple;

public class ControladorLoginUsuario {
	private ICapaLogica fachada;
	private LoginUsuario ventana;
	
	private final String errorCon = "Error de conexion";
	public ControladorLoginUsuario(LoginUsuario ventana) {
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
	
	public void loginUsuario (VOJugadorSimple voj) {
		try {
			fachada.login(voj);
			ventana.setVisible(false);
			IniciarNuevaPartida iniciar = new IniciarNuevaPartida();
			ControladorIniciarNuevaPartida cIniciar = new ControladorIniciarNuevaPartida(iniciar, voj);
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (CodigoIncorrectoException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
	}
}