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
public class Titular {

    private String nombre;
    private String cuit;

    public Titular(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.cuit);
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
        final Titular other = (Titular) obj;
        if (nombre.compareToIgnoreCase(other.getNombre()) != 0 || cuit.compareToIgnoreCase(other.getCuit()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Titular{" + "nombre=" + nombre + ", cuit=" + cuit + '}';
    }

}
