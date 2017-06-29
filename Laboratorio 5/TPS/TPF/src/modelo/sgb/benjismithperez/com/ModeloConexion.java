package modelo.sgb.benjismithperez.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModeloConexion {
	private static String url = "jdbc:mysql://localhost:3306/sgb";    
    private static String nombreDriver = "com.mysql.jdbc.Driver";   
    private static String usuario = "root";   
    private static String pass = "";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(nombreDriver);
            try {
                con = DriverManager.getConnection(url, usuario, pass);
            } catch (SQLException e) {
            	e.getStackTrace();
                System.out.println("Error al conectar a la BD."); 
            }
        } catch (ClassNotFoundException e) {
        	e.getStackTrace();
            System.out.println("No encontré el driver...."); 
        }
        return con;
    }
}