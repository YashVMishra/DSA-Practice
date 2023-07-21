//https://leetcode.com/problems/sum-of-two-integers/description/

public class Sum_Two_Integers {
    public static void main(String[] args) {
        int a = 9;
        int b = 11;
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        int XOR_op = a ^ b;
        int AND_op = (a & b) << 1;
        int temp1 = XOR_op;
        int temp2 = AND_op;

        while (temp2 != 0) {
            XOR_op = temp1 ^ temp2;
            AND_op = (temp1 & temp2) << 1;
            temp1 = XOR_op;
            temp2 = AND_op;
        }

        return temp1;
    }

}