/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayCircularDeque;

import interfaces.Deque;

/**
 *
 * @author Mariano
 */
public class ArrayCircularDeque<E> implements Deque<E> {

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
     * Index of the bottom element of the queue in the array.
     */
    private int r = 0;                            // index of the last element

    /**
     * Current number of elements in the queue.
     */
    private int sz = 0;                           // current number of elements

    // constructors
    /**
     * Constructs an empty queue using the default array capacity.
     */
    public ArrayCircularDeque() {
        this(CAPACITY);
    }         // constructs queue with default capacity

    /**
     * Constructs and empty queue with the given array capacity.
     *
     * @param capacity length of the underlying array
     */
    @SuppressWarnings({"unchecked"})
    public ArrayCircularDeque(int capacity) {             // constructs queue with given capacity
        data = (E[]) new Object[capacity];          // safe cast; compiler may give warning
    }

    // methods
    /**
     * Returns the number of elements in the queue.
     *
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        return sz;
    }

    /**
     * Tests whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue (or null if empty)
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    /**
     * Returns, but does not remove, the last element of the queue.
     *
     * @return the last element of the queue (or null if empty)
     */
    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return data[r];
    }

    /**
     * Returns a string representation of the queue as a list of elements. This
     * method runs in O(n) time, where n is the size of the queue.
     *
     * @return textual representation of the queue.
     */
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
    public void addFirst(E e) throws IllegalStateException {
        if (sz == data.length) {    // Queue is full
            throw new IllegalStateException("Deque is full");
        }
        if (isEmpty()) {    // Queue is empty
            f = r = 0;
        } else {
            f = (f - 1 + data.length) % data.length;    // Calculate the new front (front--)
        }
        data[f] = e;    // Assing the new element at the front
        sz++;
    }

    @Override
    public void addLast(E e) throws IllegalStateException {
        if (sz == data.length) {    // Queue is full
            throw new IllegalStateException("Deque is full");
        }
        if (isEmpty()) {    // Queue is empty
            f = r = 0;
        } else {
            r = (r + 1) % data.length;  // Calculate the new rear (rear++)
        }
        data[r] = e;    // Assing the new element at the rear
        sz++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {    // Queue is empty
            return null;
        }
        E removed = data[f];

        if (f == r) {   // Only 1 element left in the queue
            f = r = 0;
        } else {
            f = (f + 1) % data.length;  // Calculate the new front (front++)
        }
        sz--;
        return removed;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {    // Queue is empty
            return null;
        }
        E removed = data[r];

        if (f == r) {   // Only 1 element left in the queue
            f = r = 0;
        } else {
            r = (r - 1 + data.length) % data.length;    // Calculate the new rear (rear--)
        }
        sz--;
        return removed;
    }

}
