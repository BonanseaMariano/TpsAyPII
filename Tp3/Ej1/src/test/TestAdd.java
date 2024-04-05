package test;

import lista.Lista;

public class TestAdd {

	public static void main(String[] args) {

		testAdd1();
		testAdd2();
		testAdd3();
		testAdd4();
		testAdd5();
		testAdd6();
		testAdd7();
	}

	// Insertar lista vacía
	// Antes: { }
	// Después: { A }
	public static void testAdd1() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 1");
			lista.add(0, "A");			
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Insertar antes
	// Antes: { A }
	// Después: { B, A }
	public static void testAdd2() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");

			System.out.println("Test 2");
			lista.add(0, "B");			
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Insertar después
	// Antes: { A }
	// Después: { A, B }
	public static void testAdd3() {
		try {
			Lista<String> lista = new Lista<String>(10);
			lista.add("A");
			
			System.out.println("Test 3");
			lista.add(1, "B");
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Indice negativo
	// Antes: { }
	// Después: error
	public static void testAdd4() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 4");
			lista.add(-1, "A");
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Indice fuera de rango
	// Antes: { }
	// Después: error
	public static void testAdd5() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 5");
			lista.add(1, "A");
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Lista llena
	// Antes: { }
	// Después: error
	public static void testAdd6() {
		try {
			Lista<String> lista = new Lista<String>(2);

			System.out.println("Test 6");
			lista.add(0, "A");
			lista.add(0, "B");
			lista.add(0, "C");
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

	// Indice insertar en el medio
	// Antes: { }
	// Después: { C Z B A}
	public static void testAdd7() {
		try {
			Lista<String> lista = new Lista<String>(10);

			System.out.println("Test 7");
			lista.add(0, "A");
			lista.add(0, "B");
			lista.add(0, "C");
			lista.add(1, "Z");
			System.out.println(lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("error");
		}
	}

}
