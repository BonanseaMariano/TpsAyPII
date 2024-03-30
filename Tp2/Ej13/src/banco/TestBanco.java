/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

public class TestBanco {

    public static void main(String[] args) {

        //Test banco
        Banco banco = new Banco();

        //Test cliente (las cuentas del cliente se agregan al usar los constructores de cuentas bancarias)
        Cliente c1 = new Cliente("Mariano", 235678, "Lavalle 51", "test@mail.com");
        Cliente c2 = new Cliente("Carlos", 235908, "Calle 123", "test1@mail.com");

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

        //Test cuenta corriente
        CuentaCorriente cb2 = new CuentaCorriente(-1000, 222, c2, 0);
        System.out.println(cb.toString());
        cb2.extraccion(1000);
        System.out.println("Extraccion de $1000: " + cb2.toString());

        System.out.println("");

        
        //Agregar clientes y cuentas al banco
        banco.agregar(c1);
        banco.agregar(c2);
        banco.agregar(ca);
        banco.agregar(cb);
        banco.agregar(cb2);
        
        //Test Saldo total del cliente
        System.out.println("Saldo total de " + c1.getNombre() + ": $" + c1.saldoTotal());
        System.out.println("");

        System.out.println("Saldo total de " + c2.getNombre() + ": $" + c2.saldoTotal());
        System.out.println("");

        //Test banco
        System.out.println("Total saldos clientes: $" + banco.totalSaldosClientes());
        System.out.println("");
        System.out.println("Total saldos negativos cuentas corrientes: $" + banco.totalSaldosNegativosCC());
        System.out.println("");

    }
}
