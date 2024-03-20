package racional;

// Clase Racional
public class Racional {

	// Atributos
	private int numerador;
	private int denominador;

	// Constructor
	public Racional(int numerador, int denominador) {
		this.numerador = numerador;

		if (denominador == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Getters: acceder a los valores de los atributos
	// Setters: modificar los valores de los atributos
	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		if (denominador == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Metodos
	public Racional sumar(Racional b) {
            int n = (numerador * b.denominador) + (b.numerador * denominador);
            int d = denominador * b.denominador;
            return new Racional(n, d);
	}

	public Racional restar(Racional b) {
            int n = (numerador * b.denominador) + (b.numerador * denominador);
            int d = denominador * b.denominador;
            return new Racional(n, d);
	}

	public Racional multiplicar(Racional b) {
            int n = numerador * b.numerador;
            int d = denominador * b.denominador;
            return new Racional(n, d);
	}

	public Racional dividir(Racional b) {
            int n = numerador * b.denominador;
            int d = denominador * b.numerador;
            return new Racional(n, d);
	}

	public static Racional potencia(Racional base, int exponente) {
            int n = (int) Math.pow((double)exponente, (double)base.numerador);
            int d = (int) Math.pow((double)exponente, (double)base.denominador);
            return new Racional(n, d);
	}

	// Metodo estatico
	public static Racional simplificar(Racional a) {
		int x = mcd(Math.abs(a.numerador), Math.abs(a.denominador));
		int n = a.numerador / x;
		int d = a.denominador / x;
		return new Racional(n, d);
	}

	// toString: mostrar un objeto
	public String toString() {
		return (numerador + "/" + denominador);
	}

	// equals: verificar cuando dos objetos son iguales
	public boolean equals(Object o) {
		Racional r1 = simplificar(this);
		Racional r2 = simplificar((Racional) o);
		return ((r1.numerador == r2.numerador) && (r1.denominador == r2.denominador));
	}

	// M�todo privado
	private static int mcd(int m, int n) {
		int t;
		while (m > 0) {
			t = m;
			m = n % m;
			n = t;
		}
		return n;
	}

}