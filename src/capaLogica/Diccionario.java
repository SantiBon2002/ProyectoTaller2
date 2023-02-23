package capaLogica;

import java.io.Serializable;
import java.util.TreeMap;

public class Diccionario <K,T> implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	protected TreeMap <K,T> arbol;
	
	public Diccionario ()
	{	arbol = new TreeMap<K, T>();}
	
	public boolean empty ()
	{	return arbol.isEmpty();	}
	
	public boolean member (K clave)
	{ return arbol.containsKey(clave); 	}
	
	public T find (String clave)
	{ return arbol.get(clave); 	}
	
	public void insert (K clave, T objeto)
	{ arbol.put(clave,objeto); 	}
	
	public void delete (K clave)
	{ arbol.remove(clave);	}
	
	public int largo() 
	{	return arbol.size();	}
}
