/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import empresa.Empleado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Mariano
 */
public class ListaEmpleadosTest {

    static List<Empleado> lista;
    static Empleado e1, e2, e3;

    @BeforeAll
    public static void setUp() {
        lista = new ArrayList<>();
        e1 = new Empleado(111, "Mariano", null, 0, 0);
        e2 = new Empleado(222, "Pedro", null, 0, 0);
        e3 = new Empleado(333, "Maradona", null, 0, 0);
    }

    @Test
    public void testEmpty() {
        lista = new ArrayList<>();
        assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testAddYGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.add(1, e1);
        });

        lista.add(0, e1);
        lista.add(1, e2);
        assertEquals(e1, lista.get(0));
        assertEquals(e2, lista.get(1));
        assertEquals(2, lista.size());
        System.out.println(lista);
    }

    @Test
    public void testSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.set(2, e1);
        });
        lista.set(1, e3);
        assertEquals(e3, lista.get(1));
        assertEquals(2, lista.size());
    }

    @Test
    public void testRemove() {
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.remove(3);
        });

        lista.remove(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.get(2);
        });

        assertEquals(2, lista.size());
    }

    @Test
    public void testIterator() {
        System.out.println("\t---- ITERADOR ----");
        Empleado temp = null;
        Iterator<Empleado> iterador = lista.iterator();
        while (iterador.hasNext()) {
            temp = iterador.next();
            System.out.println(temp);
        }
        assertEquals(e2, temp);
    }
}
