package ejercicio1;

public class Conductor {
	private String nombre;
	
	public Conductor(){
		nombre = "";
	}
	
	public Conductor(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
