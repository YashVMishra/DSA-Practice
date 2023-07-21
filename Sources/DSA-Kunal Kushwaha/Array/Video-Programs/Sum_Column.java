/*
 WAP to calculate the sum of columns of the 2D matrix and print the highest sum.
 */

import java.util.Scanner;
public class Sum_Column {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        System.out.println("Enter the elements");
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(calculate(arr));
    }
    static int calculate(int[][] arr){
        int sum=0;
        for(int a[]:arr){
            int sum2=0;
            for(int b:a){
                sum2+=b;
            }
            if(sum2>sum)
                sum=sum2;
        }
        return sum;
    }
}
