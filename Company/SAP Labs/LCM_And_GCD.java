// https://practice.geeksforgeeks.org/problems/lcm-and-gcd4516/1?page=2&company[]=SAP%20Labs&sortBy=submissions

import java.util.Arrays;

public class LCM_And_GCD {
    public static void main(String[] args) {
        Long A = 5L;
        Long B = 10L;
        System.out.println(Arrays.toString(lcmAndGcd(A, B)));
    }

    public static Long[] lcmAndGcd(Long A, Long B) {
        // code here

        Long GCD = gcd(A, B);
        Long LCM = (A * B) / GCD;
        Long[] ans = { LCM, GCD };

        return ans;
    }

    public static Long gcd(Long a, Long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
