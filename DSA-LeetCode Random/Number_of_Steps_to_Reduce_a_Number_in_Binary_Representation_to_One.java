// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/

public class Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {
        if (s.length() == 1 && s.charAt(0) == '1') {
            return 0;
        }

        int totalSteps = 0;
        while (true) {
            if (checkForOne(new StringBuilder(s))) {
                return totalSteps;
            } else {
                s = operation(new StringBuilder(s)).toString();
                totalSteps++;
            }
        }
    }

    // in this method, we will perform the operation on the string
    // if the string is even then we divide it by 2 and if the string is odd
    // we add 1 to it
    private static StringBuilder operation(StringBuilder sb) {
        if (sb.charAt(sb.length() - 1) == '0') {
            return sb.deleteCharAt(sb.length() - 1);
        } else {
            int i = sb.length() - 1;
            while (i >= 0 && sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
                i--;
            }

            if (i >= 0) {
                sb.setCharAt(i, '1');
            } else {
                sb.insert(0, '1');
            }

            return sb;
        }
    }

    private static boolean checkForOne(StringBuilder sb) {
        int oneCount = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                oneCount++;
            }
        }

        return oneCount == 1 && sb.charAt(sb.length() - 1) == '1';
    }
}
