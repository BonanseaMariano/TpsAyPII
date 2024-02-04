/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej4;

import java.util.Scanner;

/**
 *
 * @author Mariano
 */
public class Ej4 {

    public static void main(String[] args) {
        System.out.println("Ingrese un numero");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        
        if (num1 % 2 == 0) {
            System.out.println("El numero es par");
        }else{
            System.out.println("El numero es impar");
        }
    }
}
