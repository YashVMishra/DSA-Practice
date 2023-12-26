// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2023-12-22

public class Maximum_Score_After_Splitting_a_String {
    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

    public static int maxScore(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int zerosLeft = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    zerosLeft++;
                }
            }

            int onesRight = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '1') {
                    onesRight++;
                }
            }

            result = Math.max(result, zerosLeft + onesRight);
        }

        return result;
    }
}
