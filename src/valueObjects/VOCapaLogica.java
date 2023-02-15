package valueObjects;

import java.io.Serializable;

import capaLogica.DiccJugadores;
import capaLogica.DiccPeliculas;

public class VOCapaLogica implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private DiccJugadores diccJ;
	private DiccPeliculas diccP;
	
	public VOCapaLogica (DiccJugadores diccJ, DiccPeliculas diccP) {
		diccJ = new DiccJugadores();
		diccP = new DiccPeliculas();
	}
	
	public DiccJugadores getDiccJugadores () 
	{	return diccJ;	}
	
	public DiccPeliculas getDiccPeliculas () 
	{	return diccP;	}
}