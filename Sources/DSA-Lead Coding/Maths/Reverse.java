//https://leetcode.com/problems/reverse-integer/description/

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }

        long temp = x;
        long rev_num = 0;

        if (temp < 0) {
            temp *= -1;
        }

        while (temp > 0) {
            rev_num = (rev_num * 10) + temp % 10;
            temp /= 10;
        }

        if (rev_num > Integer.MAX_VALUE) {
            return 0;
        }

        if (rev_num > Integer.MAX_VALUE) {
            return 0;
        }

        if (x < 0) {
            return (int) (-1 * rev_num);
        }

        return (int) (rev_num);
    }
}