package ejer1;

public class Usuario implements Comparable<Usuario>{
	private String nombre;
	private String apellido;
	private String dni;
	private String sexo;
	
	public Usuario(){
		nombre = "";
		apellido = "";
		dni = "";
		sexo = "";
	}
	
	public Usuario(String nombre, String apellido, String dni, String sexo){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int compareTo(Usuario e) {
		if (e.nombre.equals(this.nombre))
		{
			return 0;
		}
		if (e.nombre.compareTo(this.nombre) < 0)
		{
			return 1;
		}
		return -1;
	}
	
	public String toString(){
		return this.dni + " " + this.nombre + " " + this.apellido + " " + this.sexo;
	}
}
