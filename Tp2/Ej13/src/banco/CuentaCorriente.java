/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Mariano
 */
public class CuentaCorriente extends CuentaBancaria {

    private double saldoNegativoMax;

    public CuentaCorriente(double saldoNegativoMax, int numeroCuenta, Cliente titular, double saldo) {
        super(numeroCuenta, titular, saldo);
        if (saldoNegativoMax < 0) {
            this.saldoNegativoMax = saldoNegativoMax;
        } else {
            System.out.println("Saldo negativo invalido, se asignara el minimo (-$100)");
            this.saldoNegativoMax = -100;
        }
    }

    @Override
    public void extraccion(float cantidad) {
        if (super.saldo - cantidad >= saldoNegativoMax) {
            super.extraccion(cantidad);
        } else {
            System.out.println("El monto excede el saldo disponible y el saldo negativo maximo permitido en la cuenta");
        }
    }

    @Override
    public String toString() {
        return super.toString()+ " saldoNegativoMax=" + saldoNegativoMax;
    }

}
