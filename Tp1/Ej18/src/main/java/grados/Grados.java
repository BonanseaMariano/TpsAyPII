/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grados;

public class Grados {
    private double grados;

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }
    
    public double fahrToCent() {
        return 5.0 / 9.0 * (grados - 32);
    }

    public double centToFahr() {
        return 9.0 / 5.0 * grados + 32;
    }
}
