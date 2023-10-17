//https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/

public class Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = 7;
        System.out.println(minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        // you can also write this
        // while( a != 0 || b != 0 || c != 0)
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                flips += bitA + bitB;
            }

            else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            a >>= 1; // a = a >> 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}
