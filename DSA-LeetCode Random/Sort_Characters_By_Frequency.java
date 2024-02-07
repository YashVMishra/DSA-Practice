// https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=daily-question&envId=2024-02-07

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Pair[] freq = new Pair[123];
        for (char ch : s.toCharArray()) {
            if (freq[ch] == null) {
                freq[ch] = new Pair(ch, 1);
            } else {
                freq[ch].freq++;
            }
        }

        Arrays.sort(freq, (a, b) -> {
            if (a == null && b == null) {
                return 0;
            }

            if (a == null) {
                return 1;
            }

            if (b == null) {
                return -1;
            }

            // this ensures that the array is sorted in
            // descending order of frequency
            return b.freq - a.freq;
        });

        StringBuilder sb = new StringBuilder();
        for (Pair p : freq) {
            if (p == null) {
                break;
            }

            for (int i = 0; i < p.freq; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }

    // --------------------------------------------------------------------------------

    public static String frequencySort_2(String s) {
        Pair[] freq = new Pair[123];
        for (char ch : s.toCharArray()) {
            if (freq[ch] == null) {
                freq[ch] = new Pair(ch, 1);
            } else {
                freq[ch].freq++;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Pair p : freq) {
            if (p != null) {
                pq.add(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int i = 0; i < p.freq; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}
