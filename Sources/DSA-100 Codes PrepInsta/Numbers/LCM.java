public class LCM {
    public static void main(String[] args) {
        int num1 = 50;
        int num2 = 15;
        System.out.println(helper1(num1, num2));
        System.out.println(helper2(num1, num2));
        System.out.println(helper3(num1, num2));
    }

    // using simple for loop.
    public static int helper1(int num1, int num2) {
        int max = (num1 > num2) ? num1 : num2;
        int ans = 1;

        for (int i = max; i <= num1 * num2; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // using the algo that by increasing the max number
    // by itself then at some point we will find the LCM.
    public static int helper2(int num1, int num2) {
        int max = (num1 > num2) ? num1 : num2;
        int count = max;

        while (true) {
            if (max % num1 == 0 && max % num2 == 0) {
                break;
            }

            else {
                max += count;
            }
        }

        return max;
    }

    // using the formula
    // num1 * num2 = LCM * HCF.
    public static int helper3(int num1, int num2) {
        int hcf = solve(num1, num2);

        return (num1 * num2) / hcf;
    }

    // used for helper3.
    public static int solve(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        return solve(num2, num1 % num2);

    }
}
