// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2023-12-24

public class Minimum_Changes_To_Make_Alternating_Binary_String {
    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
    }

    public static int minOperations(String s) {
        int n = s.length();
        int start_with_0 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start_with_0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    start_with_0++;
                }
            }
        }

        return Math.min(start_with_0, n - start_with_0);
    }
}