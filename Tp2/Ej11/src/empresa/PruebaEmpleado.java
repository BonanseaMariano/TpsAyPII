package empresa;

//En esta clase se prueba la clase Empleado.
public class PruebaEmpleado {
	public static void main(String[] args) {

		Empleado e1 = new Empleado(1234, "Juan", null, 40, 25);
		Empleado e2 = new Empleado(1235, "Ana", e1, 40, 15);

		System.out.println(e1);
		System.out.println("Sueldo: " + e1.obtenerPago());
		System.out.println(e2);
		System.out.println("Sueldo: " + e2.obtenerPago());

	}

}
