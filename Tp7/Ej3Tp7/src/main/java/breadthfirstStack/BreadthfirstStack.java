/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package breadthfirstStack;

import net.datastructures.*;

/**
 *
 * @author Mariano
 */
public class BreadthfirstStack {

    static LinkedBinaryTree<String> linkedBinaryTree;
    static Position<String> a, b, c, d, e, f;

    public static void main(String[] args) {
        linkedBinaryTree = new LinkedBinaryTree<>();
        a = linkedBinaryTree.addRoot("A");
        b = linkedBinaryTree.addLeft(a, "B");
        c = linkedBinaryTree.addLeft(b, "C");
        d = linkedBinaryTree.addRight(b, "D");
        e = linkedBinaryTree.addRight(c, "E");
        f = linkedBinaryTree.addRight(a, "F");

        breadthFirst();
        breadthFirstStack();
        System.out.println();
        System.out.println("El recorrido realizado con una pila es de nodo derecho a nodo izquierdo");
        System.out.println("El recorrido realizado con una cola es de nodo izquierdo a nodo derecho ");
    }

    public static void breadthFirst() {
        System.out.println("\n---- breathFirst ----");
        for (Position<String> i : linkedBinaryTree.breadthfirst()) { //breathfirst = Por niveles
            System.out.print(i.getElement());
        }
    }

    public static void breadthFirstStack() {
        System.out.println("\n---- breathFirstStack ----");
        for (Position<String> i : linkedBinaryTree.breadthfirstStack()) { //breathfirst = Por niveles
            System.out.print(i.getElement());
        }

    }
}
