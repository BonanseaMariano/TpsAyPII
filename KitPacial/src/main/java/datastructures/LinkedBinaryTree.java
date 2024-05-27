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
package datastructures;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> implements Cloneable {

    //---------------- nested Node class ----------------

    /**
     * Nested static class for a binary tree node.
     */
    protected static class Node<E> implements Position<E> {
        private E element;          // an element stored at this node
        private Node<E> parent;     // a reference to the parent node (if any)
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param e          the element to be stored
         * @param above      reference to a parent node
         * @param leftChild  reference to a left child node
         * @param rightChild reference to a right child node
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // update methods
        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    } //----------- end of nested Node class -----------

    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent,
                                 Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // LinkedBinaryTree instance variables
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null;     // root of the tree

    /**
     * The number of nodes in the binary tree
     */
    private int size = 0;              // number of nodes in the tree

    // constructor

    /**
     * Construts an empty binary tree.
     */
    public LinkedBinaryTree() {
    }      // constructs an empty binary tree

    // nonpublic utility

    /**
     * Verifies that a Position belongs to the appropriate class, and is
     * not one that has been previously removed. Note that our current
     * implementation does not actually verify that the position belongs
     * to this particular list instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;       // safe cast
        if (node.getParent() == node)     // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // update methods supported by this class

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                       LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent());  // child's grandparent becomes its parent
        if (node == root)
            root = child;                       // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);                // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);                 // our convention for defunct node
        return temp;
    }

    /**
     * Checks if this object is equal to another object. Two objects are considered equal if they are of the same class and have the same root node.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return equalsHelper(root, ((LinkedBinaryTree) obj).root);
    }

    /**
     * Metodo recursivo para realizar el equals
     *
     * @param p1 posicion del arbol original
     * @param p2 posicion del arbol con el que se compara
     * @return True si los arboles son iguales, False si son distintos
     */
    private boolean equalsHelper(Position<E> p1, Position<E> p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }
        return p1.getElement().equals(p2.getElement())
                && equalsHelper(left(p1), left(p2))
                && equalsHelper(right(p1), right(p2));
    }

    /**
     * Returns an independent clone of the LinkedBinaryTree
     *
     * @return a copy of the LinkedBinaryTree
     * @throws CloneNotSupportedException
     */
    @SuppressWarnings({"unchecked"})
    public LinkedBinaryTree<E> clone() throws CloneNotSupportedException {
        LinkedBinaryTree<E> other = new LinkedBinaryTree<>();

        if (!isEmpty()) {
            other.addRoot(this.root.getElement());
            cloneHelper(root, other, other.root);
        }
        return other;
    }

    /**
     * Recursive method for the clone() method
     *
     * @param p     Position of the main Tree
     * @param other The copy of the Tree
     * @param q     The position of the copy tree where the next node is going to be
     *              placed
     */
    private void cloneHelper(Position<E> p, LinkedBinaryTree<E> other, Position<E> q) {
        for (Position<E> c : children(p)) {
            Position<E> temp;
            if (c == left(p)) { // Node is left child
                temp = other.addLeft(q, c.getElement());
            } else { // Node is right child
                temp = other.addRight(q, c.getElement());
            }
            cloneHelper(c, other, temp);
        }
    }

    /**
     * Reemplaza todas las ocurrencias de un elemento por otro.
     *
     * @param search  elemento a buscar
     * @param replace elemento a remplazar
     * @return retorna un iterable con todas las posiciones de los elementos
     * reemplazados
     */
    public Iterable<Position<E>> replaceAll(E search, E replace) {
        java.util.List<Position<E>> snapshot = new java.util.ArrayList<>();

        for (Position<E> p : positions()) {
            if (p.getElement() == null && search == null) {
                snapshot.add(p);
                this.set(p, replace);
            }
            if (p.getElement() != null && p.getElement().equals(search)) {
                snapshot.add(p);
                this.set(p, replace);
            }
        }
        return snapshot;
    }

    /**
     * Crea un árbol a partir de un árbol binario pasado en un arreglo
     * <p>
     * Por ejemplo dado el siguiente array:
     * <p>
     * {"/", "*", "+", "+", "4", "-", "2", "3", "1", null, null, "9", "5", null,
     * null }
     * <p>
     * Crea un árbol cuyo recorrido es el siguiente:
     * <p>
     * Por nivel: / * + + 4 - 2 3 1 9 5
     * <p>
     * Inorder: 3 + 1 * 4 / 9 - 5 + 2
     *
     * @param array representación de un árbol binario en un arreglo
     */
    public LinkedBinaryTree(E array[]) {
        addRoot(array[0]); // Asume que el primer elemento es la raíz
        createTreeRecursive(root, array, 0);
    }

    /**
     * Funcion recursiva para crear el arbol a partir de un arbol en
     * LinkedBinaryTree()
     *
     * @param p     la posicion de donde se colocaran los nodos
     * @param array el arreglo con los elementos a colocar en el arbol
     * @param index el indice donde se encuentra el elemento a colocar
     */
    private void createTreeRecursive(Position<E> p, E[] array, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < array.length && array[leftIndex] != null) {
            Position<E> leftChild = addLeft(p, array[leftIndex]);
            createTreeRecursive(leftChild, array, leftIndex);
        }
        if (rightIndex < array.length && array[rightIndex] != null) {
            Position<E> rightChild = addRight(p, array[rightIndex]);
            createTreeRecursive(rightChild, array, rightIndex);
        }
    }

    /**
     * Retorna una lista que contiene la representación de un árbol binario.
     *
     * @return Lista que contiene la representación de un árbol binario.
     */
    public java.util.List<E> ListBinaryTree() {
        java.util.List<E> snapshot = new java.util.ArrayList<>();
        for (Position<E> p : breadthfirst()) {
            snapshot.add(p.getElement());
            if (p != root && sibling(p) == null) {
                snapshot.add(null);
            }
        }
        return (java.util.List<E>) snapshot;
    }

    /**
     * Verifica si el árbol t es un subArbol. Es decir que el árbol t está contenido
     * dentro del árbol
     *
     * @param t árbol a verificar
     * @return true si t es una subArbol o false si no lo es.
     */
    /**
     * Ejemplo, dado el árbol:
     * <p>
     * 1
     * <p>
     * / \
     * <p>
     * 2 3
     * <p>
     * / \ / \
     * <p>
     * 4 5 6 7
     * <p>
     * El siguiente árbol es un subArbol:
     * <p>
     * 3
     * <p>
     * / \
     * <p>
     * 6 7
     */
    public boolean isSubtree(LinkedBinaryTree<E> t) {
        if (t.size > size)
            return false;

        int i;
        ArrayList<E> l1 = new ArrayList<>();
        ArrayList<E> l2 = new ArrayList<>();

        i = 0;
        for (Position<E> e : inorder())
            l1.add(i++, e.getElement());

        i = 0;
        for (Position<E> e : t.inorder())
            l2.add(i++, e.getElement());

        if (!l1.isSubList(l2))
            return false;

        l1 = new ArrayList<>();
        l2 = new ArrayList<>();

        i = 0;
        for (Position<E> e : postorder())
            l1.add(i++, e.getElement());

        i = 0;
        for (Position<E> e : t.postorder())
            l2.add(i++, e.getElement());

        if (!l1.isSubList(l2))
            return false;

        return true;
    }

    /**
     * Retorna una lista con todas las posiciones de los elementos que son primos de
     * un elemento dado. Un elemento es primo de otro elemento si tiene la misma
     * profundidad y distintos padres.
     *
     * @param p posición del elemento
     * @return Retorna una lista con todas las posiciones de los elementos que son
     * primos del elemento que está en la posición p.
     */
    public List<Position<E>> cousins(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>();
        for (Position<E> e : breadthfirst()) {
            if (depth(p) == depth(e) && parent(p) != parent(e)) {
                snapshot.add(snapshot.size(), e);
            }
        }
        return snapshot;
    }

} //----------- end of LinkedBinaryTree class -----------
