
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

public class Duration_60_Min {
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60_2(new int[] { 30, 20, 150, 100, 40 }));
    }

    // simple approach to check all the pairs.
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;

        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // using extra space to compute the pairs.
    public static int numPairsDivisibleBy60_2(int[] time) {

        // we have taken it as long as on multiplying the
        // frequencies there might be a case that it exceeds the
        // integer range.
        long count = 0;
        long[] freq = new long[60];

        // System.out.println(Arrays.toString(time));

        for (int i = 0; i < time.length; i++) {
            freq[time[i] % 60]++;
        }

        // System.out.println(Arrays.toString(freq));

        // checking for the boundary conditions
        if (freq[0] > 1) {
            count += ((freq[0]) * (freq[0] - 1)) / 2;
        }

        if (freq[30] > 1) {
            count += ((freq[30]) * (freq[30] - 1)) / 2;
        }

        // for rest of the numbers and we are looping till length/2 as
        // after the half the number will be doubles as 30 forms the mirror image
        for (int i = 1; i < 30; i++) {
            count += freq[i] * freq[freq.length - i];
        }

        return (int) count;
    }
}
