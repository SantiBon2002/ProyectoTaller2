package valueObjects;

import java.io.Serializable;
import capaLogica.Pelicula;

public class VOPartidaBase implements Serializable{
	private static final long serialVersionUID = 1L;
	private Pelicula peliculaAAdivinar;
	
	public VOPartidaBase (Pelicula peli) 
	{	peliculaAAdivinar = peli;	}
	
	public Pelicula getPeliculaAAdivinar () 
	{	return peliculaAAdivinar;	}
	
	public void setPeliculaAAdivinar (Pelicula peli) 
	{	peliculaAAdivinar = peli;	}
}
