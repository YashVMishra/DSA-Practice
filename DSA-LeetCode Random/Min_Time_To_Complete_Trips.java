//https://leetcode.com/problems/minimum-time-to-complete-trips/description/

public class Min_Time_To_Complete_Trips {
    public static void main(String[] args) {
        int[] time = { 1, 2, 3 };
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }

    public static long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        long end = Integer.MAX_VALUE;
        long mid = 0;
        long ans = 0;

        for (int i : time) {
            end = Math.min(end, i);
        }

        end = end * totalTrips;

        while (start < end) {
            mid = start + (end - start) / 2;
            ans = calculate(time, mid);

            // if ans is less than totalTrips then it means that our mid is too small.
            if (ans < totalTrips) {
                start = mid + 1;
            }

            // we can reach the totalTrips but we want end to be as small as possible
            else {
                end = mid;
            }

        }

        return start;
    }

    public static long calculate(int[] time, long ans) {

        long required = 0;

        for (int i : time) {
            required += ans / i;
        }

        return required;
    }
}
