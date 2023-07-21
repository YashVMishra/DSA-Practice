public class HCF {
    public static void main(String[] args) {

        // if number is negative just make it positive in any method you call.
        int num1 = 50;
        int num2 = 15;
        System.out.println(helper1(num1, num2));
        System.out.println(helper2(num1, num2));
        System.out.println(helper3(num1, num2));
        System.out.println(helper4(num1, num2));
    }

    // using simple for loop.
    public static int helper1(int num1, int num2) {
        int i = 0;

        for (i = Math.min(num1, num2); i >= 1; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                break;
            }
        }

        return i;
    }

    // using recursion.
    // also call Euclidean Algorithm.
    public static int helper2(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        return helper1(num2, num1 % num2);
    }

    // repeated subtraction.
    public static int helper3(int num1, int num2) {

        while (num1 != num2) {
            if (num1 > num2) {
                num1 -= num2;
            }

            else {
                num2 -= num1;
            }
        }

        return num1;
    }

    // repeated subtraction using recursion.
    public static int helper4(int num1, int num2) {

        // diff base cases.
        if (num1 == 0) {
            return num2;
        }

        // diff base cases.
        if (num2 == 0) {
            return num1;
        }

        if (num1 == num2) {
            return num1;
        }

        else {
            if (num1 > num2) {
                return helper4(num1 - num2, num2);
            }

            else {
                return helper4(num1, num2 - num1);
            }
        }
    }
}