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
    /**
     * Returns a string representation of the queue as a list of elements. This
     * method runs in O(n) time, where n is the size of the queue.
     *
     * @return textual representation of the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        int k = f;
        for (int j = 0; j < sz; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[k]);
            k = (k + 1) % data.length;
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public void rotate() {
        if (!isEmpty()) {
            enqueue(dequeue());
        }
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
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;   // use modular arithmetic
        data[avail] = e;
        sz++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null;                             // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

}
