/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deque;

import java.util.NoSuchElementException;
import list.ArrayList;

/**
 *
 * @author Mariano
 */
public class ArrayDeque<E> implements interfaces.Deque<E> {

    ArrayList<E> deque = new ArrayList<>();

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return deque.get(0);
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return deque.get(deque.size() - 1);
    }

    @Override
    public void addFirst(E e) {
        deque.add(0, e);
    }

    @Override
    public void addLast(E e) {
        deque.add(deque.size(), e);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return deque.remove(0);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return deque.remove(deque.size() - 1);
    }

}
