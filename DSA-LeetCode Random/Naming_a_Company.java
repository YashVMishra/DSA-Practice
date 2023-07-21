//https://leetcode.com/problems/naming-a-company/description/

import java.util.Set;
import java.util.HashSet;

public class Naming_a_Company {
    public static void main(String[] args) {
        String[] arr = { "coffee", "donuts", "time", "toffee" };
        System.out.println(distinctNames(arr));
        System.out.println(distinctNames_2(arr));
    }

    // brute force approach.
    public static long distinctNames(String[] ideas) {

        long ans = 0;
        Set<String> set = new HashSet<>();

        for (String i : ideas) {
            set.add(i);
        }

        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String str_1 = ideas[i].charAt(0) + ideas[j].substring(1);
                String str_2 = ideas[j].charAt(0) + ideas[i].substring(1);

                if (!(set.contains(str_1) || set.contains(str_2))) {
                    ans++;
                    ans++;
                }
            }
        }

        return ans;
    }

    // simplified approach
    public static long distinctNames_2(String[] ideas) {

        long ans = 0;
        Set<String> set = new HashSet<>();

        for (String i : ideas) {
            set.add(i);
        }

        // array to store th frequ of each pair.
        int[][] freq = new int[26][26];
        for (int i = 0; i < ideas.length; i++) {
            int first_char = ideas[i].charAt(0) - 'a';

            // checking every char with the substirn.
            for (char j = 'a'; j <= 'z'; j++) {
                if (!(set.contains(j + ideas[i].substring(1)))) {
                    freq[first_char][j - 'a']++;
                }
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                ans += (long) freq[i - 'a'][j - 'a'] * (long) freq[j - 'a'][i - 'a'];
            }
        }

        return ans;
    }
}
