package empresa;

/*Esta clase es para probar las clases Factura y Empleado, poniendolos en el arreglo llamado 'pagos'
 * que es de tipo PorPagar.
 */
public class PruebaPagos {

    public static void main(String[] args) {

        // Cargar cinco empleados y cinco facturas
        //Empleados
        Empleado e1 = new Empleado(1231, "Juan", null, 40, 25);
        Empleado e2 = new Empleado(1233, "Ana", e1, 40, 15);
        Empleado e3 = new Empleado(1235, "Luis", e1, 40, 15);
        Empleado e4 = new Empleado(1236, "Pedro", null, 50, 25);
        Empleado e5 = new Empleado(1238, "Paula", e4, 30, 10);

        //Facturas
        Factura f1 = new Factura("FortinRepublica", 22221, "2017-05-05");
        Factura f2 = new Factura("Tornillito", 22222, "2022-09-07");
        Factura f3 = new Factura("Martillito", 22223, "2021-07-07");
        Factura f4 = new Factura("Con Pinzas", 22224, "2023-06-06");
        Factura f5 = new Factura("Maquinas y Herramientas", 22225, "2024-02-02");

        //Cargo items a las Facturas
        //f1
        f1.agregarItem("Mecha", 10, 7.5);
        //f2
        f2.agregarItem("Tornillo", 50, 0.25);
        f2.agregarItem("Clavos", 100, 0.1);
        //f3
        f3.agregarItem("Clavos", 100, 0.1);
        //f4
        f4.agregarItem("Tornillo", 50, 0.25);
        //f5
        f5.agregarItem("Tuercas", 60, 0.75);
        f5.agregarItem("Arandelas", 60, 0.5);

        // Asignar los objetos creados a un lugar del arreglo 'pagos'        
        PorPagar pagos[] = new PorPagar[]{e1, f1, e2, f2, e3, f3, e4, f4, e5, f5};

        // Escribir el resultado que tienen que pagar cada uno
        for (int i = 0; i < pagos.length; i++) {
            System.out.printf("Importes a pagar: $%.02f, tipo: %s\n", pagos[i].obtenerPago(), pagos[i].getClass().getSimpleName());
        }
    }
}
