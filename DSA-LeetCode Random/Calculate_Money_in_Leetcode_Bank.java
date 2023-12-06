// https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/?envType=daily-question&envId=2023-12-06

public class Calculate_Money_in_Leetcode_Bank {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(totalMoney(n));
    }

    public static int totalMoney(int n) {
        int totalWeeks = n / 7;
        int remainingDays = n % 7;
        int ans = 0;

        int weeklyAddOn = 28;
        while (totalWeeks > 0) {
            ans += weeklyAddOn;
            weeklyAddOn += 7;
            totalWeeks--;
        }

        // basically dayAddOn is quotient + 1
        // but in the above loop quotient becomes 0
        // so we have written n / 7 + 1
        int dayAddOn = n / 7 + 1;
        while (remainingDays > 0) {
            ans += dayAddOn;
            dayAddOn++;
            remainingDays--;
        }

        return ans;
    }
}
