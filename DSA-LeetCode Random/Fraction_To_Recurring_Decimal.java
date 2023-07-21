//https://leetcode.com/problems/fraction-to-recurring-decimal/

import java.util.HashMap;
import java.util.Map;

public class Fraction_To_Recurring_Decimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        // checking for negative values.
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            ans.insert(0, "-");
        }

        // converting everything to long so that
        // overflow does not happen when we take numerator or denominator
        // as extreme values.
        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        long quotient = divisor / dividend;
        long remainder = divisor % dividend;

        ans.append(quotient);

        if (remainder == 0) {
            return ans.toString();
        }

        else {
            ans.append(".");
            // map to store the remainder and if the remainder
            // repeats then recurring decimals has started.
            Map<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    int len = map.get(remainder);
                    ans.insert(len, "(");
                    ans.append(")");
                    break;
                }

                else {
                    map.put(remainder, ans.length());
                    remainder = remainder * 10;
                    quotient = remainder / dividend;
                    remainder = remainder % dividend;
                    ans.append(quotient);
                }
            }
        }

        return ans.toString();
    }
}
