// https://practice.geeksforgeeks.org/problems/remove-spaces0128/1?page=2&company[]=SAP%20Labs&sortBy=submissions

public class Remove_Spaces {
    public static void main(String[] args) {
        String S = "geeks  for geeks";
        System.out.println(modify(S));
    }

    // dont know why this approach is showing TLE
    // even though TC is O(|S|).
    public static String modify(String S) {
        // your code here
        String ans = "";

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch != ' ') {
                ans = ans + ch;
            }
        }

        return ans;
    }

    // this code runs.
    public static String modify_2(String str) {
        // your code here
        str = str.replaceAll(" ", "");
        return str;
    }
}
