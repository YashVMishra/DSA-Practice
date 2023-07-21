//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

import java.util.ArrayList;
import java.util.List;

public class Kids_With_the_Greatest_Number_of_Candies {
    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = max(candies);

        ArrayList<Boolean> list = new ArrayList<>();

        for (int i : candies) {
            if ((i + extraCandies) >= max) {
                list.add(true);
            }

            else {
                list.add(false);
            }
        }

        return list;
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(max, i);
        }

        return max;
    }
}
