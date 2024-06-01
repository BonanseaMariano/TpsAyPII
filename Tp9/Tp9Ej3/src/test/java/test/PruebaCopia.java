package test;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.ProbeHashMap;
import net.datastructures.Vertex;

public class PruebaCopia {

    public static void main(String[] args) {

        // Grafo Original
        Graph<String, Camino> g = new AdjacencyMapGraph<>(false);

        Vertex<String> v1 = g.insertVertex("MAD");
        Vertex<String> v2 = g.insertVertex("TRE");
        Vertex<String> v3 = g.insertVertex("RAW");
        Vertex<String> v4 = g.insertVertex("ESQ");
        Vertex<String> v5 = g.insertVertex("COM");
        Vertex<String> v6 = g.insertVertex("SAR");

        Edge<Camino> a1 = g.insertEdge(v1, v2, new Camino("Ruta 3", 65, 3));
        Edge<Camino> a2 = g.insertEdge(v1, v3, new Camino("Ruta 1", 70, 2));
        Edge<Camino> a3 = g.insertEdge(v2, v3, new Camino("Ruta 3", 17, 1));
        Edge<Camino> a4 = g.insertEdge(v2, v4, new Camino("Ruta 25", 619, 1));
        Edge<Camino> a5 = g.insertEdge(v2, v5, new Camino("Ruta 3", 350, 1));
        Edge<Camino> a6 = g.insertEdge(v5, v6, new Camino("Ruta 3", 155, 1));
        Edge<Camino> a7 = g.insertEdge(v6, v4, new Camino("Ruta 3", 441, 1));

        System.out.println("Grafo original");
        System.out.println(g);

        // Copia del grafo original. Los arcos solo tienen un entero para indicar su peso
        // shortestPathLengths (Que implementa Dijkstra) necesita un grafo con �ste formato
        Graph<String, Integer> gd = new AdjacencyMapGraph<>(false);

        Map<String, Vertex<String>> res = new ProbeHashMap<>();
        for (Vertex<String> result : g.vertices())
            res.put(result.getElement(), gd.insertVertex(result.getElement()));

        Vertex<String>[] vert;
        for (Edge<Camino> result : g.edges()) {
            vert = g.endVertices(result);
            gd.insertEdge(res.get(vert[0].getElement()), res.get(vert[1].getElement()), result.getElement().getDistancia());
        }

        System.out.println("Grafo duplicado");
        System.out.println(gd);

    }
}
