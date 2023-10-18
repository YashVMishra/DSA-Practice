// https://www.hackerrank.com/contests/grapecity-coding-questions/challenges/remove-duplicates-from-a-string-2

import java.util.HashSet;
import java.util.Scanner;

public class Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        String ans = "";

        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                ans += ch;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
