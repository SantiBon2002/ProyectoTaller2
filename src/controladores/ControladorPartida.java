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
import excepciones.LetraNoPerteneceAlTituloException;
import excepciones.LetraYaAdivinadaException;
import excepciones.NoHayPartidaEnCursoException;
import excepciones.PeliculaIncorrectaException;
import gui.PartidaGui;
import valueObjects.VOJugadorSimple;
import valueObjects.VOPartida;

public class ControladorPartida {
	private ICapaLogica fachada;
	private PartidaGui ventana;
	private VOJugadorSimple voj;
	
	private final String errorCon = "Error de conexion";
	public ControladorPartida(PartidaGui ventana, VOJugadorSimple voj) {
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
			ventana.mensajeError(errorCon, false, false);
		}
		VOPartida aux = null;
		try {
		aux = fachada.verPartidaEnCurso(voj);
		
		} catch (ElementoNoExisteEnDiccException e) {
		ventana.mensajeError(e.getMensaje(), false, false);
		} catch (CodigoIncorrectoException e) {
		ventana.mensajeError(e.getMensaje(), false, false);
		} catch (NoHayPartidaEnCursoException e) {}
		catch (RemoteException e) {
		ventana.mensajeError(errorCon, false, false);
		}
		ventana.setDesc(aux.getPeliculaAAdivinar().getDescripcion());
		actualizarPartida();
		
	}
	
	public void ingresarLetra (String letra) {
		if (letra.length() == 1) {
			try {
				fachada.ingresarLetra(voj, letra.toUpperCase());
				if (fachada.partidaUltimaAcertada(voj.getNombre())) 
					ventana.mensajeError("Lo adivinaste!", true, true);
			} catch (NoHayPartidaEnCursoException e) {
				ventana.mensajeError(e.getMensaje(), false, false);
			} catch (ElementoNoExisteEnDiccException e) {
				ventana.mensajeError(e.getMensaje(), false, false);
			} catch (CodigoIncorrectoException e) {
				ventana.mensajeError(e.getMensaje(), false, false);
			} catch (LetraNoPerteneceAlTituloException e) {
				ventana.mensajeError(e.getMensaje(), false, false);
			} catch (LetraYaAdivinadaException e) {
				ventana.mensajeError(e.getMensaje(), false, false);
			} catch (RemoteException e) {
				ventana.mensajeError(errorCon, false, false);
			}
		} else
			ventana.mensajeError("Solo ingrese una letra", false, false);
		actualizarPartida();
	}
	
	public void arriesgarPelicula (String titulo) {
		try {
			fachada.arriesgarPelicula(voj, titulo.toUpperCase());
			ventana.mensajeError("Lo adivinaste!", true, true);
		} catch (NoHayPartidaEnCursoException e) {
			ventana.mensajeError(e.getMensaje(), false, false);
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false, false);
		} catch (CodigoIncorrectoException e) {
			ventana.mensajeError(e.getMensaje(), false, false);
		} catch (PeliculaIncorrectaException e) {
			ventana.mensajeError(e.getMensaje(), true, false);
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false, false);
		}
		actualizarPartida();
	}
	
	public void actualizarPartida () {
		VOPartida partida = null;
		try {
			partida = fachada.verPartidaEnCurso(voj);
			ventana.actualizarTxtAdivinado(partida.getTextoAdivinado());
			ventana.actualizarPuntaje( ( (Integer)partida.getPuntaje() ).toString() );
		} catch (ElementoNoExisteEnDiccException e) {
			ventana.mensajeError(e.getMensaje(), false, false);
		} catch (CodigoIncorrectoException e) {
			ventana.mensajeError(e.getMensaje(), false, false);
		} catch (NoHayPartidaEnCursoException e) {}
		catch (RemoteException e) {
			ventana.mensajeError(errorCon, false, false);
		}
		
	}
	
}