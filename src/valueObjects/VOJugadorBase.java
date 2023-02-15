package valueObjects;

import java.io.Serializable;

public class VOJugadorBase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	public VOJugadorBase (String nom)
	{	nombre = nom;	}
	
	public String getNombre ()
	{	return nombre;	}
}
