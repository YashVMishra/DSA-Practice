// https://leetcode.com/problems/reveal-cards-in-increasing-order/description/?envType=daily-question&envId=2024-04-10

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Reveal_Cards_In_Increasing_Order {
    public static void main(String[] args) {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };

        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
        System.out.println(Arrays.toString(deckRevealedIncreasing_2(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        Arrays.sort(deck);
        boolean skip = false;
        int index = 0;

        for (int i = 0; i < deck.length; i++) {
            while (true) {
                if (result[index] == 0) {
                    if (!skip) {
                        result[index] = deck[i];
                        skip = true;
                        index = (index + 1) % deck.length;
                        break;
                    } else {
                        index = (index + 1) % deck.length;
                        skip = false;
                    }
                } else {
                    index = (index + 1) % deck.length;
                }
            }
        }

        return result;
    }

    // --------------------------------------------------------------------------------

    public static int[] deckRevealedIncreasing_2(int[] deck) {
        int[] result = new int[deck.length];
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }

        for (int i = 0; i < deck.length; i++) {
            int index = queue.poll();
            result[index] = deck[i];

            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return result;
    }
}
