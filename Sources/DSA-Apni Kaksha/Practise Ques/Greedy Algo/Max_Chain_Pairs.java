//https://practice.geeksforgeeks.org/problems/max-length-chain/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;
import java.util.Comparator;

public class Max_Chain_Pairs {
    public static void main(String[] args) {
        Pair arr[] = { new Pair(1, 10), new Pair(2, 3), new Pair(4, 5), new Pair(6, 7), new Pair(8, 9) };
        System.out.println(maxChainLength(arr, arr.length));
    }

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public static int maxChainLength(Pair arr[], int n) {
        // your code here
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair ob1, Pair ob2) {
                if (ob1.y < ob2.y) {
                    return -1;
                }

                else {
                    return 1;
                }
            }
        });

        int max_length = 1;
        Pair prev_pair = arr[0];
        for (int i = 1; i < n; i++) {
            Pair curr_pair = arr[i];
            if (prev_pair.y < curr_pair.x) {
                max_length++;
                prev_pair = curr_pair;
            }
        }

        return max_length;
    }
}
