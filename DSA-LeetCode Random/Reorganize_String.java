//https://leetcode.com/problems/reorganize-string/description/

import java.util.PriorityQueue;

public class Reorganize_String {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }

    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String reorganizeString(String s) {
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        // making max heap according to the frequency.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.add(new Pair((char) ('a' + i), map[i]));
            }
        }

        StringBuilder ans = new StringBuilder();
        Pair block = pq.poll();
        ans.append(block.ch);
        block.freq--;

        while (pq.size() > 0) {
            Pair temp = pq.poll();
            ans.append(temp.ch);
            temp.freq--;

            if (block.freq > 0) {
                pq.add(block);
            }

            block = temp;
        }

        if (block.freq > 0) {
            return "";
        }

        return ans.toString();
    }
}