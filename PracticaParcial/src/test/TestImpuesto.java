/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import impuesto.Bien;
import impuesto.Inmueble;
import impuesto.Titular;
import impuesto.Vehiculo;

/**
 *
 * @author Mariano
 */
public class TestImpuesto {

    public static void main(String[] args) {
        final double alicuotaBaldio = 0.006;
        final double alicuotaEdificado = 0.002;
        final double alicuotaVehiculo = 0.004;

        Bien arregloBienes[] = new Bien[4];

        Titular t1 = new Titular("Mariano", "123456");
        Titular t2 = new Titular("Pedro", "654321");

        Inmueble i1 = new Inmueble("", 50000, alicuotaBaldio, alicuotaEdificado, true, "2004", t1);
        Inmueble i2 = new Inmueble("", 70000, alicuotaBaldio, alicuotaEdificado, false, "2004", t1);

        Vehiculo v1 = new Vehiculo("AAA", "BMW", 1, alicuotaVehiculo, 30000, "2000", t2);
        Vehiculo v2 = new Vehiculo("BBB", "BMW", 2, alicuotaVehiculo, 30000, "2020", t1);

        arregloBienes[0] = i1;
        arregloBienes[1] = i2;
        arregloBienes[2] = v1;
        arregloBienes[3] = v2;

        impresionImpuestos(arregloBienes);

        impuestosDeTitular(arregloBienes, t1);
    }

    public static void impresionImpuestos(Bien[] arregloBienes) {
        double impuestosTotal = 0;
        for (int i = 0; i < arregloBienes.length; i++) {
            System.out.println(arregloBienes[i].toString());
            System.out.println("Impuestos del bien: $" + arregloBienes[i].calcularImpuesto());
            impuestosTotal += arregloBienes[i].calcularImpuesto();
        }
        System.out.println();
        System.out.println("Valor total de los impuestos: $" + impuestosTotal + "\n");
    }

    public static void impuestosDeTitular(Bien[] arregloBienes, Titular titular) {
        double impuestosTotal = 0;
        for (int i = 0; i < arregloBienes.length; i++) {
            if (titular.equals(arregloBienes[i].getTitular())) {
                System.out.println(arregloBienes[i].toString());
                System.out.println("Impuestos del bien: $" + arregloBienes[i].calcularImpuesto());
                impuestosTotal += arregloBienes[i].calcularImpuesto();
            }

        }
        System.out.println();
        System.out.println("Valor total de los impuestos de " + titular.getNombre() + " : $" + impuestosTotal);
    }

}
