/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapaEmpleados;

import datastructures.*;
import empleados.*;


/**
 * @author Mariano
 */
public class MapaEmpleados {

    static SortedMap<String, Employee> mapaE;

    static Employee empleados[] = new Employee[]{
            new BasePlusCommissionEmployee("Mariano", "Bonansea", "10", 20, 40, 200000),
            new CommissionEmployee("Carlos", "Carlos", "20", 20, 100000),
            new HourlyEmployee("Diego", "Maradona", "30", 500000, 10),
            new SalariedEmployee("Pedro", "Pepon", "40", 150000)
    };

    public static void main(String[] args) {
        System.out.println("\t\t---- SortedTableMap ----");
        sortedTableMap();
        System.out.println("\n\t\t---- TreeMap ----");
        treeMap();
        System.out.println("\n\t\t---- AVLTreeMap ----");
        avlTreeMap();
    }

    public static void sortedTableMap() {
        //firstEntry, lastEntry, ceilingEntry, floorEntry, lowerEntry, higherEntry, subMap. 
        mapaE = new SortedTableMap();
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }
        System.out.println("\t---- FirstEntry ----");
        System.out.println(mapaE.firstEntry());

        System.out.println("\n\t---- LastEntry ----");
        System.out.println(mapaE.lastEntry());

        System.out.println("\n\t---- CeilingEntry de 29 ----");
        System.out.println(mapaE.ceilingEntry("29"));

        System.out.println("\n\t---- FloorEntry de 29 ----");
        System.out.println(mapaE.floorEntry("29"));

        System.out.println("\n\t---- HigherEntry de 29 ----");
        System.out.println(mapaE.higherEntry("29"));

        System.out.println("\n\t---- LowerEntry de 29 ----");
        System.out.println(mapaE.lowerEntry("29"));

        System.out.println("\n\t---- Submap entre 10 y 30 ----");
        for (Entry<String, Employee> e : mapaE.subMap("10", "30")) {
            System.out.println(e);
        }

    }

    public static void treeMap() {
        //firstEntry, lastEntry, ceilingEntry, floorEntry, lowerEntry, higherEntry, subMap. 
        mapaE = new TreeMap<>();
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }
        System.out.println("\t---- FirstEntry ----");
        System.out.println(mapaE.firstEntry());

        System.out.println("\n\t---- LastEntry ----");
        System.out.println(mapaE.lastEntry());

        System.out.println("\n\t---- CeilingEntry de 4 ----");
        System.out.println(mapaE.ceilingEntry("4"));

        System.out.println("\n\t---- FloorEntry de 1 ----");
        System.out.println(mapaE.floorEntry("1"));

        System.out.println("\n\t---- HigherEntry de 1 ----");
        System.out.println(mapaE.higherEntry("1"));

        System.out.println("\n\t---- LowerEntry de 4 ----");
        System.out.println(mapaE.lowerEntry("4"));

        System.out.println("\n\t---- Submap entre 1 y 3 ----");
        for (Entry<String, Employee> e : mapaE.subMap("1", "3")) {
            System.out.println(e);
        }

    }

    public static void avlTreeMap() {
        //firstEntry, lastEntry, ceilingEntry, floorEntry, lowerEntry, higherEntry, subMap. 
        mapaE = new AVLTreeMap<>();
        for (Employee empleado : empleados) {
            mapaE.put(empleado.getSocialSecurityNumber(), empleado);
        }
        System.out.println("\t---- FirstEntry ----");
        System.out.println(mapaE.firstEntry());

        System.out.println("\n\t---- LastEntry ----");
        System.out.println(mapaE.lastEntry());

        System.out.println("\n\t---- CeilingEntry de 4 ----");
        System.out.println(mapaE.ceilingEntry("4"));

        System.out.println("\n\t---- FloorEntry de 1 ----");
        System.out.println(mapaE.floorEntry("1"));

        System.out.println("\n\t---- HigherEntry de 1 ----");
        System.out.println(mapaE.higherEntry("1"));

        System.out.println("\n\t---- LowerEntry de 4 ----");
        System.out.println(mapaE.lowerEntry("4"));

        System.out.println("\n\t---- Submap entre 1 y 3 ----");
        for (Entry<String, Employee> e : mapaE.subMap("1", "3")) {
            System.out.println(e);
        }

    }
}
