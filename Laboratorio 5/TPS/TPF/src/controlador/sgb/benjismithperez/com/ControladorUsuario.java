package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controlador.sgb.benjismithperez.com.ControladorConexion;

public class ControladorUsuario {
	private ModeloUsuario u;
	private ControladorConexion c;
	
	public ControladorUsuario(ModeloUsuario u) {
		this.u = u;	
		this.c = new ControladorConexion();
	}
	
	public boolean Agregar(){
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    String fechaNac = df.format(u.getFechaNac());
		    
		    String q1 = "insert into usuarios(tipo,usuario,pass,activo) values("
					+ u.getTipo()+",'"
					+u.getUsuario()+"','"
					+u.getPass()+"',1);";
			
			String q2 = "insert into datosUsuarios(dni,idUsuario,nombre,apellido,fechaNac) values('"
					+u.getDni()+"','?','"
					+u.getNombre()+"','"
					+u.getApellido()+"','"
					+fechaNac+" 00:00:00');";
			c.EjecutarUpdateCompuesto(q1,q2);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda esto");
			e.printStackTrace();
			return false;
		}
	}
	
	public int Buscar(){
		try {
			ResultSet r = c.EjecutarQuery("select tipo from usuarios where usuario = '"+u.getUsuario()+"' and pass = '"+u.getPass()+"' and activo = 1;");
			if (!r.next() ) {
			    return -1;
			} 
			System.err.println("anda esto");
			r.first();
			return r.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda esto");
			e.printStackTrace();
			return -1;
		}
	}
}
