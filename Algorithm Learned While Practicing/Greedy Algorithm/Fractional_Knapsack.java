import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        Item[] arr = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;

        System.out.println(fractionalKnapsack(capacity, arr, arr.length));

    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1,
                    Item item2) {
                double cpr1 = (double) item1.value
                        / (double) item1.weight;
                double cpr2 = (double) item2.value
                        / (double) item2.weight;

                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

        double profit = 0;
        Item curr_item;
        for (int i = 0; i < n; i++) {
            curr_item = arr[i];
            if (curr_item.weight <= W) {
                W -= curr_item.weight;
                profit += (double) curr_item.value;
            }

            else {
                profit = profit + ((double) (W) / (double) (curr_item.weight)) * (double) (curr_item.value);
                break;
            }
        }

        return profit;
    }
}
