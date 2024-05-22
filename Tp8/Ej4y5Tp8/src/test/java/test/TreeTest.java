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
 * @author Mariano
 */
public class TreeTest {

    LinkedBinaryTree<String> linkedBinaryTree;
    Position<String> a, b, c, d, e, f, g;

    @BeforeEach
    public void setUp() {
        linkedBinaryTree = new LinkedBinaryTree<>();
        a = linkedBinaryTree.addRoot("*");
        b = linkedBinaryTree.addLeft(a, "+");
        c = linkedBinaryTree.addLeft(b, "2");
        d = linkedBinaryTree.addRight(b, "-");
        e = linkedBinaryTree.addRight(c, "5");
        f = linkedBinaryTree.addLeft(c, "E");
        g = linkedBinaryTree.addRight(a, "2");
    }

    @Test
    public void mapDepthTest() {
        Map<Integer, List<String>> mapa = linkedBinaryTree.mapDepth();
        assertTrue(mapa.get(0).contains(a));
        assertTrue(mapa.get(1).contains(b));
        assertTrue(mapa.get(1).contains(g));
        assertTrue(mapa.get(2).contains(c));
        assertTrue(mapa.get(2).contains(d));
        assertTrue(mapa.get(3).contains(e));
        assertTrue(mapa.get(3).contains(f));
        assertFalse(mapa.get(0).contains(f));
    }

    @Test
    public void postfixExpressionTest() {
        Map<String, Double> v = new UnsortedTableMap<>();
        v.put("E", 7.0);

        List<String> lista = linkedBinaryTree.postfixExpression(v);

        assertTrue(lista.contains("*"));
        assertTrue(lista.contains("+"));
        assertTrue(lista.contains("-"));
        assertTrue(lista.contains("2"));
        assertTrue(lista.contains("5"));
        assertTrue(lista.contains("7.0"));

        linkedBinaryTree.set(e, "Z");
        assertThrows(ArithmeticException.class, () -> linkedBinaryTree.postfixExpression(v));
    }
}
