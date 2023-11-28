// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/?envType=daily-question&envId=2023-11-28

import java.util.ArrayList;

public class Number_of_Ways_to_Divide_a_Long_Corridor {
    static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(numberOfWays("SSPPSPS"));
        System.out.println(numberOfWays("PPSPSP"));
    }

    public static int numberOfWays(String corridor) {
        ArrayList<Integer> posSeats = new ArrayList<>();

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                posSeats.add(i);
            }
        }

        if (posSeats.size() % 2 != 0 || posSeats.size() == 0) {
            return 0;
        }

        long result = 1;
        int prev = posSeats.get(1); // End index of the starting subarray having 2 seats

        for (int i = 2; i < posSeats.size(); i += 2) {
            int length = posSeats.get(i) - prev;
            result = (result * length) % mod;

            prev = posSeats.get(i + 1);
        }

        return (int) result;
    }
}
