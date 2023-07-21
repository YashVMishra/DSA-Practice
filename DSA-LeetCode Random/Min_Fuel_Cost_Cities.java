//https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/

import java.util.ArrayList;
import java.util.List;

public class Min_Fuel_Cost_Cities {

    static long ans;
    static long seats;

    public static void main(String[] args) {
        int[][] roads = { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 } };
        int seats = 2;

        System.out.println(minimumFuelCost(roads, seats));
    }

    public static long minimumFuelCost(int[][] roads, int s) {
        List<List<Integer>> list = new ArrayList<>();

        seats = s;
        ans = 0L;

        for (int i = 0; i <= roads.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] arr : roads) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        helper(list, 0, -1);

        return ans;
    }

    public static long helper(List<List<Integer>> list, int u, int prev) {
        long person = 1L;

        for (int v : list.get(u)) {
            if (prev == v) {
                continue;
            }

            person += helper(list, v, u);
        }

        if (u != 0) {
            ans += (seats + person - 1) / seats;
        }

        return person;
    }
}
