/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.datastructures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Mariano
 */
@TestMethodOrder(OrderAnnotation.class)
public class TreeTest {

    LinkedBinaryTree<String> linkedBinaryTree;
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
    @Order(1)
    public void preOrder() {
        System.out.println("---- Preorder (RID)----");
        for (Position<String> i : linkedBinaryTree.preorder()) { //preorder = RID
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    @Test
    @Order(2)
    public void inOrder() {
        System.out.println("\n---- InOrder (IRD)----");
        for (Position<String> i : linkedBinaryTree.inorder()) { //inorder = IRD
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    @Test
    @Order(3)
    public void postOrder() {
        System.out.println("\n---- PostOrder (IDR)----");
        for (Position<String> i : linkedBinaryTree.postorder()) { //postorder = IDR
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    @Test
    @Order(4)
    public void breadthFirst() {
        System.out.println("\n---- Por Niveles ----");
        for (Position<String> i : linkedBinaryTree.breadthfirst()) { //breathfirst = Por niveles
            System.out.print(i.getElement());
        }
        System.out.println();
    }

    @Test
    @Order(5)
    public void hijosRaizYAltura() {
        System.out.println("\nNodo raiz: " + linkedBinaryTree.root().getElement()); //Raiz
        assertEquals("A", linkedBinaryTree.root().getElement());

        System.out.println("Hijos de raiz: ");
        for (Position<String> i : linkedBinaryTree.children(linkedBinaryTree.root())) {
            System.out.println(i.getElement() + " ");
        }

        System.out.println("\nAltura desde la raiz: " + linkedBinaryTree.height(linkedBinaryTree.root())); //Raiz
        assertEquals(3, linkedBinaryTree.height(linkedBinaryTree.root()));

    }

    @Test
    @Order(6)
    public void sibiling() {
        System.out.println("sibiling de b: " + linkedBinaryTree.sibling(b).getElement());
        assertEquals("F", linkedBinaryTree.sibling(b).getElement());
    }

    @Test
    @Order(7)
    public void produndidadNodoHoja() {
        System.out.println("Profundidad desde e: " + linkedBinaryTree.depth(e));
        assertEquals(3, linkedBinaryTree.depth(e));
        System.out.println("Profundidad desde f: " + linkedBinaryTree.depth(f));
        assertEquals(1, linkedBinaryTree.depth(f));
        System.out.println("Profundidad desde d: " + linkedBinaryTree.depth(d));
        assertEquals(2, linkedBinaryTree.depth(d));
    }

    @Test
    @Order(8)
    public void drawTreeTest() {
        System.out.println("\nImpresion arbol:");
        drawTree();
    }

    public String calculateIndent(Position<String> pos) {
        int level = linkedBinaryTree.height(pos);
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += "  ";
        }
        return indent;
    }

    public void drawTree() {
        int lvl = 0;
        var ite = linkedBinaryTree.breadthfirst();

        Position<String> padre = linkedBinaryTree.root();

        String cadena = "";
        for (Position<String> i : ite) {
            if (lvl != linkedBinaryTree.depth(i)) {
                cadena += "\n";
                lvl = linkedBinaryTree.depth(i);
            }

            cadena += calculateIndent(i) + i.getElement() + "  ";
        }
        System.out.println(cadena);
    }
}
