//https://leetcode.com/problems/power-of-three/description/

public class Power_of_Three {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(729));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0 || n < 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int temp = n;

        // running the loop till temp its either 3 or a lower number.
        while (temp > 3) {
            if (temp % 3 == 0) {
                temp /= 3;
            }

            else {
                return false;
            }
        }

        // if temp == 3 or temp == 1 then only the number is divisible by 3 as
        // 3^1=3 and 3^0=1.
        if (temp == 3 || temp == 1) {
            return true;
        }

        return false;
    }
}
