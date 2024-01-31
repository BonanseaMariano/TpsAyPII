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
         
        int num1,num2,seleccion;
        do {            
            String[] boton = {"OK","Cancelar"};
            int temp = JOptionPane.showOptionDialog(null, textField, "Ingrese el primer numero:", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, boton, boton[0]);
            //Para que se salga si le pone cancelar
            if (temp == 1) {
                System.exit(0);
            }
            num1 = Integer.parseInt(textField.getText());
            
            //Para limpiar el textField
            textField.setText("");
            temp = JOptionPane.showOptionDialog(null, textField, "Ingrese el segundo numero:", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, boton, boton[0]);
            
            //Para que se salga si le pone cancelar
            if (temp == 1) {
                System.exit(0);
            }
            num2 = Integer.parseInt(textField.getText()); 
            
            //Para limpiar el textField
            textField.setText("");
            
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
