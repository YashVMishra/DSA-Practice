/*
Problem Statement: Given an array, find the second smallest and second largest element in the array.
Print ‘-1’ in the event that either of them doesn’t exist.

Examples:

Example 1:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
	Second Largest : 5
Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and 
second smallest is 2

Example 2:
Input: [1]
Output: Second Smallest : -1
	Second Largest : -1
Explanation: Since there is only one element in the array, it is the largest and smallest 
element present in the array. There is no second largest or second smallest element present. 
*/

public class Second_Smallest_Greatest {
    public static void main(String[] args) {
        int[] arr_1 = { 1, 2, 3, 6, 8 };
        System.out.println(largest(arr_1));
        System.out.println(smallest(arr_1));
    }

    public static int largest(int[] nums) {
        int first_largest = Integer.MIN_VALUE;

        for (int i : nums) {
            first_largest = Math.max(i, first_largest);
        }

        int second_largest = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i != first_largest) {
                second_largest = Math.max(i, second_largest);
            }
        }

        return second_largest;
    }

    public static int smallest(int[] nums) {
        int first_smallest = Integer.MAX_VALUE;

        for (int i : nums) {
            first_smallest = Math.min(i, first_smallest);
        }

        int second_smallest = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i != first_smallest) {
                second_smallest = Math.min(i, second_smallest);
            }
        }

        return second_smallest;
    }
}
