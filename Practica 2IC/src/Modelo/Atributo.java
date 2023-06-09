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

	public double calcularEntropiaValor(ArrayList<Ejemplo> ejemplos, String valor,Atributo clase) {
		int numEjemplos = ejemplos.size(); 						// Obtenemos el numero total de ejemplos
		int conteo = 0; 										// Inicializamos el contador del valor
		ArrayList<String> posiblesClases = clase.getPosiblesValores();
		int[] contadorClases = new int[clase.getPosiblesValores().size()];
		for(int i = 0; i < contadorClases.length; i++) {
			contadorClases[i] = 0;
		}	
		
		for (Ejemplo ejemplo : ejemplos) { 						// Iteramos sobre todos los ejemplos
   			ArrayList<String> valores = ejemplo.getValores(); 	// Obtenemos los valores del ejemplo actual
			if (valores.size() > pos && valores.get(pos).equals(valor)) {
				// Incrementamos el contador si encontramos el valor en la posición dada
				conteo++;
				for(int j = 0; j < posiblesClases.size();j++){
					if (ejemplo.getClase().equals(posiblesClases.get(j))){
						contadorClases[j] += 1; 
					}
				}
			}
		}
		double entropiaValor = 0;
		for(int j = 0; j < posiblesClases.size();j++){
			if(contadorClases[j] != 0){
				double division = (double)contadorClases[j] / (double)conteo;
				double logaritmo = Math.log(division) / Math.log(2);
				entropiaValor += contadorClases[j]* logaritmo;
			}	
		}
		return entropiaValor;
	}

	public Double calcularEntropiaAtributo(ArrayList<Ejemplo> ejemplos,Atributo clase) {
		double entropia = 0.0;
		
		// valoresPosibles es una lista de todos los valores posibles que se
		// pueden encontrar en la posicion dada
		for (String valor : posiblesValores) {
			// calculamos la probabilidad de cada valor
			double entropiaValor = calcularEntropiaValor(ejemplos,valor, clase);
			
			// calculamos la entropia
			entropia+= entropiaValor;
		}
		entropia = -(entropia / (ejemplos.size())); 
		System.out.println(nombre + " " + entropia);
		return entropia;
	}
}
