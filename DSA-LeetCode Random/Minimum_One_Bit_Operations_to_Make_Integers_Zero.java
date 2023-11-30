// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/?envType=daily-question&envId=2023-11-30

public class Minimum_One_Bit_Operations_to_Make_Integers_Zero {
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
    }

    public static int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        long[] function = new long[32];

        // function[i] = x
        // Means it will take x operations to make the ith bit 1
        function[0] = 1;
        for (int i = 1; i <= 31; i++) {
            function[i] = 2 * function[i - 1] + 1;
        }

        int result = 0;
        int sign = 1;

        for (int i = 30; i >= 0; i--) {
            int ithBit = ((1 << i) & n);

            if (ithBit == 0) {
                continue;
            }

            if (sign > 0) {
                result += function[i];
            } else {
                result -= function[i];
            }

            sign *= -1;
        }

        return result;
    }
}
