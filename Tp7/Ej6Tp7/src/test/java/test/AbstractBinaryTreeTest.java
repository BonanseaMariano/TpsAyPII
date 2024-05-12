/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.List;
import net.datastructures.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class AbstractBinaryTreeTest {

    //“((5+2) * (2−1))/((2+9)+((7−2)−1)) *8”
    LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
    Position<String>[] p = new Position[19];

    @BeforeEach
    public void setUp() {
        p[0] = linkedBinaryTree.addRoot("*");

        p[1] = linkedBinaryTree.addRight(p[0], "8");
        p[2] = linkedBinaryTree.addLeft(p[0], "/");

        p[3] = linkedBinaryTree.addRight(p[2], "+");
        p[4] = linkedBinaryTree.addLeft(p[2], "*");

        p[5] = linkedBinaryTree.addRight(p[4], "-");
        p[6] = linkedBinaryTree.addLeft(p[4], "+");
        p[7] = linkedBinaryTree.addRight(p[3], "-");
        p[8] = linkedBinaryTree.addLeft(p[3], "+");

        p[9] = linkedBinaryTree.addRight(p[5], "1");
        p[10] = linkedBinaryTree.addLeft(p[5], "2");
        p[11] = linkedBinaryTree.addRight(p[6], "2");
        p[12] = linkedBinaryTree.addLeft(p[6], "5");
        p[13] = linkedBinaryTree.addRight(p[7], "1");
        p[14] = linkedBinaryTree.addLeft(p[7], "-");
        p[15] = linkedBinaryTree.addRight(p[8], "9");
        p[16] = linkedBinaryTree.addLeft(p[8], "2");

        p[17] = linkedBinaryTree.addRight(p[14], "2");
        p[18] = linkedBinaryTree.addLeft(p[14], "7");
    }

    @Test
    public void fullTest() {
        assertTrue(linkedBinaryTree.full());
        linkedBinaryTree.addLeft(p[18], "1");
        assertFalse(linkedBinaryTree.full());
        linkedBinaryTree = new LinkedBinaryTree<>();
        linkedBinaryTree.addRoot("1");
        assertTrue(linkedBinaryTree.full());
    }

    @Test
    public void ValidExpresionTreeTest() {
        List<String> operadores = new ArrayList<>();
        operadores.add("+");
        operadores.add("-");
        operadores.add("*");
        operadores.add("/");
        assertTrue(linkedBinaryTree.validExpressionTree(operadores));

        linkedBinaryTree.set(p[18], "C");
        assertFalse(linkedBinaryTree.validExpressionTree(operadores));

        linkedBinaryTree.remove(p[18]);
        assertFalse(linkedBinaryTree.validExpressionTree(operadores));
    }

}
