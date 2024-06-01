package test;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;

public class Prueba {
    static Graph<String, Integer> g;

    public static void main(String[] args) {
        dirigido();
        noDirigido();
    }

    public static void dirigido() {
        g = new AdjacencyMapGraph<>(true);

        Vertex<String> v1 = g.insertVertex("1");
        Vertex<String> v2 = g.insertVertex("2");
        Vertex<String> v3 = g.insertVertex("3");
        Vertex<String> v4 = g.insertVertex("4");
        Vertex<String> v5 = g.insertVertex("5");
        Vertex<String> v6 = g.insertVertex("6");
        Vertex<String> v7 = g.insertVertex("7");

        Edge<Integer> a1 = g.insertEdge(v1, v2, 2);
        Edge<Integer> a2 = g.insertEdge(v1, v4, 1);
        Edge<Integer> a3 = g.insertEdge(v2, v4, 3);
        Edge<Integer> a4 = g.insertEdge(v2, v5, 10);
        Edge<Integer> a5 = g.insertEdge(v3, v1, 4);
        Edge<Integer> a6 = g.insertEdge(v3, v6, 6);
        Edge<Integer> a7 = g.insertEdge(v4, v3, 2);
        Edge<Integer> a8 = g.insertEdge(v4, v5, 2);
        Edge<Integer> a9 = g.insertEdge(v4, v6, 8);
        Edge<Integer> a10 = g.insertEdge(v4, v7, 4);
        Edge<Integer> a11 = g.insertEdge(v5, v7, 6);
        Edge<Integer> a12 = g.insertEdge(v7, v6, 1);

        System.out.println("\n\t\tGrafo Dirigido");

        System.out.println("Arcos que salen del verice 1: ");
        for (Edge<Integer> arc : g.outgoingEdges(v1)) {
            System.out.println(arc.getElement());
        }

        System.out.println("Arcos que llegan al vertice 4: ");
        for (Edge<Integer> arc : g.incomingEdges(v4)) {
            System.out.println(arc.getElement());
        }

        System.out.println("Vertice opuesto al V5 con arco de peso 10: ");
        System.out.println(g.opposite(v5, a4).getElement());

        System.out.println("Arco entre V6 y V7: ");
        System.out.println(g.getEdge(v7, v6).getElement());

        System.out.println("Vertices del arco que tiene peso 8:");
        for (Vertex<String> vertice : g.endVertices(a9)) {
            System.out.println(vertice.getElement());
        }
    }

    public static void noDirigido() {
        g = new AdjacencyMapGraph<>(false);

        Vertex<String> v1 = g.insertVertex("1");
        Vertex<String> v2 = g.insertVertex("2");
        Vertex<String> v3 = g.insertVertex("3");
        Vertex<String> v4 = g.insertVertex("4");
        Vertex<String> v5 = g.insertVertex("5");
        Vertex<String> v6 = g.insertVertex("6");
        Vertex<String> v7 = g.insertVertex("7");

        Edge<Integer> a1 = g.insertEdge(v1, v2, 2);
        Edge<Integer> a2 = g.insertEdge(v1, v4, 1);
        Edge<Integer> a3 = g.insertEdge(v2, v4, 3);
        Edge<Integer> a4 = g.insertEdge(v2, v5, 10);
        Edge<Integer> a5 = g.insertEdge(v3, v1, 4);
        Edge<Integer> a6 = g.insertEdge(v3, v6, 6);
        Edge<Integer> a7 = g.insertEdge(v4, v3, 2);
        Edge<Integer> a8 = g.insertEdge(v4, v5, 2);
        Edge<Integer> a9 = g.insertEdge(v4, v6, 8);
        Edge<Integer> a10 = g.insertEdge(v4, v7, 4);
        Edge<Integer> a11 = g.insertEdge(v5, v7, 6);
        Edge<Integer> a12 = g.insertEdge(v7, v6, 1);

        System.out.println("\n\t\tGrafo No Dirigido");

        System.out.println("Arcos que salen del verice 1: ");
        for (Edge<Integer> arc : g.outgoingEdges(v1)) {
            System.out.println(arc.getElement());
        }

        System.out.println("Arcos que llegan al vertice 4: ");
        for (Edge<Integer> arc : g.incomingEdges(v4)) {
            System.out.println(arc.getElement());
        }

        System.out.println("Vertice opuesto al V5 con arco de peso 10: ");
        System.out.println(g.opposite(v5, a4).getElement());

        System.out.println("Arco entre V6 y V7: ");
        System.out.println(g.getEdge(v7, v6).getElement());

        System.out.println("Vertices del arco que tiene peso 8:");
        for (Vertex<String> vertice : g.endVertices(a9)) {
            System.out.println(vertice.getElement());
        }
    }
}
