//https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1

public class Position_of_Set_bit {
    public static void main(String[] args) {
        System.out.println(position(45));
    }

    public static int position(int n) {
        if (n == 0) {
            return -1;
        }

        String str = Integer.toBinaryString(n);

        int count = 0;
        int index = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                count++;
                index = i;
                if (count > 1) {
                    return -1;
                }
            }
        }

        // return the index of the first 1 from the LSB side
        // assuming the index starts from 1 form the LSB
        return str.length() - index;
    }
}
