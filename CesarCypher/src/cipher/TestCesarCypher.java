/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cipher;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class TestCesarCypher {

    public static void main(String[] args) {

        int llave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la llave para la encriptacion"));
        CesarCypher mensaje = new CesarCypher(llave);

        //Imprimo los alfabetos para testear
        System.out.println(mensaje.impresionAlfabetos());
        
        String encriptar = mensaje.encriptar(JOptionPane.showInputDialog("Ingrese un mensaje a encriptar:"));
        JOptionPane.showMessageDialog(null, "Mensaje encriptado:\n" + encriptar);

        JOptionPane.showMessageDialog(null, "Mensaje decodificado:\n" + mensaje.decodificar(encriptar));
    }
}
