package datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList<String> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
        lista.add(lista.size(), "A");
        lista.add(lista.size(), "B");
        lista.add(lista.size(), "C");
        lista.add(lista.size(), "D");
        lista.add(lista.size(), "E");
    }

    @Test
    void subList() {
        List<String> sub = new ArrayList<>();
        sub.add(sub.size(), "A");
        sub.add(sub.size(), "B");
        sub.add(sub.size(), "E");
        assertTrue(lista.containsAll(sub));


        lista = new ArrayList<>();
        assertFalse(lista.containsAll(sub));
    }
}