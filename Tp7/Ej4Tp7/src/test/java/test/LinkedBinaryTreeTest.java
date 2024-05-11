/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.datastructures.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class LinkedBinaryTreeTest {

    LinkedBinaryTree<String> linkedBinaryTree, clon;
    Position<String> a, b, c, d, e, f;

    @BeforeEach
    public void setUp() {
        linkedBinaryTree = new LinkedBinaryTree<>();
        a = linkedBinaryTree.addRoot("A");
        b = linkedBinaryTree.addLeft(a, "B");
        c = linkedBinaryTree.addLeft(b, "C");
        d = linkedBinaryTree.addRight(b, "D");
        e = linkedBinaryTree.addRight(c, "E");
        f = linkedBinaryTree.addRight(a, "F");
        linkedBinaryTree.addRight(f, "H");
        linkedBinaryTree.addLeft(f, "G");
    }

    @Test
    public void cloneYEqualsTest() {
        try {
            clon = linkedBinaryTree.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(LinkedBinaryTreeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        preOrder(linkedBinaryTree, "Original");
        preOrder(clon, "Clon");
        postOrder(linkedBinaryTree, "Original");
        postOrder(clon, "Clon");
        inOrder(linkedBinaryTree, "Original");
        inOrder(clon, "Clon");
        breadthFirst(linkedBinaryTree, "Original");
        breadthFirst(clon, "Clon");

        assertTrue(linkedBinaryTree.equals(clon));
        clon.set(clon.root(), "Z");
        assertFalse(linkedBinaryTree.equals(clon));
    }

    public void preOrder(LinkedBinaryTree<String> tree, String nombre) {
        System.out.println("---- Preorder " + nombre + " (RID)----");
        for (Position<String> i : tree.preorder()) { //preorder = RID
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    public void inOrder(LinkedBinaryTree<String> tree, String nombre) {
        System.out.println("\n---- InOrder " + nombre + " (IRD)----");
        for (Position<String> i : tree.inorder()) { //inorder = IRD
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    public void postOrder(LinkedBinaryTree<String> tree, String nombre) {
        System.out.println("\n---- PostOrder " + nombre + "(IDR)----");
        for (Position<String> i : tree.postorder()) { //postorder = IDR
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    public void breadthFirst(LinkedBinaryTree<String> tree, String nombre) {
        System.out.println("\n---- Por Niveles " + nombre + " ----");
        for (Position<String> i : tree.breadthfirst()) { //breathfirst = Por niveles
            System.out.print(i.getElement());
        }
        System.out.println();
    }
}
