package test;

public class Camino {

    private String nombre;
    private int distancia;
    private int tipo;

    public Camino(String nombre, int distancia, int tipo) {
        super();
        this.nombre = nombre;
        this.distancia = distancia;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Camino [nombre=" + nombre + ", distancia=" + distancia
                + ", tipo=" + tipo + "]";
    }


}
