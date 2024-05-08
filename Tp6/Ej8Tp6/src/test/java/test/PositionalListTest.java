/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import interfaces.*;
import empresa.*;
import java.util.Collections;
import java.util.Iterator;
import linkedPositionalList.LinkedPositionalList;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class PositionalListTest {

    PositionalList<PorPagar> posList;
    Position<PorPagar> cursor;
    Empleado e1, e2;
    Factura f1, f2;

    @BeforeEach
    public void setUp() {
        posList = new LinkedPositionalList<>();
        Empleado e1 = new Empleado(111, "Mariano", null, 72, 50000);
        Empleado e2 = new Empleado(222, "Pepito", e1, 32, 40000);
        Factura f1 = new Factura("Mariano", 333, "06/05/2024");
        Factura f2 = new Factura("Luis", 444, "06/05/2024");
        cursor = posList.first();
    }

    @Test
    public void sizeYEmptyTest() {
        assertEquals(0, posList.size());
        assertTrue(posList.isEmpty());
    }

    @Test
    public void addyFirstYLastTest() {

        posList.addLast(e1);
        cursor = posList.addLast(e2);

        assertEquals(e1, posList.first().getElement());

        posList.addAfter(cursor, f1);

        assertEquals(f1, posList.last().getElement());

        cursor = posList.addFirst(f1);

        assertEquals(f1, posList.first().getElement());

        posList.addBefore(cursor, f2);

        assertEquals(f2, posList.first().getElement());
    }

    @Test
    public void afterYBeforeTest() {
        posList.addLast(e1);
        cursor = posList.addLast(e2);
        posList.addLast(f1);

        assertEquals(f1, posList.after(cursor).getElement());
        assertEquals(e1, posList.before(cursor).getElement());
    }

    @Test
    public void removeYSetTest() {
        cursor = posList.addLast(e1);
        posList.addLast(e2);
        posList.set(cursor, f1);
        assertEquals(f1, posList.first().getElement());
        posList.remove(cursor);
        assertEquals(e2, posList.first().getElement());
    }

    @Test
    public void importesAPagar() {
        double acu = 0;
        posList.addLast(e1);
        posList.addLast(f1);
        posList.addLast(e2);
        posList.addLast(f2);

        var iter = posList.iterator();

        while (iter.hasNext()) {
            acu += iter.next().obtenerPago();
        }
        System.out.println("Total a pagar: $" + acu);
    }
}
