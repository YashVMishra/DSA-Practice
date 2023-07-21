//https://leetcode.com/problems/can-place-flowers/description/

public class Can_Place_Flowers {
    public static void main(String[] args) {
        int[] flowerbed = { 0, 0 };
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        // counts the number of pots that can be placed in the flowerbed.
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {

            // For every element, we check if its both adjacent positions are
            // empty. If so, we can plant a flower at the current position without violating
            // the no-adjacent-flowers-rule. For the first and last elements, we need not
            // check the previous and the next adjacent positions respectively.

            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);

                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;

    }
}
