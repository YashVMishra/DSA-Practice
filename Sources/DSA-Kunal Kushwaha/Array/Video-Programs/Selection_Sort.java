import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr={4,6,1,7,3,8,5,9};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for(int i=0;i<arr.length;i++){
            int last=arr.length-1-i;
            int maxIndex=getMaxIndex(arr,0,last);
            swap(arr, last, maxIndex);
        }
    }
    static void swap(int[] arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    static int getMaxIndex(int[]arr, int start, int last){
        int max=start;
        for (int i=start;i<=last;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
}
