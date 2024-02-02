// https://leetcode.com/problems/sequential-digits/description/?envType=daily-question&envId=2024-02-02

import java.util.ArrayList;
import java.util.List;

public class Sequential_Digits {
    public static void main(String[] args) {
        int low = 100;
        int high = 300;

        System.out.println(sequentialDigits(low, high));
    }

    // brute force
    // just check each number between the low and high
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            if (isSequential(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    // function to check if the number is sequential
    private static boolean isSequential(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) + 1 != s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    // --------------------------------------------------------------------------------

    public static List<Integer> sequentialDigits_2(int low, int high) {
        List<Integer> allPossible = List.of(12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789);

        List<Integer> result = new ArrayList<>();
        int n = allPossible.size();

        for (int i = 0; i < n; i++) {
            if (allPossible.get(i) < low) {
                continue;
            }

            if (allPossible.get(i) > high) {
                break;
            }

            result.add(allPossible.get(i));
        }
        return result;
    }

}
