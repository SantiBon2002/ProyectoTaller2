package excepciones;

public class NoHayPeliculasParaAdivinarException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public NoHayPeliculasParaAdivinarException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
