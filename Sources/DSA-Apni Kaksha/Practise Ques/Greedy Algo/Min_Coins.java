//https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;
import java.util.List;

public class Min_Coins {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        System.out.println(min_coins(coins, 43));
    }

    public static List<Integer> min_coins(int[] coins, int value) {
        int temp_value = value;

        // creating a list to store the answers.
        List<Integer> list = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            int count = 0;
            if (temp_value >= coins[i]) {
                count = temp_value / coins[i];
                temp_value = temp_value % coins[i];

                while (count > 0) {
                    list.add(coins[i]);
                    count--;
                }
            }

        }

        return list;
    }
}
