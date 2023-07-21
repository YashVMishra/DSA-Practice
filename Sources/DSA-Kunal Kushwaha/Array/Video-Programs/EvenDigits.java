/*
 WAP to print the numbers of elements in the array that have even numbers of digits.
*/

import java.util.Scanner;
public class EvenDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        System.out.println("Enter the elements");
        int [] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int ans=even(arr);
        System.out.println(ans);
    }
    static int even(int[]arr){
        int count=0;
        for(int a:arr){
            if(even_odd(a))
                count++;
        }
        return count;
    }
    static int numberOfDigits(int num){
        int count=0;
        if(num==0){
            return -1;
        }
        if(num<0){
            num=num*-1;
        }
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
    static boolean even_odd(int num){
        if(numberOfDigits(num)%2==0)
            return true;
        return false;
    }
}
