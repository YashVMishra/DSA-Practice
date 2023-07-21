//https://practice.geeksforgeeks.org/problems/next-permutation5226/1

import java.util.List;
import java.util.ArrayList;

public class Next_Permutation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 4 };
        System.out.println(nextPermutation(arr.length, arr));
    }

    static List<Integer> nextPermutation(int N, int nums[]) {
        // code here
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            return list;
        }

        int index = 0;
        int index_2 = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break; // break is important as we are finding the first element that is satisfying the
                       // condition.
            }
        }

        // System.out.println(index);

        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                index_2 = i;
                break; // break is important as we are finding the first element that is satisfying the
                       // condition.
            }
        }

        // System.out.println(index_2);

        if (index == 0 && index_2 == 0) {
            reverse_iter(nums, 0);

            for (int i : nums) {
                list.add(i);
            }

            return list;
        }

        swap(nums, index, index_2);
        reverse_iter(nums, index + 1);

        for (int i : nums) {
            list.add(i);
        }

        return list;
    }

    public static void reverse_iter(int[] arr, int k) {

        for (int i = k; i < (arr.length + k) / 2; i++) {
            swap(arr, i, (arr.length + k) - i - 1);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
