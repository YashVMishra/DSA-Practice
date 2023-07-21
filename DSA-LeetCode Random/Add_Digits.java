//https://leetcode.com/problems/add-digits/description/

public class Add_Digits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits_Rec(38));
        System.out.println(addDigits_Loop(38));
    }

    // takes constant time.
    public static int addDigits(int num) {
        if (num <= 9) {
            return num;
        }

        return num % 9 == 0 ? 9 : num % 9;
    }

    // simple loop.
    public static int addDigits_Loop(int num) {
        int temp = num;

        while (temp > 9) {
            temp = addAll(temp);
        }

        return temp;
    }

    // helper method to find the sum of all digits.
    public static int addAll(int num) {
        int ans = 0;

        while (num > 0) {
            int rem = num % 10;
            ans += rem;
            num /= 10;
        }

        return ans;
    }

    // using recursion.
    public static int addDigits_Rec(int num) {
        if (num < 10) {
            return num;
        }

        int ans = 0;

        while (num > 0) {
            int rem = num % 10;
            ans += rem;
            num /= 10;
        }

        return addDigits_Rec(ans);
    }
}
