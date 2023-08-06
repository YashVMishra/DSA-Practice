public class Total_Set_Bits {
    public static void main(String[] args) {
        System.out.println(countSetBits(17));
    }

    // function to find the total set bits.
    public static int countSetBits(int n) {

        // Your code here
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int set_bits = no_of_set_bits(i);
            sum += set_bits;
        }

        return sum;
    }

    // func to find the set bits of the givem number.
    public static int no_of_set_bits(int num) {

        String str = Integer.toBinaryString(num);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
