//https://leetcode.com/problems/bulb-switcher/description/

import java.util.Arrays;

public class Bulb_Switcher {
    public static void main(String[] args) {
        System.out.println(bulbSwitch_1(6));
        System.out.println(bulbSwitch_2(6));
        System.out.println(bulbSwitch_3(6));
    }

    // Important observation that number which has even no of factors will be turned
    // off at the end and numbers with odd numbers of factors will be turned on at
    // the end.

    // causes memory limit exceed.
    public static int bulbSwitch_1(int n) {
        boolean[] bulbs = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (bulbs[j] == false) {
                    bulbs[j] = true;
                }

                else {
                    bulbs[j] = false;
                }
            }
        }

        System.out.println(Arrays.toString(bulbs));

        int ans = 0;
        for (boolean bulb : bulbs) {
            if (bulb) {
                ans++;
            }
        }

        return ans;
    }

    // shows TLE.
    public static int bulbSwitch_2(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (factors(i) % 2 != 0) {
                ans++;
            }
        }

        return ans;
    }

    // helper function used in the above function.
    public static int factors(int n) {
        int count = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return (count + 1);
    }

    // based on the observation that the prime numbers between 1 and n have
    // even factors

    // and the factors are always in pair, so if in the pair then means even
    // factors so we can exclude them also.

    // but the perfect squares between 1 and n have pair factors but they
    // have one pair as their square root.
    // Example:- 9 have factors 1,3,9 so pairs will be 1 X 9 and 3 X 3
    // since 3 is repeating two time we count it as one and that make odd
    // numbers of factors and the number with odd numbers of factors will always be
    // turned on.
    public static int bulbSwitch_3(int n) {
        return (int) (Math.sqrt(n));
    }
}
