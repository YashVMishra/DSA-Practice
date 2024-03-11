// https://leetcode.com/problems/custom-sort-string/description/?envType=daily-question&envId=2024-03-11

public class Custom_Sort_String {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freq[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (freq[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
