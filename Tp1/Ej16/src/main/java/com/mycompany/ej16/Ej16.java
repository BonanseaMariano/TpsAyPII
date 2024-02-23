/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej16;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej16 {

    public static void main(String[] args) {
        int seleccion=0;
        
        String[] opciones = {"Volver a ingresar grado de presision","Salir"};
        JTextField textField = new JTextField();
        
        //Agregar un key listener para que detecte los inputs incorrectos
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int t=evt.getKeyCode();
                if ((t>=evt.VK_A && t<=evt.VK_Z) || t==evt.VK_SPACE) {
                    textField.setEditable(false);
                }else{
                    textField.setEditable(true);
                }
            }
        });
        
        boolean val;
        
        do {
            do{
                val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese el grado de presicion del numero pi:",textField}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
            }while(!val);
            int pres = Integer.parseInt(textField.getText());            
            //Para limpiar el textField
            textField.setText("");
            
            //Tiro los dados las veces indicadas
            
            
            //La impresion
            seleccion = JOptionPane.showOptionDialog(null, "El numero pi aproximado es: "+calcularPI(pres), "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]); 
        }while (seleccion<1);
    }
    
    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(int temp, JTextField textField){
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }else if (textField.getText().isBlank()||textField.getText().compareTo("-")==0) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco","Error",JOptionPane.ERROR_MESSAGE);  
            textField.setText("");
            return false;
        }else{
            int n = Integer.parseInt(textField.getText()); 
            if (n<0) {
                JOptionPane.showMessageDialog(null, "Grado de presicion invalido, ingrese otro","Error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                return false;
            }
        }
        return true;
    }
    
    public static double calcularPI(int pres){
        double pi = 0.0;
        double signo = 1.0;
        double denominador = 1.0;

        for (int i = 1; i <= pres; i++) { // Puedes aumentar el número para una aproximación más precisa
            pi += signo * 4 / denominador; // Añade el término actual a la suma
            signo *= -1; // Cambia el signo para el siguiente término
            denominador += 2; // Incrementa el denominador en 2 para el siguiente término
        }
        return pi;
    }
}
