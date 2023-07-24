// https://leetcode.com/problems/powx-n/description/

public class Pow_x_n {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double ans = 1;
        boolean isNegative = n < 0 ? true : false;
        long nn = n;

        // we have taken n as long as on taking its absolute value it will convert
        // the number to positive and if the value of n is Integer.MIN_VALUE that is
        // -2147483648 and on making it positive it will make as 2147483648 but the
        // highest value of int is 2147483647, so thats why we have taken nn as long.
        nn = Math.abs(nn);

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }

        if (isNegative) {
            return 1.0 / ans;
        }

        return ans;
    }
}
