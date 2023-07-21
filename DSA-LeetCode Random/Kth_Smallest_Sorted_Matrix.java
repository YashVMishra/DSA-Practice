//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Kth_Smallest_Sorted_Matrix {
    public static void main(String[] args) {
        int[][] arr = { { -5 } };
        System.out.println(kthSmallest_2(arr, 1));
    }

    public static int kthSmallest(int[][] matrix, int k) {

        int length = matrix.length * matrix[0].length;

        int[] temp = new int[length];

        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[index] = matrix[i][j];
                index++;
            }
        }

        Arrays.sort(temp);

        return temp[k - 1];
    }

    // This approach also uses n^2 space complexity
    // even in worst case it will ise 2(n^2) complexity
    // while writing this code I thought it will have better space complexity
    // but on analysis it's even worse.
    // in this method we have first stored each unique element of the matrix
    // in the map with their count;
    // then we have added the keys of the map to the list and then sorted it.
    // then we have run the while loop till k becomes less than 0
    // each time we have decreased the value of k by the value of the key
    // given in the sorted order in the list.
    // all this done to achieve a better space complexity than n^2.
    public static int kthSmallest_2(int[][] matrix, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], 1);
                }

                else {
                    map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
                }
            }
        }

        // System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        // System.out.println(list);

        int ans = matrix[0][0];
        int index = 0;

        while ((k - 1) >= 0) {
            k = k - map.get(list.get(index));
            ans = list.get(index);
            index++;
        }

        return ans;
    }
}
