// https://leetcode.com/problems/jewels-and-stones/description/

import java.util.HashSet;

public class Jewels_and_Stones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
