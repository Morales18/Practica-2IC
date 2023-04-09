package Modelo;

import java.util.ArrayList;

public class Nodo {

	private String atributo;
	private String valor;
	private String clase;
	private ArrayList<Nodo> hijos;
	private boolean esHoja;
	
	public Nodo(String atributo, String valor) {
		this.setAtributo(atributo);
		this.setValor(valor);
		this.hijos = new ArrayList<Nodo>();
	}
	
	public Nodo() {
		this.setAtributo("raiz");
		this.hijos = new ArrayList<Nodo>();
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<Nodo> hijos) {
		this.hijos = hijos;
	}
	public void setHijo(Nodo hijo) {
		hijos.add(hijo);
	}
	public boolean esHoja() {
		if(hijos.size() == 0) return true;
		else return false;
	}
}
