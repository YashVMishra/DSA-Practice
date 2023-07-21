//https://leetcode.com/problems/kth-missing-positive-number/description/

public class Kth_Smallest_Missing_No {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositive_2(arr, k));
    }

    // uses extra space.
    public static int findKthPositive(int[] arr, int k) {
        int[] ans = new int[1001];

        for (int i : arr) {
            ans[i] = i;
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                if (k == 0) {
                    return i;
                }

                k--;
            }
        }

        return -1;
    }

    // uses constant space and runs in 0 ms.
    public static int findKthPositive_2(int[] arr, int k) {
        int index = 0;
        int ans = 0;
        int count = 0;

        for (int i = 1;; i++) {
            // checking for the indexes of the given array.
            if (index < arr.length && arr[index] == i) {
                index++;
            }

            else {
                count++;

                // as count becomes equal to k break out of the loop.
                if (count == k) {
                    ans = i;
                    break;
                }
            }
        }

        return ans;
    }
}