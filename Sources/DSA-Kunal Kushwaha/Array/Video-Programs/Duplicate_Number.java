/*
  WAP to find the first duplicate number.
  Array contains numbers from 1 to n in a n+1 array.
  only one duplicate number.
 */

import java.util.Arrays;

class Duplicate_Number {
    public static void main(String[] args) {
        int[] arr={1};
        //System.out.println(findDuplicate(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int findDuplicate(int[] nums) {
        sort(nums);
        return nums[nums.length-1];
    }
    
    static void sort(int[]arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr, i, correct);
            }
            else {
                i++;
            }
        }
    }
    
    static void swap(int[]arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}