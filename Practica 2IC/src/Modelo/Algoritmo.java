package Modelo;

import java.util.ArrayList;

public class Algoritmo {
	
	private ArrayList<Atributo> atributos;
	private ArrayList<Ejemplo> ejemplos;
	private ArrayList<String> posiblesValoresClase;
	
	public Algoritmo() {
		this.atributos = new ArrayList<Atributo>();
		this.ejemplos = new ArrayList<Ejemplo>();
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<String> strings) {
		Atributo aux;
		//strings.remove(strings.size()-1);
		for(int i = 0; i < strings.size(); i++) {
			aux = new Atributo(strings.get(i), i);
			atributos.add(aux);
		}
	}
	
	public void setPosiblesValoresClase(){
		this.posiblesValoresClase = calcularPosiblesValoresClase(atributos.get(atributos.size()-1));

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
	
	public Nodo ID3 (ArrayList<Atributo> atributos, ArrayList<Ejemplo> ejemplos) {
		if(ejemplos.isEmpty()) {
			return null;
		}
		
		String claseMayoritaria = calcularClase(ejemplos);
		
		if (atributos.isEmpty() || mismaClase(ejemplos)){
			return new Nodo(claseMayoritaria);
		}
		else {
			Atributo a = calcularMaximaGanancia(atributos, ejemplos);
			Nodo nodo = new Nodo(a);
			for (int i = 0; i < a.getPosiblesValores().size();i++){
				ArrayList<Ejemplo> ejRestantes = ejemplosRestantes(a.getPosiblesValores().get(i), ejemplos);
				ArrayList<Atributo> atribRestantes = atributos;
				atribRestantes.remove(a);
				
				Nodo hijo = new Nodo(a.getNombre(), a.getPosiblesValores().get(i));
				Nodo aux = ID3(atribRestantes, ejRestantes);
				if(aux != null) {
					hijo.setHijo(aux);
					//arbol.addEdge();
				}
					
				nodo.setHijo(hijo);
			}
			return nodo;
		}
	}
	
	public boolean mismaClase(ArrayList<Ejemplo> ejemplos) {
		String claseAux = ejemplos.get(0).getClase();
		for(int i = 1; i < ejemplos.size(); i++) {
			if(!ejemplos.get(i).getClase().equals(claseAux)) return false;
		}
		return true;
	}
	
	public ArrayList<Ejemplo> ejemplosRestantes(String valor, ArrayList<Ejemplo> ejemplos){
		ArrayList<Ejemplo> restantes = new ArrayList<Ejemplo>();
		
		for(Ejemplo e : ejemplos){
			if(e.getValores().contains(valor)) {
				restantes.add(e);
			}
		}
		
		return restantes;
	}
	
	public ArrayList<String> calcularPosiblesValoresClase(Atributo atributo) {
		ArrayList<String> valores = new ArrayList<String>();
		
		for(int i = 0; i < ejemplos.size(); i++) {
			if(valores.isEmpty()) {
				valores.add(ejemplos.get(i).getClase());
			}
			else {
				if(!valores.contains(ejemplos.get(i).getClase())) {
					valores.add(ejemplos.get(i).getClase());
				}
			}
		}
		
		atributo.setPosiblesValores(valores);
		return valores;
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
	
	public String calcularClase(ArrayList<Ejemplo> ejemplos) {
		int[] contador = new int[this.posiblesValoresClase.size()];
		int max = 0;
		int pos = 0;
		
		for(int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		
		for(int i = 0; i < ejemplos.size(); i++) {
			contador[this.posiblesValoresClase.indexOf(ejemplos.get(i).getClase())]++;
		}
		
		for(int i = 0; i < contador.length; i++) {
			if(contador[i] > max) {
				max = contador[i];
				pos = i;
			}
		}
		
		return this.posiblesValoresClase.get(pos);
	}
	
	public Atributo calcularMaximaGanancia(ArrayList<Atributo> atributos, ArrayList<Ejemplo> ejemplos){
		ArrayList<Double> entropias = new ArrayList<Double>();
		int indice = 0;
		//La entropia no puede ser mayor que 1 por eso inicializamos el menor a 1
		double min = 1;
		
		// Muestra por pantalla los valores de las ganancias para comprobacion nuestra
		for(int i = 0; i < ejemplos.size(); i++) {
			for(int j = 0; j < ejemplos.get(i).getValores().size(); j++) {
				System.out.println(ejemplos.get(i).getValores().get(j));
			}
		}
		
		for (int i = 0; i < atributos.size()-1; i++){
			if(atributos.get(i).getPosiblesValores() == null) calcularPosiblesValores(atributos.get(i));
			double aux = atributos.get(i).calcularEntropiaAtributo(ejemplos, atributos.get(atributos.size()-1));
			entropias.add(atributos.get(i).calcularEntropiaAtributo(ejemplos, atributos.get(atributos.size()-1)));
			if(entropias.get(i) < min){
				indice = i;
				min = entropias.get(i);
			} 
		}
		return atributos.get(indice);

	}

}
