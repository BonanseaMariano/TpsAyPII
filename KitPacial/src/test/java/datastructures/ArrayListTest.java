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
        sub.add(sub.size(), "1");
        sub.add(sub.size(), "2");
        lista.addAll(2, sub);
        assertEquals(7, lista.size());
        assertEquals("B", lista.get(1));
        assertEquals("1", lista.get(2));
        assertEquals("2", lista.get(3));
        assertEquals("C", lista.get(4));

    }
}