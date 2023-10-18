// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/print-the-pattern-3-2-2

// Sample Input 0
// 3
// Sample Output 0
// 1
// 1 2
// 1 2 3

// Sample Input 1
// 4
// Sample Output 1
// 1
// 1 2
// 1 2 3
// 1 2 3 4

import java.util.Scanner;

public class Print_the_Pattern_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        pattern(n);
        sc.close();
    }

    private static void pattern(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
