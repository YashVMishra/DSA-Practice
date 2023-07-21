//https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://leetcode.com/problems/majority-element/

import java.util.Arrays;

public class Majority_Element {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 3, 1, 3, 3, 2, 2, 2, 2, 2, 2 }));
    }

    public static int majorityElement(int[] arr) {

        Arrays.sort(arr);
        int majority = -1;

        if (arr.length == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int max_length = 0;

        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
                max_length++;
            }

            else {
                // System.out.println(max_length);
                if (max_length > arr.length / 2) {
                    majority = arr[i];
                }
                i = j;
                max_length = 0;
            }
        }

        if (max_length > arr.length / 2) {
            majority = arr[i];
        }

        return majority;
    }
}
