package com.mycompany.ej11;

import java.util.Scanner;


public class Ej11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        // Leer los cinco números entre 1 y 30
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingresa el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();

            // Validar que estén dentro del rango
            if (numeros[i] < 1 || numeros[i] > 30) {
                System.out.println("El número debe estar entre 1 y 30. Inténtalo de nuevo.");
                i--; // Repetir la lectura del mismo número
            }
        }
        
        ordenar(numeros, 5);
        
        // Crear el histograma
        for (int i = 0; i < 5; i++) {
            System.out.print((i+1)+":\t");
            for (int j = 0; j < numeros[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
     public static void ordenar(int[] nums,int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (nums[j]>nums[j+1]) {
                    int aux = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=aux;
                }
            }
        }
    }
}
