/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arreglo;

import java.util.Arrays;

/**
 *
 * @author Mariano
 */
public class TestArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arreglo1[] = new int[]{1, 2, 3, 4, 5};
        int arreglo2[] = new int[]{6, 2, 7, 4, 8};

        //ToString()
        System.out.println(Arrays.toString(arreglo1));
        System.out.println(Arrays.toString(arreglo2));
        System.out.println("");
        //eqals()
        System.out.println(Arrays.equals(arreglo1, arreglo2));
        System.out.println("");
        //sort()
        Arrays.sort(arreglo2);
        System.out.println(Arrays.toString(arreglo2));
        System.out.println("");
        //BinarySearch()
        System.out.println("El numero 7 se encuentra en la posicion " + Arrays.binarySearch(arreglo2, 7));
        System.out.println("");
        //CopyOfRange()
        arreglo1 = Arrays.copyOfRange(arreglo2, 0, 2);
        System.out.println(Arrays.toString(arreglo1) + " nueva longitud: " + arreglo1.length);
        System.out.println("");
        //Copyof()
        arreglo1 = Arrays.copyOf(arreglo1, 3);
        System.out.println(Arrays.toString(arreglo1) + " nueva longitud: " + arreglo1.length);
        System.out.println("");
        //Fill
        Arrays.fill(arreglo1, 0);
        System.out.println(Arrays.toString(arreglo1));
        System.out.println("");
    }

}
