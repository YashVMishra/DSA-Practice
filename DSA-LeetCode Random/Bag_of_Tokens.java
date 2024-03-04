// https://leetcode.com/problems/bag-of-tokens/description/?envType=daily-question&envId=2024-03-04

import java.util.Arrays;

public class Bag_of_Tokens {
    public static void main(String[] args) {
        int[] tokens = { 100, 200, 300, 400 };
        int power = 200;
        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        int currScore = 0;
        int maxScore = 0;
        int i = 0;
        int j = tokens.length - 1;
        Arrays.sort(tokens);

        while (i <= j) {

            // doing the token face-up
            // thiinking greedily that is
            // for increasing score we are using the power
            // of lower value.
            if (power >= tokens[i]) {
                power -= tokens[i];
                currScore++;
                i++;
                maxScore = Math.max(maxScore, currScore);
            }

            // doing the token face-down
            // thinking greedily that is
            // for increasing power we are using the power
            // of higher value.
            else if (currScore > 0) {
                power += tokens[j];
                currScore--;
                j--;
            }

            // if we cannot do any of the above operations
            // then we have to break as we have found the max score.
            else {
                break;
            }
        }

        return maxScore;
    }
}
