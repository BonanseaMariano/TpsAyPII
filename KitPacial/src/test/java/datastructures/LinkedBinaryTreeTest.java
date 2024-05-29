package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {
    LinkedBinaryTree<String> tree;
    Position<String> positions[];

    @BeforeEach
    void setUp() {
        tree = new LinkedBinaryTree<>();
        positions = new Position[11];
        positions[0] = tree.addRoot("F");
        positions[1] = tree.addLeft(positions[0], "B");
        positions[2] = tree.addRight(positions[0], "G");
        positions[3] = tree.addLeft(positions[1], "A");
        positions[4] = tree.addRight(positions[1], "D");
        positions[5] = tree.addRight(positions[2], "I");
        positions[6] = tree.addLeft(positions[4], "C");
        positions[7] = tree.addRight(positions[4], "E");
        positions[8] = tree.addLeft(positions[5], "H");
    }

    @Test
    void listBinaryTree() {
        System.out.print("path (A, I): ");
        for (Position<String> p : tree.path(positions[3], positions[5])) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println();
        System.out.print("path (E, A): ");
        for (Position<String> p : tree.path(positions[7], positions[3])) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println();
        System.out.print("path (B, B): ");
        for (Position<String> p : tree.path(positions[1], positions[1])) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println();
        System.out.print("path (D, B): ");
        for (Position<String> p : tree.path(positions[4], positions[1])) {
            System.out.print(p.getElement() + " ");
        }
    }
}