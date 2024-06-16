// https://leetcode.com/problems/relative-sort-array/?envType=daily-question&envId=2024-06-11

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relative_Sort_Array {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to count the occurrences of each number in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Create a list to store the result
        List<Integer> result = new ArrayList<>();

        // Add elements of arr2 to the result list in the order and number of times they
        // appear in arr1
        for (int num : arr2) {
            if (countMap.containsKey(num)) {
                for (int i = 0; i < countMap.get(num); i++) {
                    result.add(num);
                }
                // Remove the element from the map after adding to result list
                countMap.remove(num);
            }
        }

        // Add the remaining elements from arr1 (those not in arr2) in ascending order
        List<Integer> remaining = new ArrayList<>();
        for (int num : countMap.keySet()) {
            for (int i = 0; i < countMap.get(num); i++) {
                remaining.add(num);
            }
        }

        Collections.sort(remaining);
        result.addAll(remaining);

        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
