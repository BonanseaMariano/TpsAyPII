/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progresiones;

public class Progression {

    protected long current;

    public Progression() {
        this(0);
    }

    public Progression(long start) {
        current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    protected void advance() {
        current++;
    }

    public void printProgression(int n) {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(nextValue());
        for (int i = 1; i < n; i++) {
            System.out.println(nextValue());
        }
    }
}
