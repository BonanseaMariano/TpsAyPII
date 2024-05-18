/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import net.datastructures.*;

/**
 * Testea si lista1 es similar a lista2
 *
 * @author Mariano
 */
public class ListasSimilaresTest {

    private List<String> lista1 = new ArrayList<>();
    private List<String> lista2 = new ArrayList<>();

    @BeforeEach
    private void setUp() {
        lista1.add("Ana");
        lista1.add("Juan");
        lista1.add("Ana");
        lista1.add("Pedro");
        lista1.add("Ana");

        lista2.add("Juan");
        lista2.add("Pedro");
        lista2.add("Ana");
        lista2.add("Ana");
        lista2.add("Ana");
    }

    @Test
    public void listaSimilarTest() {
        assertTrue(listaSimilar(lista1, lista2));
        lista2.remove(lista2.size() - 1);
        assertFalse(listaSimilar(lista1, lista2));
        lista2.add("Pedro");
        assertFalse(listaSimilar(lista1, lista2));
    }

    public static boolean listaSimilar(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        Map<String, Integer> mapa = new ChainHashMap<>();
        //Cargo el mapa con la lista 1
        for (String s : l1) {
            if (mapa.get(s) == null) {
                mapa.put(s, 1);
            } else {
                mapa.put(s, 1 + mapa.get(s));
            }
        }

        //Recorro la lista 2 y voy comparando con el mapa
        for (String s : l2) {
            if (mapa.get(s) == null) { //Existe algun elemento diferente
                return false;
            } else {
                mapa.put(s, mapa.get(s) - 1);
            }
        }

        for (Integer i : mapa.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
