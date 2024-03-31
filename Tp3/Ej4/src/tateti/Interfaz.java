/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tateti;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Interfaz {

    private final String jugador1;
    private final String jugador2;
    protected String nombre;

    //Objetos para formato de JOptionpane
    private final JTextField jTextFieldX = new JTextField();
    private final JTextField jTextFieldY = new JTextField();

    public Interfaz() {
        this.jugador1 = JOptionPane.showInputDialog("Ingrese el nombre del primer jugador:", null);
        this.jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del segundo jugador:", null);
    }

    public int[] input(boolean turno) {

        //Limpieza de los campos
        jTextFieldX.setText("");
        jTextFieldY.setText("");

        JOptionPane.showMessageDialog(null, new Object[]{imprimirTablero() + nombreJugadorActual(turno) + " es tu turno, ingresa las coordenadas de tu jugada:\nFila = ", jTextFieldX, "\nColumna = ", jTextFieldY});

        return new int[]{Integer.parseInt(jTextFieldX.getText()) - 1, Integer.parseInt(jTextFieldY.getText()) - 1};
    }

    public String nombreJugadorActual(boolean turno) {
        String jugadorActual;
        //Para saber el nombre del jugador que esta jugando
        if (turno) {
            jugadorActual = jugador1;
        } else {
            jugadorActual = jugador2;
        }
        return jugadorActual;
    }

    private String imprimirTablero() {
        String tablero = "";
        for (int i = 0; i < Matriz.tamTablero; i++) {
            for (int j = 0; j < Matriz.tamTablero; j++) {
                switch (Matriz.matriz[i][j]) {
                    case 0 ->
                        tablero += "[   ]   ";
                    case 1 ->
                        tablero += "[ X ]   ";
                    case -1 ->
                        tablero += "[ O ]   ";
                    default ->
                        throw new AssertionError();
                }
            }
            tablero += "\n\n"; // Cambio de línea para cada fila
        }
        return tablero;
    }

}
