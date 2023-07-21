import java.util.Arrays;

//https://leetcode.com/problems/counting-bits/description/

public class Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = no_of_set_bits(i);
        }

        return ans;
    }

    public static int no_of_set_bits(int num) {

        String str = Integer.toBinaryString(num);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
