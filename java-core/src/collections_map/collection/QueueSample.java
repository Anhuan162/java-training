package collections_map.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueSample {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Queue queue1 = new PriorityQueue();

        queue.add(1);
        queue.add(2);

        // Lấy phần tử đầu hàng đợi (nhưng không xoá), return null neu rong
        System.out.println("Peek: " + queue.peek());

        System.out.println("Poll: " + queue.poll());  // Lấy và xoá phần tử đầu,  return null neu rong
        System.out.println("Remove: " + queue.remove()); // delete and then throw exception if null

        queue1.add(10);
        queue1.add(5);
        queue1.add(15);
        System.out.println(queue1);        // thứ tự không đảm bảo
        System.out.println(queue1.poll()); // 5 (ưu tiên nhỏ nhất)
    }
}
