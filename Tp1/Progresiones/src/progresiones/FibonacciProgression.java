/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresiones;

/**
 *
 * @author Mariano
 */
public class FibonacciProgression extends Progression {

    protected long prev;

    public FibonacciProgression() {
        this(0, 1);
    }

    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first;
    }

    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
