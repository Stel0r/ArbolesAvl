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
	
	public void eliminarNodo(NodoAvl nodo) {
		
	}
	
	public NodoAvl buscar (int dato) {
		return null;
	}
	
	public void recorrido() {
		if(raiz != null) {
			raiz.recorridoInfijo();
		}
	}
}
