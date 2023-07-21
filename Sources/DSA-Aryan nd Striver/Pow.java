public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        System.out.println(myPow(x, n));
        System.out.println(myPow_2(x, n));
    }

    // shows TLE.
    public static double myPow(double x, int n) {
        double ans = 1;
        boolean isNegative = n < 0 ? true : false;
        long nn = n;

        // making nn as long as last value of int is -2147483648 and converting it to
        // positive will make it as 2147483648 but the largest value of int is
        // 2147483647, so n overflows thats why we will use long.
        nn = Math.abs(nn);

        for (long i = 1; i <= nn; i++) {
            ans *= x;
        }

        if (isNegative) {
            return 1.0 / ans;
        }

        return ans;
    }

    // uses binary exponentiation.
    public static double myPow_2(double x, int n) {
        double ans = 1;
        boolean isNegative = n < 0 ? true : false;
        long nn = n;

        // making nn as long as last value of int is -2147483648 and converting it to
        // positive will make it as 2147483648 but the largest value of int is
        // 2147483647, so n overflows thats why we will use long.
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
