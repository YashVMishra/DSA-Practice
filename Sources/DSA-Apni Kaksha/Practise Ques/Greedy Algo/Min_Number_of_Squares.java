//https://practice.geeksforgeeks.org/problems/cutting-rectangles3659/1

import java.util.List;
import java.util.ArrayList;

public class Min_Number_of_Squares {
    public static void main(String[] args) {
        System.out.println(minimumSquares(989493, 43543));
    }

    public static List<Long> minimumSquares(long L, long B) {
        // code here
        List<Long> list = new ArrayList<>();
        long min = Math.min(L, B);
        long max = Math.max(L, B);

        list.add((L * B) / gcd(max, min) * gcd(max, min));
        list.add(gcd(max, min));

        return list;
    }

    static long gcd(long n1, long n2) {
        if (n2 != 0) {
            return gcd(n2, n1 % n2);
        }

        return n1;
    }
}
