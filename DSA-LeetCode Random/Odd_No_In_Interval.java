//https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

public class Odd_No_In_Interval {
    public static void main(String[] args) {
        System.out.println(countOdds(2, 18));
    }

    public static int countOdds(int low, int high) {

        int count = 0;

        int temp = low % 2 == 0 ? low + 1 : low;

        for (int i = temp; i <= high; i += 2) {
            count++;
        }

        return count;
    }

    // much better method.
    public static int countOdds_2(int low, int high) {

        int ans = (high - low) / 2;

        // checking if any no is odd or not.
        if (low % 2 != 0 || high % 2 != 0) {
            return ans + 1;
        }

        return ans;
    }
}
