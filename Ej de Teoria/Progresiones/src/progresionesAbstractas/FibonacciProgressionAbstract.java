/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresionesAbstractas;

public class FibonacciProgressionAbstract extends AbstractProgression {

    protected long prev;

    public FibonacciProgressionAbstract() {
        this(0, 1);
    }

    public FibonacciProgressionAbstract(long first, long second) {
        super(first);
        prev = second - first;
    }

    @Override
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
