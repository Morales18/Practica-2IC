package Modelo;

import java.util.ArrayList;

public class Ejemplo {
	private ArrayList<String> valores;
	private String clase;
	
	public Ejemplo(ArrayList<String> fila) {
		this.valores = fila;
		this.setClase(valores.get(valores.size()-1));
		valores.remove(valores.size()-1);
	}
	
	public ArrayList<String> getValores(){
		return valores;
	}
	
	public void setValores(ArrayList<String> valores) {
		this.valores = valores;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
}
