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
public class Juego {

    private final Interfaz interfaz;
    private final Logica logica;

    public Juego() {
        Matriz.inicializar();
        this.interfaz = new Interfaz();
        this.logica = new Logica();
    }

    public void jugar() {
        //Para saber de que jugador es el turno
        boolean turno = true;

        //Bucle del juego (se corta con los break)
        while (true) {

            while (!logica.chequearPosValida(interfaz.input(turno), turno)) {
            }

            //Chequeo siempre si alguien gano para cortar antes
            if (logica.chequearVictoria(turno)) {
                JOptionPane.showMessageDialog(null, "Juego terminado, el ganador es " + interfaz.nombreJugadorActual(turno) + "!");
                break;
            } else if (logica.chequearEmpate()) { //Y si no gano chequeo si hay empate para terminar el juego
                break;
            }

            //Cambio de turno (en caso de que el juego continue)
            turno = !turno;
        }

    }

}
