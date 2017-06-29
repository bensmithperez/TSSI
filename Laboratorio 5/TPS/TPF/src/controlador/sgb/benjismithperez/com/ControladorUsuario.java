package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloUsuario;

import java.sql.SQLException;

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
			c.EjecutarUpdate("insert into usuarios(id,tipo,usuario,pass) values('0',"+u.getTipo()+",'"+u.getUsuario()+"','"+u.getPass()+"');");
			System.err.println("anda esto");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("no anda esto");
			e.printStackTrace();
			return false;
		}
	}
}
