// https://leetcode.com/problems/power-of-four/description/?envType=daily-question&envId=2023-10-23

public class Power_of_Four {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(64));
        System.out.println(isPowerOfFour(256));
        System.out.println(isPowerOfFour(1024));
        System.out.println(isPowerOfFour(4096));
        System.out.println(isPowerOfFour(16384));
        System.out.println(isPowerOfFour(65536));
        System.out.println(isPowerOfFour(262144));
        System.out.println(isPowerOfFour(1048576));
        System.out.println(isPowerOfFour(4194304));
        System.out.println(isPowerOfFour(16777216));
        System.out.println(isPowerOfFour(67108864));
        System.out.println(isPowerOfFour(268435456));
        System.out.println(isPowerOfFour(1073741824));
        System.out.println(isPowerOfFour(2147483647));
    }

    // dont consider the negative values as
    // questions asks only for power of 4 and not for -4.
    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 4) {
            return false;
        }

        while (n > 4) {
            if (n % 4 != 0) {
                return false;
            }

            n = n / 4;
        }

        return n == 4;
    }

    // using recursion.
    public static boolean isPowerOfFour_2(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 4) {
            return false;
        }

        return n % 4 == 0 && isPowerOfFour(n / 4);
    }

    // using bit manipulation.
    public static boolean isPowerOfFour_3(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 4) {
            return false;
        }

        return (n & (n - 1)) == 0 && (n - 1 % 3 == 0);
    }

    // using pow function.
    public static boolean isPowerOfFour_4(int n) {
        if (n <= 0) {
            return false;
        }

        int a = (int) (Math.log(n) / Math.log(4));
        /*
         * 4^a = n
         * a = log(n) to base 4
         * a = log(n) to base e / log(4) to base e
         */

        return n == Math.pow(4, a);
    }
}
