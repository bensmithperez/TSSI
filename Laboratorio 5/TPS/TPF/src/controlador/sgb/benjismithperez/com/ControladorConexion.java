package controlador.sgb.benjismithperez.com;

import modelo.sgb.benjismithperez.com.ModeloConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public int EjecutarUpdateSimple(String sql) throws SQLException{
		con = ModeloConexion.getConnection();
		stmt = con.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public boolean EjecutarUpdateCompuesto(String q1, String q2) throws SQLException{
		con = ModeloConexion.getConnection();
		boolean res = false;
		
		try
		{
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate(q1, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.first();
			int indice = rs.getInt(1);

			System.err.println("indice es: " + indice);
			q2 = q2.replace("?",Integer.toString(indice));
			System.err.println(q1);
			System.err.println(q2);
			
			System.err.println(stmt.executeUpdate(q2));
			
			con.commit();
			
			res = true;
		}
		catch(Exception e)
		{
			
			System.err.println(e);
			con.rollback();
		}
		finally
		{
		   con.close();
		}
		return res;
	}
}
