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
	
	public Nodo ID3( ArrayList<Atributo> atributos, ArrayList<Ejemplo> ejemplos, Nodo nodo) {
		String claseMayoritaria = calcularClase(atributos.get(atributos.size()-1));
		if (atributos.isEmpty()){
			nodo.setClase(claseMayoritaria);
		}
		else{
			Atributo a = calcularMaximaGanancia(atributos,ejemplos);
			for (int i = 0; i < a.getPosiblesValores().size();i++){
				//Nodo hijo = new Nodo(a.getNombre(),a.getPosiblesValores().get(i), )
			}
		}
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
	public Atributo calcularMaximaGanancia(ArrayList<Atributo> atributos, ArrayList<Ejemplo> ejemplos){
		ArrayList<Double> entropias = new ArrayList<Double>();
		int indice = 0;
		//La entropía no puede ser mayor que 1 por eso inicializamos el menor a 1
		double min = 1;
		for (int i = 0; i < atributos.size() - 1;i++){
			entropias.set(i, atributos.get(i).calcularEntropiaAtributo(ejemplos, atributos.get(atributos.size()-1)));
			System.out.println("Entropia: " + atributos.get(i).getNombre() + " "+  entropias.get(i));
			if(entropias.get(i) < min){
				indice = i;
				min = entropias.get(i);
			} 
		}
		return atributos.get(indice);

	}

}
