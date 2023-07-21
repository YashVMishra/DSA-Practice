//https://leetcode.com/problems/sqrtx/description/

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt_2(2147395599));
    }

    // not good for large number
    // Ex:-2147395599
    public static int sqrt(int n) {
        int start = 0;
        int end = n;
        int root = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            root = mid;

            if (root * root == n) {
                return root;
            }

            else if (root * root > n) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return (root * root) < n ? root : root - 1;
    }

    // Newton Ramphson Method
    public static int sqrt_2(int n) {
        double x = n;
        double root;

        // edge case
        if (n == 0) {
            return 0;
        }

        while (true) {
            root = 0.5 * (x + (n / x));

            if (Math.abs(root - x) < 1) {
                break;
            }

            x = root;
        }

        return (int) (root);
    }
}
