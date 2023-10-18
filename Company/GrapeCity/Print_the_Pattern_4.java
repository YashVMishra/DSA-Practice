// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/print-the-pattern-4-2

// Sample Input 0
// 3
// Sample Output 0
// 2
// 2 4 2
// 2 4 6 4 2

// Sample Input 1
// 4
// Sample Output 1
// 2
// 2 4 2
// 2 4 6 4 2
// 2 4 6 8 6 4 2

import java.util.Scanner;

public class Print_the_Pattern_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        pattern(n);
        sc.close();
    }

    private static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            int middle = 2 * i;

            for (int j = 2; j <= middle; j = j + 2) {
                System.out.print(j + " ");
            }

            for (int j = middle - 2; j >= 2; j = j - 2) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
