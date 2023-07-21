//https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/

public class All_Equal_Min_Cost {
    public static void main(String[] args) {
        System.out.println(minCost(new int[] { 4, 6 }));
    }

    public static int minCost(int[] arr) {

        int assumedCost = 0;
        int len = arr.length;
        int min_Cost = 0;

        // if the length is even we just take the average of the middle elements.
        if (arr.length % 2 == 0) {
            assumedCost = (arr[len / 2] + arr[len / 2 - 1]) / 2;
        }

        // length is odd we just take the middle element.
        else {
            assumedCost = arr[len / 2];
        }

        // just calculating the cost now.
        for (int i = 0; i < len; i++) {
            min_Cost += Math.abs(arr[i] - assumedCost);
        }

        return min_Cost;
    }
}
