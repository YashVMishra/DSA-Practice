//https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1

public class Power_of_2 {
    public static void main(String[] args) {
        System.out.println(is_Power_of_2(512));
    }

    public static boolean is_Power_of_2(int n) {
        if (n == 1) {
            return true;
        }

        double ans = n;

        while (ans > 2) {
            ans /= 2.0;
        }

        if (ans == 2.0) {
            return true;
        }

        return false;

    }
}
