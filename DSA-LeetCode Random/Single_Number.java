//https://leetcode.com/problems/single-number/description/

public class Single_Number {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 2, 2, 1, 4, 1, 5, 5 }));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        // using XOR op as a XOR a = 0;
        for (int i : nums) {
            ans = ans ^ i;
        }

        return ans;
    }
}
