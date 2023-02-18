package capaLogica;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import excepciones.*;
import valueObjects.*;
import persistencia.PersistenciaDeDatos;

import java.util.ArrayList;
import java.util.Properties;

public class CapaLogica extends UnicastRemoteObject implements ICapaLogica{
	
	private static final long serialVersionUID = 1L;
	private DiccJugadores diccJ;
	private DiccPeliculas diccP;
	private Monitor monitor;
	
	public static boolean esAlfaNumerico(String s) {
		return s != null && s.matches("^[a-zA-Z0-9]*$");
	}
	
	
 	public CapaLogica() throws RemoteException,IOException
	{
		PersistenciaDeDatos dx = new PersistenciaDeDatos();
		Properties p = new Properties();
		String nomArch;
		VOCapaLogica aux;
		
		try {
			p.load(new FileInputStream("config/configuracion.properties"));
			nomArch = p.getProperty("nombreArchivo");
			aux = dx.recuperar(nomArch);
			
			if (aux != null) {
				diccJ = aux.getDiccJugadores();
				diccP = aux.getDiccPeliculas();
			} else {
				diccJ = new DiccJugadores();
				diccP = new DiccPeliculas();
			}
		} catch (FileNotFoundException e) {
			diccJ = new DiccJugadores();
			diccP = new DiccPeliculas();
		}
		
		// --SOLO PARA LAS PRUEBAS--
		//diccJ = new DiccJugadores();
		//diccP = new DiccPeliculas();
		// -------------------------
		monitor = new Monitor();
	}
	
	public void registrarJugador(VOJugadorSimple VOjug) throws RemoteException, ElementoYaExisteEnDiccException, NoAlfanumericoException
	{
		String nombre = VOjug.getNombre();
		int codigo = VOjug.getCodigo();
		Jugador j;
		if(diccJ.member(nombre))
			throw new ElementoYaExisteEnDiccException("Error: El jugador ya existe en el sistema.");
		else if(!(esAlfaNumerico(nombre))) 
			throw new NoAlfanumericoException("Error: El nombre solo debe contener caracteres alfanumericos.");
		else {
			j = new Jugador(nombre, codigo);
			monitor.comienzoEscritura();
			diccJ.insert(j.getNombre(), j);
			monitor.terminoEscritura();
		}
	}
	
	public ArrayList <VOJugadorListado> listarJugadores () throws RemoteException, DiccionarioVacioException
	{
		ArrayList <VOJugadorListado> arrJugListado = null;
		monitor.comienzoLectura();
		if (diccJ.empty()) {
			throw new DiccionarioVacioException("Error: El diccionario esta vacio");}
		else {
			arrJugListado = diccJ.listarJugadores();
		}
		
		monitor.terminoLectura();
		return arrJugListado;
	}
	/*
	public VOPartida listarPartidasDeJugadror(String nombre) throws RemoteException, JugadorNoExisteException
	{
		
	}
	
	public void registrarPelicula(VOPelicula pel)throws RemoteException, ExistePeliculaMismoTituloException,TieneCaracterAlfanumericoException
	{
		
	}
	
	public VOPelicula listarPeliculas()throws RemoteException,NoHayPeliculasException
	{
		
	}
	
	public void guardarCambios()throws RemoteException
	{
		//monitor.comienzoLectura();
		VOCapaLogica voc = new VOCapaLogica(diccJ,diccP);
		PersistenciaDeDatos dx = new PersistenciaDeDatos();
		Properties p = new Properties();
		String nomArch = " ";
		try {
			p.load(new FileInputStream(nomArch));
			String archivo = p.getProperty("nombreArchivo");
			dx.respaldar(archivo, voc);
			//monitor.terminoLectura();
		}
		catch(IOException e){
			//monitor.terminoLectura();
			throw new PersistenciaException("Error al respaldar");
		}
	}
	
	public void restaurarInformacion()throws RemoteException
	{
		
	}
	
	public void login(String nom, int cod)throws RemoteException, JugadorNoExisteException
	{
		
	}
	
	public void iniciarPartida(String nom, int cod)throws RemoteException, NoExistePartidaCursoException, NoQuedanPelisPorAdivinarException, JugadorNoExisteException
	{
		
	}
	
	public VOPartida verPartidaEnCurso(String nom, int cod)throws RemoteException, JugadorNoExisteException
	{
		
	}
	
	public String ingresarLetra(String nom, int cod)throws RemoteException, LetraYaAdivinadaException, LetraNoPerteneceTituloException, NoExistePartidaCursoException, JugadorNoExisteException
	{
		
	}
	
	public void arriesgarPelicula(String nom, int cod)throws RemoteException, NoExistePartidaCursoException, JugadorNoExisteException
	{
		
	}
	
	public VOJugadorListado rankingGeneral()throws RemoteException
	{
		
	}
*/
}