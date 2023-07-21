//https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// the test case of this ques might not be correct as there own solution is giving wrong 
// answers when run through that test case.

public class Copy_Set_Bits {
    public static void main(String[] args) {
        System.out.println(copy_set_bits(16, 2, 1, 3));
        System.out.println(copy_set_bits_2(16, 2, 1, 3));
    }

    // this function causes TLE
    // just make the two array for both the number and
    // change the values according to the ques in the second array
    // within the given range.
    public static int copy_set_bits(int x, int y, int l, int r) {

        String str1 = Integer.toBinaryString(x);
        String str2 = Integer.toBinaryString(y);

        if (str1.length() > str2.length()) {
            int len = str1.length() - str2.length();
            for (int i = 0; i < len; i++) {
                str2 = "0" + str2;
            }
        }

        else {
            int len = str2.length() - str1.length();
            for (int i = 0; i < len; i++) {
                str1 = "0" + str1;
            }
        }

        char[] arr = new char[str1.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str1.charAt(i);
        }

        char[] arr_2 = new char[str2.length()];

        for (int i = 0; i < arr.length; i++) {
            arr_2[i] = str2.charAt(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (i >= l && i <= r) {
                if (arr_2[i] == '1') {
                    arr[i] = '1';
                }
            }
        }

        String ans = "";

        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }

        return Integer.parseInt(ans, 2);

    }

    // using mask and calculating in constant time.
    public static int copy_set_bits_2(int x, int y, int l, int r) {
        int mask = 1 << (r - l + 1);
        mask--;

        mask = mask << (l - 1);

        mask = mask & y;

        return x | mask;
    }
}
