// https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75

public class Guess_Number_Higher_or_Lower {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }

    // linear time.
    public static int guessNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // binary search
    public static int guessNumber_2(int n) {
        int ans = 0;
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                ans = res;
                break;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static int guess(int num) {
        int pick = 6;
        if (num == pick) {
            return 0;
        } else if (num > pick) {
            return -1;
        } else {
            return 1;
        }
    }
}
