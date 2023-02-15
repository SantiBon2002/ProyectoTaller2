package valueObjects;

import java.io.Serializable;

public class VOJugadorListado extends VOJugadorSimple implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int puntajeTotal;
	private int cantPelisAcertadas;
	private int cantPelisErradas;
	
	public VOJugadorListado (String nom, int cod, int p, int cpa, int cpe) {
		super(nom, cod);
		puntajeTotal = p;
		cantPelisAcertadas = cpa;
		cantPelisAcertadas = cpe;
	}
	
	public int getPuntajeTotal () 
	{	return puntajeTotal;	}
	
	public int getCantPelisAcertadas () 
	{	return cantPelisAcertadas;	}
	
	public int getCantPelisErradas () 
	{	return cantPelisErradas;	}
}
