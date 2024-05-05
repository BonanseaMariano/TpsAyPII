/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import list.ArrayList;

/**
 *
 * @author Mariano
 */
public class ArrayStack<E> implements interfaces.Stack<E> {

    ArrayList<Object> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.add(0, e);
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return (E) list.get(0);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return (E) list.remove(0);
    }

}
