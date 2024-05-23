package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructures.ArrayQueue;
import datastructures.LinkedQueue;
import datastructures.Queue;

class TestArrayQueue {

    private Queue<String> q1;

    @BeforeEach
    void setUp() throws Exception {
        q1 = new ArrayQueue<String>(5);
        q1.enqueue("Juan");
        q1.enqueue("Pedro");
        q1.enqueue("Ana");
    }

    @Test
    void testThis() {
        assertTrue(q1.equals(q1));
    }

    @Test
    void testNull() {
        assertFalse(q1.equals(null));
    }

    @Test
    void testClass() {
        Queue<String> q2 = new LinkedQueue<String>();
        q2.enqueue("Juan");
        q2.enqueue("Pedro");
        q2.enqueue("Ana");
        assertFalse(q1.equals(q2));
    }

    @Test
    void testIgual1() {
        Queue<String> q2 = new ArrayQueue<String>();
        q2.enqueue("Juan");
        q2.enqueue("Pedro");
        q2.enqueue("Ana");
        assertTrue(q1.equals(q2));
    }

    @Test
    void testIgual2() {
        Queue<String> q2 = new ArrayQueue<String>(3);
        q2.enqueue("Juan");
        q2.enqueue("Juan");
        q2.enqueue("Juan");
        q2.dequeue();
        q2.dequeue();
        q2.enqueue("Pedro");
        q2.enqueue("Ana");
        assertTrue(q1.equals(q2));
    }
}
