//https://leetcode.com/problems/gas-station/description/

public class Gas_Station {
    public static void main(String[] args) {
        int[] gas = { 2, 3, 4, };
        int[] cost = { 3, 4, 3 };
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int total_cost = 0;

        // this is what we have
        for (int i : gas) {
            total_gas += i;
        }

        // this is what we need
        for (int i : cost) {
            total_cost += i;
        }

        // if what we have is less than what we need then we cannot
        // make a circular path.
        if (total_gas < total_cost) {
            return -1;
        }

        int start = 0;
        int total_sum = 0;

        // whenever the total_sum is negative we acnnot start from that
        // index as we need fuel to get there and whenever we have positive
        // total_sum that means we can maintain some gas even if we
        // travel from that index.
        for (int i = 0; i < gas.length; i++) {
            total_sum += gas[i] - cost[i];

            if (total_sum < 0) {
                start = i + 1;
                total_sum = 0;
            }
        }

        return start;
    }
}
