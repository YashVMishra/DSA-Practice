// https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/?envType=daily-question&envId=2024-01-15

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Find_Players_With_Zero_or_One_Losses {
    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };

        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        HashMap<Integer, Integer> map = new HashMap<>();

        // calculating the losses of player
        // consider only the matches[1] as it is the loser
        for (int[] match : matches) {
            int loser = match[1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }

        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            // now the winner should not be present in the map and set
            // as it has not lost any match.
            if (!map.containsKey(winner)) {
                result.get(0).add(winner);

                // we can use set DS to remove the redundancy
                // for the set solution see the solution submitted by me
                // on leetcode in the first successful attempt
                // but after adding the element to our list we can put
                // the element in the map with value greater than 1
                // so that it will not be added to the list again
                map.put(winner, 2);
            }

            // now the loser should be present in the map and not in the set
            // and the loser should have lost only one match.
            // here we have not written !set.contains(loser)
            // as if the player has lost 1 match only then
            // it will be present in matches array only once
            if (map.get(loser) == 1) {
                result.get(1).add(loser);
            }
        }

        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }
}
