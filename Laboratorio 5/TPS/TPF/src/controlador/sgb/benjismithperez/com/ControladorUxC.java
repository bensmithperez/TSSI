package controlador.sgb.benjismithperez.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.sgb.benjismithperez.com.ModeloCuenta;
import modelo.sgb.benjismithperez.com.ModeloTransaccion;
import modelo.sgb.benjismithperez.com.ModeloUsuario;
import modelo.sgb.benjismithperez.com.ModeloUxC;

public class ControladorUxC {
	private ModeloUxC m;
	private ControladorConexion c;
	
	public ControladorUxC() {

	}
	
	public ControladorUxC(ModeloUxC m) {
		this.m = m;
		this.c = new ControladorConexion();
	}
	
	public boolean ValidarCantidad(){ //si ya hay 4, false... else true
		try {
			String q1 = "select count(*) as cant from cuentasPorUsuario where dniUsuario = '"+
						m.getDniUsuario() + "' and activo = 1;";
			
			System.err.println(q1);
			ResultSet r = c.EjecutarQuery(q1);
			if (!r.next()){
		    	return false;
		    }
			r.first();
			System.err.println("cantidad: " + r.getInt("cant"));
			if (r.getInt(1) >= 4){
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda asociar cuenta a usuario");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean ExisteAsociacion(){
		try {
			String q1 = "select dniUsuario,numCUenta from cuentasPorUsuario where dniUsuario = "+
						m.getDniUsuario() + " and numCuenta = "+
						m.getNumCuenta() + " and activo = 1;";
			
			ResultSet r = c.EjecutarQuery(q1);
			if (!r.next()){
		    	return false;
		    }
			r.first();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda existe asociacion");
			e.printStackTrace();
			return false;
		}
	}

	public boolean Asociar(){
		try {
			String q1 = "insert into cuentasPorUsuario (dniUsuario, numCuenta, activo) values ("+
						m.getDniUsuario() + "," +
						m.getNumCuenta() + ",1);";
			
			if (c.EjecutarUpdateSimple(q1) == 0){
		    	return false;
		    }
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda asociar cuenta a usuario");
			e.printStackTrace();
			return false;
		}
	}
	
	public List<ModeloCuenta> cargarCuentasUsuario(String dniUsuario){
		try{
			ModeloCuenta m;
			List<ModeloCuenta> listaCuentas = new ArrayList<ModeloCuenta>();
			ResultSet r = c.EjecutarQuery("select cuentasPorUsuario.numCuenta as nc, cuentas.monto as monto from cuentasPorUsuario join cuentas on cuentasPorUsuario.numCuenta = cuentas.numCuenta where dniUsuario = '"+dniUsuario+"' and cuentasPorUsuario.activo = 1;");
			
			r.beforeFirst();
			while (r.next()){
				m = new ModeloCuenta(r.getString("nc"),r.getInt("monto"));
				listaCuentas.add(m);
			}
			return listaCuentas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cargarCuentasUsuario");
			e.printStackTrace();
		}
		return null;
	}
}
