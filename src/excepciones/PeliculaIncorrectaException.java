package excepciones;

public class PeliculaIncorrectaException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public PeliculaIncorrectaException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
