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
//        positions[0] = tree.addRoot("/");
//        positions[1] = tree.addLeft(positions[0], "*");
//        positions[2] = tree.addRight(positions[0], "+");
//        positions[3] = tree.addLeft(positions[1], "+");
//        positions[4] = tree.addRight(positions[1], "4");
//        positions[5] = tree.addLeft(positions[2], "-");
//        positions[6] = tree.addRight(positions[2], "2");
//        positions[7] = tree.addLeft(positions[3], "3");
//        positions[8] = tree.addRight(positions[3], "1");
//        positions[9] = tree.addLeft(positions[5], "9");
//        positions[10] = tree.addRight(positions[5], "5");

    }

    @Test
    void listBinaryTree() {
        for (String s : tree.ListBinaryTree()) {
            if (s == null)
                System.out.print("null ");
            else
                System.out.print(s + " ");
        }
    }
}