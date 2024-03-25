/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import progresiones.*;
import progresionesAbstractas.*;

public class ProgressionTest {

    private static final int MAX = 3;

    public static void main(String[] args) {
        Progression arregloPolimorifico[] = new Progression[]{new ArithmeticProgression(), new FibonacciProgression(), new GeometricProgression()};

        AbstractProgression arregloPolimorficoAbs[] = new AbstractProgression[]{new ArithmeticProgressionAbstract(), new FibonacciProgressionAbstract(), new GeometricProgressionAbstract()};

        for (int i = 0; i < MAX; i++) {

            arregloPolimorifico[i].printProgression(4);

            arregloPolimorficoAbs[i].printProgression(4);

        }
    }
}
