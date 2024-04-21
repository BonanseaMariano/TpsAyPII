/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import arrayStack.ArrayStack;
import doublyLinkedStack.DoublyLinkedStack;
import linkedStack.LinkedStack;
import stackInterface.Stack;

/**
 *
 * @author Mariano
 */
public class stackTest {

    /**
     * Demonstrates sample usage of a stack.
     */
    public static void main(String[] args) {
        
        Stack<Integer> stacks[] = new Stack[]{new ArrayStack<>(), new LinkedStack<>(), new DoublyLinkedStack<>()};
        
        for (Stack<Integer> stack : stacks) {
            test(stack);
        }
    }
    
    public static void test(Stack<Integer> S) {
        System.out.println("---- " + S.getClass().getSimpleName() + " ----");
        long startTime = System.nanoTime();
        S.push(5);                              // contents: (5)
        S.push(3);                              // contents: (5, 3)
        System.out.println(S.size());           // contents: (5, 3)     outputs 2
        System.out.println(S.pop());            // contents: (5)        outputs 3
        System.out.println(S.isEmpty());        // contents: (5)        outputs false
        System.out.println(S.pop());            // contents: ()         outputs 5
        System.out.println(S.isEmpty());        // contents: ()         outputs true
        System.out.println(S.pop());            // contents: ()         outputs null
        S.push(7);                              // contents: (7)
        S.push(9);                              // contents: (7, 9)
        System.out.println(S.top());            // contents: (7, 9)     outputs 9
        S.push(4);                              // contents: (7, 9, 4)
        System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
        System.out.println(S.pop());            // contents: (7, 9)     outputs 4
        S.push(6);                              // contents: (7, 9, 6)
        S.push(8);                              // contents: (7, 9, 6, 8)
        System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución " + S.getClass().getSimpleName() + ": " + (endTime - startTime) + " ns\n");
    }
    
}
