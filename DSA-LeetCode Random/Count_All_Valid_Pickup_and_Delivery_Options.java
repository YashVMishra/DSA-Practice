// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/?envType=daily-question&envId=2023-09-10

public class Count_All_Valid_Pickup_and_Delivery_Options {
    public static void main(String[] args) {
        System.out.println(countOrders(3));
    }

    public static int countOrders(int n) {
        int M = 1000000007;
        if (n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            int spaces = (i - 1) * 2 + 1;
            int possibility = spaces * (spaces + 1) / 2;
            result *= possibility;
            result %= M;
        }

        return (int) result;
    }
}
