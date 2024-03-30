/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class Banco {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    public void agregar(Object item){
        if (item instanceof Cliente) {
            clientes.add((Cliente)item);
        }else if (item instanceof CuentaBancaria) {
            cuentas.add((CuentaBancaria)item);
        }
    }
    
    public double totalSaldosClientes() {
        double saldosTotal = 0;
        for (int i = 0; i < clientes.size(); i++) {
            saldosTotal += clientes.get(i).saldoTotal();
        }
        return saldosTotal;
    }

    public double totalSaldosNegativosCC() {
        double saldoNegTotal = 0;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i) instanceof CuentaCorriente && cuentas.get(i).getSaldo() < 0) {
                saldoNegTotal += cuentas.get(i).getSaldo();
            }
        }
        return saldoNegTotal;
    }
}
