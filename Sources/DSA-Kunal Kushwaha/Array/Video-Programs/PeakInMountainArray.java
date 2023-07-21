/*
 WAP to find the peak element in the mountain array.
 A mountain array is type of array in which one side is in ascending order
 and other is in descending order.
 Ex=[1,2,4,5,3,2,1]
 Mountain array is also called Bitonic array.
 */


public class PeakInMountainArray {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,3,2};
        int ans = findPeakElement(arr);
        System.out.println(ans);
    }

    public static int findPeakElement(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                end=mid;
            else
                start=mid+1;
        }
        //at last the start and end wil at the position where the peak alement is there
        return start;
    }
}
