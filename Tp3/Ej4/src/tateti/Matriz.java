/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tateti;

import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class Matriz {

    protected static int matriz[][];
    protected static int tamTablero;

    public static void inicializar() {
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingresen el tamaño del tablero"));
        Matriz.tamTablero = tam;
        matriz = new int[tamTablero][tamTablero];
    }

}
