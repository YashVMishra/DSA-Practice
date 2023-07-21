/*
Problem statement: Given an array, we have found the number of occurrences of each element in 
the array.

Examples:

Example 1:
Input: arr[] = {10,5,10,15,10,5};
Output: 10  3
	    5  2
        15  1
Explanation:  10 occurs 3 times in the array
	          5 occurs 2 times in the array
              15 occurs 1 time in the array

Example2: 
Input: arr[] = {2,2,3,4,4,2};
Output: 2  3
	    3  1
        4  2
Explanation: 2 occurs 3 times in the array
	         3 occurs 1 time in the array
             4 occurs 2 time in the array 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frequency_Each_Element {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3, 2, 1 };
        frequency(arr);
        System.out.println();
        frequency_2(arr);
    }

    // uses O(n^2) TC and O(n) SC at max.
    public static void frequency(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i)) {
                continue;
            }

            set.add(i);

            int count = 0;

            for (int j : arr) {
                if (i == j) {
                    count++;
                }
            }

            System.out.println("Count of " + i + " is " + count);
        }
    }

    // uses O(2n) SC at max but O(n) TC.
    public static void frequency_2(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        // to stop the printing of same elements more than once.
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i)) {
                continue;
            }

            set.add(i);
        }

        for (int i : arr) {

            // containsKey uses O(1) TC.
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            else {
                map.put(i, 1);
            }
        }

        for (int i : set) {
            System.out.println("Count of " + i + " is " + map.get(i));
        }
    }
}
