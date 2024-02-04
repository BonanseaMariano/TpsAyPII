/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej5 {

    public static void main(String[] args) {
       boolean ban=false;
        
        String[] opciones = {"Volver a ingresar numeros","Salir"};
        
        
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();

        textField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int t;
                t=evt.getKeyCode();
                if ((t>=evt.VK_A && t<=evt.VK_Z) || t==evt.VK_SPACE) {
                    textField1.setEditable(false);
                }else{
                    textField1.setEditable(true);
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int t;
                t=evt.getKeyCode();
                if ((t>=evt.VK_A && t<=evt.VK_Z) || t==evt.VK_SPACE) {
                    textField2.setEditable(false);
                }else{
                    textField2.setEditable(true);
                }
            }
        });
        //Para que pueda tener el textField con un string
        Object[] params = {"Ingrese dos numeros:",textField1,textField2}; 
        
        int num1,num2,seleccion=0;
        boolean val;
        do {            
            do{
                val = validar(JOptionPane.showConfirmDialog(null, params, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField1,textField2);
            }while(!val);
            num1 = Integer.parseInt(textField1.getText());
            num2 = Integer.parseInt(textField2.getText());
            
            //Para limpiar el textField
            textField1.setText("");
            textField2.setText("");
            
            if (num1 % num2 == 0) {
                seleccion = JOptionPane.showOptionDialog(null, "El primer numero ("+num1+") es multiplo del segundo ("+num2+")", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            }else{
                seleccion = JOptionPane.showOptionDialog(null, "El primer numero ("+num1+") NO es multiplo del segundo ("+num2+")", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            }
        }while (seleccion<1);
    }
    
    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(int temp, JTextField textField1,JTextField textField2){
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }else if (textField1.getText().isBlank()||textField2.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco","Error",JOptionPane.ERROR_MESSAGE);               
            return false;
        }
        return true;
    }
}
