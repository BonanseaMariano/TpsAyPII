/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class Juego {

    private final int numeroAdivinar;
    private int intentos;
    private String nombreJugador;

    //Constructor con parametros
    public Juego(String nombreJugador) {
        //Para generar el entero aleatorio a adivinar con el constructor
        Random random = new Random();
        numeroAdivinar = random.nextInt(1001);
        //PARA DEBUGGING
        System.out.println(numeroAdivinar);
        //Nombre del jugador
        this.nombreJugador = nombreJugador;
    }

    public void jugar() {
        //Bandera de corte del juego
        boolean ban;
        //Inicializo los intentos
        intentos = 0;

        do {
            ban = false;
            int input = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero del 0 al 1000"));
            intentos++;

            if (input == numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "Felicidades " + nombreJugador + "!! adivinaste el numero " + numeroAdivinar + " en " + intentos + " intentos");
                ban = true;
            } else if (input < numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "Demasiado bajo");
            } else if (input > numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "Demasiado alto");

            }
        } while (ban == false);
    }
}
