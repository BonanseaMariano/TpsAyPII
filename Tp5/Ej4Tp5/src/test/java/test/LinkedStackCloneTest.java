/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import linkedStack.LinkedStack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariano
 */
public class LinkedStackCloneTest {

    /**
     * Tests the Clone and Equals methods of a LinkedStack
     */
    @Test
    public void linkedStackTest() {
        LinkedStack<String> stack = new LinkedStack<>();
        LinkedStack<String> clon = null;
        stack.push("Mariano");
        stack.push("Luis");
        stack.push("Pedro");

        System.out.println("---- Original ----");
        System.out.println(stack);

        try {
            clon = stack.clone();
            System.out.println("---- Clon ----");
            System.out.println(clon);
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar");
        }

        assertEquals(true, stack.equals(clon));
    }

}
