package empresa;

/*Esta clase es para probar las clases Factura y Empleado, poniendolos en el arreglo llamado 'pagos'
 * que es de tipo PorPagar.
 */
public class PruebaPagos {

	public static void main(String[] args) {

		// Empiezo a instanciar los objetos de clase Facturas y Empleados
		PorPagar pagos[] = new PorPagar[10];

		// Cargar cinco empleados y cinco facturas


		// Asignar los objetos creados a un lugar del arreglo 'pagos'
		
		
		// Escribir el resultado que tienen que pagar cada uno
		for (int i = 0; i < pagos.length; i++) {
			System.out.printf("Importes a pagar: %.02f\n", pagos[i].obtenerPago());
		}
	}
}
