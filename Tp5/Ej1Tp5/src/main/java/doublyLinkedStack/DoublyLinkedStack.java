package doublyLinkedStack;

import stackInterface.Stack;

/**
 *
 * @author Mariano
 */
public class DoublyLinkedStack<E> implements Stack<E> {

    private DoublyLinkedList<E> doublyLinkedList = new DoublyLinkedList<>();

    public DoublyLinkedStack() {
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    @Override
    public int size() {
        return doublyLinkedList.size();
    }

    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    /**
     * Inserts an element at the top of the stack.
     *
     * @param element the element to be inserted
     */
    @Override
    public void push(E element) {
        doublyLinkedList.addFirst(element);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     *
     * @return top element in the stack (or null if empty)
     */
    @Override
    public E top() {
        return doublyLinkedList.first();
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return element removed (or null if empty)
     */
    @Override
    public E pop() {
        return doublyLinkedList.removeFirst();
    }

    /**
     * Produces a string representation of the contents of the stack. (ordered
     * from top to bottom)
     *
     * This exists for debugging purposes only.
     *
     * @return textual representation of the stack
     */
    public String toString() {
        return doublyLinkedList.toString();
    }

}
