/*
 WAP to reverse an array and print it.
 */
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Enter the array size");
        Scanner sc=new Scanner (System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        System.out.println("Enter the array elements");
        for (int i=0;i<arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int[] arr){
        int len=arr.length;
        for (int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[len-(i+1)];
            arr[len-(i+1)]=temp;
        }
    }
}
