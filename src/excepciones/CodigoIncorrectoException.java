package excepciones;

public class CodigoIncorrectoException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public CodigoIncorrectoException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
