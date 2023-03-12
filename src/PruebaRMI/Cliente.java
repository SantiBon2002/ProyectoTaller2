package PruebaRMI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import capaLogica.ICapaLogica;
import excepciones.DiccionarioVacioException;
import excepciones.ElementoYaExisteEnDiccException;
import excepciones.NoAlfanumericoException;
import valueObjects.VOJugadorListado;
import valueObjects.VOJugadorSimple;

public class Cliente {
	public static void main(String [] args) {
		try {
			Properties p = new Properties();
			String nomArch = "src/config/archivo.properties";
			p.load(new FileInputStream(nomArch));
			String ip = p.getProperty("ipServidor");
			System.out.println(ip);
			String servidor = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + servidor + ":" + puerto + "/fachada";
		
			ICapaLogica fachada = (ICapaLogica) Naming.lookup(ruta);
			
			VOJugadorSimple a = new VOJugadorSimple("Armando",12);
			
			try {
				fachada.registrarJugador(a);
				ArrayList<VOJugadorListado> jug = new ArrayList<VOJugadorListado>();
				jug = fachada.listarJugadores();
				for(int i = 0; i<jug.size(); i++) {
					System.out.println("Nombre:"+jug.get(i).getNombre() + "Codigo:" + jug.get(i).getCodigo());
				}
				
			}
			catch(RemoteException e) {
				System.out.println(e.getMessage());
			}
			catch(NoAlfanumericoException e) {
				System.out.println(e.getMessage());
			}
			catch(ElementoYaExisteEnDiccException e) {
				System.out.println(e.getMessage());
			}
			catch(DiccionarioVacioException e) {
				System.out.println(e.getMessage());
			}
		}
		catch(RemoteException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(FileNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		} 
		catch (IOException ex)
		{
			System.out.println(ex.getMessage());
		} 
		catch (NotBoundException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
