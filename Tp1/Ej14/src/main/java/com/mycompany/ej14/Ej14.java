/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej14;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej14 {

    public static void main(String[] args) {
       int seleccion=0;
        
        String[] opciones = {"Volver a ingresar numeros","Salir"};
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
                val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese el numero para calcular su factorial:",textField}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
            }while(!val);
            int num = Integer.parseInt(textField.getText());            
            //Para limpiar el textField
            textField.setText("");
            
            //Tiro los dados las veces indicadas
            int fact = calcularFactorial(num);
            
            //La impresion
            seleccion = JOptionPane.showOptionDialog(null, "El factorial de "+num+" es: "+fact, "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]); 
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
                JOptionPane.showMessageDialog(null, "No se permiten cantidades negativas","Error",JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                return false;
            }
        }
        return true;
    }
    
    public static int calcularFactorial(int num){
        int res = num;
        for (int i = num-1; i > 1; i--) {
            res *= i;
        }
        return res;
    }
    
}
