package excepciones;

public class LetraNoPerteneceAlTituloException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public LetraNoPerteneceAlTituloException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
