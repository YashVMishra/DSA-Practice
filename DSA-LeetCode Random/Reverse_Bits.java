//https://leetcode.com/problems/reverse-bits/description/

public class Reverse_Bits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int ans = 0;

        for (int i = 1; i <= 32; i++) {
            if (kthBit(i, n)) {
                ans = (1 << (32 - i)) | ans;
            }
        }

        return ans;
    }

    public static boolean kthBit(int k, int n) {
        if (((1 << (k - 1)) & n) != 0) {
            return true;
        }

        return false;
    }
}
