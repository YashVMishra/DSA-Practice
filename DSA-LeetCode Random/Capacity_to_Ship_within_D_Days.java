//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

public class Capacity_to_Ship_within_D_Days {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    // uses binary search approach.
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int i : weights) {
            high += i;
            low = Math.max(low, i);
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if the mid is correct then we update the high
            // and if not then we update the low.
            if (total_days(mid, weights, days)) {
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // checks whether mid value is a valid answer or not.
    // valid here means that temp_days should be less than or equal to days.
    public static boolean total_days(int mid, int[] weights, int days) {

        int sum = 0;
        int temp_days = 1;

        // keep adding array elements in the sum until it
        // exceeds or become equal to the mid and then check for the validity of
        // temp_days.
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] <= mid) {
                sum += weights[i];
            }

            else {
                sum = weights[i];
                temp_days++;
            }
        }

        // if temp_days is equal to days then its ok but if its
        // less than then its a possible answer so we will consider it also.
        if (temp_days <= days) {
            return true;
        }

        return false;
    }
}
