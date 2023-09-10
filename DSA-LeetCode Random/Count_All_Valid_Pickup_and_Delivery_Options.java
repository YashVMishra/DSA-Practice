// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/?envType=daily-question&envId=2023-09-10

public class Count_All_Valid_Pickup_and_Delivery_Options {
    public static void main(String[] args) {
        System.out.println(countOrders(3));
    }

    public static int countOrders(int n) {
        int mod = 1000000007;
        long ans = 1;

        for (int i = 2; i <= n; i++) {
            ans = (ans * (2 * i - 1) * i) % mod;
        }

        return (int) (ans % mod);
    }
}
