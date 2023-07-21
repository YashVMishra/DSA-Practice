/*
Problem Statement: Given an array, we have to find the smallest and largest element in the array.

Examples:

Example 1:
Input: arr[] = {2,5,1,3,0};
Output: 0
Explanation: 0 is the smallest element in the array. 

Example2: 
Input: arr[] = {8,10,5,7,9};
Output: 5
Explanation: 5 is the smallest element in the array.

Example 1:
Input: arr[] = {2,5,1,3,0};
Output: 5
Explanation: 5 is the largest element in the array. 

Example2: 
Input: arr[] = {8,10,5,7,9};
Output: 10
Explanation: 10 is the largest element in the array. 
*/

public class Smallest_Largest_Element {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        System.out.println(largest(arr));
        System.out.println(smallest(arr));
    }

    public static int largest(int[] nums) {
        int largest = nums[0];

        for (int i : nums) {
            largest = Math.max(i, largest);
        }

        return largest;
    }

    public static int smallest(int[] nums) {
        int smallest = nums[0];

        for (int i : nums) {
            smallest = Math.min(i, smallest);
        }

        return smallest;
    }
}