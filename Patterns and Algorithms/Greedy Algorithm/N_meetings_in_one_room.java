// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.Arrays;
import java.util.Comparator;

public class N_meetings_in_one_room {
    public static void main(String[] args) {
        int N = 6;
        int start[] = { 1, 5, 8, 5, 3, 0 };
        int end[] = { 2, 7, 9, 9, 4, 6 };

        System.out.println(maxMeetings(start, end, N));
    }

    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            time[i][0] = start[i];
            time[i][1] = end[i];
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        };

        Arrays.sort(time, comp);

        int count = 1;
        int endTime = time[0][1];

        for (int[] arr : time) {
            if (arr[0] > endTime) {
                count++;
                endTime = arr[1];
            }
        }

        return count;
    }
}
