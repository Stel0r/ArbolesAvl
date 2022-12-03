package Logica;

public class test {
	public static void main(String[] args) {
		ArbolAvl arbol = new ArbolAvl();
		arbol.agregarNodo(10);
		arbol.agregarNodo(3);
		arbol.agregarNodo(0);
		
		arbol.recorrido();
	} 
}
