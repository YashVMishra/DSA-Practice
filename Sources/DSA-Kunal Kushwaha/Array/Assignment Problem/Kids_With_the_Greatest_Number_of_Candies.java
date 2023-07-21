//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.ArrayList;

class Kids_With_the_Greatest_Number_of_Candies {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 1, 3 };
        System.out.println(kidsWithCandies(arr, 3));
    }

    static int highest(int[] arr) {
        int highest = arr[0];

        for (int i : arr) {
            if (i > highest) {
                highest = i;
            }
        }

        return highest;
    }

    static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highest = highest(candies);

        ArrayList<Boolean> list = new ArrayList<>();

        for (int i : candies) {
            if ((i + extraCandies) >= highest) {
                list.add(true);
            }

            else {
                list.add(false);
            }
        }

        return list;
    }
}