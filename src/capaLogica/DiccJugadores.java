package capaLogica;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import valueObjects.VOJugadorListado;


public class DiccJugadores extends Diccionario <String, Jugador> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public DiccJugadores () 
	{	super();}
	
	public ArrayList <VOJugadorListado> listarJugadores () {
		ArrayList <VOJugadorListado> res = new ArrayList<VOJugadorListado>();
		Iterator <Jugador> iter = arbol.values().iterator();
		
		while(iter.hasNext()) {
			Jugador j = iter.next();
			VOJugadorListado vop = null;
			vop = new VOJugadorListado(j.getNombre(), j.getCodigo(), j.getPuntajeTotal(), j.getCantPelisAcertadas(), j.getCantPelisErradas());
			res.add(vop);
		}
		return res;
	}
	
	public VOJugadorListado[] rankingGeneral()throws RemoteException
	{
		ArrayList<VOJugadorListado> jugadores = this.listarJugadores();
		VOJugadorListado[] ranking = new VOJugadorListado[jugadores.size()];
		
		ranking[0] = jugadores.get(0);
		int j;
		boolean insertado;
		for (int i = 1; i < jugadores.size(); i++) {
			j = 0;
			insertado = false;
			while (ranking[j] != null && j < ranking.length && !insertado) {
				if (jugadores.get(i).getPuntajeTotal() > ranking[j].getPuntajeTotal()) {
					for (int k = ranking.length - 2; k >= j; k--) 
						ranking[k + 1] = ranking[k];
					ranking[j] = jugadores.get(i);
					insertado = true;
				}
				j++;
			}
			if (ranking[j] == null)
				ranking[j] = jugadores.get(i);
		}
		return ranking;
	}
}
