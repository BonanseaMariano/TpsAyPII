/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.datastructures.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Mariano
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedBinaryTreeTest {

    String arreglo[] = new String[]{"/", "*", "+", "+", "4", "-", "2", "3", "1", null, null, "9", "5", null, null};
    LinkedBinaryTree<String> tree = new LinkedBinaryTree(arreglo);

    @Test
    @Order(1)
    public void LinkedBinaryTreeTest() {
        System.out.println();
        System.out.print("Por nivel: ");
        for (Position<String> p : tree.breadthfirst()) {
            System.out.print(p.getElement());
        }
        System.out.println();
        System.out.print("Inorder: ");
        for (Position<String> p : tree.inorder()) {
            System.out.print(p.getElement());
        }
    }

    @Test
    @Order(2)
    public void ListBinaryTreeTest() {
        List<String> arbolLista = tree.ListBinaryTree();
        System.out.println();
        System.out.print("Representacion del arbol en una lista: ");
        System.out.println(arbolLista);
    }

    @Test
    @Order(3)
    public void replaceAllTest() {
        System.out.println();
        System.out.println("Reaplace all de los + por A y los 4 por B:");
        for (Position<String> p : tree.replaceAll("+", "A")) {
            System.out.println("Elemento reemplazado: " + p.getElement());
        }
        for (Position<String> p : tree.replaceAll("4", "B")) {
            System.out.println("Elemento reemplazado: " + p.getElement());
        }
        LinkedBinaryTreeTest();
        System.out.println();

        //Intentando reemplazar por elemento inexistente
        assertTrue(!(tree.replaceAll("Z", "Z").iterator().hasNext()));
    }
}
