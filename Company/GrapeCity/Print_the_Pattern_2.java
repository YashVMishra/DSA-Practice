// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/print-the-patter-2

// Sample Input 0
// 4
// Sample Output 0
// 1
// 121 
// 12321 
// 1234321

// Sample Input 1
// 3
// Sample Output 1
// 1
// 121
// 12321

import java.util.Scanner;

public class Print_the_Pattern_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        pattern(n);
        sc.close();
    }

    // in ques there is no space between the numbers
    // but for clear display we have added space
    private static void pattern(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
