package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
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
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String q1 = "insert into usuarios(tipo,usuario,pass,activo) values("
					+ u.getTipo()+",'"
					+u.getUsuario()+"','"
					+u.getPass()+"',1);";
			
			String q2 = "insert into datosUsuarios(dni,idUsuario,nombre,apellido,fechaNac) values('"
					+u.getDni()+"',?,'"
					+u.getNombre()+"','"
					+u.getApellido()+"','"
					+format.format(u.getFechaNac())+" 00:00:00');";
			c.EjecutarUpdateCompuesto(q1,q2);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda agregar");
			e.printStackTrace();
			return false;
		}
	}
	
	public void BuscarTipo(){
		try {
			ResultSet r = c.EjecutarQuery("select tipo from usuarios where usuario = '"+u.getUsuario()+"' and pass = '"+u.getPass()+"' and activo = 1;");
			if (!r.next() ) {
			    u.setTipo(-1);
			}
			r.first();
			u.setTipo(r.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda buscarTipo");
			e.printStackTrace();
			u.setTipo(-1);
		}
	}
	
	public void CargarDatos(){
		try {
			ResultSet r = c.EjecutarQuery("select id, usuario, nombre, apellido, fechaNac "
					+ "from usuarios join datosUsuarios "
					+ "on usuarios.id = datosUsuarios.idUsuario "
					+ "where dni = '"+u.getDni()+"' and activo = 1;");
			if (!r.next() ) {
			    u.setTipo(-1);
			}
			r.first();
			System.err.println("id: " + r.getString("id") 
			+ " usuario: " + r.getString("usuario") 
			+ " nombre: " + r.getString("nombre") 
			+ " apellido: " + r.getString("apellido") 
			+ " fechaNac: " + r.getString("fechaNac"));
			u.setId(Integer.parseInt(r.getString("id")));
			u.setUsuario(r.getString("usuario"));
			u.setNombre(r.getString("nombre"));
			u.setApellido(r.getString("apellido"));
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date fecha = (Date)formatter.parse(r.getString("fechaNac"));
			
			u.setFechaNac(fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cargarDatos");
			e.printStackTrace();
			u.setTipo(-1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("algo con la fecha...");
			e.printStackTrace();
		}
	}
	
	public boolean ModificarDatosUsuario(){
		try {	    
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String q1 = "update datosUsuarios set "
		    		+ "nombre = '" + u.getNombre() + "',"
    				+ "apellido = '" + u.getApellido() + "',"
					+ "fechaNac = '" + format.format(u.getFechaNac())+" 00:00:00' "
					+ "where idUsuario = " + u.getId() + ";";
		    
		    c.EjecutarUpdateSimple(q1);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda modificarDatosUsuario");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean CambiarContraeniaUsuario(){
		try {	    
		    String q1 = "update usuarios set "
		    		+ "pass = '" + u.getPass() + "'"
					+ "where id = " + u.getId() + ";";
		    
		    c.EjecutarUpdateSimple(q1);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cambiarContraseniaUsuario");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean BorrarUsuario(){
		try {	    
		    String q1 = "update usuarios set "
		    		+ "activo = 0 where id = " + u.getId() + ";";
		    
		    c.EjecutarUpdateSimple(q1);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda cambiarContraseniaUsuario");
			e.printStackTrace();
			return false;
		}
	}
}
