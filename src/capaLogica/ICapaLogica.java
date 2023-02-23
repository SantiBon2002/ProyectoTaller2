package capaLogica;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import excepciones.*;
import valueObjects.*;

public interface ICapaLogica extends Remote{

	public void registrarJugador(VOJugadorSimple VOjug) throws RemoteException, ElementoYaExisteEnDiccException, NoAlfanumericoException;
	public ArrayList<VOJugadorListado> listarJugadores() throws RemoteException, DiccionarioVacioException;
	public VOPartida[] listarPartidasDeJugador(String nombre) throws RemoteException, ElementoNoExisteEnDiccException;
	public void registrarPelicula(VOPelicula pel)throws RemoteException, ElementoYaExisteEnDiccException,  NoAlfanumericoException;
	public ArrayList <VOPelicula> listarPeliculas() throws RemoteException, DiccionarioVacioException;
	public void guardarCambios() throws RemoteException, PersistenciaException;
	//public void restaurarInformacion() throws RemoteException;
	//public void login(String nom, int cod) throws RemoteException, ElementoNoExisteEnDiccException;
	public void iniciarPartida(VOJugadorSimple voj) throws RemoteException, HayPartidaEnCursoException, NoHayPeliculasParaAdivinarException, ElementoNoExisteEnDiccException, CodigoIncorrectoException;
	public VOPartida verPartidaEnCurso(VOJugadorSimple voj) throws RemoteException, ElementoNoExisteEnDiccException, CodigoIncorrectoException, NoHayPartidaEnCursoException;
	public void ingresarLetra(VOJugadorSimple voj, String letra) throws RemoteException, LetraYaAdivinadaException, LetraNoPerteneceAlTituloException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException, CodigoIncorrectoException;
	public void arriesgarPelicula(VOJugadorSimple voj, String titulo) throws RemoteException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException, CodigoIncorrectoException;
	public VOJugadorListado[] rankingGeneral() throws RemoteException;
}
