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
package net.datastructures;

import java.util.Iterator;
import java.util.List;         // for use as snapshot iterator
import java.util.ArrayList;    // for use as snapshot iterator
import jdk.jshell.spi.ExecutionControl;

/**
 * An abstract base class providing some functionality of the Tree interface.
 *
 * The following three methods remain abstract, and must be implemented by a
 * concrete subclass: root, parent, children. Other methods implemented in this
 * class may be overridden to provide a more direct and efficient
 * implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * Returns true if Position p has one or more children.
     *
     * @param p A valid Position within the tree
     * @return true if p has at least one child, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    @Override
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * Returns true if Position p does not have any children.
     *
     * @param p A valid Position within the tree
     * @return true if p has zero children, false otherwise
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    @Override
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * Returns true if Position p represents the root of the tree.
     *
     * @param p A valid Position within the tree
     * @return true if p is the root of the tree, false otherwise
     */
    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * Returns the number of children of Position p.
     *
     * @param p A valid Position within the tree
     * @return number of children of Position p
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        for (Position child : children(p)) {
            count++;
        }
        return count;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        int count = 0;
        for (Position p : positions()) {
            count++;
        }
        return count;
    }

    /**
     * Tests whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    //---------- support for computing depth of nodes and height of (sub)trees ----------
    /**
     * Returns the number of levels separating Position p from the root.
     *
     * @param p A valid Position within the tree
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    public int depth(Position<E> p) throws IllegalArgumentException {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * Returns the height of the tree.
     *
     * Note: This implementation works, but runs in O(n^2) worst-case time.
     */
    private int heightBad() {             // works, but quadratic worst-case time
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) // only consider leaf positions
            {
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     *
     * @param p A valid Position within the tree
     * @throws IllegalArgumentException if p is not a valid Position for this
     * tree.
     */
    public int height(Position<E> p) throws IllegalArgumentException {
        int h = 0;                          // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    //---------- support for various iterations of a tree ----------
    //---------------- nested ElementIterator class ----------------
    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = positions().iterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the tree.
     *
     * @return iterator of the tree's elements
     */
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Returns an iterable collection of the positions of the tree.
     *
     * @return iterable collection of the tree's positions
     */
    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * using a preorder traversal
     *
     * @param p Position serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);                       // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in
     * preorder.
     *
     * @return iterable collection of the tree's positions in preorder
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot);   // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * using a postorder traversal
     *
     * @param p Position serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);                       // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in
     * postorder.
     *
     * @return iterable collection of the tree's positions in postorder
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot);   // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree in breadth-first
     * order.
     *
     * @return iterable collection of the tree's positions in breadth-first
     * order
     */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());                 // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();     // remove from front of the queue
                snapshot.add(p);                      // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c);                  // add children to back of queue
                }
            }
        }
        return snapshot;
    }

    /**
     * Retorna una colección iterable con las posiciones de los ancestros hasta
     * la raíz
     *
     * @param p posición del primer nodo
     * @return colección iterable con las posiciones de los ancestros hasta la
     * raíz
     */
    public Iterable<Position<E>> ancestor(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>();

        while (parent(p) != null) {
            snapshot.add(parent(p));
            p = parent(p);
        }

        return snapshot;
    }

    /**
     * Busca un elemento dentro del árbol y retorna su posición o null si no se
     * encuentra
     *
     * @param e elemento a buscar
     * @return la posición donde se encuentra el elemento "e" o null si no se
     * encuentra
     */
    public Position<E> search(E e) {
        for (Position<E> p : positions()) {
            if (p.getElement() == null && e == null) {
                return p;
            }
            if (p.getElement() != null && p.getElement().equals(e)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Retorna una lista con todas las posiciones de los elementos encontrados
     *
     * @param e elemento a buscar
     * @return lista con las posiciones donde se encuentra el elemento "e"
     */
    public List<Position<E>> searchAll(E e) {
        List<Position<E>> snapshot = new ArrayList<>();

        for (Position<E> p : positions()) {
            if (p.getElement() == null && e == null) {
                snapshot.add(p);
            }
            if (p.getElement() != null && p.getElement().equals(e)) {
                snapshot.add(p);
            }
        }
        return snapshot;
    }

    /**
     * Indica si un árbol tienen elementos duplicados
     *
     * @return "true" si tiene elementos duplicados o "false" caso contrario
     */
    public boolean duplicate() {
        for (Position<E> pos : positions()) {
            for (Position<E> p : positions()) {
                if (pos != p) {
                    if (pos.getElement() == null && p.getElement() == null) {
                        return true;
                    }
                    if (pos.getElement() != null && pos.getElement().equals(p.getElement())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Retorna un iterable con todas las posiciones de los nodos externos
     * (hijos)
     *
     * @return iterable de las posiciones de los nodos externos
     */
    public Iterable<Position<E>> listChildren() {
        List<Position<E>> snapshot = new ArrayList<>();
        for (Position<E> p : positions()) {
            if (isExternal(p)) {
                snapshot.add(p);
            }
        }
        return snapshot;
    }

    /**
     * Retorna un iterable con todas las posiciones de la rama más larga de un
     * árbol comenzando desde un nodo externo hasta llegar a la raíz
     *
     * Si hay más de una rama con la misma profundidad, retorna una de las ramas
     * que cumpla con la condición dada
     *
     * @return iterable de las posiciones de rama más larga de un árbol
     */
    public Iterable<Position<E>> listGreaterAncestor() {

        //Calculo de la rama mas larga
        int maxdepth = -1; //Una depth invalida para poder utilizarla y acceder a la primera posicion
        Position<E> maxdpos = null; //Una posicion invalida para poder utilizarla y acceder a la primera posicion

        for (Position<E> p : listChildren()) {
            int currentDepth = depth(p); //Auxiliar para no llamar tantas veces a la funcion recursiva
            if (maxdpos == null) { // Primera posicion de los nodos externos
                maxdepth = currentDepth;
                maxdpos = p;
            }
            if (currentDepth > maxdepth) {
                maxdepth = currentDepth;
            }
        }

        List<Position<E>> snapshot = (List<Position<E>>) ancestor(maxdpos);
        snapshot.add(0, maxdpos);

        return snapshot;
    }

    /**
     * Retorna un iterable con los valores de todos los nodos que tienen la
     * profundidad depth
     *
     * @param depth profundidad
     *
     * @return iterable con los valores de los nodos que tienen la profundidad
     * depth
     */
    public Iterable<E> listDepth(int depth) {
        List<E> snapshot = new ArrayList<>();
        for (Position<E> p : positions()) {
            if (depth(p) == depth) {
                snapshot.add(p.getElement());
            }
        }
        return snapshot;
    }

}
