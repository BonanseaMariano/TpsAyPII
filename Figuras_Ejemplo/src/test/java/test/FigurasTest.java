/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import figuras.*;
import positionalList.LinkedPositionalList;
import interfaces.*;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class FigurasTest {

    PositionalList<Shape> posList = new LinkedPositionalList<Shape>();

    @BeforeEach
    public void setUp() {
        posList.addFirst(new Circle(20));
        posList.addFirst(new Square(2));
        posList.addFirst(null);
        posList.addFirst(new Sphere(20));
        posList.addFirst(new Cube(20));
    }

    @Test
    public void recorrer() {
        Iterator<Shape> ite = posList.iterator();

        assertEquals(5, posList.size());

        while (ite.hasNext()) {
            var s = ite.next();
            if (s == null || s.getArea() < 10) {
                ite.remove();
            }
        }

        System.out.println(posList);

        assertEquals(3, posList.size());
    }

}
