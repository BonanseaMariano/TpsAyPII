package doublyLinkedDeque;

import interfaces.Deque;

/**
 *
 * @author Mariano
 */
public class DoublyLinkedDeque<E> implements Deque<E> {

    /**
     * The primary storage for elements of the queue
     */
    private DoublyLinkedList<E> doublyLinkedList = new DoublyLinkedList<>();    // an empty double linked list

    /**
     * Constructs an initially empty queue.
     */
    public DoublyLinkedDeque() {    // new queue relies on the initially empty list
    }

    @Override
    public int size() {
        return doublyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    @Override
    public E first() {
        return doublyLinkedList.first();
    }

    @Override
    public E last() {
        return doublyLinkedList.last();
    }

    @Override
    public void addFirst(E e) {
        doublyLinkedList.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        doublyLinkedList.addLast(e);
    }

    @Override
    public E removeFirst() {
        return doublyLinkedList.removeFirst();
    }

    @Override
    public E removeLast() {
        return doublyLinkedList.removeLast();
    }

    @Override
    public String toString() {
        return doublyLinkedList.toString();
    }

}
