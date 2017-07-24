package controlador.sgb.benjismithperez.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
	
	public List<ModeloTransaccion> cargarTransacciones(String dniUsuario){
		try {
			ModeloTransaccion m;
			List<ModeloTransaccion> listaTransacciones = new ArrayList<ModeloTransaccion>();
			ResultSet r = c.EjecutarQuery("select id, idTipo, fecha, numCuenta, estado "
					+ "from transacciones "
					+ "where numCuenta in (select numCuenta from cuentasPorUsuario where dniUsuario = '"+dniUsuario+"');");
			r.beforeFirst();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			while (r.next() ) {
			    m = new ModeloTransaccion(r.getInt("id"),r.getInt("idTipo"),(Date)formatter.parse(r.getString("fecha")),r.getString("numCuenta"),r.getInt("estado"));
			    listaTransacciones.add(m);
			}
			return listaTransacciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cargarTransacciones");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("algo con la fecha...");
			e.printStackTrace();
		}
		return null;
	}
}
