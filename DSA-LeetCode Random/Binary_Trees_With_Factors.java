// https://leetcode.com/problems/binary-trees-with-factors/description/?envType=daily-question&envId=2023-10-26

import java.util.Arrays;
import java.util.HashMap;

public class Binary_Trees_With_Factors {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 10 };
        System.out.println(numFactoredBinaryTrees(arr));
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, 1L);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int root = arr[i];

                // we consider arr[j] as left child
                // so acc to ques right child have to be root / arr[j]
                if (root % arr[j] == 0 && map.containsKey(root / arr[j])) {
                    long addOn = map.get(arr[j]) * map.get(root / arr[j]);
                    map.put(root, map.get(root) + addOn);
                }
            }
        }

        long result = 0;
        for (long val : map.values()) {
            result += val;
        }

        return (int) (result % (1e9 + 7));
    }
}
