package capaLogica;

import java.io.Serializable;
import java.util.ArrayList; 

public class Partida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idPartida;
	private int puntaje;
	private boolean finalizada;
	private boolean acertada;
	private String textoAdivinado;
	private Pelicula peliculaAAdivinar;
	
	public Partida (int id, Pelicula peli) {
		idPartida = id;
		puntaje = 0;
		finalizada = false;
		acertada = false;
		textoAdivinado = "";
		peliculaAAdivinar = peli;
		
		for(int i = 0; i < peliculaAAdivinar.getTitulo().length(); i++)
			if (peliculaAAdivinar.getTitulo().charAt(i) == ' ') 
				textoAdivinado += " ";
			else
				textoAdivinado += "_";
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
	
	public void setFinalizada (boolean fin) 
	{	finalizada = fin;	}
	
	public void setAcertada (boolean acer) 
	{	acertada = acer;	}
	
	public void setTextoAdivinado (String txt) 
	{	textoAdivinado = txt;	}
	
	public void setPeliculaAAdivinar (Pelicula peli) 
	{	peliculaAAdivinar = peli;	}
	
	public void addCinco () 
	{	puntaje += 5;	}
	
	public void addCien () 
	{	puntaje += 100;	}
	
	public void susCinco () 
	{	puntaje -= 5;	}
	
	public void susCien () 
	{	puntaje -= 100;	}
	
	public boolean letraYaAdivinada (String letra)
	{	return textoAdivinado.contains(letra);	}
	
	public void agregarLetra (char letra)
	{	
		letra = Character.toUpperCase(letra);
		ArrayList<Integer> ocu = new ArrayList<Integer>();
		ocu = peliculaAAdivinar.getOcurrencias(letra);
		char[] auxCharArray = textoAdivinado.toCharArray();
		
		for (int i = 0; i < ocu.size(); i++)
			auxCharArray[ocu.get(i)] = letra;

		textoAdivinado = String.valueOf(auxCharArray);
	}
}
