/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.datastructures.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class AbstractTreeTest {

    LinkedBinaryTree<String> tree;
    Position<String> a, b, c, d, e, f;

    @BeforeEach
    public void setUp() {
        tree = new LinkedBinaryTree<>();
        a = tree.addRoot("A");
        b = tree.addLeft(a, "B");
        c = tree.addLeft(b, "C");
        d = tree.addRight(b, "D");
        e = tree.addRight(c, "E");
        f = tree.addRight(a, "F");

    }

    @Test
    public void ancestorTest() {
        System.out.println("--- Ancestors ----");
        System.out.println("Ancestros de F:");
        for (Position<String> p : tree.ancestor(f)) {
            System.out.print(p.getElement());
        }
        System.out.println("\nAncestros de E:");
        for (Position<String> p : tree.ancestor(e)) {
            System.out.print(p.getElement());
        }
    }

    @Test
    public void searchTest() {
        assertEquals(null, tree.search("Z"));
        assertEquals(c, tree.search("C"));
        Position<String> n = tree.addRight(d, null);
        assertEquals(n, tree.search(null));
    }

    @Test
    public void searchAllTest() {
        System.out.println("--- SearchAllTest ----");
        for (Position<String> p : tree.searchAll("F")) {
            System.out.println("Padre de F : " + tree.parent(p).getElement());
        }

        assertTrue(tree.searchAll("Z").isEmpty());

        tree.addRight(d, "E");
        tree.addRight(f, "E");
        for (Position<String> p : tree.searchAll("E")) {
            System.out.println("Padre de E : " + tree.parent(p).getElement());
        }
    }

    @Test
    public void duplicateTest() {
        assertFalse(tree.duplicate());

        tree.addRight(d, "E");
        assertTrue(tree.duplicate());

        tree = new LinkedBinaryTree<>();
        tree.addRight(tree.addRoot(null), null);
        assertTrue(tree.duplicate());
    }

    @Test
    public void listChildrenTest() {
        System.out.println("--- ListChildrenTest ----");
        for (Position<String> p : tree.listChildren()) {
            System.out.print(p.getElement());
        }
    }

    @Test
    public void listGreatAncestor() {
        System.out.println("--- ListGreatAncestor ----");
        for (Position<String> p : tree.listGreaterAncestor()) {
            System.out.print(p.getElement());
        }

    }

    @Test
    public void listDepthTest() {
        System.out.println("--- ListDepth ----");
        for (String p : tree.listDepth(2)) {
            System.out.println(p);
        }
    }
}
