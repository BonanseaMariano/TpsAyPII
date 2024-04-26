package conjunto;

public class ConjuntoEntero {

    private static final int MAX = 101;
    private boolean conjunto[];

    public ConjuntoEntero() {
        conjunto = new boolean[MAX];
    }

    public void insertarElemento(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > conjunto.length) {
            throw new IndexOutOfBoundsException();
        }
        conjunto[i] = true;
    }

    public void eliminarElemento(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > conjunto.length) {
            throw new IndexOutOfBoundsException();
        }
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

    public boolean esIgualA(ConjuntoEntero c) {
        //Si los conjuntos tienen diferentes tamaños
        if (this.conjunto.length != c.conjunto.length) {
            return false;
        }

        //Recorro ambos arreglos viendo si el elemento pertenece a ambos conjuntos
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i] && !c.conjunto[i]) {
                return false;
            }
        }

        return true;
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

}
