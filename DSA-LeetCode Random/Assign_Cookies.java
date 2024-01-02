// https://leetcode.com/problems/assign-cookies/description/?envType=daily-question&envId=2024-01-01

import java.util.Arrays;

public class Assign_Cookies {
    public static void main(String[] args) {
        int[] g = { 10, 9, 8, 7 };
        int[] s = { 5, 6, 7, 8 };
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] child, int[] cookie) {
        int childPointer = 0, cookiePointer = 0;
        int ans = 0;
        Arrays.sort(child);
        Arrays.sort(cookie);

        while (childPointer < child.length && cookiePointer < cookie.length) {
            if (child[childPointer] <= cookie[cookiePointer]) {
                ans++;
                childPointer++;
                cookiePointer++;
            } else {
                cookiePointer++;
            }
        }

        return ans;
    }
}
