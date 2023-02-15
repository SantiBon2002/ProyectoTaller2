package capaLogica;

import java.io.Serializable;

import valueObjects.VOPartida;

public class Jugador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int codigo;
	private int puntajeTotal;
	private int cantPelisAcertadas;
	private int cantPelisErradas;
	private SecPartidas partidasJugadas;
	
	
	public Jugador(String nom, int cod) {
		nombre = nom;
		codigo = cod;
		puntajeTotal = 0;
		cantPelisAcertadas = 0;
		cantPelisErradas = 0;
	}
	public String getNombre() 
	{	return nombre;	}
	
	public int getCodigo () 
	{	return codigo;	}
	
	public int getPuntajeTotal () 
	{	return puntajeTotal;	}
	
	public int getCantPelisAcertadas () 
	{	return cantPelisAcertadas;	}
	
	public int getCantPelisErradas () 
	{	return cantPelisErradas;	}
	
	public VOPartida[] getPartidasJugadas () 
	{	return partidasJugadas.getVOPartidas();	}
}
