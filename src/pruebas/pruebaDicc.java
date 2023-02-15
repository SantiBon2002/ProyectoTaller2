package pruebas;
import java.util.ArrayList;

import capaLogica.DiccJugadores;
import capaLogica.DiccPeliculas;
import capaLogica.Jugador;
import capaLogica.Pelicula;
import valueObjects.VOJugadorListado;
import valueObjects.VOPelicula;

public class pruebaDicc {
	public static void main(String[] args) {
		Jugador j1 = new Jugador ("Pepe", 1);
		Jugador j2 = new Jugador ("Juan", 2);
		Jugador j3 = new Jugador ("Rodri", 3);
		Jugador j4 = new Jugador ("Jose", 4);
		Jugador j5 = new Jugador ("Santi", 5);
		Jugador j6 = new Jugador ("Mauro", 6);
		Jugador j7 = new Jugador ("Facu", 7);
		
		DiccJugadores diccJ = new DiccJugadores();
		diccJ.insert(j1.getNombre(), j1);
		diccJ.insert(j2.getNombre(), j2);
		diccJ.insert(j3.getNombre(), j3);
		diccJ.insert(j4.getNombre(), j4);
		diccJ.insert(j5.getNombre(), j5);
		diccJ.insert(j6.getNombre(), j6);
		diccJ.insert(j7.getNombre(), j7);
		
		ArrayList<VOJugadorListado> arrVOJ = diccJ.listarJugadores();
		
		for (int i = 0; i < arrVOJ.size(); i++) {
			System.out.println("Jugador " + arrVOJ.get(i).getCodigo());
			System.out.println("Nombre: " + arrVOJ.get(i).getNombre());
		}
		
		Pelicula p1 = new Pelicula (" a a ", "aaa");
		Pelicula p2 = new Pelicula ("sdjf kajdhfiuqe jklashdkja    askj ", "aasd d ");
		Pelicula p3 = new Pelicula ("asdhh askjd    ", "sjsdj djdj");
		
		DiccPeliculas diccP = new DiccPeliculas();
		diccP.insert(p1.getTitulo(), p1);
		diccP.insert(p2.getTitulo(), p2);
		diccP.insert(p3.getTitulo(), p3);
		
		ArrayList<VOPelicula> arrVOP = diccP.listarPeliculas();
		
		for (int i = 0; i < arrVOP.size(); i++) {
			System.out.println("Titulo: " + arrVOP.get(i).getTitulo());
			System.out.println("Descripcion: " + arrVOP.get(i).getDescripcion());
		}
	}
}
