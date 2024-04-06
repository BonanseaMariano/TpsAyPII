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
public class Inmueble extends Bien {

    private String partida;
    private double valuacionFiscal;
    private double alicuotaBaldio;
    private double alicuotaEdificado;
    private boolean baldio;

    public Inmueble(String partida, double valuacionFiscal, double alicuotaBaldio, double alicuotaEdificado, boolean baldio, String fechaAlta, Titular titular) {
        super(fechaAlta, titular);
        this.partida = partida;
        this.valuacionFiscal = valuacionFiscal;
        this.alicuotaBaldio = alicuotaBaldio;
        this.alicuotaEdificado = alicuotaEdificado;
        this.baldio = baldio;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public void setValuacionFiscal(double valuacionFiscal) {
        this.valuacionFiscal = valuacionFiscal;
    }

    public double getAlicuotaBaldio() {
        return alicuotaBaldio;
    }

    public void setAlicuotaBaldio(double alicuotaBaldio) {
        this.alicuotaBaldio = alicuotaBaldio;
    }

    public double getAlicuotaEdificado() {
        return alicuotaEdificado;
    }

    public void setAlicuotaEdificado(double alicuotaEdificado) {
        this.alicuotaEdificado = alicuotaEdificado;
    }

    public boolean isBaldio() {
        return baldio;
    }

    public void setBaldio(boolean baldio) {
        this.baldio = baldio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.partida);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valuacionFiscal) ^ (Double.doubleToLongBits(this.valuacionFiscal) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.alicuotaBaldio) ^ (Double.doubleToLongBits(this.alicuotaBaldio) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.alicuotaEdificado) ^ (Double.doubleToLongBits(this.alicuotaEdificado) >>> 32));
        hash = 29 * hash + (this.baldio ? 1 : 0);
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
        final Inmueble other = (Inmueble) obj;
        if (Double.doubleToLongBits(this.valuacionFiscal) != Double.doubleToLongBits(other.valuacionFiscal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.alicuotaBaldio) != Double.doubleToLongBits(other.alicuotaBaldio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.alicuotaEdificado) != Double.doubleToLongBits(other.alicuotaEdificado)) {
            return false;
        }
        if (this.baldio != other.baldio) {
            return false;
        }
        if (this.partida.compareToIgnoreCase(other.partida) != 0) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Inmueble{" + "partida=" + partida + ", valuacionFiscal=" + valuacionFiscal + ", alicuotaBaldio=" + alicuotaBaldio + ", alicuotaEdificado=" + alicuotaEdificado + ", baldio=" + baldio + " " + super.toString() + '}';
    }

    @Override
    public double calcularImpuesto() {
        if (baldio) {
            return valuacionFiscal * alicuotaBaldio;
        } else {
            return valuacionFiscal * alicuotaEdificado;
        }
    }

}
