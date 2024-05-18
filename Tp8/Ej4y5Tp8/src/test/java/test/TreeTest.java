/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.List;
import net.datastructures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mariano
 */
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
    }

    @Test
    public void mapDepthTest() {
        Map<Integer, List<String>> mapa = linkedBinaryTree.mapDepth();
        assertTrue(mapa.get(0).contains(a));
        assertTrue(mapa.get(1).contains(b));
        assertTrue(mapa.get(1).contains(f));
        assertTrue(mapa.get(2).contains(c));
        assertTrue(mapa.get(2).contains(d));
        assertTrue(mapa.get(3).contains(e));
        assertFalse(mapa.get(0).contains(f));
    }

}
