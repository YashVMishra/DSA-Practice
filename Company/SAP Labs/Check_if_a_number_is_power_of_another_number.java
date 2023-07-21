// https://practice.geeksforgeeks.org/problems/check-if-a-number-is-power-of-another-number5442/1?page=2&company[]=SAP%20Labs&sortBy=submissions

public class Check_if_a_number_is_power_of_another_number {
    public static void main(String[] args) {
        Long X = 2L;
        Long Y = 8L;
        System.out.println(isPowerOfAnother(X, Y));
        System.out.println(isPowerOfAnother_2(X, Y));
    }

    // accepted.
    public static Long isPowerOfAnother(Long X, Long Y) {
        // code here

        double ans1 = Math.log(Y) / Math.log(X);

        if (ans1 % 1 == 0) {
            return 1L;
        } else {
            return 0L;
        }
    }

    // also accepted.
    public static Long isPowerOfAnother_2(Long x, Long y) {
        // The only power of 1 is 1 itself
        if (x == 1) {
            return y == 1 ? 1L : 0L;
        }

        // Repeatedly compute power of x
        long pow = 1;
        while (pow < y) {
            pow = pow * x;
        }

        // Check if power of x becomes y
        return pow == y ? 1L : 0L;
    }
}
