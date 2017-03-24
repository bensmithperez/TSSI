package ejercicio2;

public class Empleado {
	private final int id;
	private String nombre;
	private int edad;
	private static int contador = 999;
	
	public Empleado(){
		this.nombre = "pepe";
		this.edad = 30;
		Empleado.contador += 1;
		id = Empleado.contador;
	}
	
	public Empleado(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
		Empleado.contador += 1;
		id = Empleado.contador;
	}
	
	public int devuelveProximoID(){
		return id + 1;
	}
	
	public String devuelveDatos(){
		return "ID: " + id + 
			   " | Nombre: " + nombre +
			   " | Edad: " + edad;
	}
	
}
