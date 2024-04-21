/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayCircularQueue;

import interfaces.CircularQueue;

/**
 *
 * @author Mariano
 */
public class ArrayCircularQueue<E> implements CircularQueue<E> {

    // instance variables
    /**
     * Default array capacity.
     */
    public static final int CAPACITY = 1000;      // default array capacity

    /**
     * Generic array used for storage of queue elements.
     */
    private E[] data;                             // generic array used for storage

    /**
     * Index of the top element of the queue in the array.
     */
    private int f = 0;                            // index of the front element

    /**
     * Current number of elements in the queue.
     */
    private int sz = 0;                           // current number of elements

    // constructors
    /**
     * Constructs an empty queue using the default array capacity.
     */
    public ArrayCircularQueue() {
        this(CAPACITY);
    }         // constructs queue with default capacity

    /**
     * Constructs and empty queue with the given array capacity.
     *
     * @param capacity length of the underlying array
     */
    @SuppressWarnings({"unchecked"})
    public ArrayCircularQueue(int capacity) {             // constructs queue with given capacity
        data = (E[]) new Object[capacity];          // safe cast; compiler may give warning
    }

    // methods
    @Override
    public void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    @Override
    public void enqueue(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E first() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E dequeue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
