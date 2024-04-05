// https://leetcode.com/problems/decode-xored-array/description/

import java.util.Arrays;

public class Decode_XORed_Array {
    public static void main(String[] args) {
        int[] encoded = { 6, 2, 7, 3 };
        int first = 4;

        System.out.println(Arrays.toString(decode(encoded, first)));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;

        for (int i = 1; i < ans.length; i++) {
            ans[i] = encoded[i - 1] ^ first;
            first = ans[i];
        }

        return ans;
    }
}
