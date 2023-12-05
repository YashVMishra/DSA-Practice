// https://leetcode.com/problems/count-of-matches-in-tournament/description/?envType=daily-question&envId=2023-12-05

public class Count_of_Matches_in_Tournament {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfMatches(n));
    }

    public static int numberOfMatches(int n) {
        int matches = 0;

        while (n > 1) {
            if (n % 2 == 0) {
                matches += n / 2;
                n /= 2;
            } else {
                matches += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }

        return matches;
    }
}