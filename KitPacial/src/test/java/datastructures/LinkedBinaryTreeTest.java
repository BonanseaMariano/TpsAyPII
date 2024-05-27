package datastructures;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {
    LinkedBinaryTree<String> tree;
    Position<String> a, b, c, d, e, f, g, h, i;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        tree = new LinkedBinaryTree<>();
        f = tree.addRoot("F");
        b = tree.addLeft(f, "B");
        g = tree.addRight(f, "G");
        a = tree.addLeft(b, "A");
        d = tree.addRight(b, "D");
        i = tree.addRight(g, "I");
        c = tree.addLeft(d, "C");
        e = tree.addRight(d, "D");
        h = tree.addLeft(i, "H");
    }

    @org.junit.jupiter.api.Test
    void path() {
        List<Position<String>> path = tree.path(a, i);
        Iterator<Position<String>> it = path.iterator();
        System.out.print("path (A->I): ");
        while (it.hasNext()) {
            System.out.print(it.next().getElement() + ", ");
        }

        System.out.println();

        path = tree.path(e, a);
        it = path.iterator();
        System.out.print("path (E->A): ");
        while (it.hasNext()) {
            System.out.print(it.next().getElement() + ", ");
        }

        System.out.println();

        path = tree.path(b, b);
        it = path.iterator();
        System.out.print("path (B->B): ");
        while (it.hasNext()) {
            System.out.print(it.next().getElement() + ", ");
        }

        System.out.println();

        path = tree.path(d, b);
        it = path.iterator();
        System.out.print("path (D->B): ");
        while (it.hasNext()) {
            System.out.print(it.next().getElement() + ", ");
        }
    }
}