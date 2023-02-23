package capaLogica;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import valueObjects.VOPartida;

public class SecPartidas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Partida> secPartida;
	
	public SecPartidas () 
	{	secPartida = new LinkedList<Partida>();	}
	
	public int tamanio() 
	{	return secPartida.size();	}
	
	public boolean empty ()
	{	return secPartida.isEmpty();}
	
	public boolean partidaEnCurso ()
	{	return !(secPartida.getFirst().getFinalizada());}
	
	public void insert (Partida p)
	{	secPartida.push(p);	}
	
	public Partida getFirst ()
	{	return secPartida.getFirst();}

	public VOPartida[] getVOPartidas () {
		VOPartida arrPartidas[] = new VOPartida[secPartida.size()];
		for (int i = 0; i < arrPartidas.length; i++) {
			Partida aux = secPartida.get(i);
			VOPartida vp = new VOPartida(aux.getPeliculaAAdivinar(), aux.getIdPartida(), aux.getPuntaje(), aux.getFinalizada(), aux.getAcertada(), aux.getTextoAdivinado());
			arrPartidas[i] = vp;
		}
		return arrPartidas;
	}
	 public String[] getTitulosPartida () {
		 String[] titulos = new String[secPartida.size()];
		 Iterator<Partida> iter = secPartida.iterator();
		 for (int i = 0; i < titulos.length; i++) {
			titulos[i] = iter.next().getPeliculaAAdivinar().getTitulo();
		}
		 return titulos;
	 }
}
