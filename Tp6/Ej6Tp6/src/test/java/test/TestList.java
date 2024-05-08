/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import interfaces.List;
import list.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class TestList {

    private List<String> list = new ArrayList<String>();

    @BeforeEach
    public void setUp() throws Exception {
        list.add(0, "Juan");
        list.add(1, "Ana");
        list.add(2, "Pedro");
        list.add(3, null);
        list.add(4, "Mar�a");
        list.add(5, "Pedro");
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testContains() {
        // Crea un nuevo objeto, para verificar si se usa equals en lugar de ==
        assertTrue(list.contains(new String("Pedro")));
        assertFalse(list.contains(new String("Mario")));
        assertTrue(list.contains(null));
    }

    @Test
    public void testIndexOf() {
        assertEquals(list.indexOf(new String("Pedro")), 2);
        assertEquals(list.indexOf(new String("Mario")), -1);
        assertEquals(list.indexOf(null), 3);
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(list.lastIndexOf(new String("Pedro")), 5);
        assertEquals(list.lastIndexOf(new String("Mario")), -1);
        assertEquals(list.lastIndexOf(null), 3);
    }

    @Test
    public void testRemove() {
        list.remove(new String("Pedro"));
        list.remove(null);
        assertEquals(list.indexOf(new String("Pedro")), 3);
        assertEquals(list.indexOf(null), -1);
    }

}
