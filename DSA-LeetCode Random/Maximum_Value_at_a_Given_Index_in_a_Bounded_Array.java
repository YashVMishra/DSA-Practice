//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/

public class Maximum_Value_at_a_Given_Index_in_a_Bounded_Array {
    public static void main(String[] args) {
        int n = 6, index = 1, maxSum = 10;
        System.out.println(maxValue(n, index, maxSum));
    }

    public static int maxValue(int n, int index, int maxSum) {
        long emptyR = n - index - 1;
        long emptyL = index;

        int left = 1;
        int right = maxSum;
        long ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long leftSum = 0;
            long rightSum = 0;
            long el = mid - 1;

            // calculating rightSum.
            if (emptyR <= el) {

                // for array like {5,4,3,2,1}
                rightSum = (el * (el + 1)) / 2 - ((el - emptyR) * (el - emptyR + 1)) / 2;
            } else {

                // for array like {3,2,1,1,1}
                rightSum = (el * (el + 1)) / 2 + (emptyR - el);
            }

            // calculating leftSum.
            if (emptyL <= el) {

                // for array like {5,4,3,2,1}
                leftSum = (el * (el + 1)) / 2 - ((el - emptyL) * (el - emptyL + 1)) / 2;
            } else {

                // for array like {3,2,1,1,1}
                leftSum = (el * (el + 1)) / 2 + (emptyL - el);
            }

            long sum = leftSum + rightSum + mid;

            if (sum <= maxSum) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return (int) (ans);
    }
}
