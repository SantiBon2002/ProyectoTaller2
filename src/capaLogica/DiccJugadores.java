package capaLogica;

import java.io.Serializable;
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
}
