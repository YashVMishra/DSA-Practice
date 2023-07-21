//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/

public class Partition_Array_Into_Three_Parts_With_Equal_Sum {
    public static void main(String[] args) {
        int[] arr = { 1, -1, 1, -1 };
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int total_sum = 0;

        // finding total sum
        for (int i : arr) {
            total_sum += i;
        }

        // very imp as if the sum is divisible by 3 then only it
        // can be divided into 3 equal parts.
        if (total_sum % 3 != 0) {
            return false;
        }

        int target_sum = total_sum / 3;
        int prefix_sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];

            if (prefix_sum == target_sum) {
                count++;
                prefix_sum = 0;
            }
        }

        // as count can be greater than 3.
        if (count >= 3) {
            return true;
        }

        return false;
    }
}