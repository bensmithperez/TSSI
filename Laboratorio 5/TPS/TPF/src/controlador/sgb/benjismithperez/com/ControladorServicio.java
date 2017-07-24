package controlador.sgb.benjismithperez.com;

import java.sql.SQLException;

import modelo.sgb.benjismithperez.com.ModeloServicio;

public class ControladorServicio {
	private ModeloServicio m;
	private ControladorConexion c;
	
	public ControladorServicio(ModeloServicio m) {
		this.m = m;
		this.c = new ControladorConexion();
	}	
	
	public boolean Agregar(){
		try {	    
		    String q1 = "insert into servicios(descripcion,activo) values('"
					+ m.getDescripcion()+"',1);";
		    
			c.EjecutarUpdateSimple(q1);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda agregar servicio");
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean Borrar(){
		try {	    
		    String q1 = "update servicios set activo = 0 where descripcion = '"
					+ m.getDescripcion()+"' and activo = 1;";
		    
		    if (c.EjecutarUpdateSimple(q1) == 0){
		    	return false;
		    }
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda borrar servicio");
			e.printStackTrace();
			return false;
		}

	}
}
