/*
  WAP to print the intersection of two arrays.
  Result will be unique
  Ex=[1,2,2,1] and [2,2]
  Ans=[2]
 */

import java.util.Arrays;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] nums1={61,24,20,58,95,53,17,32,45,85,70,20,83,62,
                35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,
                38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66
                ,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,
                96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int[] nums2={5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,
                92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        int[] num3=intersection(nums1,nums2);
        System.out.println(Arrays.toString(num3));
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        int size = Math.min(nums1.length, nums2.length);
        int[] nums3=new int[size];
        for(int i=0;i<size;i++){
            nums3[i]=Integer.MAX_VALUE;
        }
        int k=0;int count=0;
        for (int value : nums1) {
            for (int i : nums2) {
                if (value == i) {
                    count++;
                }
            }
            if (count > 0) {
                int ans = linearSearch(nums3, value);
                if (ans == -1) {
                    nums3[k] = value;
                    k++;
                }
            }
            count = 0;
        }
        int [] nums4=new int[k];
        for(int i=0;i<k;i++){
            nums4[i]=nums3[i];
        }
        return nums4;
    }
    static int linearSearch(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
}
