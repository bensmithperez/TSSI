package Consigna;

public class Gato extends Animal implements Cuadrupedo{

	@Override
	public void existir(String razon) {
		System.out.println("Existe para " + razon);
	}

	@Override
	public void dormir() {
		System.out.println("GRRR");
	}

	@Override
	public void comunicarse() {
		System.out.println("Miau");
	}

}
