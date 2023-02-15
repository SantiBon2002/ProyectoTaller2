package pruebas;

import capaLogica.Partida;
import capaLogica.Pelicula;

public class pruebaPartida {
	public static void main(String[] args) {
		Pelicula peli = new Pelicula ("    Hasta    el    ultimo    hombre    ",
				"Pelicula sobre un soldado de la segunda guerra mundial");
		Partida parti = new Partida (123, peli);
		
		System.out.println("Titulo de la pelicula: " + 
				parti.getPeliculaAAdivinar().getTitulo());
		System.out.println("Descripcion: " + 
				parti.getPeliculaAAdivinar().getDescripcion());
		
		System.out.println("ID de la partida: " + parti.getIdPartida());
		System.out.println("Puntaje: " + parti.getPuntaje());
		System.out.println("Finalizada?: " + parti.getFinalizada());
		System.out.println("Acertada?: " + parti.getAcertada());
		System.out.println("Texto adivinado: " + parti.getTextoAdivinado());
		
		parti.agregarLetra('p');
		System.out.println("Texto adivinado: " + parti.getTextoAdivinado());
		
		parti.agregarLetra('a');
		System.out.println("Texto adivinado: " + parti.getTextoAdivinado());
		
		parti.agregarLetra('e');
		System.out.println("Texto adivinado: " + parti.getTextoAdivinado());
		
		parti.agregarLetra('z');
		System.out.println("Texto adivinado: " + parti.getTextoAdivinado());
	}
}
