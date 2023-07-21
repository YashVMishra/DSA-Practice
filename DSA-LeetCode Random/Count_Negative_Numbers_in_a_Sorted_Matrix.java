//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

public class Count_Negative_Numbers_in_a_Sorted_Matrix {
    public static void main(String[] args) {
        int[][] grid = { { 3, 2 }, { 1, 0 } };
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;

        // iterate over every row.
        for (int[] arr : grid) {
            int start = 0;
            int end = arr.length - 1;

            // using binary search find the index of the first
            // negative number.
            while (start <= end) {
                int mid = (end + start) / 2;

                if (arr[mid] < 0) {
                    end = mid - 1;
                }

                else {
                    start = mid + 1;
                }
            }

            // left pointer contains the index of the first
            // negative number.
            count += (arr.length - start);
        }

        return count;
    }
}