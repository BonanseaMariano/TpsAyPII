package empresa;

//En esta clase se prueba la clase Factura
public class PruebaFactura {

	public static void main(String[] args) {

		Factura f2 = new Factura("FortinRepublica", 22222, "2017-05-05");
		f2.agregarItem("Tornillo", 50, 0.25);
		f2.agregarItem("Clavos", 100, 0.1);

		System.out.println(f2);
		System.out.println("Total de la factura: " + f2.obtenerPago());

	}
	
}
