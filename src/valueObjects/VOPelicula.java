package valueObjects;

import java.io.Serializable;

public class VOPelicula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String descripcion;
	
	public VOPelicula(String tit, String desc) {
		super();
		titulo = tit;
		descripcion = desc;
	}
	
	public String getTitulo() 
	{	return titulo;	}
	
	public String getDescripcion() 
	{	return descripcion;	}
	
}