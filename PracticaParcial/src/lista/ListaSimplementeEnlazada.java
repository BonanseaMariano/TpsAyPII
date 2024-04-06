/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariano
 */
public class ListaSimplementeEnlazada<E> implements Cloneable {

    private static class Node<E> {

        private E element;            // reference to the element stored at this node
        private Node<E> next;         // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    //Atributos de la lista
    private Node<E> head = null;               // head node of the list (or null if empty)
    private Node<E> tail = null;               // last node of the list (or null if empty)
    private int size = 0;                      // number of nodes in the list

    public ListaSimplementeEnlazada() {
    }              // constructs an initially empty list

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

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

    /**
     * Crea una nueva lista y copia todos sus elementos
     *
     * @return lista nueva con una copia de la lista actual
     *
     */
    public ListaSimplementeEnlazada<E> duplicate() {
        ListaSimplementeEnlazada<E> other = new ListaSimplementeEnlazada<E>();
        Node<E> walk = head;
        while (walk != null) {
            other.addLast(walk.getElement());
            walk = walk.getNext();
        }
        return other;
    }

    /**
     * Retorna la lista con todos los elementos de la lista l insertados a
     * partir de la posición pos.
     *
     * Considere la opción de utilizar el método duplicate() o clone()
     *
     * No utilizar métodos que insertan de a un elemento como por ejemplo
     * addPos(E, p)
     *
     * Por ejemplo:
     *
     * Dada la lista: {A, B, C, D} y la lista l = {X, Y}
     *
     * addPos(l, 2) => {A, B, X, Y, C, D}
     *
     * addPos(l, 0) => {X, Y, A, B, C, D}
     *
     * addPos(l, 4) => {A, B, C, D, X, y}
     *
     * @param ListaSimplementeEnlazada<E> l : lista a insertar
     * @param ListaSimplementeEnlazada<E> pos : posición a partir de donde se
     * inserta
     *
     *
     * @return lista original más todos los elementos de la lista l insertados a
     * partir de la posición pos
     *
     * @exception Si los índices están fuera de rango lanza la excepción
     * IndexOutOfBoundsException
     *
     */
    public void addList(ListaSimplementeEnlazada<E> l, int pos) throws IndexOutOfBoundsException {
        //Posicion invalida
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posici�n inv�lida: " + pos);
        }
        //La lista a insertar esta vacia
        if (l.isEmpty()) {
            return;
        }
        //Duplico la lista a introducir para no tener referencias a la misma lista
        ListaSimplementeEnlazada<E> other = l.duplicate();
        Node<E> walk = head; //Nodo actual
        Node<E> ant = null; //Nodo anterior
        int c = 0; //Contador
        while (c < pos) { //Recorro hasta pos
            ant = walk;
            walk = walk.getNext();
            c++;
        }
        //Si la posicion es la primera actualizo la cabeza para que sea igual a la a insertar
        if (ant == null) {
            head = other.head;
        } else {
            //Sino seteo el siguiente del anterior a la cabeza del nuevo
            ant.setNext(other.head);
        }
        //Y seteo la cola de lo que voy a ingresar como el ultimo nodo que se recorrio
        other.tail.setNext(walk);
        //Si la posicion a ingresar es la ultima entonces actualizo la cola para que quede como la ultima de la a ingresar
        if (size == pos) {
            tail = other.tail;
        }
        //Incremento el tamaño de la lista
        size += other.size;

    }
}
