package collections_map.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    // both are fast
    static void testAddEnd(List<Integer> list, int size) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) list.add(i);
        long end = System.nanoTime();
        System.out.println(list.getClass().getSimpleName() + " addEnd: " + (end - start) / 1e6 + " ms");
    }

    // array is very fast , linkded is very slow
    static void testRandomAccess(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i += 1000) {
            int value = list.get(i);
        }
        long end = System.nanoTime();
        System.out.println(list.getClass().getSimpleName() + " randomAccess: " + (end - start) / 1e6 + " ms");
    }

    static void testAddFront(List<Integer> list, int size) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) list.add(0, i);
        long end = System.nanoTime();
        System.out.println(list.getClass().getSimpleName() + " addFront: " + (end - start) / 1e6 + " ms");
    }

    static void testRemoveFront(List<Integer> list) {
        long start = System.nanoTime();
        while (!list.isEmpty()) list.remove(0);
        long end = System.nanoTime();
        System.out.println(list.getClass().getSimpleName() + " removeFront: " + (end - start) / 1e6 + " ms");
    }

    public static void main(String[] args) {
        int size = 100_000;

        List<Integer> arrayList = new ArrayList<>(size);
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("=== Add cuối danh sách ===");
        testAddEnd(arrayList, size);
        testAddEnd(linkedList, size);

        System.out.println("\n=== Truy cập ngẫu nhiên ===");
        testRandomAccess(arrayList);
        testRandomAccess(linkedList);

        System.out.println("\n=== Thêm vào đầu danh sách ===");
        testAddFront(new ArrayList<>(), size);
        testAddFront(new LinkedList<>(), size);

        System.out.println("\n=== Xoá phần tử đầu tiên liên tục ===");
        testRemoveFront(new ArrayList<>(arrayList));
        testRemoveFront(new LinkedList<>(linkedList));
    }
}
