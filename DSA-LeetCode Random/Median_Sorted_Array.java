// https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=daily-question&envId=2023-09-21

public class Median_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays_3(nums1, nums2));
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

    // ----------------------------------------------------------------------------------------

    // using constant space.
    // and O(m+n) TC.
    // since from the array we only needed two elements at max
    // so we store them in two variables.
    public static double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int index1 = 0, index2 = 0;

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                index1 = k == totalLength / 2 ? nums1[i] : index1;
                index2 = k == totalLength / 2 - 1 ? nums1[i] : index2;
                i++;
                k++;
            } else {
                index1 = k == totalLength / 2 ? nums2[j] : index1;
                index2 = k == totalLength / 2 - 1 ? nums2[j] : index2;
                j++;
                k++;
            }
        }

        // if nums1 has a greater length.
        while (i < nums1.length) {
            index1 = k == totalLength / 2 ? nums1[i] : index1;
            index2 = k == totalLength / 2 - 1 ? nums1[i] : index2;
            i++;
            k++;
        }

        // if nums2 has a greater length.
        while (j < nums2.length) {
            index1 = k == totalLength / 2 ? nums2[j] : index1;
            index2 = k == totalLength / 2 - 1 ? nums2[j] : index2;
            j++;
            k++;
        }

        if (totalLength % 2 == 0) {
            return (index1 + index2) / 2.0;
        }

        return index1;
    }

    // ---------------------------------------------------------------------------------------

    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays_2(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int low = 0, high = len1;

        while (low <= high) {
            int px = (low + high) / 2;
            int py = (len1 + len2 + 1) / 2 - px;

            double l1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            double l2 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];

            double r1 = px == len1 ? Integer.MAX_VALUE : nums1[px];
            double r2 = py == len2 ? Integer.MAX_VALUE : nums2[py];

            if (l1 <= r2 && l2 <= r1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                else {
                    return Math.max(l1, l2);
                }
            }

            else if (l1 > r2) {
                high = px - 1;
            }

            else {
                low = px + 1;
            }
        }

        return 0.0;

    }
}
