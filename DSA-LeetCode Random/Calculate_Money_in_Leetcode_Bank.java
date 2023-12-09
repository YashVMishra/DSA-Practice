// https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/?envType=daily-question&envId=2023-12-06

public class Calculate_Money_in_Leetcode_Bank {
    public static void main(String[] args) {
        int n = 20;
        System.out.println(totalMoney_2(n));
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

    public static int totalMoney_2(int n) {
        int items = n / 7;
        int first = 28;
        int last = 28 + (items - 1) * 7;

        int arithmeticSum = items * (first + last) / 2;

        // Final week remaining days
        int mondayMoney = 1 + items;
        int finalWeek = 0;

        for (int day = 1; day <= (n % 7); day++) {
            finalWeek += mondayMoney++;
        }

        return arithmeticSum + finalWeek;
    }
}
