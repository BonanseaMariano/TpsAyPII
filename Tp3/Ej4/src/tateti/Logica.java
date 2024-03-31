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
public class Logica {

    public boolean chequearPosValida(int coord[], boolean turno) {
        int x = coord[0];
        int y = coord[1];
        //Para manejar el error ArrayOutOfBounds y que no me finalice el programa
        try {
            int pos = Matriz.matriz[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Posicion fuera de rango del tablero, ingrese otra", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Chequeo que la posicion no se encuentre ocupada anteriormente
        if (Matriz.matriz[x][y] == 1 || Matriz.matriz[x][y] == -1) {
            JOptionPane.showMessageDialog(null, "Posicion ya ocupada, ingrese otra", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        agregarJugadaAMatriz(x, y, turno);

        return true;
    }

    public boolean chequearEmpate() {
        for (int i = 0; i < Matriz.tamTablero; i++) {
            for (int j = 0; j < Matriz.tamTablero; j++) {
                //Si se encuentra al menos un espacio vacio en la matriz significa que todavia no termino el juego
                if (Matriz.matriz[i][j] == 0) {
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Empate, Juego terminado!");
        return true;
    }

    public boolean chequearVictoria(boolean turno) {
        //Solo hace falta recorrer la matriz con un for porque es una matriz cuadrada y los metodos estan separados
        for (int i = 0; i < Matriz.tamTablero; i++) {
            if (chequearVictoriaFilas(i) || chequearVictoriaColumnas(i) || chequearVictoriaDiagonal() || chequearVictoriaDiagonalInversa()) {
                return true;
            }
        }
        return false;
    }

    private boolean chequearVictoriaColumnas(int fila) {
        for (int i = 1; i < Matriz.tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la columna distinto
            if (Matriz.matriz[fila][i] != Matriz.matriz[fila][0]) {
                return false;
            }
        }

        //Si los elementos son iguales pero no son 0 (en blanco)
        if (Matriz.matriz[fila][0] != 0) {
            return true;
        }

        return false;

    }

    private boolean chequearVictoriaFilas(int columna) {
        for (int i = 1; i < Matriz.tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la fila distinto
            if (Matriz.matriz[i][columna] != Matriz.matriz[0][columna]) {
                return false;
            }
        }

        //Si los elementos son iguales pero no son 0 (en blanco)
        if (Matriz.matriz[0][columna] != 0) {
            return true;
        }

        return false;
    }

    //Solo para las diagonales principales
    private boolean chequearVictoriaDiagonal() {
        for (int i = 1; i < Matriz.tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la diagonal principal distinto
            if (Matriz.matriz[i][i] != Matriz.matriz[0][0]) {
                return false;
            }
        }

        //Si la diagonal no se encuentra vacia
        if (Matriz.matriz[0][0] != 0) {
            return true;
        }

        return false;
    }

    private boolean chequearVictoriaDiagonalInversa() {
        for (int i = 1; i < Matriz.tamTablero; i++) {
            //Si se encuentra al menos 1 elemento en la diagonal principal inversa distinto
            if (Matriz.matriz[i][Matriz.tamTablero - i - 1] != Matriz.matriz[0][Matriz.tamTablero - 1]) {
                return false;
            }
        }

        //Si la diagonal no se encuentra vacia
        if (Matriz.matriz[0][Matriz.tamTablero - 1] != 0) {
            return true;
        }

        return false;
    }

    private void agregarJugadaAMatriz(int x, int y, boolean turno) {
        if (turno) {
            Matriz.matriz[x][y] = 1;
        } else {
            Matriz.matriz[x][y] = -1;
        }
    }
}
