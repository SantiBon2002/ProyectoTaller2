package capaLogica;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import excepciones.*;
import valueObjects.*;

public interface ICapaLogica extends Remote{

	public void registrarJugador(VOJugadorSimple VOjug) throws RemoteException, ElementoYaExisteEnDiccException, NoAlfanumericoException;
	public ArrayList<VOJugadorListado> listarJugadores() throws RemoteException, DiccionarioVacioException;
	/*public VOPartida listarPartidasDeJugadror(String nombre) throws RemoteException, ElementoNoExisteEnDiccException;
	public void registrarPelicula(VOPelicula pel)throws RemoteException, ElementoYaExisteEnDiccException,  NoAlfanumericoException;
	public VOPelicula listarPeliculas() throws RemoteException, DiccionarioVacioException;
	public void guardarCambios() throws RemoteException;
	public void restaurarInformacion() throws RemoteException;
	public void login(String nom, int cod) throws RemoteException, ElementoNoExisteEnDiccException;
	public void iniciarPartida(String nom, int cod) throws RemoteException, HayPartidaEnCursoException, NoHayPeliculasParaAdivinarException, ElementoNoExisteEnDiccException;
	public VOPartida verPartidaEnCurso(String nom, int cod) throws RemoteException, ElementoNoExisteEnDiccException;
	public String ingresarLetra(String nom, int cod) throws RemoteException, LetraYaAdivinadaException, LetraNoPerteneceAlTituloException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException;
	public void arriesgarPelicula(String nom, int cod) throws RemoteException, NoHayPartidaEnCursoException, ElementoNoExisteEnDiccException;
	public VOJugadorListado rankingGeneral() throws RemoteException;*/
}
