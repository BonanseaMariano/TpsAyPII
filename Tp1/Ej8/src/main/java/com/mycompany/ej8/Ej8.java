/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ej8;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * El requestFocusInWindow() no funciono para que el textfield tuviera el foco
 * @author Mariano
 */

class Tipo{
    int negativos=0;
    int positivos=0;
    int ceros=0;
}

public class Ej8 {

    public static void main(String[] args) {        
        Tipo tipo = new Tipo();
        boolean ban=false;
        int num,seleccion=0;
        
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
                num = Integer.parseInt(textField.getText());            
                //Para limpiar el textField
                textField.setText("");
                if (num<0) {
                    tipo.negativos++;  
                }else if (num==0) {
                    tipo.ceros++;
                }else{
                    tipo.positivos++;
                }
            }
            seleccion = JOptionPane.showOptionDialog(null, "Hay "+tipo.positivos+" numeros positivos, "+tipo.negativos+" numeros negativos, y "+tipo.ceros+" ceros", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]); 
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
}

