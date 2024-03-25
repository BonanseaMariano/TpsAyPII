package conjunto;

import java.util.Arrays;

public class ConjuntoEntero {

    private static final int MAX = 101;
    private boolean conjunto[];

    public ConjuntoEntero() {
        conjunto = new boolean[MAX];
    }

    public void insertarElemento(int i) {
        conjunto[i] = true;
    }

    public void eliminarElemento(int i) {
        conjunto[i] = false;
    }

    public ConjuntoEntero union(ConjuntoEntero c) {
        //Declaro el conjunto resultado
        ConjuntoEntero resultado = new ConjuntoEntero();
        //Recorro ambos arreglos viendo si el elemento pertenece al menos a uno de los 2 conjuntos y lo guardo
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i] || c.conjunto[i]) {
                resultado.conjunto[i] = true;
            }
        }
        return resultado;
    }

    public ConjuntoEntero interseccion(ConjuntoEntero c) {
        //Declaro el conjunto resultado
        ConjuntoEntero resultado = new ConjuntoEntero();
        //Recorro ambos arreglos viendo si el elemento pertenece a ambos conjuntos y lo guardo
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i] && c.conjunto[i]) {
                resultado.conjunto[i] = true;
            }
        }
        return resultado;
    }

    public ConjuntoEntero diferencia(ConjuntoEntero c) {
        //Declaro el conjunto resultado
        ConjuntoEntero resultado = new ConjuntoEntero();
        //Recorro ambos arreglos viendo si el elemento pertenece al primer conjunto pero no al segundo
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i] && !c.conjunto[i]) {
                resultado.conjunto[i] = true;
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        //Declaro el string
        String cadena = new String();
        //Recorro el arreglo y si el elemento es true lo agrego al String
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i]) {
                cadena += i + " ";
            }
        }
        return cadena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.hashCode(this.conjunto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ConjuntoEntero other = (ConjuntoEntero) obj;
        if (!Arrays.equals(conjunto, other.conjunto)) {
            return false;
        }
        return true;
    }
    
}
