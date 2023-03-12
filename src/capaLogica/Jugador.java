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
		partidasJugadas = new SecPartidas();
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
	
	public SecPartidas getSecPartidas ()
	{	return partidasJugadas;	}
	
	public VOPartida[] getPartidasJugadas () 
	{	return partidasJugadas.getVOPartidas();	}
	
	public Partida getFirstPartida ()
	{	return partidasJugadas.getFirst();	}
	
	public void addPartida (Partida p)
	{	partidasJugadas.insert(p);	}
	
	public int cantPartidas ()
	{	return partidasJugadas.tamanio();	}
	
	public boolean tienePartidas ()
	{	return !(partidasJugadas.empty());	}
	
	public boolean tienePartidaEnCurso () {	
		if (partidasJugadas.empty())
			return false;
		else
			return partidasJugadas.partidaEnCurso();
	}
	public void finPartida(boolean a) {
		partidasJugadas.getFirst().setFinalizada(true);
		partidasJugadas.getFirst().setAcertada(a);
		if (a)
			cantPelisAcertadas += 1;
		else
			cantPelisErradas += 1;
		puntajeTotal += partidasJugadas.getFirst().getPuntaje();
	}
}
