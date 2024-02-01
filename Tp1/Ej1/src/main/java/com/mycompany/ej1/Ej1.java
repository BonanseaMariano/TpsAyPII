package com.mycompany.ej1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej1 {

    public static void main(String[] args) {
        boolean ban=false;
        
        String[] opciones = {"Suma", "Producto", "Diferencia","Cociente","Volver a ingresar numeros","Salir"};
        
        
        JTextField textField = new JTextField();
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
        //Para que pueda tener el textField con un string
        Object[] params = {"Ingrese un numero:",textField}; 
        
        int num1,num2,seleccion;
        boolean val;
        do {            
            do{
                val = validar(JOptionPane.showConfirmDialog(null, params, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
            }while(!val);
            num1 = Integer.parseInt(textField.getText());
            
            //Para limpiar el textField
            textField.setText("");
            
            do{
                val = validar(JOptionPane.showConfirmDialog(null, params, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
            }while(!val);
            num2 = Integer.parseInt(textField.getText()); 
            
            //Para limpiar el textField
            textField.setText("");
            
            do {                
                seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                calcular(num1, num2, seleccion);
            } while (seleccion<4);
        }while (seleccion<5);
    }
    
    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(int temp, JTextField textField){
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }else if (textField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco","Error",JOptionPane.ERROR_MESSAGE);               
            return false;
        }
        return true;
    }
    
    public static void calcular(int num1, int num2, int seleccion){           
            switch (seleccion) {
                case 0:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" + "+num2+" es: "+(num1+num2),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" * "+num2+" es: "+(num1*num2),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"El resultado de "+num1+" - "+num2+" es: "+(num1-num2),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 3:
                    if (num2!=0){
                        JOptionPane.showMessageDialog(null,"El resultado de "+num1+" / "+num2+" es: "+(num1/num2),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede dividir por 0","Error",JOptionPane.ERROR_MESSAGE);               
                    }
                    break;
                default:
                    break;
            }
    }
}
