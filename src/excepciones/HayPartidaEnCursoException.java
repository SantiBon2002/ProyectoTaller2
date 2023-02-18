package excepciones;

public class HayPartidaEnCursoException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public HayPartidaEnCursoException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
