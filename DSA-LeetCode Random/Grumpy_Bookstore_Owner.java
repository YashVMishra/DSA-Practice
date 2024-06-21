// https://leetcode.com/problems/grumpy-bookstore-owner/description/

public class Grumpy_Bookstore_Owner {
    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsat = 0;

        // Calculate initial unsatisfied customers in the first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unsat += customers[i] * grumpy[i];
        }

        int maxUnsat = unsat;

        // Use two pointers i and j to define the sliding window of size 'minutes'
        int i = 0;
        int j = minutes;

        while (j < n) {
            unsat += customers[j] * grumpy[j]; // Include current element
            unsat -= customers[i] * grumpy[i]; // Remove element going out of window

            maxUnsat = Math.max(maxUnsat, unsat); // Update maxUnsat
            i++;
            j++;
        }

        int totalCustomers = maxUnsat;

        // Calculate total satisfied customers
        for (int k = 0; k < n; k++) {
            totalCustomers += customers[k] * (1 - grumpy[k]);
        }

        return totalCustomers;
    }
}
