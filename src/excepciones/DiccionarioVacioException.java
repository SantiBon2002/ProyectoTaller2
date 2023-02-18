package excepciones;

public class DiccionarioVacioException extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public DiccionarioVacioException(String m)
	{
		msg = m;
	}
	public String getMensaje() {
		return msg;
	}
	
}
