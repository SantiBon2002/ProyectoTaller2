package valueObjects;

import java.io.Serializable;

public class VOJugadorSimple extends VOJugadorBase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	
	public VOJugadorSimple (String nom, int cod) {
		super(nom);
		codigo = cod;
	}
	
	public int getCodigo ()
	{	return codigo;	}
}
