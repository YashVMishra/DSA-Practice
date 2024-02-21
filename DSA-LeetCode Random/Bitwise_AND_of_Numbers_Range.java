// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/?envType=daily-question&envId=2024-02-21

public class Bitwise_AND_of_Numbers_Range {
    public static void main(String[] args) {
        int left = 1;
        int right = 2147483647;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    // --------------------------------------------------------------------------------

    public static int rangeBitwiseAnd_2(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }

        return right;
    }
}
