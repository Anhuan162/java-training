package collections_map.revision;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];

        int[] b = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            b[i] = sc.nextInt();
        }


        for (int i = 0; i < n+1; i++) {
            a[b[i]] += 1;
            if (a[b[i]] > 1) {
                System.out.println(b[i]);
                break;
            }
        }
    }
}
