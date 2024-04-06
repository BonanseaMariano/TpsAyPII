package singlyLinkedList;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 */
public class SinglyLinkedList<E> implements Cloneable {
    //---------------- nested Node class ----------------

    /**
     * Node of a singly linked list, which stores a reference to its element and
     * to the subsequent node in the list (or null if this is the last node).
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

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

    // instance variables of the SinglyLinkedList
    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)

    /**
     * The last node of the list
     */
    private Node<E> tail = null;               // last node of the list (or null if empty)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public SinglyLinkedList() {
    }              // constructs an initially empty list

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
        return head.getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        head = new Node<>(e, head);              // create and link a new node
        if (size == 0) {
            tail = head;                           // special case: new node becomes tail also
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
        if (isEmpty()) {
            head = newest;                         // special case: previously empty list
        } else {
            tail.setNext(newest);                  // new node after existing tail
        }
        tail = newest;                           // new node becomes the tail
        size++;
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
        E answer = head.getElement();
        head = head.getNext();                   // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null;                           // special case as list is now empty
        }
        return answer;
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
        if (size != other.size) {
            return false;
        }
        Node walkA = head;                               // traverse the primary list
        Node walkB = other.head;                         // traverse the secondary list
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false; //mismatch
            }
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;   // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
        if (size > 0) {                    // we need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();      // walk through remainder of original list
            Node<E> otherTail = other.head;     // remember most recently created node
            while (walk != null) {              // make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);     // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
            h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
        }
        return h;
    }

    /**
     * Produces a string representation of the contents of the list. This exists
     * for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail) {
                sb.append(", ");
            }
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    //---------------------------------- METODOS AGREGADOS ------------------------------
    /**
     * @return Inserta el elemento e en la posicion n de la lista
     */
    public void addPos(E e, int n) throws IndexOutOfBoundsException {

        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        //Si la posicion es la primera
        if (n == 0) {
            this.addFirst(e);
            return;
        } else if (n == size) { //si la posicion es la ultima como este caso ya esta contemplado no hace falta modificar a tail
            this.addLast(e);
            return;
        }

        //Si la posicion no es la primera ni la ultima
        Node<E> walk = head;
        //Recorre hasta llegar a la posicion anterior a la indicada
        for (int i = 0; i < n - 1; i++) {
            walk = walk.getNext();
        }

        walk.setNext(new Node<>(e, walk.getNext())); // Inserta el nuevo nodo
        size++; //incremento el tamaño de la lista

    }

    /**
     * @return Elimina elemento que se encuentra en la posicion n de la lista,
     * Retorna NULL si no es una posicion valida
     */
    public E removeElement(E e) {
        //El elemento se encontro
        if (search(e) != null) {
            Node<E> actual = head.getNext();
            Node<E> anterior = head;

            //Esta en la primera posicion
            if (anterior.getElement() == e) {
                removeFirst();
                System.out.println("cola" + tail.getElement());
                return actual.getElement();
            }

            while (actual != null) {
                if (actual.getElement() == e) {
                    anterior.setNext(actual.getNext());
                    if (actual == tail) {  //El elemento se encontro y esta al final hay que modificar el nodo de tail
                        tail = anterior;
                    }
                    size--; //Decremento el tamaño de la lista
                    return actual.getElement();
                }

                anterior = actual;
                actual = actual.getNext();
            }
        }
        //El elemento no se encontro
        return null;
    }

    /**
     * @return Elimina elemento que se encuentra en la posicion n de la lista,
     * Retorna NULL si no es una posicion valida
     */
    public E removePos(int n) throws IndexOutOfBoundsException {
        E eliminado;
        if (n < 0 || n > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        //Si la posicion es la primera
        if (n == 0) {
            eliminado = this.first();
            this.removeFirst();
            return eliminado;
        }

        //Si la posicion no es la primera ni la ultima
        Node<E> walk = head;
        //Recorre hasta llegar a la posicion anterior a la indicada
        for (int i = 0; i < n - 1 && walk.getNext() != null; i++) {
            walk = walk.getNext();
        }

        eliminado = walk.getNext().getElement();

        if (walk.getNext() == tail) {  //El elemento esta al final hay que modificar el nodo de tail
            walk.setNext(null); // Elimina el nodo si es la ultima posicion
            tail = walk; //seteo la nueva cola
            size--; // Decremento el tamaño de la lista
            return eliminado;
        }

        walk.setNext(walk.getNext().getNext()); // Elimina el nodo si no es la ultima posicion
        size--; // Decremento el tamaño de la lista
        return eliminado;
    }

    /**
     * @return Inserta todos los elementos de la Lista l al final de la lista
     */
    public void concatenate(SinglyLinkedList l) {
        Node<E> copia = l.head;
        for (int i = 0; i < l.size; i++) {
            this.addLast(copia.getElement());
            copia = copia.getNext();
        }
        this.size += l.size; //incremento el tamaño de la lista
    }

    /**
     * @return Busca el elemento e dentro de la lista, Retorna el elemnto si lo
     * encuentra o Null si no esta en la lista
     */
    public E search(E e) {

        Node<E> walk = head;
        while (walk != null) {
            //El elemento se encontro
            if (walk.getElement() == e) {
                return walk.getElement();
            }
            walk = walk.getNext();
        }

        //El elemento no se encontro
        return null;
    }

}