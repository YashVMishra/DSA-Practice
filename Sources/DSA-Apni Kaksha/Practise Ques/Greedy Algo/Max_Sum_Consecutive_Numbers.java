//https://practice.geeksforgeeks.org/problems/swap-and-maximize5859/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Max_Sum_Consecutive_Numbers {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 9));
    }

    // using extra space
    public static int maxSum(int arr[], int n) {

        // returning the sun as the answer;
        int sum = 0;

        // using extra array to store the array like we want
        int[] temp = new int[n];

        // sorting the elements as our logic depends on it.
        Arrays.sort(arr);

        int last_index = arr.length - 1;
        int first_index = 0;
        for (int i = 0; i < temp.length - 1; i = i + 2) {
            temp[i] = arr[first_index];
            first_index++;
            temp[i + 1] = arr[last_index];
            last_index--;
        }

        if (n % 2 != 0) {
            temp[n - 1] = arr[n / 2];
        }

        System.out.println(Arrays.toString(temp));

        for (int i = 0; i < temp.length - 1; i++) {
            sum += Math.abs(temp[i] - temp[i + 1]);
        }

        // since its a circular array we need to calculate diff of first and last
        // element
        sum = sum + Math.abs(temp[temp.length - 1] - temp[0]);

        return sum;
    }

    // withoit using extra space
    public static int maxSum_2(int[] arr, int n) {
        int sum = 0;

        // Sorting the array.
        Arrays.sort(arr);

        // Subtracting a1, a2, a3,....., a(n/2)-1,
        // an/2 twice and adding a(n/2)+1, a(n/2)+2,
        // a(n/2)+3,....., an - 1, an twice.
        for (int i = 0; i < n / 2; i++) {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }

        return sum;
    }
}
