package controlador.sgb.benjismithperez.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import modelo.sgb.benjismithperez.com.ModeloCuenta;

public class ControladorCuenta {
	private ModeloCuenta cu;
	private ControladorConexion c;
	
	public ControladorCuenta(ModeloCuenta cu) {
		this.cu = cu;	
		this.c = new ControladorConexion();
	}
	
	public boolean Agregar(){
		try {	    
		    String q1 = "insert into cuentas(numCuenta,monto,activo) values("
					+ cu.getNumCuenta()+",'"
					+cu.getMonto()+"',1);";
		    
			c.EjecutarUpdateSimple(q1);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda agregar cuenta");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean Borrar(){
		try {	    
		    String q1 = "update cuentas set "
		    		+ "activo = 0 where numCuenta = " + cu.getNumCuenta() + " and activo = 1;";
		    
		    if (c.EjecutarUpdateSimple(q1) == 0){
		    	return false;
		    }
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda BorrarCuenta");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean CargarDatos(){
		try{
			String q1 = "select numCuenta, monto from cuentas where numCuenta = "
					+ cu.getNumCuenta()	+ " and activo = 1;";
		
			ResultSet r = c.EjecutarQuery(q1);
			if (!r.next()){
		    	return false;
		    }
			r.first();
			cu.setMonto(r.getFloat("monto"));
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cargarDatos de cuenta");
			e.printStackTrace();
			return false;
		}
	}
//	
//	public boolean ModificarDatosCuenta(){
//		
//	}
//	
//	public boolean BorrarUsuario(){
//		
//	}
}