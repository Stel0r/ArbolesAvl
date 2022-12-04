package Logica;

public class test {
	public static void main(String[] args) {
		ArbolAvl arbol = new ArbolAvl();
		arbol.agregarNodo(110);
		arbol.agregarNodo(170);
		arbol.agregarNodo(200);
		arbol.agregarNodo(210);
		arbol.agregarNodo(140);
		arbol.agregarNodo(90);
		arbol.agregarNodo(20);
		arbol.agregarNodo(7);
		arbol.agregarNodo(130);
		arbol.agregarNodo(3);
		arbol.agregarNodo(10);
		arbol.agregarNodo(85);
		arbol.agregarNodo(250);
		arbol.agregarNodo(95);
		arbol.agregarNodo(70);
		arbol.agregarNodo(50);
		arbol.recorrido();
		
		arbol.eliminarNodo(arbol.buscar(200));
		arbol.recorrido();
		arbol.eliminarNodo(arbol.buscar(3));
		arbol.recorrido();
		arbol.eliminarNodo(arbol.buscar(70));
		arbol.recorrido();
		arbol.eliminarNodo(arbol.buscar(85));
		arbol.recorrido();
		arbol.eliminarNodo(arbol.buscar(110));
		arbol.recorrido();
		//probar balanceo al borrar
		arbol.eliminarNodo(arbol.buscar(210));
		arbol.recorrido();
		arbol.eliminarNodo(arbol.buscar(250));
		arbol.recorrido();
	} 
}
