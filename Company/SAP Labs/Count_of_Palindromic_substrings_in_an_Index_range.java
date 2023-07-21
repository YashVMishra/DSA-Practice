//https://practice.geeksforgeeks.org/problems/count-of-palindromic-substrings-in-an-index-range3752/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// For the next two approach watch the video
// https://www.youtube.com/watch?v=pp8K5C2hMr4

public class Count_of_Palindromic_substrings_in_an_Index_range {
    public static void main(String[] args) {
        String S = "xyaabax";
        int q1 = 2;
        int q2 = 3;
        System.out.println(countPalinInRange(S.length(), S, q1, q2));
    }

    public static int countPalinInRange(int N, String S, int q1, int q2) {
        String str = S.substring(q1, q2 + 1);
        return (helper_3(str));
    }

    // brute force approach.
    public static int helper_1(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String temp = str.substring(i, j);

                if (isPalindrome(temp)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String temp) {
        int start = 0;
        int end = temp.length() - 1;

        while (start < end) {
            if (temp.charAt(start) != temp.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static int helper_2(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int count = 0;
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        // Base case 1 : Length = 1 -> true
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Base case 2 : Length - 2 -> char[i] == char[i+1].
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = str.charAt(i) == str.charAt(i + 1);

            if (dp[i][i + 1]) {
                count++;
            }
        }

        // Length - 3 -> char[i] == char[i+1] && dp[i+1][j-1] is true.
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; j++, i++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int helper_3(String str) {
        if (str.length() == 0) {
            return 0;
        }

        char[] temp = str.toCharArray();
        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            // Cheack for odd and even lengths
            // Center of odd -> (i,i)
            // Center of even -> (i.i+1).

            count += isPalin(i, i, temp);
            count += isPalin(i, i + 1, temp);
        }

        return count;
    }

    public static int isPalin(int start, int end, char[] temp) {
        int count = 0;

        while (start >= 0 && end < temp.length && temp[start--] == temp[end++]) {
            count++;
        }

        return count;
    }
}
