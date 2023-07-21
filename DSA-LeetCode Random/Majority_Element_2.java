//https://leetcode.com/problems/majority-element-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Majority_Element_2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int value = (int) (Math.floor(nums.length / 3));

        for (int i : nums) {
            map.put(i, (map.getOrDefault(i, 0) + 1));
        }

        Set<Integer> keySet = map.keySet();

        for (int i : keySet) {
            if (map.get(i) > value) {
                list.add(i);
            }
        }

        return list;
    }
}
