package modelo.sgb.benjismithperez.com;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloUsuario {
	//datos tabla usuarios
	private int id;
	private int tipo;
	private String usuario;
	private String pass;
	private boolean activo;
	//datos tabla datosUsuarios
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaNac;
	private List<String> cuentas;
		
	public ModeloUsuario() {
		this.cuentas = new ArrayList<String>();
	}

	public ModeloUsuario(int tipo, String usuario, String pass, boolean activo , String nombre, String apellido, String dni,Date fechaNac) {
		this.tipo = tipo;
		this.usuario = usuario;
		try {
			setPass(pass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.activo = activo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.cuentas = new ArrayList<String>();
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
	
	public String getFechaNacString(){
		DateFormat format = new SimpleDateFormat("d/M/y");
		return format.format(fechaNac);
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
}