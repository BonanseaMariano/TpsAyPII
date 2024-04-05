package test;

import lista.Empleado;
import lista.Lista;

public class PruebaLista {

	public static void main(String[] args) {
		Lista<Empleado> lista = new Lista<Empleado>(3);

		Empleado e1 = new Empleado(100, "Juan");
		Empleado e2 = new Empleado(110, "Ana");
		Empleado e3 = new Empleado(120, "Pedro");
		Empleado e4 = new Empleado(120, "Maria");

		try {
			lista.add(e1);
			lista.add(e2);
			lista.add(e3);
			lista.add(e4);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		System.out.println(lista);
	}
}
