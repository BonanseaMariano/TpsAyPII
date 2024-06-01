package test;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.HashMap;
import java.util.TreeSet;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;

/**
 * This class provides a utility to build a graph from a list of edges.
 * <p>
 * It also contains specific factory methods to generate graph instances used as
 * examples within Data Structures and Algorithms in Java, 6th edition.
 */
public class GraphExamplesChubut {

    /**
     * Constructs a graph from an array of array strings.
     * <p>
     * An edge can be specified as { "SFO", "LAX" }, in which case edge is
     * created with default edge value of 1, or as { "SFO", "LAX", "337" }, in
     * which case the third entry should be a string that will be converted to
     * an integral value.
     */
    public static Graph<String, Integer> graphFromEdgelist(String[][] edges, boolean directed) {
        Graph<String, Integer> g = new AdjacencyMapGraph<>(directed);

        // first pass to get sorted set of vertex labels
        TreeSet<String> labels = new TreeSet<>();
        for (String[] edge : edges) {
            labels.add(edge[0]);
            labels.add(edge[1]);
        }

        // now create vertices (in alphabetical order)
        HashMap<String, Vertex<String>> verts = new HashMap<>();
        for (String label : labels)
            verts.put(label, g.insertVertex(label));

        // now add edges to the graph
        for (String[] edge : edges) {
            Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2]));
            g.insertEdge(verts.get(edge[0]), verts.get(edge[1]), cost);
        }

        Map<Vertex<String>, Integer> res = GraphAlgorithms.shortestPathLengths(g, verts.get("MAD"));

        for (Vertex<String> result : res.keySet())
            System.out.println(result.getElement() + "  -->  " + res.get(result));

        return g;
    }

    public static Graph<String, Integer> Chubut() {
        String[][] edges = {{"MAD", "TRE", "65"}, {"MAD", "RAW", "70"},
                {"TRE", "RAW", "17"}, {"TRE", "ESQ", "619"},
                {"TRE", "COM", "350"}, {"COM", "SAR", "155"},
                {"SAR", "ESQ", "441"},};
        return graphFromEdgelist(edges, false);
    }

    public static void main(String[] args) {
        System.out.println("Chubut");
        System.out.println(Chubut());
    }

}
