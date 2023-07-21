//https://leetcode.com/problems/happy-number/description/

public class Happy {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }

    public static boolean isHappy(int n) {
        int temp = n;

        while (true) {
            temp = square_sum(temp);
            if (temp == 1) {
                return true;
            }

            if (temp == 4) {
                return false;
            }
        }
    }

    public static int square_sum(int num) {

        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans = ans + (rem * rem);
            num /= 10;
        }

        return ans;
    }

}
