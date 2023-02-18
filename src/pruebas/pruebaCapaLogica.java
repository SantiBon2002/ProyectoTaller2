package pruebas;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import valueObjects.*;
import excepciones.*;

import capaLogica.*;
public class pruebaCapaLogica {
	public static void main(String[] args) {
		/*CapaLogica cl = new CapaLogica();
		
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
		*/
	}
}
