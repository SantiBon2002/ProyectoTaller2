package capaLogica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import valueObjects.VOPelicula;

public class DiccPeliculas extends Diccionario <String, Pelicula> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DiccPeliculas ()
	{	super();	}
	
	public int largo() 
	{	return arbol.size();	}
	
	public ArrayList <VOPelicula> listarPeliculas () {
		ArrayList <VOPelicula> res = new ArrayList<VOPelicula>();
		Iterator <Pelicula> iter = arbol.values().iterator();
		
		while(iter.hasNext()) {
			Pelicula p = iter.next();
			VOPelicula vop = null;
			vop = new VOPelicula(p.getTitulo(),p.getDescripcion());
			res.add(vop);
		}
		return res;
	}

}