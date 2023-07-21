//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class Max_Points {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 1, 79, 80, 1, 1, 1, 200, 1 };
        System.out.println(maxScore(arr, k));
    }

    // in this we are finding the the subarray of size length-k with min sum
    // and subtracting it from the total sum of the array
    public static int maxScore(int[] cardPoints, int k) {
        int max_sum = 0;
        int len = cardPoints.length;

        // finding the total sum of the array
        for (int i = 0; i < cardPoints.length; i++) {
            max_sum += cardPoints[i];
        }

        // if k== length of the array
        // return the sum.
        if (k == len) {
            return max_sum;
        }

        // finding the subarray with min sum
        int reqd_sum = 0; // required sum of window k.
        int window_sum = 0; // for the sum of every window of size n-k.

        // creating window of n-k-1 as we will add the last element of the window
        // in the next loop and everytime calculate the reqd sum
        for (int i = 0; i < len - k - 1; i++) {
            window_sum += cardPoints[i];
        }

        for (int i = len - k - 1; i < len; i++) {
            window_sum += cardPoints[i];
            reqd_sum = Math.max(reqd_sum, max_sum - window_sum);
            window_sum -= cardPoints[i - (len - k - 1)];
        }

        return reqd_sum;
    }
}
