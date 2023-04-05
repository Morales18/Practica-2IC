package Modelo;

import java.util.ArrayList;

public class Algoritmo {
	
	private ArrayList<Atributo> atributos;
	private ArrayList<Ejemplo> ejemplos;
	
	public Algoritmo() {
		this.atributos = new ArrayList<Atributo>();
		this.ejemplos = new ArrayList<Ejemplo>();
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<String> strings) {
		Atributo aux;
		for(int i = 0; i < strings.size(); i++) {
			aux = new Atributo(strings.get(i), i);
			atributos.set(i, aux);
		}
	}

	public ArrayList<Ejemplo> getEjemplos() {
		return ejemplos;
	}

	public void setEjemplos(ArrayList<ArrayList<String>> strings) {
		Ejemplo aux;
		
		for(int i = 0; i < strings.size(); i++) {
			aux = new Ejemplo(strings.get(i));
			ejemplos.add(aux);
		}
	}
	
	public Nodo ID3() {
		return null;
	}
	
	public void calcularPosiblesValores(Atributo atributo) {
		ArrayList<String> valores = new ArrayList<String>();
		
		for(int i = 0; i < ejemplos.size(); i++) {
			if(valores.isEmpty()) {
				valores.add(ejemplos.get(i).getValores().get(atributo.getPos()));
			}
			else {
				if(!valores.contains(ejemplos.get(i).getValores().get(atributo.getPos()))) {
					valores.add(ejemplos.get(i).getValores().get(atributo.getPos()));
				}
			}
		}
		
		atributo.setPosiblesValores(valores);
	}
	
	public String calcularClase(Atributo clase) {
		calcularPosiblesValores(clase);
		int[] contador = new int[clase.getPosiblesValores().size()];
		int max = 0;
		int pos = 0;
		
		for(int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		
		for(int i = 0; i < ejemplos.size(); i++) {
			contador[clase.getPosiblesValores().indexOf(ejemplos.get(i).getClase())]++;
		}
		
		for(int i = 0; i < contador.length; i++) {
			if(contador[i] > max) {
				max = contador[i];
				pos = i;
			}
		}
		
		return clase.getPosiblesValores().get(pos);
	}
}
