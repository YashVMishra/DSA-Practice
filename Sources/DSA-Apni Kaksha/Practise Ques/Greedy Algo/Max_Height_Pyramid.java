//https://www.geeksforgeeks.org/find-maximum-height-pyramid-from-the-given-array-of-objects/

import java.util.Arrays;

public class Max_Height_Pyramid {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 50, 60, 70 };
        System.out.println(max_height(arr));
    }

    public static int max_height(int[] arr) {
        Arrays.sort(arr);

        int prev_width = arr[0];
        int prev_count = 1;

        int ans = 1;

        int curr_width = 0;
        int curr_count = 0;

        for (int i = 1; i < arr.length; i++) {

            curr_width += arr[i];
            curr_count += 1;

            if (curr_count > prev_count && curr_width > prev_width) {
                prev_count = curr_count;
                prev_width = curr_width;

                curr_count = 0;
                curr_width = 0;

                ans++;
            }
        }

        return ans;
    }
}
