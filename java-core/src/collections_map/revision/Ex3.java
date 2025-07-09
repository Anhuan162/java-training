package collections_map.revision;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();

        String line = sc.nextLine();
        List<String> list = Arrays.asList(line.split("\\s+"));


        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s.trim(), map.getOrDefault(s, 0) + 1);
        }

        List<String> res = map.entrySet().stream().sorted((m1, m2) -> {
            if (m2.getValue() != m1.getValue()) return m2.getValue().compareTo(m1.getValue());
            return m1.getKey().compareTo(m2.getKey());
        }).limit(k).map(Map.Entry::getKey).toList();

        for (String s : res) {
            System.out.println(s);
        }
    }
}
