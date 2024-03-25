/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresionesAbstractas;

public class ArithmeticProgressionAbstract extends AbstractProgression {

    protected long increment;

    public ArithmeticProgressionAbstract() {
        this(1, 0);
    }

    public ArithmeticProgressionAbstract(long stepsize) {
        this(stepsize, 0);
    }

    public ArithmeticProgressionAbstract(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }

    @Override
    protected void advance() {
        current += increment;
    }
}
