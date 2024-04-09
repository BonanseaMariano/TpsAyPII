/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package circularyLinkedList;

/**
 * An implementation of a circularly linked list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CircularlyLinkedList<E> implements Cloneable {
    //---------------- nested Node class ----------------

    /**
     * Singly linked node, which stores a reference to its element and to the
     * subsequent node in the list.
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;     // an element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;  // a reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods
        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods
        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /**
     * The designated cursor of the list
     */
    private Node<E> tail = null;                  // we store tail (but not head)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                         // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public CircularlyLinkedList() {
    }             // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();         // the head is *after* the tail
    }

    /**
     * Returns (but does not remove) the last element of the list
     *
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
        {
            tail = tail.getNext();         // the old head becomes the new tail
        }
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);                     // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        addFirst(e);             // insert new element at front of list
        tail = tail.getNext();   // now new element becomes the tail
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) {
            return null;              // nothing to remove
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;           // must be the only node left
        } else {
            tail.setNext(head.getNext());       // removes "head" from the list
        }
        size--;
        return head.getElement();
    }

    /**
     * Produces a string representation of the contents of the list. This exists
     * for debugging purposes only.
     */
    public String toString() {
        if (tail == null) {
            return "()";
        }
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail) {
                sb.append(", ");
            }
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    //---------------------------------- METODOS AGREGADOS ------------------------------
    /**
     * @return Inserta el elemento e en la posicion n de la lista
     */
//    public void addPos(E e, int n) throws IndexOutOfBoundsException {
//
//        if (n < 0 || n > size) {
//            throw new IndexOutOfBoundsException("Índice fuera de rango");
//        }
//
//        //Si la posicion es la primera
//        if (n == 0) {
//            this.addFirst(e);
//            return;
//        } else if (n == size) { //si la posicion es la ultima como este caso ya esta contemplado no hace falta modificar a tail
//            this.addLast(e);
//            return;
//        }
//
//        //Si la posicion no es la primera ni la ultima
//        Node<E> walk = tail.getNext();
//        //Recorre hasta llegar a la posicion anterior a la indicada
//        for (int i = 0; i < n - 1; i++) {
//            walk = walk.getNext();
//        }
//
//        walk.setNext(new Node<>(e, walk.getNext())); // Inserta el nuevo nodo
//        size++; //incremento el tamaño de la lista
//
//    }
    /**
     * @return Elimina elemento que se encuentra en la posicion n de la lista,
     * Retorna NULL si no es una posicion valida
     */
    public E removeElement(E e) {
        //El elemento se encontro
        if (search(e) != null) {
            Node<E> actual = tail.getNext();
            Node<E> anterior = tail;
            do {
                if (actual.getElement().equals(e)) {
                    anterior.setNext(actual.getNext());
                    size--;
                    if (actual == tail) { //El unico caso que hay que actualizar la cola es cuando esta se elimina
                        tail = anterior;
                    }
                    return actual.getElement();
                }
                anterior = actual;
                actual = actual.getNext();
            } while (actual != tail.getNext());

        }
        //El elemento no se encontro
        return null;
    }

    /**
     * @return Elimina elemento que se encuentra en la posicion n de la lista,
     * Retorna NULL si no es una posicion valida
     */
//    public E removePos(int n) throws IndexOutOfBoundsException {
//        E eliminado;
//        if (n < 0 || n > size) {
//            throw new IndexOutOfBoundsException("Índice fuera de rango");
//        }
//
//        //Si la posicion es la primera
//        if (n == 0) {
//            eliminado = this.first();
//            this.removeFirst();
//            return eliminado;
//        }
//
//        //Si la posicion no es la primera ni la ultima
//        Node<E> walk = head;
//        //Recorre hasta llegar a la posicion anterior a la indicada
//        for (int i = 0; i < n - 1 && walk.getNext() != null; i++) {
//            walk = walk.getNext();
//        }
//
//        eliminado = walk.getNext().getElement();
//
//        if (walk.getNext() == tail) {  //El elemento esta al final hay que modificar el nodo de tail
//            walk.setNext(null); // Elimina el nodo si es la ultima posicion
//            tail = walk; //seteo la nueva cola
//            size--; // Decremento el tamaño de la lista
//            return eliminado;
//        }
//
//        walk.setNext(walk.getNext().getNext()); // Elimina el nodo si no es la ultima posicion
//        size--; // Decremento el tamaño de la lista
//        return eliminado;
//    }
    /**
     * @return Inserta todos los elementos de la Lista l al final de la lista
     */
    public void concatenate(CircularlyLinkedList l) {
        CircularlyLinkedList<E> nuevaListaCircular = new CircularlyLinkedList<>();
        Node<E> aux = tail.getNext(); //Auxiliar para guardar la cabeza de la original
        
        this.tail.setNext(l.tail.getNext()); //Al siguiente de la cola original le asigno la cabeza de l
        l.tail.setNext(aux); //Al siguiente de la cola l le asigno la cabeza original
        this.tail = l.tail; //La nueva cabeza pasa a ser la de la lista agregada
        
        this.size += l.size; //incremento el tamaño de la lista
    }
    /**
     * @return Busca el elemento e dentro de la lista, Retorna el elemnto si lo
     * encuentra o Null si no esta en la lista
     */
    public E search(E e) {
        Node<E> walk = tail;
        do {
            if (walk.getElement().equals(e)) {
                return walk.getElement();
            }
            walk = walk.getNext();
        } while (walk != tail);

        //El elemento no se encontro
        return null;
    }

//    @SuppressWarnings({"unchecked"})
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        if (getClass() != o.getClass()) {
//            return false;
//        }
//        CircularlyLinkedList other = (CircularlyLinkedList) o;   // use nonparameterized type
//        if (size != other.size) {
//            return false;
//        }
//        Node walkA = head;                               // traverse the primary list
//        Node walkB = other.head;                         // traverse the secondary list
//        while (walkA != null) {
//            if (!walkA.getElement().equals(walkB.getElement())) {
//                return false; //mismatch
//            }
//            walkA = walkA.getNext();
//            walkB = walkB.getNext();
//        }
//        return true;   // if we reach this, everything matched successfully
//    }
    @SuppressWarnings({"unchecked"})
    public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if (size > 0) {                    // we need independent chain of nodes       
            Node<E> walk = tail;      // walk through remainder of original list
            do {
                other.addLast(walk.getNext().getElement());
                walk = walk.getNext();
            } while (walk != tail);
        }
        return other;
    }

//    /**
//     * Crea una nueva lista y copia todos sus elementos
//     *
//     * @return lista nueva copia de la lista actual
//     *
//     */
//    public SinglyLinkedList<E> duplicate() {
//        SinglyLinkedList<E> other = new SinglyLinkedList<E>();
//        Node<E> walk = head;
//        while (walk != null) {
//            other.addLast(walk.getElement());
//            walk = walk.getNext();
//        }
//        return other;
//    }
}
