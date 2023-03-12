package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.PersistenciaException;
import gui.MenuAdmin;

public class ControladorMenuAdmin {
	private MenuAdmin ventana;
	private ICapaLogica fachada;
	private final String errorCon = "Error de conexion";
	private final String exito = "Exito";
	
	public ControladorMenuAdmin(MenuAdmin ventana) {
		this.ventana = ventana;
		this.ventana.setVisible(true);
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
	
	public void guardarCambios() {
		try {
			fachada.guardarCambios();
			ventana.mensajeError(exito,true);
		}
		catch(RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		catch(PersistenciaException e) {
			ventana.mensajeError(e.getMensaje(), false);
		}
		}
}
