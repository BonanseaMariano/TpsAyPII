/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuenta;

import java.util.ArrayList;

/**
 *
 * @author Mariano
 */
public class Cliente {

    private String nombre;
    private int cuit;
    private String direccion;
    private String email;
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>(); 

    public Cliente(String nombre, int cuit, String direccion, String email) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(CuentaBancaria cuenta){
        cuentas.add(cuenta);
    }
    
    public double saldoTotal(){
        double total = 0;
         for (int i = 0; i < cuentas.size(); i++) {
            total+=cuentas.get(i).getSaldo();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cuit=" + cuit + ", direccion=" + direccion + ", email=" + email + '}';
    }
    
}