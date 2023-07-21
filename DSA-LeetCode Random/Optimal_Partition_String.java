//https://leetcode.com/problems/optimal-partition-of-string/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Optimal_Partition_String {
    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
        System.out.println(partitionString_2(s));
    }

    public static int partitionString(String s) {

        // array to keep the count of each letter in the gievn substring.
        int[] count = new int[26];

        // initialize to 1 as their will be one substring for sure
        // if 's' as a whole is non-repeating.
        int ans = 1;

        for (int i = 0; i < s.length(); i++) {

            // if you found the repeating character increment the ans by 1
            // and fill the array with 0.s
            if (count[s.charAt(i) - 'a'] != 0) {
                ans++;
                Arrays.fill(count, 0);
            }

            count[s.charAt(i) - 'a']++;
        }

        return ans;
    }

    // both the method are same just difference is the use of array
    // in one method and HashSet in the other one.
    public static int partitionString_2(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 1;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                ans++;
                set.clear();
            }

            set.add(s.charAt(i));
        }

        return ans;
    }
}
