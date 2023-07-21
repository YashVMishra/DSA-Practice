//https://leetcode.com/problems/last-stone-weight/description/

import java.util.ArrayList;
import java.util.Collections;

public class Last_Stone_Weight {
    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }

        while (list.size() > 1) {
            Collections.sort(list);

            int first = list.get(list.size() - 1);
            int second = list.get(list.size() - 2);

            int result = first - second;

            list.remove(list.size() - 1);
            list.remove(list.size() - 1);

            if (result != 0) {
                list.add(result);
            }
        }

        if (list.size() > 0) {
            return list.get(0);
        }

        return 0;
    }
}
