//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// At first this may seems to be a DP problem but it can be done in much easier way (DP soln can also work).
// see the video 
// https://www.youtube.com/watch?v=XcJyzicbGn8

public class Stock_buy_and_sell_2 {
    public static void main(String[] args) {
        int price[] = { 3, 4, 1, 5 };
        System.out.println(stockBuyAndSell(price.length, price));
    }

    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int prev = prices[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            int current = prices[i];

            if (prev < current) {
                profit += current - prev;
                prev = current;
            } else {
                prev = current;
            }
        }

        return profit;
    }
}
