package com.mycompany.ej2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Ej2 {

    public static void main(String[] args) {
        
        boolean ban=false;
        
        
        String[] opciones = {"Diametro", "Circunferencia", "Area","Volver a ingresar radio","Salir"};
        
        
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
        Object[] params = {"Ingrese el radio del circulo:",textField}; 
        
        float radio;
        int seleccion;
        boolean val;
        do {            
            do{
                val = validar(JOptionPane.showConfirmDialog(null, params, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
            }while(!val);
            radio = Float.parseFloat(textField.getText());
            
            //Para limpiar el textField
            textField.setText("");
            
            do {                
                seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú de opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
                calcular(radio, seleccion);
            } while (seleccion<3);
        }while (seleccion<4);
    }
    
    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(float temp, JTextField textField){
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        }else if (textField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco","Error",JOptionPane.ERROR_MESSAGE);               
            return false;
        }
        return true;
    }
    
    public static void calcular(float radio, int seleccion){           
        final double pi = 3.14159;    
        switch (seleccion) {
                case 0:
                    JOptionPane.showMessageDialog(null,"El diametro del circulo de radio "+radio+" es: "+(2*radio),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,"El perimetro del circulo de radio "+radio+" es: "+(2*pi*radio),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,"El area del circulo de radio "+radio+" es: "+(Math.sqrt(radio)),"Resultado",JOptionPane.PLAIN_MESSAGE);
                    break;
                default:
                    break;
            }
    }
}
