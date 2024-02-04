/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej7;

/**
 *
 * @author Mariano
 */
public class Ej7 {

    public static void main(String[] args) {
        System.out.println("Numero\tCuadrado\tCubo");
        for (int i = 0; i < 11; i++) {
            System.out.println((i)+"\t"+(int)Math.pow(i,2)+"\t\t"+(int)(Math.pow(i, 3)));
        }
    }
}
