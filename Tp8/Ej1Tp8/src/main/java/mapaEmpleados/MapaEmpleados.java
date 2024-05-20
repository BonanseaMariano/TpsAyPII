/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapaEmpleados;

import net.datastructures.*;
import empleados.*;

/**
 * @author Mariano
 */
public class MapaEmpleados {

    static Map<String, Employee> mapaE;
    static Employee[] empleados = new Employee[]{
            new BasePlusCommissionEmployee("Mariano", "Bonansea", "41127031", 20, 40, 200000),
            new CommissionEmployee("Carlos", "Carlos", "1234", 20, 100000),
            new HourlyEmployee("Diego", "Maradona", "4321", 500000, 10),
            new SalariedEmployee("Pedro", "Pepon", "1111", 150000)
    };

    public static void main(String[] args) {
        unsortedTableMap();
        chainHashMap();
        probeHashMap();
    }

    public static void unsortedTableMap() {
        mapaE = new UnsortedTableMap<>();
        System.out.println("\t\t---- UnsortedTableMap ----");
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }

        System.out.println("\t---- Empleados ----");
        for (Employee e : mapaE.values()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("\t---- Empleados con claves ----");
        for (Entry<String, Employee> e : mapaE.entrySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("* Empleado eliminado: " + mapaE.remove("1111"));
        System.out.println("\t---- Claves de Empleados ----");
        for (String e : mapaE.keySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }
    }

    public static void chainHashMap() {
        mapaE = new ChainHashMap<>();
        System.out.println("\t\t---- ChainHashMap ----");
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }

        System.out.println("\t---- Empleados ----");
        for (Employee e : mapaE.values()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("\t---- Empleados con claves ----");
        for (Entry<String, Employee> e : mapaE.entrySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("* Empleado eliminado: " + mapaE.remove("1111"));
        System.out.println("\t---- Claves de Empleados ----");
        for (String e : mapaE.keySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }
    }

    public static void probeHashMap() {
        mapaE = new ProbeHashMap<>();
        System.out.println("\t\t---- ProbeHashMap ----");
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }

        System.out.println("\t---- Empleados ----");
        for (Employee e : mapaE.values()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("\t---- Empleados con claves ----");
        for (Entry<String, Employee> e : mapaE.entrySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }

        System.out.println("* Empleado eliminado: " + mapaE.remove("1111"));
        System.out.println("\t---- Claves de Empleados ----");
        for (String e : mapaE.keySet()) {
            System.out.println(e);
            System.out.println("\t--------------------");
        }
    }
}
