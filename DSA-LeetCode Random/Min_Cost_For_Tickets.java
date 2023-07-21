//https://leetcode.com/problems/minimum-cost-for-tickets/description/

public class Min_Cost_For_Tickets {
    public static void main(String[] args) {
        int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
        int[] costs = { 2, 7, 15 };
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {

        // recursion method.
        // return solve(days, costs, 0);

        int[] dp = new int[days.length];
        return solve_2(days, costs, 0, dp);

    }

    // recursion method.
    public static int solve(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }

        // 1 day trip.
        int option1 = costs[0] + solve(days, costs, index + 1);

        // 7 days trip
        int i;
        for (i = index; i < days.length && (days[i] < days[index] + 7); i++) {
            ;
        }

        int option2 = costs[1] + solve(days, costs, i);

        // 30 days trip
        for (i = index; i < days.length && (days[i] < days[index] + 30); i++) {
            ;
        }

        int option3 = costs[2] + solve(days, costs, i);

        return Math.min(option1, Math.min(option2, option3));
    }

    // using DP.
    public static int solve_2(int[] days, int[] costs, int index, int[] dp) {
        if (index >= days.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        // 1 day trip.
        int option1 = costs[0] + solve_2(days, costs, index + 1, dp);

        // 7 days trip
        int i;
        for (i = index; i < days.length && (days[i] < days[index] + 7); i++) {
            ;
        }

        int option2 = costs[1] + solve_2(days, costs, i, dp);

        // 30 days trip
        for (i = index; i < days.length && (days[i] < days[index] + 30); i++) {
            ;
        }

        int option3 = costs[2] + solve_2(days, costs, i, dp);

        dp[index] = Math.min(option1, Math.min(option2, option3));

        return dp[index];
    }
}
