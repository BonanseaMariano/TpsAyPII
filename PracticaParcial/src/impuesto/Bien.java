/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuesto;

import java.util.Objects;

/**
 *
 * @author Mariano
 */
public abstract class Bien {

    private String fechaAlta;
    private Titular titular;

    public Bien(String fechaAlta, Titular titular) {
        this.fechaAlta = fechaAlta;
        this.titular = titular;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.fechaAlta);
        hash = 53 * hash + Objects.hashCode(this.titular);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        } 
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bien other = (Bien) obj;
        if (fechaAlta.compareToIgnoreCase(other.getFechaAlta()) != 0 || !titular.equals(other.getTitular())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fechaAlta=" + fechaAlta + ", titular=" + titular;
    }

    public abstract double calcularImpuesto();
}
