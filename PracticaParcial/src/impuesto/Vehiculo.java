/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuesto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Mariano
 */
public class Vehiculo extends Bien {

    private String patente;
    private String marca;
    private int modelo;
    private final int antiguedad = 20;
    private double alicuotaVehiculo;
    private double valuacionFiscal;

    public Vehiculo(String patente, String marca, int modelo, double alicuotaVehiculo, double valuacionFiscal, String fechaAlta, Titular titular) {
        super(fechaAlta, titular);
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.alicuotaVehiculo = alicuotaVehiculo;
        this.valuacionFiscal = valuacionFiscal;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getAlicuotaVehiculo() {
        return alicuotaVehiculo;
    }

    public void setAlicuotaVehiculo(double alicuotaVehiculo) {
        this.alicuotaVehiculo = alicuotaVehiculo;
    }

    public double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public void setValuacionFiscal(double valuacionFiscal) {
        this.valuacionFiscal = valuacionFiscal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.patente);
        hash = 17 * hash + Objects.hashCode(this.marca);
        hash = 17 * hash + this.modelo;
        hash = 17 * hash + this.antiguedad;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.alicuotaVehiculo) ^ (Double.doubleToLongBits(this.alicuotaVehiculo) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.valuacionFiscal) ^ (Double.doubleToLongBits(this.valuacionFiscal) >>> 32));
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
        final Vehiculo other = (Vehiculo) obj;

        if (this.modelo != other.modelo) {
            return false;
        }
        if (this.antiguedad != other.antiguedad) {
            return false;
        }
        if (Double.doubleToLongBits(this.alicuotaVehiculo) != Double.doubleToLongBits(other.alicuotaVehiculo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valuacionFiscal) != Double.doubleToLongBits(other.valuacionFiscal)) {
            return false;
        }
        if (this.patente.compareToIgnoreCase(other.patente) != 0 || this.marca.compareToIgnoreCase(other.marca) != 0) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", antiguedad=" + antiguedad + ", alicuotaVehiculo=" + alicuotaVehiculo + ", valuacionFiscal=" + valuacionFiscal + " " + super.toString() + '}';
    }

    @Override
    public double calcularImpuesto() {
        if ((LocalDate.now().getYear() - Integer.parseInt(this.getFechaAlta())) >= this.antiguedad) {
            return 0;
        } else {
            return valuacionFiscal * alicuotaVehiculo;
        }
    }

}
