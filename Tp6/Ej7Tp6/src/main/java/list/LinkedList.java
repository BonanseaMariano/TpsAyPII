package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mariano
 */
public class LinkedList<E> implements interfaces.List<E> {
// instance variables


    /**
     * Generic list used for storage of elements.
     */
    private DoublyLinkedList<E> data;                        // generic array used for storage

    // constructors

    /**
     * Creates an array list with default initial capacity.
     */
    public LinkedList() {
        data = new DoublyLinkedList<>();
    }   // constructs list with default capacity

    // public methods

    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    public int size() {
        return data.size();
    }

    /**
     * Tests whether the array list is empty.
     *
     * @return true if the array list is empty, false otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns (but does not remove) the element at index i.
     *
     * @param i the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size());
        int j = 0;
        Iterator<E> ite = iterator();
        while (j < i) {
            ite.next();
            j++;
        }
        return ite.next();
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     *
     * @param i the index of the element to replace
     * @param e the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size());
        E temp = get(i);
        Iterator<E> ite = iterator();
        while (ite.hasNext() ) {
            ite.next();
            j++;
        }
        return temp;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
        data.addBetween();
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     *
     * @param i the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill hole
        {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;                   // help garbage collection
        size--;
        return temp;
    }

    // utility methods

    /**
     * Checks whether the given index is in the range [0, n-1].
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Resizes internal array to have given capacity >= size.
     */
    @SuppressWarnings({"unchecked"})
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];     // safe cast; compiler may give warning
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;                               // start using the new array
    }

    @Override
    public void clear() {
        Iterator<E> ite = iterator();
        while (iterator().hasNext()) {
            ite.next();
            ite.remove();
        }
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null && e == null) {
                return true;
            }
            if (data[i] != null && data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null && e == null) {
                return i;
            }
            if (data[i] != null && data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == null && e == null) {
                return i;
            }
            if (data[i] != null && data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(E e) {
        try {
            remove(indexOf(e));
            return true;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    //---------------- nested ArrayIterator class ----------------

    /**
     * A (nonstatic) inner class. Note well that each instance contains an
     * implicit reference to the containing list, allowing it to access the
     * list's members.
     */
    private class ArrayIterator implements Iterator<E> {

        /**
         * Index of the next element to report.
         */
        private int j = 0;                   // index of the next element to report
        private boolean removable = false;   // can remove be called at this time?

        /**
         * Tests whether the iterator has a next object.
         *
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext() {
            return j < size;
        }   // size is field of outer instance

        /**
         * Returns the next object in the iterator.
         *
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            removable = true;   // this element can subsequently be removed
            return data[j++];   // post-increment j, so it is ready for future call to next
        }

        /**
         * Removes the element returned by most recent call to next.
         *
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since
         *                               recent next
         */
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("nothing to remove");
            }
            ArrayList.this.remove(j - 1);  // that was the last one returned
            j--;                         // next element has shifted one cell to the left
            removable = false;           // do not allow remove again until next is called
        }
    } //------------ end of nested ArrayIterator class ------------

    /**
     * Returns an iterator of the elements stored in the list.
     *
     * @return iterator of the list's elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();     // create a new instance of the inner class
    }

    /**
     * Produces a string representation of the contents of the indexed list.
     * This exists for debugging purposes only.
     *
     * @return textual representation of the array list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[j]);
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Sets the array size to the current number of elements on it
     */
    public void trimToSize() {
        resize(size);
    }

    /**
     * For testing the trimToSize method
     *
     * @return the array of the ArrayList
     */
    public int getDataLen() {
        return data.length;
    }

}
