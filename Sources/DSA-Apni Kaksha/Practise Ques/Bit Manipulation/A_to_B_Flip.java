//https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1

public class A_to_B_Flip {
    public static void main(String[] args) {
        System.out.println(countBitsFlip(20, 25));
    }

    public static int countBitsFlip(int a, int b) {

        // Your code here
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toBinaryString(b);

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

        System.out.println(str1);
        System.out.println(str2);

        int count = 0;
        for (int i = str1.length() - 1; i >= 0; i--) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
