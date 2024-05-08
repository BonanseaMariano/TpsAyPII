/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import list.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class ArrayListTest {

    ArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void removeTest() {
        list.add(0, "Messi");
        list.add(0, "Maradona");
        assertEquals(2, list.size());
        assertEquals(16, list.getDataLen(), list.getDataLen());
        assertEquals("Maradona", list.remove(0));
        assertEquals(1, list.getDataLen(), list.getDataLen());

    }
}
