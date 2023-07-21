//https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1

public class Total_Set_Bits_upto_N {
    public static void main(String[] args) {
        System.out.println(countSetBits(17));
    }

    // logic from the video of Sumeet Malik.
    // 1 << x gives 2^x (read Kunal Kushwaha notes copy)
    public static int countSetBits(int num) {
        if (num == 0) {
            return 0;
        }

        int power_of_2 = power(num);

        int bits_till_power_of_2 = power_of_2 * (1 << (power_of_2 - 1));

        int first_bits_of_rest = num - (1 << power_of_2) + 1;

        int rest = num - (1 << power_of_2);

        int ans = bits_till_power_of_2 + first_bits_of_rest + countSetBits(rest);

        return ans;
    }

    public static int power(int num) {

        int x = 0;

        // return x as the value of power greater than the value num.
        // so return x-1.
        while ((1 << x) <= num) {
            x++;
        }

        return x - 1;
    }
}
