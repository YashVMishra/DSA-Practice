//https://leetcode.com/problems/richest-customer-wealth/

public class Richest_Customer_Wealth {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
    }

    public static int maximumWealth(int[][] accounts) {
        int max_sum = 0;

        for (int i = 0; i < accounts.length; i++) {
            int check_sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                check_sum += accounts[i][j];
            }

            max_sum = Math.max(max_sum, check_sum);
        }

        return max_sum;
    }
}
