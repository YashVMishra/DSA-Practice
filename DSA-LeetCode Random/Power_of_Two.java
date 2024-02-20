// https://leetcode.com/problems/power-of-two/description/?envType=daily-question&envId=2024-02-19

public class Power_of_Two {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(-16));
        System.out.println(isPowerOfTwo(-218));
        System.out.println(isPowerOfTwo_2(1));
        System.out.println(isPowerOfTwo_2(16));
        System.out.println(isPowerOfTwo_2(218));
        System.out.println(isPowerOfTwo_2(0));
        System.out.println(isPowerOfTwo_2(-16));
        System.out.println(isPowerOfTwo_2(-218));
    }

    // using loop.
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }

        return n == 1;
    }

    // --------------------------------------------------------------------------------

    // using bit manipulation.
    public static boolean isPowerOfTwo_2(int n) {
        if (n <= 0) {
            return false;
        }

        // see DSA copy.
        return (n & (n - 1)) == 0;
    }
}
