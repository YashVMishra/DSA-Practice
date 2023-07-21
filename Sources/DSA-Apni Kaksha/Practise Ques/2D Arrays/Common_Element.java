//https://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/

import java.util.Arrays;

public class Common_Element {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5 },
                { 1, 3, 7, 8, 10 },
                { 2, 3, 7, 9, 11 },
                { 1, 2, 3, 7, 9 },
        };
        System.out.println(helper_1(arr));
    }

    public static int helper_1(int[][] arr) {
        int ans = -1;
        int[] arr_2 = arr[0];
        int count = 0;
        // int element=arr_2[0];

        for (int i = 0; i < arr_2.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int index = Arrays.binarySearch(arr[j], arr_2[i]);
                if (index >= 0) {
                    // System.out.println(count);
                    count++;
                    // ans = arr_2[i];
                }

                else {
                    // System.out.println("break");
                    break;
                }
            }

            if (count == arr.length - 1) {
                ans = arr_2[i];
                break;
            }
            count = 0;
        }

        return ans;
    }
}
