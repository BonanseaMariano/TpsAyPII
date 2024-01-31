package com.mycompany.ej1;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class Ej1 {

    public static void main(String[] args) {
        boolean ban=false;
        
        String[] opciones = {"Suma", "Producto", "Diferencia","Cociente","Volver a ingresar numeros","Salir"};
        
        int num1,num2,seleccion;
        do {            
            num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el primer numero"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el segundo numero")); 
            do {                
                seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                calcular(num1, num2, seleccion);
            } while (seleccion<4);
        }while (seleccion<5);
    }
    
    public static void calcular(int num1, int num2, int seleccion){           
            switch (seleccion) {
                case 0:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" + "+num2+" es: "+(num1+num2));
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" * "+num2+" es: "+(num1*num2));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" - "+num2+" es: "+(num1-num2));
                    break;
                case 3:
                    if (num2!=0){
                        JOptionPane.showMessageDialog(null,"El resultado de "+num1+" / "+num2+" es: "+(num1/num2));
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede dividir por 0");               
                    }
                    break;
                default:
                    break;
            }
    }
}
