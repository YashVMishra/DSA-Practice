//https://leetcode.com/problems/palindrome-partitioning/description/

import java.util.List;
import java.util.ArrayList;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        compute(s, list, temp, 0);
        return list;
    }

    public static void compute(String str, List<List<String>> list, List<String> temp, int index) {
        if (index == str.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                temp.add(str.substring(index, i + 1));
                compute(str, list, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {

        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

}
