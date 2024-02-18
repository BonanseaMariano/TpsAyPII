package com.mycompany.ej12;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Ej12 {
    public static final int maxNums=20;
    
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
            
            int[] nums = new int[maxNums];
            
            for (int i = 0; i < maxNums; i++) {
                do{
                    val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese el "+(i+1)+"º numero:",textField}, "Input", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE),textField);
                }while(!val);
                nums[i] = Integer.parseInt(textField.getText());            
                //Para limpiar el textField
                textField.setText("");
            }
            //Ordeno para que sea mas facil no imprimir los repetidos
            ordenar(nums,maxNums);
            //La impresion
            seleccion = JOptionPane.showOptionDialog(null, "Los numeros sin repetir son:\n"+stringImpresion(nums), "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]); 
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
    
    public static void ordenar(int[] nums,int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (nums[j]>nums[j+1]) {
                    int aux = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=aux;
                }
            }
        }
    }
    
    public static String stringImpresion(int[] nums){
        int temp=nums[0];
        //Pongo el primer numero en el string para imprimir
        String texto = ""+nums[0];
        for (int j = 0; j < maxNums; j++) {
            //Si el numero es distinto lo agrego al string para imprimir y cambio a temp para ver los repetidos
            if (temp!=nums[j]) {
                temp=nums[j];
                texto += ", "+nums[j];
            }
        }
        return texto;
    }
}
