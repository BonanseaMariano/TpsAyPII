package banco;

public class CuentaBancaria {

    private int numeroCuenta;
    private Cliente titular;
    protected double saldo;

    public CuentaBancaria(int numeroCuenta, Cliente titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo invalido, se asignara el minimo ($0)");
            this.saldo = 0;
        }
        titular.agregarCuenta(this);
    }

    
    public void deposito(float cantidad) {
        this.saldo += cantidad;
    }

    public void extraccion(float cantidad) {
        this.saldo -= cantidad;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{ numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + '}';
    }

}
