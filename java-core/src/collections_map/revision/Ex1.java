package collections_map.revision;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ex1 {
    private final static int size = 100000;

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            A.add((int) (Math.random() * 2001));
        }

        Set<Integer> B = new HashSet<>();
        for (Integer i : A) {
            B.add(i);
        }
        System.out.println(A.size() + " " + B.size());

        Map<Integer, Integer> sortedMap = new HashMap<>();
        for (Integer i : A) {
            sortedMap.put(i, sortedMap.getOrDefault(i, 0) + 1);
        }

        Integer keyWithMaxValue = sortedMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())) // sort by value desc
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("Key with max value: " + keyWithMaxValue);

        List<Integer> C = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            C.add((ThreadLocalRandom.current().nextInt(1000, 3001)));
        }

        // dung set vi set co toc do truy cap phan tu nhanh nhat chi O(1)
        for (Integer i : C) {
            if (B.contains(i)) {
                System.out.println(i + " có trong A");
            } else {
                System.out.println(i + " không có trong A");
            }
        }
    }
}
