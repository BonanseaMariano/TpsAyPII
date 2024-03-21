package complejo;

public class TestComplejo {

	public static void main(String[] args) {                                                 
        // declaraci�n de numeros complejos
        Complejo c1 = new Complejo(1.0, 1.0);
        Complejo c2 = new Complejo(2.0, 2.0);
        Complejo c3;
        // operadores aritmeticos
        c3 = c1.sumar(c2);
        System.out.println(c1 + " + " + c2 + " = " + c3);
        c3 = c1.restar(c2);
        System.out.println(c1 + " - " + c2 + " = " + c3);
        c3 = c1.dividir(c2);
        System.out.println(c1 + " / " + c2 + " = " + c3);
        c3 = c1.multiplicar(c2);
        System.out.println(c1 + " * " + c2 + " = " + c3);
        c3 = c1.multiplicar(c2);
        System.out.println(c1 + " * 3.5 = " + c3);
        if (c2.equals(c3)) {
            System.out.println(c2 + " igual que " + c3);
        } else {
            System.out.println(c2 + " distinto que " + c3);
        }
}
}
