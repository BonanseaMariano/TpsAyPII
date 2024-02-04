/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej9;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ej9 {

    public static void main(String[] args) {        
        int[] nums = new int[10];
        int seleccion=0;
        
        String[] opciones = {"Volver a ingresar numeros","Salir"};
        JTextField textField = new JTextField();
        
        //Agregar un key listener para que detecte los inputs incorrectos
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int t;
                t=evt.getKeyCode();
                if ((t>=evt.VK_A && t<=evt.VK_Z) || t==evt.VK_SPACE) {
                    textField.setEditable(false);
                }else{
                    textField.setEditable(true);
                }
            }
        });
        
        
        boolean val;
        do {
            for (int i = 0; i < 10; i++) {
                do{
                    val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese el "+(i+1)+"º numero:",textField}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
                }while(!val);
                nums[i] = Integer.parseInt(textField.getText());            
                //Para limpiar el textField
                textField.setText("");
            }
            ordenar(nums);
            
            seleccion = JOptionPane.showOptionDialog(null, "El menor es: "+nums[0]+", y el mayor es "+nums[9], "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]); 
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
        }
        return true;
    }
    
    public static void ordenar(int[] nums){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10-i-1; j++) {
                if (nums[j]>nums[j+1]) {
                    int aux = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=aux;
                }
            }
        }
    }
}
