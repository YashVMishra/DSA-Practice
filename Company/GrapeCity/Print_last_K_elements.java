// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/print-k-last-elements

import java.util.Scanner;

public class Print_last_K_elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int length = sc.nextInt();

        int[] arr = new int[length];

        System.out.println("Enter elements: ");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the the value of k: ");
        int k = sc.nextInt();

        for (int i = length - k; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
