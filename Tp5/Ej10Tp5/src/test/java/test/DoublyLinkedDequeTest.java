/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import doublyLinkedDeque.DoublyLinkedDeque;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedDequeTest {

    @Test
    public void testSize() {
        DoublyLinkedDeque<Integer> deque = new DoublyLinkedDeque<>();
        assertEquals(0, deque.size());
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(2, deque.size());
    }

    @Test
    public void testIsEmpty() {
        DoublyLinkedDeque<String> deque = new DoublyLinkedDeque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst("Hello");
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testFirst() {
        DoublyLinkedDeque<Integer> deque = new DoublyLinkedDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        assertEquals(10, deque.first());
    }

    @Test
    public void testLast() {
        DoublyLinkedDeque<String> deque = new DoublyLinkedDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        assertEquals("B", deque.last());
    }

    @Test
    public void testAddFirst() {
        DoublyLinkedDeque<Integer> deque = new DoublyLinkedDeque<>();
        deque.addFirst(5);
        deque.addFirst(10);
        assertEquals(10, deque.first());
    }

    @Test
    public void testAddLast() {
        DoublyLinkedDeque<String> deque = new DoublyLinkedDeque<>();
        deque.addLast("X");
        deque.addLast("Y");
        assertEquals("Y", deque.last());
    }

    @Test
    public void testRemoveFirst() {
        DoublyLinkedDeque<Integer> deque = new DoublyLinkedDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(1, deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(2, deque.first());
        assertEquals(2, deque.removeFirst());
        assertEquals(null, deque.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        DoublyLinkedDeque<String> deque = new DoublyLinkedDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        assertEquals("B", deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals("A", deque.last());
        assertEquals("A", deque.removeLast());
        assertEquals(null, deque.removeLast());
    }
}

