package singlyLinkedList;

public class TestSingleLinkedList {

	private static int comienzo = 0;

	public static void main(String[] args) {
		
		search();
		concatenate();
		addPos();
		removePos();
		removeElement();

	}

	public static void search() {
		System.out.println("Search");

		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		System.out.println(list.search("A"));
		System.out.println("A");
		System.out.println(list.search("D"));
		System.out.println("D");
		System.out.println(list.search("Z"));
		System.out.println("null");

	}

	public static void concatenate() {
		System.out.println("Concatenate");
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
		list1.addLast("D");
		list1.addLast("E");

		list.concatenate(list1);
		System.out.println(list);
		System.out.println("(A, B, C, D, E)");

	}

	public static void addPos() {
		System.out.println("AddPos");
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");

		list.addPos("Z", 0 + comienzo);
		System.out.println(list);
		System.out.println("(Z, A, B, C, D )");
		list.addPos("Y", 5 + comienzo);		
		System.out.println(list);
		System.out.println("(Z, A, B, C, D, Y)");
		list.addPos("X", 5 + comienzo);
		System.out.println(list);
		System.out.println("(Z, A, B, C, D, X, Y)");
		int pos = -1 + comienzo;
		try {
			list.addPos("G", pos);
			System.out.println("Error! debe lanzar excepción indice: " + pos);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Bien! Lanzó excepción indice: " + pos);
		}
		pos = 8 + comienzo;
		try {
			list.addPos("G", pos);
			System.out.println("Error! debe lanzar excepción indice: " + pos);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Bien! Lanzó excepción indice: " + pos);
		}
	}

	public static void removePos() {
		System.out.println("removePos");
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");

		list.removePos(0 + comienzo);
		System.out.println(list);
		System.out.println("(B, C, D, E)");
		list.removePos(3 + comienzo);
		System.out.println(list);
		System.out.println("(B, C, D)");
		list.removePos(1 + comienzo);
		System.out.println(list);
		System.out.println("(B, D)");

		int pos = -1 + comienzo;
		try {
			list.removePos(pos);
			System.out.println("Error! debe lanzar excepción indice: " + pos);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Bien! Lanzó excepción indice: " + pos);
		}
		pos = 3 + comienzo;
		try {
			list.removePos(pos);
			System.out.println("Error! debe lanzar excepción indice: " + pos);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Bien! Lanzó excepción indice: " + pos);
		}
	}

	public static void removeElement() {
		System.out.println("removeElement");
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		list.addLast("E");

		list.removeElement("W");
		System.out.println(list);
		System.out.println("(A, B, C, D, E)");
		list.removeElement("C");
		System.out.println(list);
		System.out.println("(A, B, D, E)");
		list.removeElement("A");		
		System.out.println(list);
		System.out.println("(B, D, E)");
		list.removeElement("E");
		System.out.println(list);
		System.out.println("(B, D)");

	}
}
