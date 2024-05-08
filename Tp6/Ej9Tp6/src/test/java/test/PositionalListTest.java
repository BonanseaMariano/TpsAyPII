/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import interfaces.*;
import org.junit.jupiter.api.BeforeEach;
import positionalList.LinkedPositionalList;

/**
 *
 * @author Mariano
 */
public class PositionalListTest {

    private PositionalList<String> posList;

    @BeforeEach
    public void setUp() {
        posList = new LinkedPositionalList<>();
    }

    /**
     * Testea el metodo AddLast utilizando unicamente los metodos isEmpty(),
     * addFirst(), addAfter() y last()
     */
    @Test
    public void testAddLast() {
        posList.addLast("Mariano");
        assertFalse(posList.isEmpty());
        assertEquals("Mariano", posList.last().getElement());
        posList.addLast("Luis");
        posList.addFirst("Carlos");
        assertEquals("Luis", posList.last().getElement());
    }

    /**
     * Testea el metodo AddBefore utilizando unicamente los metodos first(),
     * addFirst(), addAfter() y before()
     */
    @Test
    public void testAddBefore() {

        posList.addLast("Mariano");

        //Añadir antes en posicion invalida
        assertThrows(IllegalArgumentException.class, () -> {
            posList.addBefore(posList.before(posList.first()), "Mariano");
        });

        //Añadir antes en posicion invalida
        assertThrows(IllegalArgumentException.class, () -> {
            posList.addBefore(posList.after(posList.last()), "Mariano");
        });

        //Añadir antes en posicion invalida
        assertThrows(IllegalArgumentException.class, () -> {
            posList.addBefore(posList.after(posList.last()), null);
        });

        //Añadir antes en posicion validaF
        posList.addBefore(posList.first(), "Luis");
        posList.addBefore(posList.after(posList.first()), "Carlos");
        assertEquals("Luis", posList.first().getElement());
        assertEquals("Carlos", posList.after(posList.first()).getElement());
    }
}
