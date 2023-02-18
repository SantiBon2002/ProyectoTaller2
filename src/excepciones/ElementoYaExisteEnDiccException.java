package excepciones;

public class ElementoYaExisteEnDiccException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public ElementoYaExisteEnDiccException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
