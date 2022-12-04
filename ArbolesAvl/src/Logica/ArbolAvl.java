package Logica;

import java.util.ArrayList;





public class ArbolAvl {
	NodoAvl raiz;
	ArrayList<NodoAvl> listaNodos;
	
	public ArbolAvl() {
		raiz = null;
		listaNodos = new ArrayList<NodoAvl>();
	}
	
	public void agregarNodo(int valor) {
		NodoAvl nuevo = new NodoAvl(valor,this);
        agregarNodo(nuevo);
	}
	
	public void agregarNodo(NodoAvl nodo) {
		 if (raiz != null) {
	            raiz.agregarNodo(nodo);
	        } else {
	            raiz = nodo;
	        }
	       listaNodos.add(nodo);
	}

	
	 public NodoAvl buscar(int dato){
	        for (NodoAvl nodo : listaNodos) {
	            if(nodo.valor == dato){
	                return nodo;
	            }
	        }
	        return null;
	    }
	 
	public void eliminarNodo(NodoAvl nodo) {
        NodoAvl candidato = nodo.hijos.get(0);
        NodoAvl padreNodo = nodo.padre != null ? nodo.padre : null;
        if (candidato == null) {
            candidato = nodo.hijos.get(1);
            if(candidato == null) {
            	if(nodo.padre != null) {
            		nodo.padre.hijos.set(nodo.padre.hijos.indexOf(nodo),null);
            		nodo.padre = null;
            	}else raiz = null;
            	padreNodo.actualizarAltura();
            	return;
            }
            candidato.padre = nodo.padre;
            if (candidato.padre != null) { 
                candidato.padre.hijos.set(candidato.padre.hijos.indexOf(nodo), candidato);
            }else{
                this.raiz =candidato;
            }
            padreNodo.actualizarAltura();
            int izq = candidato.hijos.get(0) == null ? 0 : candidato.hijos.get(0).altura;
    		int der = candidato.hijos.get(1) == null ? 0 : candidato.hijos.get(1).altura;
    		candidato.balance = der - izq;
    		candidato.altura = Math.max(izq, der) + 1;
            return;
        } else {
            while (candidato.hijos.get(1) != null) {
                candidato =  candidato.hijos.get(1);
            }
        }
        if (candidato.padre.hijos.indexOf(candidato) == 0) {
            candidato.padre.hijos.set(0, candidato.hijos.get(0));
        } else {
            candidato.padre.hijos.set(1, candidato.hijos.get(0));
        }
        candidato.padre =nodo.padre;
        candidato.hijos = nodo.hijos;
        if (candidato.padre != null) {
            candidato.padre.hijos.set(candidato.padre.hijos.indexOf(nodo), candidato);
        }else{
            this.raiz = candidato;
        }
        
        if(padreNodo != null) {
        	padreNodo.actualizarAltura();
        }
        
        int izq = candidato.hijos.get(0) == null ? 0 : candidato.hijos.get(0).altura;
		int der = candidato.hijos.get(1) == null ? 0 : candidato.hijos.get(1).altura;
		candidato.balance = der - izq;
		candidato.altura = Math.max(izq, der) + 1;
		
        
        
    }
	
	public void recorrido() {
		System.out.println("-------------------------------------------------------");
		System.out.println(raiz != null);
		if(raiz != null) {
			raiz.recorridoInfijo();
		}
	}
}
