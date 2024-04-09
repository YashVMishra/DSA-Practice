// https://leetcode.com/problems/time-needed-to-buy-tickets/description/?envType=daily-question&envId=2024-04-09

public class Time_Needed_to_Buy_Tickets {
    public static void main(String[] args) {
        int[] tickets = { 2, 6, 3, 4, 5 };
        int k = 2;

        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;

        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i] -= 1;
                    totalTime += 1;

                    if (i == k && tickets[i] == 0) {
                        return totalTime;
                    }
                }
            }
        }
    }
}
