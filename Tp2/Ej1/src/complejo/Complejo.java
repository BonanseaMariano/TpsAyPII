/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complejo;

/**
 *
 * @author Mariano
 */
public class Complejo {
        // Atributos
	private double real;
	private double imaginaria;
        
	// Constructor
	public Complejo(double real, double imaginaria) {
		this.real = real;
                
		if (imaginaria == 0)
			throw new IllegalArgumentException("La parte imaginaria debe ser distinta de cero");
		this.imaginaria = imaginaria;
	}

	// Getters: acceder a los valores de los atributos
	// Setters: modificar los valores de los atributos
	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		if (imaginaria == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.imaginaria = imaginaria;
	}
        
	// Metodos
	public Complejo sumar(Complejo b) {
            double r = real + b.real;
            double i = imaginaria + b.imaginaria;
            return new Complejo(r,i);
	}

	public Complejo restar(Complejo b) {
            double r = real - b.real;
            double i = imaginaria - b.imaginaria;
            return new Complejo(r,i);
	}

	public Complejo multiplicar(Complejo b) {
            double r = (real * b.real) - (imaginaria * b.imaginaria);
            double i = (real * b.imaginaria) +(imaginaria * b.real);
            return new Complejo(r,i);
	}

	public Complejo dividir(Complejo b) {
           double r = (real * b.real + imaginaria * b.imaginaria)/Math.pow(2, b.real)+Math.pow(2, b.imaginaria);
           double i = (imaginaria * b.real - real * b.real) / Math.pow(2, b.real)+Math.pow(2, b.imaginaria);
           return new Complejo(r,i);
        }

	public Complejo divisionEscalar(Complejo base, int escalar) {
            double r = real/escalar;
            double i = imaginaria/escalar;
            return new Complejo(r,i);
	}

	
	// toString: mostrar un objeto
	public String toString() {
		return (real + "/" + imaginaria);
	}

}
