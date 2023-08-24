// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

// https://takeuforward.org/data-structure/find-minimum-number-of-coins/

import java.util.Arrays;

public class Minimum_Coins {
    public static void main(String[] args) {
        int coins[] = { 25, 10, 5 };
        int value = 30;

        System.out.println(minCoins(coins, value));
    }

    public static int minCoins(int[] coins, int value) {
        if (value == 0) {
            return 0;
        }

        int count = 0;

        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= value) {
                count += value / coins[i];
                value = value % coins[i];
            }
        }

        return value == 0 ? count : -1;
    }
}
