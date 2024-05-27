package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedPositionalListTest {
    LinkedPositionalList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedPositionalList<>();
        list.addLast("H");
        list.addLast("O");
        list.addLast("L");
        list.addLast("A");
        list.reverse();

    }

    @Test
    void reverse() {
        for (String s : list) {
            System.out.println(s);
        }
    }
}