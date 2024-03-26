/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

import javax.swing.JOptionPane;

public class TestJuego {

    public static void main(String[] args) {
        Juego juego = new Juego(JOptionPane.showInputDialog("Por favor ingresa tu nombre"));
        juego.jugar();
    }

}
