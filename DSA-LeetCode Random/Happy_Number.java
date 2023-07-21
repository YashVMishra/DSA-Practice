//https://leetcode.com/problems/happy-number/description/?envType=study-plan&id=level-2

public class Happy_Number {
    public static void main(String[] args) {
        int n = 22;
        System.out.println(isHappy_1(n));
        System.out.println(isHappy_2(n));
    }

    // if the number is not a happy number then ultimately it will
    // become 4 and then we have to return false.
    // tyr dry run on several inouts then you will understand why 4.
    public static boolean isHappy_1(int n) {
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

    // using the fast and slow pointer method of LL here
    // loop will be formed here but after the loop is detected
    // fast or slow is equal to 1 then its happy number or if
    // they are anything else then its not a happy number.
    public static boolean isHappy_2(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square_sum(slow);
            fast = square_sum(square_sum(fast));
        } while (fast != slow);

        return fast == 1 ? true : false;
    }

    // return the sum of the square of the digits.
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
