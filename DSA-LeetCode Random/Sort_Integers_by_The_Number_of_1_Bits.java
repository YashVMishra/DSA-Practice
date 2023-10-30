// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/?envType=daily-question&envId=2023-10-30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort_Integers_by_The_Number_of_1_Bits {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] ans = sortByBits(arr);

        System.out.println(Arrays.toString(ans));
    }

    // brute force.
    public static int[] sortByBits(int[] arr) {
        Arrays.sort(arr);

        // make an array of list
        List<Integer>[] list = new ArrayList[32];

        // initialize the list, very important step
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // add the elements to the array.
        // by calculating the number of 1's in the binary representation
        for (int i = 0; i < arr.length; i++) {
            int index = count(arr[i]);
            list[index].add(arr[i]);
        }

        int[] ans = new int[arr.length];
        int index = 0;

        for (List<Integer> temp : list) {
            for (int i : temp) {
                ans[index++] = i;
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------------

    // using sort fucntion.
    public static int[] sortByBits_2(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        // defining our own comparator
        Arrays.sort(boxedArr, (a, b) -> {
            int countA = count(a);
            int countB = count(b);

            if (countA == countB) {
                return a.compareTo(b);
            }

            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }

        return arr;
    }

    // --------------------------------------------------------------------------------

    // using built-in function to calculate the number of 1's in the binary
    public static int[] sortByBits_3(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        // defining our own comparator
        Arrays.sort(boxedArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA == countB) {
                return a.compareTo(b);
            }

            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }

        return arr;
    }

    // --------------------------------------------------------------------------------

    // count the number of 1's in the binary representation
    private static int count(int num) {
        int count = 0;

        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }

        return count;
    }
}
