package excepciones;

public class ElementoNoExisteEnDiccException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public ElementoNoExisteEnDiccException (String msg)
	{
		mensaje = msg;
	}
	public String getMensaje() 
	{
		return mensaje;
	}
}
