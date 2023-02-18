package excepciones;

public class LetraYaAdivinadaException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public LetraYaAdivinadaException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}