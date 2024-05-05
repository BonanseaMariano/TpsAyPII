/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import deque.ArrayDeque;
import interfaces.Deque;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    public void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test
    public void testEmptyDeque() {
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    public void testAddFirstAndFirst() {
        deque.addFirst(10);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(10, deque.first());
    }

    @Test
    public void testAddLastAndLast() {
        deque.addLast(20);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(20, deque.last());
    }

    @Test
    public void testRemoveFirst() {
        deque.addFirst(30);
        deque.addLast(40);
        assertEquals(30, deque.removeFirst());
        assertEquals(40, deque.first());
        assertEquals(1, deque.size());
    }

    @Test
    public void testRemoveLast() {
        deque.addFirst(50);
        deque.addLast(60);
        assertEquals(60, deque.removeLast());
        assertEquals(50, deque.last());
        assertEquals(1, deque.size());
    }

}
