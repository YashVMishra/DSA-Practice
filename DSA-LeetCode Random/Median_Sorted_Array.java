//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class Median_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4, 5 };
        System.out.println(findMedianSortedArrays_2(nums1, nums2));
    }

    // using O(m+n) TC and O(m+n) SC.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        double[] temp = new double[len1 + len2];

        int x = 0;
        int y = 0;
        int i = 0;

        // combining the two arrays.
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] < nums2[y]) {
                temp[i] = nums1[x];
                i++;
                x++;
            }

            else {
                temp[i] = nums2[y];
                y++;
                i++;
            }
        }

        // if nums1 has a greater length.
        while (x < nums1.length) {
            temp[i] = nums1[x];
            x++;
            i++;
        }

        // if nums2 has a greater length.
        while (y < nums2.length) {
            temp[i] = nums2[y];
            y++;
            i++;
        }

        // if temp.length is odd then we have only one element as median
        if (temp.length % 2 != 0) {
            return temp[temp.length / 2];
        }

        // if the temp.length is even then we have to take the average of the
        // middle elements.
        else {

            int index = temp.length / 2;
            return (temp[index] + temp[index - 1]) / 2;
        }
    }

    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays_2(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int low = 0, high = len1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (len1 + len2 + 1) / 2 - cut1;

            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            double r1 = cut1 == len1 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == len2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                else {
                    return Math.max(l1, l2);
                }
            }

            else if (l1 > r2) {
                high = cut1 - 1;
            }

            else {
                low = cut1 + 1;
            }
        }

        return 0.0;

    }
}
