//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/

public class Maximize_the_Confusion_of_an_Exam {
    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers(answerKey, k));
        System.out.println(maxConsecutiveAnswers_2(answerKey, k));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0, right = 0, count = 0;

        // checking the max length of T.
        for (right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'F') {
                count++;
            }

            while (count > k) {
                if (answerKey.charAt(left) == 'F') {
                    count--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        count = 0;
        left = 0;

        // checking the max length of F.
        for (right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                count++;
            }

            while (count > k) {
                if (answerKey.charAt(left) == 'T') {
                    count--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // doing it in a single pass.
    public static int maxConsecutiveAnswers_2(String answerKey, int k) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0, right = 0, tCount = 0, fCount = 0;

        for (right = 0; right < answerKey.length(); right++) {
            char ch = answerKey.charAt(right);

            if (ch == 'T') {
                tCount++;
            } else {
                fCount++;
            }

            while (Math.min(tCount, fCount) > k) {
                char temp = answerKey.charAt(left);

                if (temp == 'T') {
                    tCount--;
                } else {
                    fCount--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
