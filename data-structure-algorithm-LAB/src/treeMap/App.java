package treeMap;

import java.util.*;

public class App {
    public static void main(String[] args) {
        TreeMap<Integer, String> treemap;
        // SortedMap is an abstract class, cannot be instantiated.
        SortedMap<Integer, String> sortedmap = new TreeMap<>();
        // Collection: interface
        Collection<Integer> numbers = new ArrayList<>();

        List<Integer> numbers2 = new ArrayList<>();
        Collections.synchronizedList(numbers2);
    }
}
