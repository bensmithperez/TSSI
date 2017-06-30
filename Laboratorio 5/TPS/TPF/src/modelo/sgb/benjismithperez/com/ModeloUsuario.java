package modelo.sgb.benjismithperez.com;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class ModeloUsuario {
	//datos tabla usuarios
	private int id;
	private int tipo;
	private String usuario;
	private String pass;
	//datos tabla datosUsuarios
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaNac;
	
	public ModeloUsuario() {
		
	}
	
	
	
	public ModeloUsuario(int tipo, String usuario, String pass, String nombre, String apellido, String dni,Date fechaNac) {
		this.tipo = tipo;
		this.usuario = usuario;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNac = fechaNac;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) throws NoSuchAlgorithmException {
		//hago la encripción de la pw aquí...
		MessageDigest d = MessageDigest.getInstance("SHA-256");
		byte[] hash = d.digest(pass.getBytes(StandardCharsets.UTF_8));
		String r = new String(hash);
		this.pass = r;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}	
	
}