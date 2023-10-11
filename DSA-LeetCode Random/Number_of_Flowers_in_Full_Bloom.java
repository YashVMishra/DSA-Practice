// https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/?envType=daily-question&envId=2023-10-11

import java.util.Arrays;

public class Number_of_Flowers_in_Full_Bloom {
    public static void main(String[] args) {
        int[][] flowers = { { 1, 3 }, { 2, 3 }, { 3, 4 } };
        int[] people = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int day = people[i];
            int count = 0;

            for (int j = 0; j < flowers.length; j++) {
                int start = flowers[j][0];
                int end = flowers[j][1];

                if (day >= start && day <= end) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    public static int[] fullBloomFlowers_2(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < people.length; i++) {
            int bloomed_already = binarySearchUpperBound(start, people[i]);
            int died_already = binarySearchLowerBound(end, people[i]);

            ans[i] = bloomed_already - died_already;
        }

        return ans;
    }

    // upperbound means the number just greater than the target.
    private static int binarySearchUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result == -1 ? arr.length : result;
    }

    // lowerbound means greater than or equal to.
    private static int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }

        }

        return result == -1 ? arr.length : result;
    }
}
