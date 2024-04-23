package arrayCircularQueue;

import interfaces.CircularQueue;

/**
 *
 * @author Mariano
 */
public class ArrayCircularQueue<E> implements CircularQueue<E> {

    ArrayQueue<E> arrayQueue;

    public ArrayCircularQueue() {
        arrayQueue = new ArrayQueue<>();
    }

    public ArrayCircularQueue(int capacity) {
        arrayQueue = new ArrayQueue<>(capacity);
    }

    @Override
    public void rotate() {
        arrayQueue.enqueue(arrayQueue.dequeue());
    }

    @Override
    public int size() {
        return arrayQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        arrayQueue.enqueue(e);
    }

    @Override
    public E first() {
        return arrayQueue.first();
    }

    @Override
    public E dequeue() {
        return arrayQueue.dequeue();
    }

    @Override
    public String toString() {
        return arrayQueue.toString();
    }

}
