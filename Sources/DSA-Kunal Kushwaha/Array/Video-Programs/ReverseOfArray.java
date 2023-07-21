import java.util.Scanner;
public class ReverseOfArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("Enter the array elements");
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        arr=reverseArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static int[] reverseArray(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return arr;
    }
}
