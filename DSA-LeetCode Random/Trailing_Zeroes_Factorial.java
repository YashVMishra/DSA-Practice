//https://leetcode.com/problems/factorial-trailing-zeroes/description/

public class Trailing_Zeroes_Factorial {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }

    public static int trailingZeroes(int n) {
        int temp = 5;
        int count = 0;

        while (temp <= n) {
            count += n / temp;
            temp *= 5;
        }

        return count;

    }
}
