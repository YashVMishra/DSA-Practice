//https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1

public class Remove_Consecutive_Character {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveCharacter("aaabbbbaaaabbba"));
    }

    public static String removeConsecutiveCharacter(String s) {
        String str = "";

        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) == s.charAt(i)) {
                // str=str+s.charAt(i);
                // i++;
            }

            else {
                str = str + s.charAt(i);
            }
        }

        if (str.charAt(str.length() - 1) != s.charAt(s.length() - 1)) {
            str = str + s.charAt(s.length() - 1);
        }

        return str;
    }
}
