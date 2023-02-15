package capaLogica;

import java.io.Serializable;
import java.util.LinkedList;

import valueObjects.VOPartida;

public class SecPartidas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private LinkedList<Partida> secPartida;
	
	public SecPartidas () 
	{	secPartida = new LinkedList<Partida>();	}
	
	public int tamanio() 
	{	return secPartida.size();	}
	
	public VOPartida[] getVOPartidas () {
		VOPartida arrPartidas[] = new VOPartida[secPartida.size()];
		for (int i = 0; i < arrPartidas.length; i++) {
			VOPartida vp = new VOPartida(secPartida.get(i).getIdPartida(), secPartida.get(i).getPuntaje(), 
					secPartida.get(i).getFinalizada(), secPartida.get(i).getAcertada(), 
					secPartida.get(i).getTextoAdivinado(), secPartida.get(i).getPeliculaAAdivinar());
			arrPartidas[i] = vp;
		}
		return arrPartidas;
	}

}
