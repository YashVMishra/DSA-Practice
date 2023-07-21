//https://leetcode.com/problems/first-unique-character-in-a-string/description/

public class First_Unique_Character {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] temp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
