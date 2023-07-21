//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/

// The ceiling() method of java.util.TreeSet<E> class is used to return 
// the least element in this set greater than or equal to the given element, 
// or null if there is no such element.

import java.util.Collections;
import java.util.ArrayList;
import java.util.TreeSet;

public class Max_Events {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } };
        System.out.println(maxEvents(arr));
    }

    public static int maxEvents(int[][] events) {
        ArrayList<Events> list = new ArrayList<>();

        for (int i = 0; i < events.length; i++) {
            list.add(new Events(events[i][0], events[i][1]));
        }

        // sort the list acc to the end time.
        Collections.sort(list, (a, b) -> a.end - b.end);

        // TreeSet is taken so that we can find out
        // the next smallest number greater than or equal to
        // the passed element.
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 100000; i++) {
            set.add(i);
        }

        // keeping count.
        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer available = set.ceiling(list.get(i).start);
            if (available == null || available > list.get(i).end) {
                continue;
            }

            else {
                ans++;
                set.remove(available);
            }
        }

        return ans;
    }

    static class Events {
        int start;
        int end;

        Events(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}