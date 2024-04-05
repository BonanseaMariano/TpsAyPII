package test;

import lista.Lista;

public class TestRemove {

	public static void main(String[] args) {

		testRemove1();
		testRemove2();
		testRemove3();
		testRemove4();
		testRemove5();
		testRemove6();

	}

	// Remover elemento
	// Antes: { A }
	// Después: { }
	public static void testRemove1() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");

			System.out.println("Test 1");
			String e = lista.remove(0);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Remover elemento
	// Antes: { A, B }
	// Después: { A }
	public static void testRemove2() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");
			lista.add("B");

			System.out.println("Test 2");
			String e = lista.remove(1);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Remover lista vacía
	// Antes: { }
	// Después: error
	public static void testRemove3() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 3");
			String e = lista.remove(0);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Remover índice negativo
	// Antes: { }
	// Después: error
	public static void testRemove4() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 4");
			String e = lista.remove(-1);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Remover índice fuera de rango
	// Antes: { A, B }
	// Después: error
	public static void testRemove5() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");
			lista.add("B");

			System.out.println("Test 5");
			String e = lista.remove(2);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Remover en el medio
	// Antes: { A, B, C }
	// Después: { A, C }
	public static void testRemove6() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");
			lista.add("B");
			lista.add("C");

			System.out.println("Test 6");
			String e = lista.remove(1);
			System.out.println(lista);
			System.out.println("Elemento removido: " + e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}
}


