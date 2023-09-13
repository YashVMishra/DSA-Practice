// https://leetcode.com/problems/candy/description/?envType=daily-question&envId=2023-09-13

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[] { 1, 0, 2 }));
        System.out.println(candy(new int[] { 1, 2, 2 }));

        System.out.println(candy_2(new int[] { 1, 0, 2 }));
        System.out.println(candy_2(new int[] { 1, 2, 2 }));
    }

    // as said in the ques first solve for the left side of the elements
    // and store in the left array, do the same for the right side.
    // and add the max of left and right for each element.
    public static int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        right[right.length - 1] = 0;
        int i = 1;
        int j = ratings.length - 2;

        while (i < ratings.length) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }

            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            } else {
                right[j] = 1;
            }

            i++;
            j--;
        }

        int count = 0;
        for (i = 0; i < ratings.length; i++) {
            count += Math.max(left[i], right[i]);
        }

        return count;
    }

    // --------------------------------------------------------------------------------------

    // using one array instead of two and processing the same array for both
    // left and right.
    // this might looks tricky at first but dry run with pen and paper for better
    // understanding.
    public static int candy_2(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = Math.max(count[i], count[i - 1] + 1);
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < ratings.length; i++) {
            ans += count[i];
        }

        return ans;
    }
}
