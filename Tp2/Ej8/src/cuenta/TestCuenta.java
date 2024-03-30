/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

public class TestCuenta {

    public static void main(String[] args) {
        //Test caja de ahorro
        CajaAhorro ca = new CajaAhorro(111, new Cliente("Mariano", 235678, "Lavalle 51", "test@mail.com"), 0);
        System.out.println(ca.toString());
        ca.extraccion(10);
        System.out.println("Extraccion de $10: " + ca.toString());
        ca.deposito(100000);
        System.out.println("Deposito de $100000: " + ca.toString());
        
        System.out.println("");
        //Test cuenta corriente
        CuentaCorriente cb = new CuentaCorriente(-1000,222, new Cliente("Homero", 267654, "La calle 123", "test2@mail.com"), 0);
        System.out.println(cb.toString());
        cb.extraccion(1000);
        System.out.println("Extraccion de $1000: " + cb.toString());
        cb.deposito(1000);
        System.out.println("Deposito de $1000: " + cb.toString());
    }
}
