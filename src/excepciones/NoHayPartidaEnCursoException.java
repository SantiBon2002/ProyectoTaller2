package excepciones;

public class NoHayPartidaEnCursoException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public NoHayPartidaEnCursoException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}