/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import supermercado.SimulacionSupermercado;

/**
 *
 * @author Mariano
 */
public class SimulacionSupermercadoTest {

    @Test
    void simulacionSupermercadoTest() {
        SimulacionSupermercado simu = new SimulacionSupermercado(3, 10, 40, 1, 5);
        simu.simulacion();
    }

}
