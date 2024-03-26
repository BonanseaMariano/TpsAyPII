/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package grados;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TestGrados {

    public static void main(String[] args) {
        int seleccion = 0;
        boolean val;
        Grados grados = new Grados();

        JTextField textField = new JTextField();
        //Agregar un key listener para que detecte los inputs incorrectos
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int t = evt.getKeyCode();
                if ((t >= evt.VK_A && t <= evt.VK_Z) || t == evt.VK_SPACE) {
                    textField.setEditable(false);
                } else {
                    textField.setEditable(true);
                }
            }
        });

        do {
            do {
                val = validar(JOptionPane.showConfirmDialog(null, new Object[]{"Ingrese los grados a convertir:", textField}, "Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE), textField);
            } while (!val);
            
            //Seteo los grados en la clase grados luego de la validacion
            grados.setGrados(Double.parseDouble(textField.getText()));

            //Para limpiar el textField
            textField.setText("");

            do {
                int tipoGrados = JOptionPane.showOptionDialog(null, "Ingrese el tipo de conversion", "Tipo de grados", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Fahrenheit a Centigrados", "Centigrados a Fahrenheit"}, 0);

                if (tipoGrados == 0) {
                    seleccion = JOptionPane.showOptionDialog(null, grados.getGrados() + " Grados fahrenheit son " + grados.fahrToCent() + " grados Centigrados", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Volver a ingresar grados", "Elegir otra conversion", "Salir"}, 0);
                } else if (tipoGrados == 1) {
                    seleccion = JOptionPane.showOptionDialog(null, grados.getGrados() + " Grados Centigrados son " + grados.centToFahr() + " grados Fahrenheit", "Resultado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Volver a ingresar grados", "Elegir otra conversion", "Salir"}, 0);
                }
            } while (seleccion == 1);
        } while (seleccion < 1);
    }

    //Para validar si el texto esta en blanco o pone cancelar
    public static boolean validar(int temp, JTextField textField) {
        if (temp == JOptionPane.CANCEL_OPTION) {
            System.exit(0);
        } else if (textField.getText().isBlank() || textField.getText().compareTo("-") == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            textField.setText("");
            return false;
        }
        return true;
    }
}
