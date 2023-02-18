package valueObjects;

import java.io.Serializable;

import capaLogica.Pelicula;

public class VOPartida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idPartida;
	private int puntaje;
	private boolean finalizada;
	private boolean acertada;
	private String textoAdivinado;
	private Pelicula peliculaAAdivinar;
	
	public VOPartida (int id, int p, boolean fin, boolean acer, String txt, Pelicula peli) {
		idPartida = id;
		puntaje = p;
		finalizada = fin;
		acertada = acer;
		textoAdivinado = txt;
		peliculaAAdivinar = peli;
	}
	
	public int getIdPartida () 
	{	return idPartida;	}
	
	public int getPuntaje () 
	{	return puntaje;	}
	
	public boolean getFinalizada () 
	{	return finalizada;	}
	
	public boolean getAcertada () 
	{	return acertada;	}
	
	public String getTextoAdivinado () 
	{	return textoAdivinado;	}
	
	public Pelicula getPeliculaAAdivinar () 
	{	return peliculaAAdivinar;	}
	
	public void setIdPartida (int id)
	{	idPartida = id;	}
	
	public void setPuntaje (int punt) 
	{	puntaje = punt;	}
	
	public void setFinalizada (boolean fin) 
	{	finalizada = fin;	}
	
	public void setAcertada (boolean acer) 
	{	acertada = acer;	}
	
	public void setTextoAdivinado (String txt) 
	{	textoAdivinado = txt;	}
	
	public void setPeliculaAAdivinar (Pelicula peli) 
	{	peliculaAAdivinar = peli;	}
}
