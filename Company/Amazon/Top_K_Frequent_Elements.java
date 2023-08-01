// https://leetcode.com/problems/top-k-frequent-elements/description/

// store the key value pair of the array in a map and then store the entry set of the 
// map in a list and sort it according to the values and then starting from the start store 
// the keys from the list in the answer array.

// for sorting list according to values of map see the articel
// https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // taking the entry set of the map and storing it in the list and
        // then sorting the list according to values.
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        int[] ans = new int[k];
        int index = list.size() - 1;
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(index).getKey();
            index--;
        }

        return ans;
    }
}
