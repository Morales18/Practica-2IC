package Modelo;

import java.util.ArrayList;

public class Atributo {
	private String nombre;
	private Integer pos;
	private ArrayList<String> posiblesValores;
	
	public Atributo(String nombre, Integer pos) {
		this.setNombre(nombre);
		this.setPos(pos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getPosiblesValores() {
		return posiblesValores;
	}

	public void setPosiblesValores(ArrayList<String> posiblesValores) {
		this.posiblesValores = posiblesValores;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}
}
