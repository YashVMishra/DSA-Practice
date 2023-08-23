// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

public class Fractional_Knapsack {
    public static void main(String[] args) {
        int W = 50;
        Item arr[] = { new Item(60, 10), new Item(100, 20) };
        System.out.println(fractionalKnapsack(W, arr, arr.length));
    }

    public static double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        double profit = 0;

        // we cannot write Arrays.sort(arr, (a, b) -> ((b.value / b.weight) - (a.value /
        // a.weight)));
        // as all the computations are done in int datatype and that can cause the
        // values
        // after decimal to be truncated.
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item ob1, Item ob2) {
                double r1 = (double) ob1.value / (double) ob1.weight;
                double r2 = (double) ob2.value / (double) ob2.weight;

                return Double.compare(r2, r1);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight <= W) {
                profit += arr[i].value;
                W -= arr[i].weight;
            } else {
                profit += ((double) (arr[i].value) / (double) (arr[i].weight)) * W;
                break;
            }
        }

        return profit;
    }
}
