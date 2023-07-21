//https://practice.geeksforgeeks.org/problems/smallest-number5829/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class Smallest_Number {
    public static void main(String[] args) {
        System.out.println(smallestNumber(20, 3));
    }

    public static String smallestNumber(int S, int D) {
        // code here
        if (S == 0) {
            return D == 1 ? "0" : "-1";
        }

        if (9 * D < S) {
            return "-1";
        }

        int[] ans = new int[D];

        S = S - 1;
        for (int i = D - 1; i > 0; i--) {
            // If sum is still greater than 9,
            // digit must be 9
            if (S > 9) {
                ans[i] = 9;
                S -= 9;
            } else {
                ans[i] = S;
                S = 0;
            }
        }

        ans[0] = S + 1;

        int result = 0;

        for (int i = 0; i < ans.length; i++) {
            result = (result * 10) + ans[i];
        }

        return Integer.toString(result);
    }
}
