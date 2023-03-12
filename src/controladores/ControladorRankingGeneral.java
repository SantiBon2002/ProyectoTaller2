package controladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import capaLogica.ICapaLogica;
import gui.RankingGeneral;
import valueObjects.VOJugadorListado;

public class ControladorRankingGeneral {
	private ICapaLogica fachada;
	private RankingGeneral ventana;
	
	private final String errorCon = "Error de conexion";
	
	public ControladorRankingGeneral(RankingGeneral ventana) {
		this.ventana = ventana;
		try {
			Properties p = new Properties();
			String nomArch = "src/config/config.properties";
			p.load(new FileInputStream(nomArch));
			String servidor = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + servidor + ":" + puerto + "/fachada";
	
			fachada = (ICapaLogica) Naming.lookup(ruta);
			ventana.setVisible(true);
		} catch (IOException | NotBoundException e) {
			ventana.mensajeError(errorCon, false);
		}
	
	}
	
	public VOJugadorListado[] rankingGeneral () {
		VOJugadorListado[] ranking = null;
		
		try {
			ranking = fachada.rankingGeneral();
		} catch (RemoteException e) {
			ventana.mensajeError(errorCon, false);
		}
		
		return ranking;
	}
	
}