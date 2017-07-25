package controlador.sgb.benjismithperez.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<ModeloServicio> cargarServicios(){
		try{
			ModeloServicio m;
			List<ModeloServicio> listaServicios = new ArrayList<ModeloServicio>();
			ResultSet r = c.EjecutarQuery("select id,descripcion from servicios where activo = 1;");
			
			r.beforeFirst();
			while (r.next()){
				m = new ModeloServicio(r.getInt("id"),r.getString("descripcion"));
				listaServicios.add(m);
			}
			return listaServicios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cargarServicios");
			e.printStackTrace();
		}
		return null;
	}
}
