package test;

import java.util.*;
import java.util.List;

import net.datastructures.*;

public class PlanDeEstudioTest {

    public static void main(String[] args) {

        Graph<String, Integer> g = new AdjacencyMapGraph<>(true);

        Vertex<String> IF001 = g.insertVertex("Elementos de Informatica");
        Vertex<String> IF002 = g.insertVertex("Expresion de Problemas y Algoritmos");
        Vertex<String> MA045 = g.insertVertex("Algebra");
        Vertex<String> IF003 = g.insertVertex("Algoritmica y Programacion I");
        Vertex<String> MA008 = g.insertVertex("Elementos de Logica y Matematica Discreta");
        Vertex<String> MA046 = g.insertVertex("Analisis Matematico");
        Vertex<String> FAD07 = g.insertVertex("Acreditacion de Idioma");
        Vertex<String> IF004 = g.insertVertex("Sistemas y organizaciones");
        Vertex<String> IF005 = g.insertVertex("Arquitectura de Computadoras");
        Vertex<String> IF006 = g.insertVertex("Algoritmica y Programacion II");
        Vertex<String> IF011 = g.insertVertex("Sistemas Operativos");
        Vertex<String> IF007 = g.insertVertex("Bases de Datos I");
        Vertex<String> IF008 = g.insertVertex("Programacion Orientada a Objetos");
        Vertex<String> MA006 = g.insertVertex("Estadistica");
        Vertex<String> IF010 = g.insertVertex("Analisis y diseño de Sistemas");
        Vertex<String> IF009 = g.insertVertex("Laboratorio de Programacion y Lenguajes");
        Vertex<String> IF012 = g.insertVertex("Desarrollo de software");
        Vertex<String> IF013 = g.insertVertex("Fundamentos Teoricos de la Informatica");
        Vertex<String> MA047 = g.insertVertex("Complementos Matematicos");
        Vertex<String> FA102 = g.insertVertex("Estrategias Comunicacionales");
        Vertex<String> FA103 = g.insertVertex("Relaciones Humanas");


        Edge<Integer> a1 = g.insertEdge(IF002, IF003, 1);
        Edge<Integer> a2 = g.insertEdge(IF001, IF005, 2);
        Edge<Integer> a3 = g.insertEdge(MA045, MA006, 3);
        Edge<Integer> a4 = g.insertEdge(MA045, MA047, 4);
        Edge<Integer> a5 = g.insertEdge(IF003, IF006, 5);
        Edge<Integer> a6 = g.insertEdge(MA008, IF006, 6);
        Edge<Integer> a7 = g.insertEdge(MA008, IF013, 7);
        Edge<Integer> a8 = g.insertEdge(MA046, MA006, 8);
        Edge<Integer> a9 = g.insertEdge(MA046, MA047, 9);
        Edge<Integer> a10 = g.insertEdge(IF005, IF011, 10);
        Edge<Integer> a11 = g.insertEdge(IF004, IF010, 11);
        Edge<Integer> a12 = g.insertEdge(IF006, IF011, 12);
        Edge<Integer> a13 = g.insertEdge(IF006, IF007, 13);
        Edge<Integer> a14 = g.insertEdge(IF006, IF008, 14);
        Edge<Integer> a15 = g.insertEdge(IF006, IF013, 15);
        Edge<Integer> a16 = g.insertEdge(IF007, IF010, 16);
        Edge<Integer> a17 = g.insertEdge(IF008, IF009, 17);
        Edge<Integer> a18 = g.insertEdge(IF008, IF012, 18);
        Edge<Integer> a19 = g.insertEdge(IF010, IF012, 19);


        // Crear un comparador personalizado para ordenar los vértices por el número de arcos de salida en orden decreciente
        Comparator<Vertex<String>> comparador = Comparator.comparingInt(g::outDegree).reversed();

        // Crear una lista para almacenar los vértices
        List<Vertex<String>> vertices = new ArrayList<>();

        // Crear un TreeSet que ordene los vértices utilizando el comparador personalizado
//        TreeSet<Vertex<String>> verticesOrdenados = new TreeSet<>(comparador);

        // Agregar todos los vértices del grafo al TreeSet
        for (Vertex<String> vertex : g.vertices()) {
//            verticesOrdenados.add(vertex);
            vertices.add(vertex);
        }

        // Ordenar la lista de vértices utilizando el comparador personalizado
        vertices.sort(comparador);

//        System.out.println("Con TreeSet:");
//        // Imprimir los vértices en el orden deseado
//        for (Vertex<String> vertex : verticesOrdenados) {
//            System.out.println(vertex.getElement() + ": " + g.outDegree(vertex));
//        }

        System.out.println();

//        System.out.println("Con ArrayList.sort:");
        // Imprimir los vértices en el orden deseado
        for (Vertex<String> vertex : vertices) {
            System.out.println(vertex.getElement() + ": " + g.outDegree(vertex) + " correlativas");
        }
    }
}
