//https://leetcode.com/problems/longest-common-prefix/

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        // String str = "Flower";

        // System.out.println(str.indexOf("wo"));

        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
