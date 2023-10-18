// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/count-carry-1

import java.util.Scanner;

public class Count_Carry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(countCarry(num1, num2));
        sc.close();
    }

    private static int countCarry(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        // making the length of both strings equal
        if (str1.length() > str2.length()) {
            int diff = str1.length() - str2.length();
            while (diff-- > 0) {
                str2 = "0" + str2;
            }
        } else {
            int diff = str2.length() - str1.length();
            while (diff-- > 0) {
                str1 = "0" + str1;
            }
        }

        int carry = 0;
        int count = 0;
        for (int i = str1.length() - 1; i >= 0; i--) {
            int digit1 = str1.charAt(i) - '0';
            int digit2 = str2.charAt(i) - '0';

            carry = (digit1 + digit2 + carry) / 10;

            if (carry > 0) {
                count++;
            }
        }

        return count;
    }
}
