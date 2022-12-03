package Logica;
import java.util.ArrayList;



public class NodoAvl {
	int altura;
	ArrayList<NodoAvl> hijos = new ArrayList<NodoAvl>(); 
	NodoAvl padre;
	int valor;
	
	
	public NodoAvl(int valor) {
		this.valor = valor;
		hijos.add(null);
		hijos.add(null);
	}
	
	public void agregarNodo(NodoAvl nodo) {
		if( nodo.valor > this.valor) {
			if(this.hijos.get(1)!=null) {
				(this.hijos.get(1)).agregarNodo(nodo);
			}else {
				nodo.padre = this;
				this.hijos.set(1, nodo);
			}
		}else {
			if(this.hijos.get(0)!=null) {
				(this.hijos.get(0)).agregarNodo(nodo);
			}else {
				nodo.padre = this;
				this.hijos.set(0, nodo);
			}
		}
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
		return String.valueOf(valor);
	}
}
