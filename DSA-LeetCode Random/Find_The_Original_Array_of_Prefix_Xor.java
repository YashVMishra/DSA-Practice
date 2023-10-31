// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/?envType=daily-question&envId=2023-10-31

import java.util.Arrays;

public class Find_The_Original_Array_of_Prefix_Xor {
    public static void main(String[] args) {
        int[] pref = { 5, 2, 0, 3, 1 };

        int[] ans = findArray(pref);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }

        return ans;
    }
}
