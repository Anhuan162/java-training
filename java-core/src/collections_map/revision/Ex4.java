package collections_map.revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex4 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int mod = k == 0 ? sum : sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) + 1 >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(checkSubarraySum(nums, k));
    }

}
