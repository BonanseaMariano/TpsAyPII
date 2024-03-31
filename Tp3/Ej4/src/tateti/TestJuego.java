/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tateti;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class TestJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamTablero = Integer.parseInt(JOptionPane.showInputDialog("Ingresen el tamaño del tablero"));
        Juego juego = new Juego(tamTablero);
        juego.jugar();
    }

}
