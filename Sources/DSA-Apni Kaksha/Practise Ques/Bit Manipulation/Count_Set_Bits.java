public class Count_Set_Bits {
    public static void main(String[] args) {
        System.out.println(set_bits(45));
    }

    public static int set_bits(int n) {
        String str = Integer.toBinaryString(n);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}