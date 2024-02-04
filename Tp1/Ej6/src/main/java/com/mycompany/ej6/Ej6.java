/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej6;

import java.util.Scanner;

/**
 *
 * @author Mariano
 */
public class Ej6 {

    public static void main(String[] args) {
        System.out.println("Ingrese su nombre");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        System.out.println("Ingrese su napellido");
        String ape = scanner.nextLine();        
        System.out.println("Hola, "+nom.toUpperCase().charAt(0)+nom.substring(1).toLowerCase()+" "+ape.toUpperCase().charAt(0)+ape.substring(1).toLowerCase()+"!"); 
    }
}
