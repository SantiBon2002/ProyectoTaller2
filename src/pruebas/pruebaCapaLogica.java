package pruebas;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import valueObjects.*;
import excepciones.*;

import capaLogica.*;
public class pruebaCapaLogica {
	public static void main(String[] args) {
		
		CapaLogica cl = null;
		
		try {
			cl = new CapaLogica();
		} catch (RemoteException e) {}
		catch (IOException e) {}
		/*
		ArrayList <VOJugadorListado> listarJ = new ArrayList <VOJugadorListado>();
		try {
			listarJ = cl.listarJugadores();
			for (int i = 0; i < listarJ.size(); i++) {
				System.out.println("<<<< Jugador Nro. " + listarJ.get(i).getCodigo() + " >>>>");
				System.out.println("Nombre: " + listarJ.get(i).getNombre());
				System.out.println("Puntaje: " + listarJ.get(i).getPuntajeTotal());
				System.out.println("Peliculas acertadas: " + listarJ.get(i).getCantPelisAcertadas());
				System.out.println("Peliculas erradas: " + listarJ.get(i).getCantPelisErradas());
			}
		} catch (DiccionarioVacioException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		ArrayList <VOPelicula> listarPelis = new ArrayList <VOPelicula>();
		try {
			listarPelis = cl.listarPeliculas();
			for (int j = 0; j < listarPelis.size(); j++) {
				System.out.println("Titulo: " + listarPelis.get(j).getTitulo());
				System.out.println("Descripcion: " + listarPelis.get(j).getDescripcion());
			}
		} catch (DiccionarioVacioException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		VOJugadorListado[] ranking = null;
		try {
			ranking = cl.rankingGeneral();
			for (int i = 0; i < ranking.length; i++) {
				System.out.println("<<<< Jugador Nro. " + ranking[i].getCodigo() + " >>>>");
				System.out.println("Nombre: " + ranking[i].getNombre());
				System.out.println("Puntaje: " + ranking[i].getPuntajeTotal());
				System.out.println("Peliculas acertadas: " + ranking[i].getCantPelisAcertadas());
				System.out.println("Peliculas erradas: " + ranking[i].getCantPelisErradas());
			}
		} catch (RemoteException e) {}
		/*/
		VOJugadorSimple voj1 = new VOJugadorSimple("pepe", 1);
		VOJugadorSimple voj2 = new VOJugadorSimple("pipo", 2);
		VOJugadorSimple voj3 = new VOJugadorSimple("pepo", 3);
		VOJugadorSimple voj4 = new VOJugadorSimple("epep", 4);
		
		ArrayList <VOJugadorListado> listarJ = new ArrayList <VOJugadorListado>();
		
		try {
			cl.registrarJugador(voj1);
			System.out.println("Registrado");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		try {
			cl.registrarJugador(voj2);
			System.out.println("Registrado");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		try {
			cl.registrarJugador(voj3);
			System.out.println("Registrado");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		try {
			cl.registrarJugador(voj4);
			System.out.println("Registrado");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		try {
			listarJ = cl.listarJugadores();
			for (int i = 0; i < listarJ.size(); i++) {
				System.out.println("<<<< Jugador Nro. " + listarJ.get(i).getCodigo() + " >>>>");
				System.out.println("Nombre: " + listarJ.get(i).getNombre());
				System.out.println("Puntaje: " + listarJ.get(i).getPuntajeTotal());
				System.out.println("Peliculas acertadas: " + listarJ.get(i).getCantPelisAcertadas());
				System.out.println("Peliculas erradas: " + listarJ.get(i).getCantPelisErradas());
			}
		} catch (DiccionarioVacioException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		VOPelicula vop1 = new VOPelicula("   Sancho    panza   ", "pipiripi");
		VOPelicula vop2 = new VOPelicula("   shrek    1", "paparapa");
		VOPelicula vop3 = new VOPelicula("   Cars    1", "peperepe");
		VOPelicula vop4 = new VOPelicula("   Toy    Story   1  ", "poporopo");
		
		try {
			cl.registrarPelicula(vop1);
			System.out.println("Peli registrada");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		try {
			cl.registrarPelicula(vop2);
			System.out.println("Peli registrada");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		try {
			cl.registrarPelicula(vop3);
			System.out.println("Peli registrada");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		try {
			cl.registrarPelicula(vop4);
			System.out.println("Peli registrada");
		} catch (ElementoYaExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (NoAlfanumericoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		ArrayList <VOPelicula> listarPelis = new ArrayList <VOPelicula>();
		try {
			listarPelis = cl.listarPeliculas();
			for (int j = 0; j < listarPelis.size(); j++) {
				System.out.println("Titulo: " + listarPelis.get(j).getTitulo());
				System.out.println("Descripcion: " + listarPelis.get(j).getDescripcion());
			}
		} catch (DiccionarioVacioException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		try {
			cl.iniciarPartida(voj1);
			System.out.println("PartidaIniciada");
		} catch (HayPartidaEnCursoException e) {
			System.out.println(e.getMensaje());
		} catch (NoHayPeliculasParaAdivinarException e) {
			System.out.println(e.getMensaje());
		} catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (CodigoIncorrectoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}

		cl.finalizarParida(voj1.getNombre(), 0);
		
		try {
			cl.iniciarPartida(voj1);
			System.out.println("PartidaIniciada");
		} catch (HayPartidaEnCursoException e) {
			System.out.println(e.getMensaje());
		} catch (NoHayPeliculasParaAdivinarException e) {
			System.out.println(e.getMensaje());
		} catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (CodigoIncorrectoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		cl.finalizarParida(voj1.getNombre(), 1);
		
		try {
			cl.iniciarPartida(voj1);
			System.out.println("PartidaIniciada");
		} catch (HayPartidaEnCursoException e) {
			System.out.println(e.getMensaje());
		} catch (NoHayPeliculasParaAdivinarException e) {
			System.out.println(e.getMensaje());
		} catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (CodigoIncorrectoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		cl.finalizarParida(voj1.getNombre(), 2);
		
		try {
			cl.iniciarPartida(voj1);
			System.out.println("PartidaIniciada");
		} catch (HayPartidaEnCursoException e) {
			System.out.println(e.getMensaje());
		} catch (NoHayPeliculasParaAdivinarException e) {
			System.out.println(e.getMensaje());
		} catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (CodigoIncorrectoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		cl.finalizarParida(voj1.getNombre(), 3);
		
		try {
			cl.iniciarPartida(voj1);
			System.out.println("PartidaIniciada");
		} catch (HayPartidaEnCursoException e) {
			System.out.println(e.getMensaje());
		} catch (NoHayPeliculasParaAdivinarException e) {
			System.out.println(e.getMensaje());
		} catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (CodigoIncorrectoException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		VOPartida[] partidas;
		try {
			partidas = cl.listarPartidasDeJugador(voj1.getNombre());
			System.out.println("Partida para listar");
			for (int i = 0; i < partidas.length; i++) {
				System.out.println("ID: " + partidas[i].getIdPartida());
				System.out.println("Pelicula a adivinar: " + partidas[i].getPeliculaAAdivinar().getTitulo());
			}
		}  catch (ElementoNoExisteEnDiccException e) {
			System.out.println(e.getMensaje());
		} catch (RemoteException e) {}
		
		VOJugadorListado[] ranking = null;
		try {
			ranking = cl.rankingGeneral();
			for (int i = 0; i < ranking.length; i++) {
				System.out.println("<<<< Jugador Nro. " + ranking[i].getCodigo() + " >>>>");
				System.out.println("Nombre: " + ranking[i].getNombre());
				System.out.println("Puntaje: " + ranking[i].getPuntajeTotal());
				System.out.println("Peliculas acertadas: " + ranking[i].getCantPelisAcertadas());
				System.out.println("Peliculas erradas: " + ranking[i].getCantPelisErradas());
			}
		} catch (RemoteException e) {}
		
		try {
			cl.guardarCambios();
			System.out.println("datos Guardados");
		} catch (RemoteException e) {}
		catch (PersistenciaException e) { 
			System.out.println(e.getMensaje());
		}
	}
}
