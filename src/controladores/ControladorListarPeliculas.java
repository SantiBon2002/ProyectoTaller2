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
import gui.ListarPeliculas;
import valueObjects.VOPelicula;

public class ControladorListarPeliculas {
	private ICapaLogica fachada;
	private ListarPeliculas ventana;
	
	private final String errorCon = "Error de conexion";
	public ControladorListarPeliculas(ListarPeliculas ventana) {
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
	
	public ArrayList <VOPelicula> listarPeliculas () {
		ArrayList <VOPelicula> pelis = null;
		try {
			pelis = fachada.listarPeliculas();
		} catch (DiccionarioVacioException e) {
			ventana.mensajeError(e.getMensaje(), false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
		return pelis;
	}
}