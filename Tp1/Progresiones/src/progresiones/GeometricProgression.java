/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresiones;

/**
 *
 * @author Mariano
 */
public class GeometricProgression extends Progression {

    protected long base;

    public GeometricProgression() {
        this(2, 1);
    }

    public GeometricProgression(long b) {
        this(b, 1);
    }

    public GeometricProgression(long b, long start) {
        super(start);
        base = b;
    }

    protected void advance() {
        current *= base;
    }
}
