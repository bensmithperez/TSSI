package controlador.sgb.benjismithperez.com;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import modelo.sgb.benjismithperez.com.ModeloTransaccion;

public class ControladorTransaccion {
	private ModeloTransaccion m;
	private ControladorConexion c;
	
	public ControladorTransaccion(ModeloTransaccion m) {
		this.m = m;
		this.c = new ControladorConexion();
	}
	
	public boolean GenerarTransaccion(){
		try {	    
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String q1 = "insert into transacciones(id,idTipo,fecha,numCuenta,estado) values("
					+ m.getId()+",'"
					+ m.getIdTipo()+"','"
					+ format.format(m.getFecha())+" 00:00:00','"
					+ m.getNumCuenta()+"','"
					+ m.getEstado()+"';";
		
			c.EjecutarUpdateSimple(q1);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda agregar");
			e.printStackTrace();
			return false;
		}
	}
}
