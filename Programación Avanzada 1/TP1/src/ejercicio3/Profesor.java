package ejercicio3;

public class Profesor extends ejercicio2.Empleado {
	String cargo;
	int antiguedadDocente;
	
	public Profesor(){
		super();
		cargo = "Sin Cargo";
		antiguedadDocente = 0;
	}
	
	public Profesor(String cargo, int antiguedadDocente, String nombre, int edad){
		super(nombre,edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}
	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public String devuelveDatos(){
		return "ID: " + getId() + 
			   " | Nombre: " + getNombre() +
			   " | Edad: " + getEdad() +
			   " | Cargo: " + cargo +
			   " | Antigüedad Docente: " + antiguedadDocente;
	}
}
