package valueObjects;
public class VOJugadorSimple extends VOJugadorBase {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	
	public VOJugadorSimple (String nom, int cod) {
		super(nom);
		codigo = cod;
	}
	
	public int getCodigo ()
	{	return codigo;	}
}
