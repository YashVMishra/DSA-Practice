// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/

public class Minimum_Penalty_for_a_Shop {
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));

    }

    public static int bestClosingTime(String customers) {
        int totalOpen = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                totalOpen++;
            }
        }

        int ans = Integer.MAX_VALUE;
        int currOpen = 0;
        int currClosed = 0;
        int hour = 0;

        for (int i = 0; i < customers.length(); i++) {
            int currPenalty = totalOpen - currOpen + currClosed;
            if (currPenalty < ans) {
                hour = i;
                ans = currPenalty;
            }

            currOpen += customers.charAt(i) == 'Y' ? 1 : 0;
            currClosed += customers.charAt(i) == 'N' ? 1 : 0;
        }

        int currPenalty = totalOpen - currOpen + currClosed;
        if (currPenalty < ans) {
            hour = customers.length();
            ans = currPenalty;
        }

        return hour;
    }
}
