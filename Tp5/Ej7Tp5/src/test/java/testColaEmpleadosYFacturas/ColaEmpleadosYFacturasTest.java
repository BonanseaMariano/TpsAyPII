/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testColaEmpleadosYFacturas;

import arrayQueue.ArrayQueue;
import empresa.Empleado;
import empresa.Factura;
import empresa.PorPagar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Mariano
 */
public class ColaEmpleadosYFacturasTest {

    public static ArrayQueue<PorPagar> queue;
    public static Empleado e1, e2;
    public static Factura f1, f2;

    @BeforeAll
    public static void setUp() {
        queue = new ArrayQueue<>(4);
        e1 = new Empleado(111, "Mariano", null, 42, 1000);
        e2 = new Empleado(222, "Pepito", e1, 30, 500);
        f1 = new Factura("Mariano", 101, "06/06/2008");
        f2 = new Factura("Luis", 202, "09/09/2007");

        //Articulos
        f1.agregarItem("Tornillos", 3, 1500);
        f2.agregarItem("Clavos", 5, 1000);
    }

    @Test
    void addEmpleadosyFacturas() {
        double pagoTotal = 0;

        queue.enqueue(e1);
        queue.enqueue(f1);
        queue.enqueue(e2);
        queue.enqueue(f2);

        System.out.println(queue);

        //Test cola llena
        assertThrows(IllegalStateException.class, () -> {
            queue.enqueue(e1);
        });

        while (!queue.isEmpty()) {
            pagoTotal += queue.dequeue().obtenerPago();
        }

        System.out.println("En total se deben pagar: $" + pagoTotal);

        //Test sacar cola vacia
        assertNull(queue.dequeue());

    }

}
