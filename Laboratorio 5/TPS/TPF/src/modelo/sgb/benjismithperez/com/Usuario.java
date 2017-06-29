package modelo.sgb.benjismithperez.com;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	private int tipo;
	private String usuario;
	private String pass;
		
	public Usuario(int tipo, String usuario, String pass) {
		this.tipo = tipo;
		this.usuario = usuario;
		this.pass = pass;
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
		MessageDigest d = MessageDigest.getInstance("SHA-256");
		byte[] hash = d.digest(pass.getBytes(StandardCharsets.UTF_8));
		String r = new String(hash);
		this.pass = r;
	}	
}