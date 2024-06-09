// https://leetcode.com/problems/hand-of-straights/description/?envType=daily-question&envId=2024-06-06

import java.util.TreeMap;

public class Hand_of_Straights {
    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;
        boolean result = isNStraightHand(hand, groupSize);
        System.out.println(result);
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int curr = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(curr + i)) {
                    return false;
                }

                map.put(curr + i, map.get(curr + i) - 1);
                if (map.get(curr + i) == 0) {
                    map.remove(curr + i);
                }
            }
        }

        return true;
    }
}
