package Consigna;

public class Perro extends Animal implements Cuadrupedo{
	
	public Perro(){
		
	}
	
	public Perro(String nombre, int edad){
		super(nombre,edad);
	}
	
	@Override
	public void dormir() {
		System.out.println("ZZZ");
	}

	@Override
	public void comunicarse() {
		System.out.println("Guau");
	}

	@Override
	public void existir(String razon) {
		System.out.println("Existe para " + razon);	
	}
	
}
