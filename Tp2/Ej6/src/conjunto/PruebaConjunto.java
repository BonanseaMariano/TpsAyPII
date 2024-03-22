package conjunto;

public class PruebaConjunto {

    public static void main(String[] args) {

        ConjuntoEntero c1 = new ConjuntoEntero();
        ConjuntoEntero c2 = new ConjuntoEntero();

        c1.insertarElemento(10);
        c1.insertarElemento(12);
        c1.insertarElemento(14);
        c1.insertarElemento(16);
        c1.insertarElemento(18);
        c1.insertarElemento(20);

        c2.insertarElemento(10);
        c2.insertarElemento(15);
        c2.insertarElemento(20);

        System.out.println("Conjunto 1: " + c1);
        System.out.println("Conjunto 2: " + c2);
        System.out.println("Union: " + c1.union(c2));
        System.out.println("Interseccion: " + c1.interseccion(c2));
        System.out.println("Diferencia: " + c1.diferencia(c2));
        System.out.println("Son iguales: " + c1.equals(c2));

        c2.eliminarElemento(15);
        ConjuntoEntero c3 = new ConjuntoEntero();
        c3.insertarElemento(10);
        c3.insertarElemento(20);
        System.out.println("Conjunto 2: " + c2);
        System.out.println("Conjunto 3: " + c3);
        System.out.println("Son iguales: " + c2.equals(c3));

    }

}
