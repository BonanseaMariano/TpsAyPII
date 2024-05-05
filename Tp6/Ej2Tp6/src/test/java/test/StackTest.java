/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import interfaces.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import stack.ArrayStack;

/**
 *
 * @author Mariano
 */
public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new ArrayStack<>();
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndTop() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.top());
    }

    @Test
    public void testPop() {
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.top());
        assertEquals(1, stack.size());
    }

}
