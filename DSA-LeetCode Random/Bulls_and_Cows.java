//https://leetcode.com/problems/bulls-and-cows/description/?envType=study-plan&id=level-1

public class Bulls_and_Cows {
    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }

            else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        // we are just taking the overlapping values.
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
