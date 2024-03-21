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
	private int real;
	private int imaginaria;
        
	// Constructor
	public Complejo(int real, int imaginaria) {
		this.real = real;
                
		if (imaginaria == 0)
			throw new IllegalArgumentException("La parte imaginaria debe ser distinta de cero");
		this.imaginaria = imaginaria;
	}

	// Getters: acceder a los valores de los atributos
	// Setters: modificar los valores de los atributos
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(int imaginaria) {
		if (imaginaria == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.imaginaria = imaginaria;
	}
        
	// Metodos
	public Complejo sumar(Complejo b) {
            int r = real + b.real;
            int i = imaginaria + b.imaginaria;
            return new Complejo(r,i);
	}

	public Complejo restar(Complejo b) {
            int r = real - b.real;
            int i = imaginaria - b.imaginaria;
            return new Complejo(r,i);
	}

	public Complejo multiplicar(Complejo b) {
            int r = (real * b.real) - (imaginaria * b.imaginaria);
            int i = (real * b.imaginaria) +(imaginaria * b.real);
            return new Complejo(r,i);
	}

	public Complejo dividir(Complejo b) {
           return null;
	}

	public Complejo divisionEscalar(Complejo base, int escalar) {
            int r = real/escalar;
            int i = imaginaria/escalar;
            return new Complejo(r,i);
	}

	
	// toString: mostrar un objeto
	public String toString() {
		return (real + "/" + imaginaria);
	}

}
