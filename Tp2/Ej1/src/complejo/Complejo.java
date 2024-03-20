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
    private float numero;

    public Complejo(float numero) {
        this.numero = numero;
    }
    
    public Complejo suma(Complejo b){
        return new Complejo(this.numero+b.numero);
    }
    
    public Complejo resta(Complejo b){
        return new Complejo(this.numero+b.numero);
    }
    
    public Complejo producto(Complejo b){
        return new Complejo(this.numero+b.numero);
    }
    
    public Complejo cociente(Complejo b){
        return new Complejo(this.numero+b.numero);
    }
    
    public Complejo divisionEscalar(Complejo b){
        return new Complejo(this.numero+b.numero);
    }

    @Override
    public String toString() {
        return numero+"";
    }
    
    
}
