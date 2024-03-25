/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresionesAbstractas;

public class GeometricProgressionAbstract extends AbstractProgression {

    protected long base;

    public GeometricProgressionAbstract() {
        this(2, 1);
    }

    public GeometricProgressionAbstract(long b) {
        this(b, 1);
    }

    public GeometricProgressionAbstract(long b, long start) {
        super(start);
        base = b;
    }

    @Override
    protected void advance() {
        current *= base;
    }
}
