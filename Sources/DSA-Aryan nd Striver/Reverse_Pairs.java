//https://leetcode.com/problems/reverse-pairs/description/

public class Reverse_Pairs {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1 };
        System.out.println(reversePairs(nums));
        System.out.println(reversePairs_2(nums));
    }

    // shows TLE and might show overflow.
    public static int reversePairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long) (nums[i]) > (long) (2) * (nums[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int reversePairs_2(int[] nums) {
        return count(nums, 0, nums.length - 1);
    }

    public static int count(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        // Divide the array into two halves
        int mid = (left + right) / 2;
        int a = count(nums, left, mid);
        int b = count(nums, mid + 1, right);

        // merge the two parts.
        int aWithb = merge(nums, left, mid, right);

        return a + b + aWithb;
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int i = left, j = mid + 1;

        // counting number of valid pairs
        while (i <= mid && j <= right) {
            if ((long) (nums[i]) > (long) (2 * nums[j])) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        // process of merging the two parts of the arrays.
        int[] temp = new int[right - left + 1];
        i = left;
        j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k] = nums[j];
                k++;
                j++;
            } else {
                temp[k] = nums[i];
                k++;
                i++;
            }
        }

        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = nums[j];
            k++;
            j++;
        }

        // copying the temp array elements back to the real one.
        k = 0;
        for (int z = left; z <= right; z++) {
            nums[z] = temp[k];
            k++;
        }

        return count;
    }
}
