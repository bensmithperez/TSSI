package ejercicio1;

public class Auto {
	//uso composición...
	public Motor m;
	public Conductor c;
	
	public Auto(){
		m = new Motor();
	}
	//uso agregación...
	public void abordar(Conductor c){
		this.c = c;
	}
}