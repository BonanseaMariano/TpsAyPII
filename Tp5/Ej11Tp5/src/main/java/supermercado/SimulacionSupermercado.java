package supermercado;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import supermercado.Cliente;

public class SimulacionSupermercado {

    //Clase Caja
    private class Caja {

        //Cola de clientes de la caja
        Queue<Cliente> cola = new LinkedList<>();
        int tiempoAtencion = 0;
        int clientesAtendidos = 0;
        int productosTotales = 0;
    }

    //Atributos Simulacion Supermercado
    private int numCajas, numClientes, maxProductos;
    private final int tPorProducto, tPago;

    //Constructor SimulacionSupermercado
    public SimulacionSupermercado(int numCajas, int numClientes, int maxProductos, int tPorProducto, int tPago) {
        this.numCajas = numCajas;
        this.numClientes = numClientes;
        this.maxProductos = maxProductos;
        this.tPorProducto = tPorProducto;
        this.tPago = tPago;
    }

    /**
     * Realiza la simulacion del supermercado
     */
    public void simulacion() {
        //Lista de cajas
        List<Caja> cajas = new ArrayList<>();
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new Caja());
        }

        // Generar clientes con cantidades aleatorias de productos
        generarClientes(cajas);

        // Simulación
        while (cajas.stream().anyMatch(c -> !c.cola.isEmpty())) {
            for (Caja caja : cajas) {
                if (!caja.cola.isEmpty()) {
                    Cliente cliente = caja.cola.poll();
                    caja.tiempoAtencion += (cliente.getProductos() * tPorProducto) + tPago;
                    caja.productosTotales += cliente.getProductos();
                    caja.clientesAtendidos++;
                }
            }
        }

        // Reporte final
        reporteFinal(cajas);
    }

    /**
     * Metodo para generar clientes con cantidad de productos aleatoria
     */
    public void generarClientes(List<Caja> cajas) {
        for (int i = 0; i < numClientes; i++) {
            int productos = (int) (Math.random() * maxProductos) + 1;
            Cliente cliente = new Cliente(productos);
            // Unirse a la caja con menos personas
            int minCajaIndex = cajaConMenosCola(cajas);
            cajas.get(minCajaIndex).cola.add(cliente);
        }
    }

    /**
     * Método para encontrar la caja con la cola más pequeña
     */
    public int cajaConMenosCola(List<Caja> cajas) {
        int minIndex = 0;
        int minSize = Integer.MAX_VALUE; // Inicializamos con un valor grande

        for (int i = 0; i < cajas.size(); i++) {
            int size = cajas.get(i).cola.size();
            if (size < minSize) {
                minSize = size;
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Metodo que realiza el reporte final de la simulacion
     */
    public void reporteFinal(List<Caja> cajas) {

        for (int i = 0; i < numCajas; i++) {
            System.out.println("Caja " + (i + 1) + ":");
            System.out.println("Clientes atendidos: " + cajas.get(i).clientesAtendidos);
            System.out.println("Tiempo de atencion total: " + cajas.get(i).tiempoAtencion);
            System.out.println("Tiempo de atencion promedio por cliente: " + cajas.get(i).tiempoAtencion / cajas.get(i).clientesAtendidos);
            System.out.println("Productos totales: " + cajas.get(i).productosTotales);
            System.out.println("Productos en promedio por cliente: " + cajas.get(i).productosTotales / cajas.get(i).clientesAtendidos);
            // Calcula otras estadísticas aquí
            System.out.println();
        }
    }

}
