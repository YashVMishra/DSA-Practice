// https://leetcode.com/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-01

public class Maximum_Odd_Binary_Number {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));
    }

    public static String maximumOddBinaryNumber(String s) {
        int oneCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }

        if (oneCount == 1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length() - 1; i++) {
                sb.append('0');
            }

            sb.append('1');
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();

            while (oneCount > 1) {
                sb.append('1');
                oneCount--;
            }

            // this is done as in the above while loop
            // the onecount decreases everytime.
            oneCount = sb.length() + oneCount;
            for (int i = 0; i < s.length() - oneCount; i++) {
                sb.append('0');
            }

            sb.append('1');
            return sb.toString();
        }
    }
}
