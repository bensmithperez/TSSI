package ejer3;

public class Articulo {
	private String nombre;
	private float precio;
	private int stock;
	private String categoria;
	
	public Articulo(){
		nombre = "";
		precio = 0;
		stock = 0;
		categoria = "";
	}
	
	public Articulo(String nombre, float precio, int stock, String categoria){
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
