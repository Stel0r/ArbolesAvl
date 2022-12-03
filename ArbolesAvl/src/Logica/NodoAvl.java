package Logica;
import java.util.ArrayList;




public class NodoAvl {
	int altura;
	int balance;
	ArrayList<NodoAvl> hijos = new ArrayList<NodoAvl>(); 
	NodoAvl padre;
	int valor;
	ArbolAvl arbol;
	
	
	public NodoAvl(int valor, ArbolAvl a) {
		this.valor = valor;
		hijos.add(null);
		hijos.add(null);
		altura = 1;
		balance = 0;
		arbol = a;
	}
	
	public void agregarNodo(NodoAvl nodo) {
		if( nodo.valor > this.valor) {
			if(this.hijos.get(1)!=null) {
				(this.hijos.get(1)).agregarNodo(nodo);
			}else {
				System.out.println("----------------------------------");
				nodo.padre = this;
				this.hijos.set(1, nodo);
			}
		}else {
			if(this.hijos.get(0)!=null) {
				(this.hijos.get(0)).agregarNodo(nodo);
			}else {
				System.out.println("----------------------------------");
				nodo.padre = this; 
				this.hijos.set(0, nodo);
			}
		}
		actualizarAltura();
	}
	
	public void actualizarAltura() {
		int izq = hijos.get(0) == null ? 0 : hijos.get(0).altura;
		int der = hijos.get(1) == null ? 0 : hijos.get(1).altura;
		balance = der - izq;
		
		if(balance >= 2) {
			if(hijos.get(1).balance > 0) {
				rotacionIzquierda();
			}else {
				hijos.get(1).rotacionDerecha();
				rotacionIzquierda();
			}
			izq = hijos.get(0) == null ? 0 : hijos.get(0).altura;
			der = hijos.get(1) == null ? 0 : hijos.get(1).altura;
			balance = der - izq;
		}else if (balance <= -2) {
			if(hijos.get(0).balance < 0) {
				rotacionDerecha();
			}else {
				hijos.get(0).rotacionIzquierda();
				rotacionDerecha();
			}
			izq = hijos.get(0) == null ? 0 : hijos.get(0).altura;
			der = hijos.get(1) == null ? 0 : hijos.get(1).altura;
			balance = der - izq;
		}
		
		
		int max = Math.max(izq,der);
		int alturaNueva = max + 1;
		
		if(alturaNueva != altura) {
			altura = alturaNueva;
			if(padre != null) {
				padre.actualizarAltura();
			}
			
		}
	}
	
	/*
	 * public void revisarAlturas() {
	 * 
	 * System.out.println("revisando altura de el nodo: "+ String.valueOf(valor));
	 * System.out.println("balance: "+String.valueOf(balance));
	 * System.out.println("altura: "+String.valueOf(altura));
	 * 
	 * if(this.hijos.get(0) != null) { hijos.get(0).revisarAlturas(); }
	 * if(this.hijos.get(1) != null) { hijos.get(1).revisarAlturas(); } int izq =
	 * hijos.get(0) == null ? 0 : hijos.get(0).altura; int der = hijos.get(1) ==
	 * null ? 0 : hijos.get(1).altura;
	 * 
	 * int max = Math.max(izq,der); altura = max + 1;
	 * 
	 * balance = der - izq;
	 * 
	 * System.out.println("despues el nodo: "+ String.valueOf(valor));
	 * System.out.println("balance: "+String.valueOf(balance));
	 * System.out.println("altura: "+String.valueOf(altura));
	 * 
	 * }
	 */
	public void rotacionIzquierda() {
		if(padre == null) {
			arbol.raiz = hijos.get(1);
			hijos.get(1).padre = null;
		}else {
			int index = padre.valor < valor ? 1:0;
			hijos.get(1).padre = padre;
			padre.hijos.set(index, hijos.get(1));
		}
		padre = hijos.get(1);
		NodoAvl aux = padre.hijos.get(0);
		padre.hijos.set(0, this);
		this.hijos.set(1, aux);
	}
	
	public void rotacionDerecha() {
		if(padre == null) {
			arbol.raiz = hijos.get(0);
			hijos.get(0).padre = null;
		}else {
			int index = padre.valor < valor ? 1:0;
			this.hijos.get(0).padre = padre;
			this.padre.hijos.set(index, hijos.get(0));
		}
		padre = hijos.get(0);
		NodoAvl aux = padre.hijos.get(1);
		padre.hijos.set(1, this);
		this.hijos.set(0, aux);
	}
	
	public void recorridoInfijo(){
        if(hijos.get(0)!=null){
            (hijos.get(0)).recorridoInfijo();
        }
        System.out.println(this.toString());
        if(hijos.get(1)!=null){
            (hijos.get(1)).recorridoInfijo();
        }
    }
	
	public String toString() {
		return String.valueOf(valor) + "| altura: "+ String.valueOf(altura) + " | Balance = " +String.valueOf(balance);
	}
}
