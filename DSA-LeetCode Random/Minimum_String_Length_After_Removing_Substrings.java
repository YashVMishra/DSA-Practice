//https://leetcode.com/problems/minimum-string-length-after-removing-substrings/

public class Minimum_String_Length_After_Removing_Substrings {
    public static void main(String[] args) {
        String s = "ACBBD";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        StringBuilder str = new StringBuilder(s);

        while (str.indexOf("AB") != -1 || str.indexOf("CD") != -1) {

            // removing the substring AB.
            if (str.indexOf("AB") != -1) {
                int index = str.indexOf("AB");
                str = str.delete(index, index + 2);
            }

            // removing the substring CD.
            if (str.indexOf("CD") != -1) {
                int index = str.indexOf("CD");
                str = str.delete(index, index + 2);
            }
        }

        return str.length();
    }
}
