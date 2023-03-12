package servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import capaLogica.CapaLogica;

public class Servidor {
	public static void main(String [] args) {
		try {
			Properties p = new Properties();
			String nomArch = "src/config/config.properties";
			p.load(new FileInputStream(nomArch));
			String ip = p.getProperty("ipServidor");
			System.out.println(ip);
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			
			LocateRegistry.createRegistry(port);
			
			CapaLogica fachada = CapaLogica.getInstancia();
			String ruta = "//" + ip + ":" + port + "/fachada";
			Naming.rebind(ruta, fachada);
					
		}
		catch(MalformedURLException ex) {
			System.out.println(ex.getMessage());
		}
		catch(FileNotFoundException ex)	// 
		{
			System.out.println(ex.getMessage());
		}catch(IOException ex)	// 
		{
			System.out.println(ex.getMessage());
		}
		
	}
}
