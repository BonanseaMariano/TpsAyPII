/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author Mariano
 */
public class TestLista {

    public static void main(String[] args) {

        // Crear una lista de enteros con capacidad inicial de 5 elementos
        Lista<String> listaNombres = new Lista<>(5);

        // Agregar elementos a la lista
        listaNombres.add("Mariano");
        listaNombres.add("Carlos");
        listaNombres.add("Nicolas");

        // Mostrar la lista completa
        System.out.println(listaNombres.toString());
        
        // Obtener un elemento de la lista
        System.out.println("Elemento en posicion 1: " + listaNombres.get(1));

        // Agregar un elemento en una posición específica
        listaNombres.add(1, "Luisa");
        System.out.println("Elemento Luisa agregado en posicion 1");

        
        // Mostrar la lista completa
        System.out.println(listaNombres.toString());
        
        // Eliminar un elemento por posicion
        String elementoEliminado = listaNombres.remove(1);
        System.out.println("Elemento eliminado: " + elementoEliminado);
        
        //Eliminar elemento por busqueda
        elementoEliminado = listaNombres.remove("Luisa");
        if (elementoEliminado != null) {
            System.out.println("Elemento eliminado: " + elementoEliminado);
        } else {
            System.out.println("El elemento no se encontro en la lista.");
        }

        // Mostrar la lista completa
        System.out.println(listaNombres.toString());
        
    }
}
