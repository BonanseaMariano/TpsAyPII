/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

public class TestCliente {

    public static void main(String[] args) {
        //Test cliente (las cuentas del cliente se agregan al usar los constructores de cuentas bancarias)
        Cliente c1 = new Cliente("Mariano", 235678, "Lavalle 51", "test@mail.com");

        //Test Caja de Ahorro
        CajaAhorro ca = new CajaAhorro(111, c1, 0);
        System.out.println(ca.toString());
        ca.extraccion(10);
        System.out.println("Extraccion de $10: " + ca.toString());
        ca.deposito(100000);
        System.out.println("Deposito de $100000: " + ca.toString());

        System.out.println("");

        //Test cuenta corriente
        CuentaCorriente cb = new CuentaCorriente(-1000, 222, c1, 0);
        System.out.println(cb.toString());
        cb.extraccion(1000);
        System.out.println("Extraccion de $1000: " + cb.toString());
        cb.deposito(10000);
        System.out.println("Deposito de $10000: " + cb.toString());

        System.out.println("");

        //Test Saldo total del cliente
        System.out.println("Saldo total de " + c1.getNombre() + ": $" + c1.saldoTotal());
    }
}
