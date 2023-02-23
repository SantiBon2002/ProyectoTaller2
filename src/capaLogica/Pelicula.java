package capaLogica;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String descripcion;
	
	
	public Pelicula (String tit, String desc) {	
		titulo = parsingTitulo(tit);
		descripcion = desc;
	}
	
	public String parsingTitulo (String tit) {
		tit = tit.toUpperCase();
		tit = tit.trim();
		String aux = "" + tit.charAt(0);
		for (int i = 1; i < tit.length(); i++) {
			if (!(tit.charAt(i - 1) == ' ' && tit.charAt(i) == ' '))
				aux = aux + tit.charAt(i);
		}
		tit = aux;
		return tit;
	}
	
	public String getTitulo ()
	{	return titulo;	}
	
	public String getDescripcion ()
	{	return descripcion;	}
	
	public void setTitulo (String tit)
	{	titulo = tit.toUpperCase();	}
	
	public void setDescripcion (String desc)
	{	descripcion = desc;	}
	
	public boolean letraPertenece (String letra)
	{	return titulo.contains(letra);	}
	
	public ArrayList<Integer> getOcurrencias (char letra)
	{
		ArrayList<Integer> ocu = new ArrayList<Integer>();
		
		for (int i = 0; i < titulo.length(); i++)
			if (titulo.charAt(i) == letra) 
				ocu.add(i);
		
		return ocu;
	} 
}
