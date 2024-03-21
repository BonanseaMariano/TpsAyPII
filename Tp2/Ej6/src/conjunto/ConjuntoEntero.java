package conjunto;

import java.util.Arrays;

public class ConjuntoEntero {

	private static final int MAX = 101;
	private boolean conjunto[];

	public ConjuntoEntero() {
		conjunto = new boolean[MAX];
	}

	// Implementar
	public void insertarElemento(int i) {
		
	}

	// Implementar
	public void eliminarElemento(int i) {
		
	}

	// Implementar
	public ConjuntoEntero union(ConjuntoEntero c) {		
		return null;
	}
	
	// Implementar
	public ConjuntoEntero interseccion(ConjuntoEntero c) {		
		return null;
	}

	// Implementar
	public ConjuntoEntero diferencia(ConjuntoEntero c) {		
		return null;
	}

	// Implementar
	public String toString() {
		return null;
	}

	// Generado con Eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conjunto);
		return result;
	}

	// Generado con Eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConjuntoEntero other = (ConjuntoEntero) obj;
		if (!Arrays.equals(conjunto, other.conjunto))
			return false;
		return true;
	}
	
}
