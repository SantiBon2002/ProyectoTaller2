 package capaLogica;
import java.util.ArrayList;
import java.util.Iterator;
import valueObjects.VOPelicula;

public class DiccPeliculas extends Diccionario <String, Pelicula> /*implements Serializable*/ {
	private static final long serialVersionUID = 1L;
	
	public DiccPeliculas ()
	{	super();	}
	
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
	
	public String[] getTitulos () {
		String[] titulos = new String[arbol.size()];
		Iterator <Pelicula> iter = arbol.values().iterator();
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = iter.next().getTitulo();
		}
		
		return titulos;
	}
}