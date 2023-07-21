//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public static void main(String[] args) {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        int len = cardPoints.length;

        // finding the total sum of the array
        for (int i : cardPoints) {
            totalSum += i;
        }

        // if k == length of the array
        // return the sum.
        if (k == len) {
            return totalSum;
        }

        // finding the subarray with min sum
        int ans = 0; // required sum of window k.
        int windowSum = 0; // for the sum of every window of size n-k.

        // creating window of n-k-1 as we will add the last element of the window
        // in the next loop and everytime calculate the window sum.
        for (int i = 0; i < len - k - 1; i++) {
            windowSum += cardPoints[i];
        }

        for (int i = len - k - 1; i < len; i++) {
            windowSum += cardPoints[i];
            ans = Math.max(ans, totalSum - windowSum);
            windowSum -= cardPoints[i - (len - k - 1)];
        }

        return ans;
    }
}
