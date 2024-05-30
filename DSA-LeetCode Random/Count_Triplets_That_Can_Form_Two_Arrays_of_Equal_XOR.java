// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/

public class Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };
        System.out.println(countTriplets(arr));
    }

    // code given by copilot
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xor = arr[i];

            for (int j = i + 1; j < n; j++) {
                xor ^= arr[j];

                if (xor == 0) {
                    count += j - i;
                }
            }
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    // using the concept of prefix xor.
    public static int countTriplets_2(int[] arr) {
        int[] prefixXor = new int[arr.length + 1];
        prefixXor[0] = 0;

        for (int i = 1; i < prefixXor.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i - 1];
        }

        int triplets = 0;
        for (int i = 0; i < prefixXor.length; i++) {
            for (int k = i + 1; k < prefixXor.length; k++) {

                if (prefixXor[k] == prefixXor[i]) {
                    triplets += k - i - 1;
                }
            }
        }

        return triplets;
    }
}
