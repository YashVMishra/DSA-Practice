// https://leetcode.com/problems/majority-element-ii/description/?envType=daily-question&envId=2023-10-05

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Majority_Element_2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int value = nums.length / 3;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > value && !set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static List<Integer> majorityElement_2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int value = nums.length / 3;

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

    // using banking voting algorithm. (Boyer Moore's Voting Algorithm)
    // see the video from the notes section.
    public static List<Integer> majorityElement_3(int[] nums) {
        int count1 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int count2 = 0;
        int candidate2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // verfiying the candidates.
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == candidate1) {
                count1++;
            } else if (i == candidate2) {
                count2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        if (count1 > nums.length / 3) {
            list.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            list.add(candidate2);
        }

        return list;
    }
}
