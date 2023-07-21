//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

public class Min_Moves {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(minMoves(arr));
    }

    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }

        for (int i : nums) {
            count += i - min;
        }

        return count;
    }
}
