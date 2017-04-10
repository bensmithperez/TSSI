package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		//PARTE 1
		Auto a1 = new Auto();		
		//¿cuantos cilindros?
		System.out.println("Cant cilindros: "+a1.m.getCantCilindros());
		
		Conductor c1 = new Conductor("Paola");
		a1.abordar(c1);
		
		//¿Como se llama el conductor?
		System.out.println("Nombre conductor: "+a1.c.getNombre());
		
	}

}
