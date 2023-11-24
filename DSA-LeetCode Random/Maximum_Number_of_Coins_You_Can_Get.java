// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/?envType=daily-question&envId=2023-11-24

import java.util.Arrays;

public class Maximum_Number_of_Coins_You_Can_Get {
    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        System.out.println(maxCoins(piles));
    }

    // since we want the maximum coins we can get
    // but the maximum everytime we have to give it
    // Alice so we get the second largest element
    // and each player get piles.length / 3 chance
    // so we start from the piles.length - 2 index
    // and run the loop piles.length / 3 times.
    // and on eacy iteration we reduce the index by 2.
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        long ans = 0;
        int index = piles.length - 2;
        int counter = 0;

        while (counter < piles.length / 3) {
            ans += piles[index];
            index -= 2;
            counter++;
        }

        return (int) ans;
    }

    // since every candidate has piles.length / 3 chance
    // and for us to have maximum coins Bob has to get the
    // lowest coins in every chance so we sort the array
    // and give the first piles.length / 3 chance to Bob
    // and start our loop piles.length/3 index and add every
    // alternate element to our answer
    public static int maxCoins_2(int[] piles) {
        Arrays.sort(piles);
        long ans = 0;

        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }

        return (int) ans;
    }
}