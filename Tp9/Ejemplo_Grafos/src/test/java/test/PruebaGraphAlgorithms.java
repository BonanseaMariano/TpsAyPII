package test;

import java.util.HashSet;
import java.util.Set;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.LinkedPositionalList;
import net.datastructures.Map;
import net.datastructures.PositionalList;
import net.datastructures.ProbeHashMap;
import net.datastructures.Vertex;

public class PruebaGraphAlgorithms {

    public static void main(String[] args) {

        Graph<String, Integer> g = new AdjacencyMapGraph<>(true);

        Vertex<String> v1 = g.insertVertex("1");
        Vertex<String> v2 = g.insertVertex("2");
        Vertex<String> v3 = g.insertVertex("3");
        Vertex<String> v4 = g.insertVertex("4");
        Vertex<String> v5 = g.insertVertex("5");
        Vertex<String> v6 = g.insertVertex("6");
        Vertex<String> v7 = g.insertVertex("7");

        Edge<Integer> a1 = g.insertEdge(v1, v7, 100);
        Edge<Integer> a2 = g.insertEdge(v2, v3, 110);
        Edge<Integer> a3 = g.insertEdge(v3, v4, 120);
        Edge<Integer> a4 = g.insertEdge(v3, v6, 130);
        Edge<Integer> a5 = g.insertEdge(v5, v1, 140);
        Edge<Integer> a6 = g.insertEdge(v5, v2, 150);
        Edge<Integer> a7 = g.insertEdge(v5, v6, 160);
        Edge<Integer> a8 = g.insertEdge(v6, v4, 170);
        Edge<Integer> a9 = g.insertEdge(v7, v5, 180);
        Edge<Integer> a10 = g.insertEdge(v7, v6, 190);


        Map<Vertex<String>, Edge<Integer>> result = new ProbeHashMap<>();
        Set<Vertex<String>> set = new HashSet<>();

        GraphAlgorithms.DFS(g, v1, set, result);

        System.out.println("Todos los vertices alcanzados desde v1");
        for (Vertex<String> ver : result.keySet())
            System.out.println(ver.getElement() + "  " + result.get(ver).getElement());

        PositionalList<Edge<Integer>> camino = new LinkedPositionalList<>();
        camino = GraphAlgorithms.constructPath(g, v1, v6, result);

        System.out.println("Un camino para alcanzar dos vertices");
        for (Edge<Integer> arcos : camino)
            System.out.println(arcos.getElement());

    }
}
