package excepciones;

public class NoAlfanumericoException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public NoAlfanumericoException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
