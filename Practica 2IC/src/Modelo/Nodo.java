package Modelo;

import java.util.ArrayList;

public class Nodo {

	private String atributo;
	private String valor;
	private String clase;
	private ArrayList<Nodo> hijos;
	private boolean esHoja;
	private boolean esAtrib;
	
	public Nodo(String atributo, String valor) {
		this.setAtributo(atributo);
		this.setValor(valor);
		this.hijos = new ArrayList<Nodo>();
	}
	
	public Nodo() {
		this.setAtributo("raiz");
		this.hijos = new ArrayList<Nodo>();
	}
	
	public Nodo(Atributo a) {
		this.setAtributo(a.getNombre());
		this.setEsAtrib(true);
		this.hijos = new ArrayList<Nodo>();
	}
	
	public Nodo(String clase) {
		this.clase = clase;
		this.esHoja = true;
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

	public boolean isEsHoja() {
		return esHoja;
	}

	public void setEsHoja(boolean esHoja) {
		this.esHoja = esHoja;
	}

	public boolean isEsAtrib() {
		return esAtrib;
	}

	public void setEsAtrib(boolean esAtrib) {
		this.esAtrib = esAtrib;
	}
	
	public boolean checkNull() {
		boolean ok = false;
		for(Nodo hijo : hijos) {
			if(hijo == null) ok = true;
		}
		
		return ok;
	}
}
/*
 * public class NodoDecision {

    private final String atributo;
    private final Map<String, NodoDecision> ramas;
    private final String clase;

    public NodoDecision(String clase) {
        this.clase = clase;
        this.atributo = null;
        this.ramas = null;
    }

    public NodoDecision(String atributo, Map<String, NodoDecision> ramas) {
        this.clase = null;
        this.atributo = atributo;
        this.ramas = ramas;
    }

    public boolean esHoja() {
        return clase != null;
    }

    public String getClase() {
        return clase;
    }

    public String getAtributo() {
        return atributo;
    }

    public Map<String, NodoDecision> getRamas() {
        return ramas;
    }

    public void setRama(String valor, NodoDecision subarbol) {
        ramas.put(valor, subarbol);
    }

    public NodoDecision getRama(String valor) {
        return ramas.get(valor);
    }
}
 */