/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import arrayCircularQueue.ArrayCircularQueue;

/**
 *
 * @author Mariano
 */
public class ArrayCircularQueueTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ArrayCircularQueue<String> arrayCircularQueue = new ArrayCircularQueue<>(4);
        arrayCircularQueue.enqueue("Mariano");
        arrayCircularQueue.enqueue("Luis");
        arrayCircularQueue.enqueue("Roberto");
        arrayCircularQueue.enqueue("Carlos");

        try {
            arrayCircularQueue.enqueue("Mariano");
            System.out.println("Mal! no lanzo excepcion!");
        } catch (IllegalStateException e) {
            System.out.println("Bien! Lanzo excepcion");
        }

        System.out.println("(Mariano, Luis, Roberto, Carlos)");
        System.out.println(arrayCircularQueue);

        System.out.println("");

        System.out.println("(Luis, Roberto, Carlos, Mariano)");
        arrayCircularQueue.rotate();
        System.out.println(arrayCircularQueue);

        System.out.println("");

        System.out.println("(Roberto, Carlos, Mariano)");
        arrayCircularQueue.dequeue();
        System.out.println(arrayCircularQueue);

        System.out.println("");

        System.out.println("(Carlos, Mariano, Roberto)");
        arrayCircularQueue.rotate();
        System.out.println(arrayCircularQueue);

        System.out.println("");

        System.out.println("(Roberto)");
        arrayCircularQueue.dequeue();
        arrayCircularQueue.dequeue();
        arrayCircularQueue.rotate();
        System.out.println(arrayCircularQueue);

        System.out.println("");

        System.out.println("()");
        arrayCircularQueue.dequeue();
        arrayCircularQueue.rotate();
        System.out.println(arrayCircularQueue);
    }
}
