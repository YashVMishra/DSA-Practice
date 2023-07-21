// https://practice.geeksforgeeks.org/problems/bleak-numbers1552/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// see the notes to find how to calculate the number of set bits.

public class Bleak_Number {
    public static void main(String[] args) {
        System.out.println(is_bleak(3));
    }

    public static int is_bleak(int n) {
        // Code here
        for (int i = 0; i < n; i++) {
            if (i + CSB(i) == n) {
                return 0;
            }
        }

        return 1;
    }

    public static int CSB(int nums) {
        int count = 0;

        while (nums > 0) {
            count++;
            nums = nums & (nums - 1);
        }

        return count;
    }
}
