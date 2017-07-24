package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloServicio;
import modelo.sgb.benjismithperez.com.ModeloTransaccion;

public class ControladorServicio {
	private ModeloServicio m;
	private ControladorConexion c;
	
	public ControladorServicio(ModeloServicio m) {
		this.m = m;
		this.c = new ControladorConexion();
	}	
	
	
}
