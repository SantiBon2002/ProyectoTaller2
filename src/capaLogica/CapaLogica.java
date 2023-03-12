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
	private static CapaLogica instancia;
	private DiccJugadores diccJ;
	private DiccPeliculas diccP;
	private Monitor monitor;
	
 	private CapaLogica() throws RemoteException, IOException
	{
		PersistenciaDeDatos dx = new PersistenciaDeDatos();
		Properties p = new Properties();
		String nomArch;
		VOCapaLogica aux;
		
		try {
			p.load(new FileInputStream("src/config/config.properties"));
			nomArch = p.getProperty("archivoDeDatos");
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
		
		monitor = new Monitor();
	}
 	
 	public static CapaLogica getInstancia() throws RemoteException, IOException
 	{
	 	if (instancia == null)
	 		instancia = new CapaLogica();
	 	return instancia;
 	}
 	
 	public boolean esAlfanumerico(String s) {
		return s != null && s.matches("^[a-zA-Z0-9 ]*$");
	}
	
	public void registrarJugador(VOJugadorSimple VOjug) throws RemoteException, ElementoYaExisteEnDiccException, NoAlfanumericoException
	{
		String nombre = VOjug.getNombre();
		int codigo = VOjug.getCodigo();
		Jugador j;
		if(diccJ.member(nombre))
			throw new ElementoYaExisteEnDiccException("Error: El jugador ya existe en el sistema.");
		else if(!(esAlfanumerico(nombre))) 
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
		if (diccJ.empty())
			throw new DiccionarioVacioException("Error: El diccionario esta vacio");
		
		else {
			monitor.comienzoLectura();
			arrJugListado = diccJ.listarJugadores();
			monitor.terminoLectura();
		}
		
		return arrJugListado;
	}
	
	public VOPartida[] listarPartidasDeJugador(String nombre) throws RemoteException, ElementoNoExisteEnDiccException
	{
		VOPartida[] partidas;
		if (!diccJ.member(nombre))
			throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado.");
		
		else {
			monitor.comienzoLectura();
			partidas = diccJ.find(nombre).getPartidasJugadas();
			monitor.terminoLectura();
		}
		return partidas;
	}
	
	public void finalizarPartida (String nom, boolean a) {
		diccJ.find(nom).finPartida(a);
	}
	
	public void registrarPelicula(VOPelicula pel)throws RemoteException, ElementoYaExisteEnDiccException,NoAlfanumericoException
	{
		String titulo = pel.getTitulo();
		String desc = pel.getDescripcion();
		Pelicula p = new Pelicula(titulo, desc);
		if(diccP.member(p.getTitulo()))
			throw new ElementoYaExisteEnDiccException("Error : La pelicula ya existe en el sistema");
		else
		{
			if(!(esAlfanumerico(titulo))){
				throw new NoAlfanumericoException("Error: El nombre solo debe contener caracteres alfanumericos.");
			}
			else
			{
				monitor.comienzoEscritura();
				diccP.insert(p.getTitulo(), p);
				monitor.terminoEscritura();
			}
		}
	}
	
	public ArrayList <VOPelicula> listarPeliculas() throws RemoteException, DiccionarioVacioException
	{
		ArrayList <VOPelicula> listarPelis = null;
		if (diccP.empty())
			throw new DiccionarioVacioException("No hay peliculas ingresadas");
		
		else {
			monitor.comienzoLectura();
			listarPelis = diccP.listarPeliculas();
			monitor.terminoLectura();
		}
		
		return listarPelis;
	}
	
	public void guardarCambios() throws RemoteException, PersistenciaException
	{
		monitor.comienzoLectura();
		VOCapaLogica voc = new VOCapaLogica(diccJ,diccP);
		PersistenciaDeDatos dx = new PersistenciaDeDatos();
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("src/config/config.properties"));
			String nomArch = p.getProperty("archivoDeDatos");
			dx.respaldar(nomArch, voc);
			monitor.terminoLectura();
		}
		catch(IOException e){
			monitor.terminoLectura();
			throw new PersistenciaException("Error al respaldar");
		}
	}
	
	public void login(VOJugadorSimple voj)throws RemoteException, ElementoNoExisteEnDiccException, CodigoIncorrectoException
	{
		String nom = voj.getNombre();
		int cod = voj.getCodigo();
		
		if ( !(diccJ.member(nom)) ) 
			throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado.");
		
		else if (diccJ.find(nom).getCodigo() != cod)
				throw new CodigoIncorrectoException("Error: el codigo del jugador no coincide.");
	}
	
	public void iniciarPartida (VOJugadorSimple voj) throws RemoteException, HayPartidaEnCursoException, NoHayPeliculasParaAdivinarException, ElementoNoExisteEnDiccException, CodigoIncorrectoException
	{
		String nom = voj.getNombre();
		int cod = voj.getCodigo();
		
		if ( !(diccJ.member(nom)) ) 
			throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado.");
		
		else {
			Jugador jug = diccJ.find(nom);
			if (jug.getCodigo() != cod)
				throw new CodigoIncorrectoException("Error: el codigo del jugador no coincide.");
			
			else if (jug.tienePartidaEnCurso())
				throw new HayPartidaEnCursoException("Error: el jugador aun esta jugando una partida.");
			
			else if (jug.cantPartidas() == diccP.largo())
				throw new NoHayPeliculasParaAdivinarException("Error: no hay mas peliculas para adivinar.");
			
			else {
				int num;
				String[] titulosJugados = jug.getSecPartidas().getTitulosPartida();
				String[] titulos = diccP.getTitulos();
				ArrayList<String> titulosDisp = new ArrayList<String>();
				boolean esta;
				int j;
				for (int i = 0; i < titulos.length; i++) {
					j = 0;
					esta = false;
					while (!esta && j < titulosJugados.length && titulosJugados != null) {
						if (titulos[i] == titulosJugados[j])
							esta = true;
						j++;
					} 
					if (!esta)
						titulosDisp.add(titulos[i]);
				}
				
				num = (int) (Math.random() * titulosDisp.size());
				
				Partida nuevaPartida = new Partida(jug.cantPartidas(), diccP.find(titulosDisp.get(num)));
				jug.addPartida(nuevaPartida);
			}
		}
			
	}
	
	public VOPartida verPartidaEnCurso (VOJugadorSimple voj) throws RemoteException, ElementoNoExisteEnDiccException, CodigoIncorrectoException, NoHayPartidaEnCursoException
	{
		String nom = voj.getNombre();
		int cod = voj.getCodigo();
		VOPartida vop = null;
		
		if (!diccJ.member(nom))
			throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado");
		else {
			Jugador jug = diccJ.find(nom);
			if (jug.getCodigo() != cod)
				throw new CodigoIncorrectoException("Error: el codigo del jugador no coincide.");
			
			else if (!jug.tienePartidaEnCurso()) 
				throw new NoHayPartidaEnCursoException("Error: el jugador no tiene ninguna partida en curso.");
			
			else {
				Partida aux = diccJ.find(nom).getFirstPartida();
				vop = new VOPartida(aux.getPeliculaAAdivinar(), aux.getIdPartida(), aux.getPuntaje(), aux.getFinalizada(), aux.getAcertada(), aux.getTextoAdivinado());
			}
		}
		
		return vop;
	}
	
	public boolean partidaUltimaAcertada(String nom) throws RemoteException
	{
		return diccJ.find(nom).getFirstPartida().getAcertada();
	}
	
	public void ingresarLetra (VOJugadorSimple voj, String letra) throws RemoteException, LetraYaAdivinadaException, LetraNoPerteneceAlTituloException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException, CodigoIncorrectoException
	{
		String nom = voj.getNombre();
		int cod = voj.getCodigo();
		
		if (!diccJ.member(nom))
		{	throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado");	}
		else {
			Jugador jug = diccJ.find(nom);
			if (jug.getCodigo() != cod)
			{	throw new CodigoIncorrectoException("Error: el codigo del jugador no coincide.");	}
			else if (!jug.tienePartidaEnCurso()) 
			{	throw new NoHayPartidaEnCursoException("Error: el jugador no tiene ninguna partida en curso.");	}
			else if (!jug.getFirstPartida().getPeliculaAAdivinar().letraPertenece(letra)) {
				jug.getFirstPartida().susCinco();
				throw new LetraNoPerteneceAlTituloException("La letra ingresada no pertenece al titulo");
			}
			else if (jug.getFirstPartida().letraYaAdivinada(letra))
			{	throw new LetraYaAdivinadaException("La letra ya fue adivinada anteriormente");	}
			else {
				jug.getFirstPartida().addCinco();
				jug.getFirstPartida().agregarLetra(letra.charAt(0));
				if (jug.getFirstPartida().getPeliculaAAdivinar().getTitulo().equals(jug.getFirstPartida().getTextoAdivinado())) {
					finalizarPartida(jug.getNombre(), true);
				}
			}
		}
	}
	
	public void arriesgarPelicula (VOJugadorSimple voj, String titulo) throws RemoteException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException, CodigoIncorrectoException, PeliculaIncorrectaException
	{
		String nom = voj.getNombre();
		int cod = voj.getCodigo();
		
		if (!diccJ.member(nom))
			throw new ElementoNoExisteEnDiccException("Error: no existe un jugador con el nombre ingresado");
		else {
			Jugador jug = diccJ.find(nom);
			if (jug.getCodigo() != cod)
				throw new CodigoIncorrectoException("Error: el codigo del jugador no coincide.");
			
			else if (!jug.tienePartidaEnCurso()) 
				throw new NoHayPartidaEnCursoException("Error: el jugador no tiene ninguna partida en curso.");
			
			else if (!jug.getFirstPartida().getPeliculaAAdivinar().getTitulo().equals(titulo)) {
				jug.getFirstPartida().susCien();
				finalizarPartida(nom, false);
				throw new PeliculaIncorrectaException("Pifiaste");
			}
			else {
				jug.getFirstPartida().addCien();
				jug.getFirstPartida().setTextoAdivinado(jug.getFirstPartida().getPeliculaAAdivinar().getTitulo());
				finalizarPartida(jug.getNombre(), true);
			}
		}
	}
	
	public VOJugadorListado[] rankingGeneral()throws RemoteException
	{
		return diccJ.rankingGeneral();
		/*ArrayList<VOJugadorListado> jugadores = diccJ.listarJugadores();
		VOJugadorListado[] ranking = new VOJugadorListado[jugadores.size()];
		
		ranking[0] = jugadores.get(0);
		int j;
		boolean insertado;
		for (int i = 1; i < jugadores.size(); i++) {
			j = 0;
			insertado = false;
			while (ranking[j] != null && j < ranking.length && !insertado) {
				if (jugadores.get(i).getPuntajeTotal() > ranking[j].getPuntajeTotal()) {
					for (int k = ranking.length - 2; k >= j; k--) 
						ranking[k + 1] = ranking[k];
					ranking[j] = jugadores.get(i);
					insertado = true;
				}
				j++;
			}
			if (ranking[j] == null)
				ranking[j] = jugadores.get(i);
		}
		return ranking;*/
	}

}