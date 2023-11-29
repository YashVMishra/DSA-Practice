// https://leetcode.com/problems/number-of-1-bits/description/?envType=daily-question&envId=2023-11-29

public class Number_of_1_Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(-3));
    }

    // using the fact that to find the rightmost set bit
    // we use the formuala n & (n - 1)
    // just run the loop until the number becomes 0
    // and keep on incrementing the count while calculating
    // the rightmost set bit
    public static int hammingWeight(int num) {
        int count = 0;

        while (num != 0) {
            num = num & (num - 1);
            count++;
        }

        return count;

    }

    // ---------------------------------------------------------------------------

    public static int hammingWeight_2(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    // --------------------------------------------------------------------------

    // using the fact that if we want the ith bit of a number,
    // we can do n >> i & 1
    // right shifting the number i times and doing an AND with 1
    public static int hammingWeight_3(int n) {
        int count = 0;

        for (int i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }

        return count;
    }

    // --------------------------------------------------------------------------

    // using the built in function
    public static int hammingWeight_4(int n) {
        return Integer.bitCount(n);
    }
}
