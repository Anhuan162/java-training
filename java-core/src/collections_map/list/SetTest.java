package collections_map.list;

import java.util.*;

public class SetTest {
    private final static int size = 100000;

    static boolean compareAddSpeed(Set<Integer>  set1, Set<Integer>  set2, int size) {
        long start1 = System.nanoTime();
        for (int i=0; i<size; i+=1000) {
            set1.add(i);
        }
        long end1 = System.nanoTime();
        System.out.println(end1-start1);

        long start2 = System.nanoTime();
        for (int i=0; i<size; i+=1000) {
            set2.add(i);
        }
        long end2 = System.nanoTime();
        System.out.println(end2-start2);
        return end2-start2>end1-start1;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        Set<Integer> set1 = new LinkedHashSet();
        Set<Integer> set2 = new TreeSet();

        if (compareAddSpeed(set, set1, size)) {
            System.out.println("Using LinkedHashSet to add item slower than Hashset");
        }
        if (compareAddSpeed(set1, set2, size)) {
            System.out.println("Using TreeSet to add item slower than LinkedHashSet");
        }
    }
}
