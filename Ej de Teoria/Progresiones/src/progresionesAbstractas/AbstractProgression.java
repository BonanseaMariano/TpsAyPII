/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresionesAbstractas;

public abstract class AbstractProgression {

    protected long current;

    public AbstractProgression() {
        this(0);
    }

    public AbstractProgression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    public void printProgression(int n) {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(nextValue());
        for (int i = 1; i < n; i++) {
            System.out.println(nextValue());
        }
    }

    protected abstract void advance();

}
