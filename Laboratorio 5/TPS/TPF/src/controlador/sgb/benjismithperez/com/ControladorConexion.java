package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorConexion {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ControladorConexion(){
		this.con = null;
		this.stmt = null;
		this.rs = null;
	}
	
	public ResultSet EjecutarQuery(String sql) throws SQLException{
		con = ModeloConexion.getConnection();
		stmt = con.createStatement();
		return stmt.executeQuery(sql);
	}

	public int EjecutarUpdate(String sql) throws SQLException{
		con = ModeloConexion.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate(sql);
	}
}
