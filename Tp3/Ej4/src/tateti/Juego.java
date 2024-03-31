/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tateti;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mariano
 */
public class Juego {

    private int matriz[][];
    private int tamTablero;
    private String jugador1;
    private String jugador2;

    //Objetos para formato de JOptionpane
    private JTextField jTextFieldX = new JTextField();
    private JTextField jTextFieldY = new JTextField();

    public Juego(int tamTablero) {
        this.tamTablero = tamTablero;
        matriz = new int[tamTablero][tamTablero];
        jugador1 = JOptionPane.showInputDialog("Ingrese el nombre del primer jugador:", null);
        jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del segundo jugador:", null);
    }

    public void jugar() {
        boolean turno = true;
        String nombre, tablero;

        //Bucle del juego (se corta con los break)
        while (true) {
            //Actualiza la impresion del tablero
            tablero = imprimirTablero();
            //Actualiza el nombre del jugador Actual
            nombre = nombreJugadorActual(turno);
            //Bucle de ingreso de posicion valida
            do {
                //Limpieza de los campos
                jTextFieldX.setText("");
                jTextFieldY.setText("");

                JOptionPane.showMessageDialog(null, new Object[]{tablero + nombre + " es tu turno, ingresa las coordenadas de tu jugada:\nFila = ", jTextFieldX, "\nColumna = ", jTextFieldY});
            } while (!chequearPosValida(Integer.parseInt(jTextFieldX.getText()) - 1, Integer.parseInt(jTextFieldY.getText()) - 1, turno));

            //Chequeo siempre si alguien gano para cortar antes
            if (chequearVictoria(turno)) {
                break;
            } else if (chequearEmpate()) { //Y si no gano chequeo si hay empate para terminar el juego
                break;
            }

            //Cambio de turno (en caso de que el juego continue)
            turno = !turno;
        }

    }

    private boolean chequearPosValida(int x, int y, boolean turno) {
        //Para manejar el error ArrayOutOfBounds y que no me finalice el programa
        try {
            int pos = matriz[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Posicion fuera de rango del tablero, ingrese otra", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Chequeo que la posicion no se encuentre ocupada anteriormente
        if (matriz[x][y] == 1 || matriz[x][y] == -1) {
            JOptionPane.showMessageDialog(null, "Posicion ya ocupada, ingrese otra", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        agregarJugadaAMatriz(x, y, turno);

        return true;
    }

    private boolean chequearEmpate() {
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                //Si se encuentra al menos un espacio vacio en la matriz significa que todavia no termino el juego
                if (matriz[i][j] == 0) {
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Empate, Juego terminado!");
        return true;
    }

    private boolean chequearVictoria(boolean turno) {
        //Solo hace falta recorrer la matriz con un for porque es una matriz cuadrada y los metodos estan separados
        for (int i = 0; i < tamTablero; i++) {
            if (chequearVictoriaFilas(i) || chequearVictoriaColumnas(i) || chequearVictoriaDiagonal() || chequearVictoriaDiagonalInversa()) {
                JOptionPane.showMessageDialog(null, "Juego terminado, el ganador es " + nombreJugadorActual(turno) + "!");
                return true;
            }
        }
        return false;
    }

    private boolean chequearVictoriaColumnas(int fila) {
        for (int i = 1; i < tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la columna distinto
            if (matriz[fila][i] != matriz[fila][0]) {
                return false;
            }
        }

        //Si los elementos son iguales pero no son 0 (en blanco)
        if (matriz[fila][0] != 0) {
            return true;
        }

        return false;

    }

    private boolean chequearVictoriaFilas(int columna) {
        for (int i = 1; i < tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la fila distinto
            if (matriz[i][columna] != matriz[0][columna]) {
                return false;
            }
        }

        //Si los elementos son iguales pero no son 0 (en blanco)
        if (matriz[0][columna] != 0) {
            return true;
        }

        return false;
    }

    //Solo para las diagonales principales
    private boolean chequearVictoriaDiagonal() {
        for (int i = 1; i < tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la diagonal principal distinto
            if (matriz[i][i] != matriz[0][0]) {
                return false;
            }
        }

        //Si la diagonal no se encuentra vacia
        if (matriz[0][0] != 0) {
            return true;
        }

        return false;
    }

    private boolean chequearVictoriaDiagonalInversa() {
        for (int i = 1; i < tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la diagonal principal inversa distinto
            if (matriz[i][tamTablero - i - 1] != matriz[0][tamTablero - 1]) {
                return false;
            }
        }

        //Si la diagonal no se encuentra vacia
        if (matriz[0][tamTablero - 1] != 0) {
            return true;
        }

        return false;
    }

    private void agregarJugadaAMatriz(int x, int y, boolean turno) {
        if (turno) {
            matriz[x][y] = 1;
        } else {
            matriz[x][y] = -1;
        }
    }

    private String nombreJugadorActual(boolean turno) {
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
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                switch (matriz[i][j]) {
                    case 0:
                        tablero += "[   ]   ";
                        break;
                    case 1:
                        tablero += "[ X ]   ";
                        break;
                    case -1:
                        tablero += "[ O ]   ";
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            tablero += "\n\n"; // Cambio de línea para cada fila
        }
        return tablero;
    }

}
