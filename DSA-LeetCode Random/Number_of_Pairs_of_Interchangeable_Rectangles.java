// https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

import java.util.HashMap;

public class Number_of_Pairs_of_Interchangeable_Rectangles {
    public static void main(String[] args) {
        System.out.println(interchangeableRectangles(new int[][] { { 4, 8 }, { 3, 6 }, { 10, 20 }, { 15, 30 } }));
    }

    // very simple
    // just calculate the ratio of width and height of each rectangle
    // and store it in a hashmap
    // if the ratio is already present in the hashmap then add the count
    // to the answer and increment the count of that ratio in the map
    public static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long count = 0;

        for (int[] arr : rectangles) {
            double key = (double) (arr[0]) / (double) (arr[1]);
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}
