package racional;

class PruebaRacional {

	public static void main(String[] args) {

		// Se crean objetos de la clase Racional
		Racional r1 = new Racional(1, 2);
		Racional r2 = new Racional(3, 4);
		Racional r3 = new Racional(5, 8);

		// Ver los atributos de un objeto
		System.out.println("Numerador de r1: " + r1.getNumerador());
		System.out.println("Denominador de r1: " + r1.getDenominador());

		// Cambiar los atributos de un objeto
		r1.setNumerador(3);
		r1.setDenominador(5);

		// Ver un objeto
		System.out.println("r1: " + r1);
		// System.out.println("r1: " + r1.toString());

		// Realizar operaciones con racionales
		System.out.println(r1 + " + " + r2 + " = " + r1.sumar(r2));

		Racional r4 = r1.sumar(r2).sumar(r3);
		System.out.println(r1 + " + " + r2 + " + " + r3 + " = " + r4);

		// Llamar a un método estático
		Racional r5 = Racional.simplificar(r4);
		System.out.println(r1 + " + " + r2 + " + " + r3 + " = " + r5);

		// Prueba si dos objetos son iguales (estado)
		if (r1.equals(r2))
			System.out.println(r1 + " es igual a " + r2);
		else
			System.out.println(r1 + " es distinto a " + r2);

		r1.setDenominador(4);
		if (r1.equals(r2))
			System.out.println(r1 + " es igual a " + r2);
		else
			System.out.println(r1 + " es distinto a " + r2);

		if (r4.equals(r5))
			System.out.println(r4 + " es igual a " + r5);
		else
			System.out.println(r4 + " es distinto a " + r5);

		// Prueba si dos objetos son iguales (direcciones de memoria)
		if (r1 == r2)
			System.out.println(r1 + " == " + r2);
		else
			System.out.println(r1 + " != " + r2);

		Racional r6 = r5;
		if (r5 == r6)
			System.out.println(r5 + " == " + r6);
		else
			System.out.println(r5 + " != " + r6);

		// Atrapar excepciones
		Racional r7 = null;

		// r7 = new Racional(2, 0);

		try {
			r7 = new Racional(2, 0);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}

		System.out.println(r7);

		// cast
		double a = 2.2;
		double b = 3.5;

		// Racional r8 = new Racional (a,b);
		Racional r8 = new Racional((int) a, (int) b);
		System.out.println(r8);
				 		
		
	}

}
