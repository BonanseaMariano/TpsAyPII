/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

/**
 *
 * @author Mariano
 */
public class CajaAhorro extends CuentaBancaria {

    public CajaAhorro(int numeroCuenta, Cliente titular, double saldo) {
        super(numeroCuenta, titular, saldo);
    }

    @Override
    public void extraccion(float cantidad) {
        if (super.saldo - cantidad >= 0) {
            super.extraccion(cantidad);
        } else {
            System.out.println("El monto excede el saldo disponible en la cuenta");
        }
    }
    
    
}
