package ejercicio1;

public class Auto {
	//uso composici�n...
	public Motor m;
	public Conductor c;
	
	public Auto(){
		m = new Motor();
	}
	//uso agregaci�n...
	public void abordar(Conductor c){
		this.c = c;
	}
}