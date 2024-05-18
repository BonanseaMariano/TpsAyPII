package test;

import net.datastructures.*;

/**
 *
 * @author Mariano
 */
public class MapTest {

    static Map<Integer, String> map;

    public static void main(String[] args) {
        map = new ProbeHashMap<>();

        map.put(50, "Juan");
        map.put(20, "Maria");

        System.out.println(map.get(50));
        System.out.println(map.get(20));

        for (Integer i : map.keySet()) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (String s : map.values()) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (Entry<Integer, String> e : map.entrySet()) {
            System.out.print(e+" ");
        }

    }

}
