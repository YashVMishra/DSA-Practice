//https://leetcode.com/problems/fair-distribution-of-cookies/description/

public class Fair_Distribution_of_Cookies {

    static int ans;
    static int count[];

    public static void main(String[] args) {
        int[] cookies = { 8, 15, 10, 20, 8 };
        int k = 2;
        System.out.println(distributeCookies(cookies, k));
    }

    public static int distributeCookies(int[] cookies, int k) {
        ans = Integer.MAX_VALUE;
        count = new int[k];

        backtrack(0, cookies, k);
        return ans;
    }

    public static void backtrack(int cookieNumber, int[] cookies, int k) {
        if (cookieNumber == cookies.length) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, count[i]);
            }

            ans = Math.min(ans, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            count[i] += cookies[cookieNumber];
            backtrack(cookieNumber + 1, cookies, k);
            count[i] -= cookies[cookieNumber];

            if (count[i] == 0) {
                break;
            }

        }
    }
}
