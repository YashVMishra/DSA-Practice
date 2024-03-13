// https://leetcode.com/problems/find-the-pivot-integer/description/?envType=daily-question&envId=2024-03-13

public class Find_the_Pivot_Integer {
    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int currSum = 0;

        for (int i = 1; i <= n; i++) {
            currSum += i;

            if (currSum == sum - currSum + i) {
                return i;
            }
        }

        return -1;
    }
}
