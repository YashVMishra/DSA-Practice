//https://leetcode.com/problems/dota2-senate/description/

import java.util.LinkedList;
import java.util.Queue;

public class Dota2_Senate {
    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int len = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            }

            else {
                dire.offer(i);
            }
        }

        if (radiant.size() == 0) {
            return "Dire";
        }

        else if (dire.size() == 0) {
            return "Radiant";
        }

        else {
            while (!dire.isEmpty() && !radiant.isEmpty()) {
                if (radiant.peek() > dire.peek()) {
                    radiant.poll();
                    int temp = dire.peek();
                    dire.offer(temp + len);
                    dire.poll();
                }

                else {
                    dire.poll();
                    int temp = radiant.peek();
                    radiant.offer(temp + len);
                    radiant.poll();
                }
            }
        }

        return radiant.size() == 0 ? "Dire" : "Radiant";
    }
}