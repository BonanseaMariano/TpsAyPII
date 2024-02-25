/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej19;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej19 {

    public static void main(String[] args) {
        int seleccion=0;
        double[] p1 = new double[2];
        double[] p2 = new double[2];

        
        
        JTextField textField = new JTextField();
        JTextField textField2 = new JTextField();

        
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
        
        //Agregar un key listener para que detecte los inputs incorrectos
        textField2.addKeyListener(new KeyAdapter() {
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
                val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese las coordenadas x e y del primer punto:\nx: ",textField,"y: ",textField2}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField,textField2);
            }while(!val);
            p1[0] = Double.parseDouble(textField.getText());
            p1[1] = Double.parseDouble(textField2.getText());            
            
            //Para limpiar el textField
            textField.setText("");
            textField2.setText("");

            
            do{
                val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese las coordenadas x e y del segundo punto:\nx: ",textField,"y: ",textField2}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField,textField2);
            }while(!val);
            p2[0] = Double.parseDouble(textField.getText());
            p2[1] = Double.parseDouble(textField2.getText());            
            
            //Para limpiar el textField
            textField.setText("");
            textField2.setText("");

            
            
            seleccion = JOptionPane.showOptionDialog(null,"La distancia entre ("+p1[0]+", "+p1[1]+") y ("+p2[0]+", "+p2[1]+") es: "+Math.sqrt(Math.pow((p2[0]-p1[0]),2.0)+Math.pow((p2[1]-p1[1]),2.0)), "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Volver a ingresar puntos","Salir"}, 0);   
        }while (seleccion<1);
    }
    
    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(int temp, JTextField textField,JTextField textField2){
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }else if (textField.getText().isBlank()||textField.getText().compareTo("-")==0 || textField2.getText().isBlank()||textField2.getText().compareTo("-")==0) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco","Error",JOptionPane.ERROR_MESSAGE);  
            textField.setText("");
            return false;
        }
        return true;
    }
    
}
