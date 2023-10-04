// https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
        System.out.println(minEatingSpeed_2(piles, h));
    }

    // takes O(max * piles.length) TC.
    // overall its a linear search.
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int ans = 1;

        for (int i : piles) {
            max = Math.max(max, i);
        }

        for (int i = 1; i <= max; i++) {
            int hours = calculate(piles, i);

            if (hours <= h) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // uses O(log(max * piles.length)) TC.
    // basically uses Binary Search.
    public static int minEatingSpeed_2(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i : piles) {
            high = Math.max(high, i);
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int hours = calculate(piles, mid);

            if (hours <= h) {

                // one of the potential answers.
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // calculates the time at the given speed.
    public static int calculate(int[] piles, int speed) {
        int required = 0;

        for (int i : piles) {
            required += Math.ceil((double) i / (double) speed);
        }

        return required;
    }
}
