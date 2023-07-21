//https://leetcode.com/problems/power-of-two/description/

public class Power_of_Two {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }

            n /= 2;
        }

        if (n == 1) {
            return true;
        }

        return false;
    }
}