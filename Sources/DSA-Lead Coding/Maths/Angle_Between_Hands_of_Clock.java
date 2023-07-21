//https://leetcode.com/problems/angle-between-hands-of-a-clock/description/

public class Angle_Between_Hands_of_Clock {
    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        System.out.println(angleClock(hour, minutes));
    }

    public static double angleClock(int hour, int minutes) {

        // angle subtended by hour hand is 30 degree.
        // angle subtended by minute hand every minute is 6 degree.
        // remember the datatypes.
        // hour/60 is in double as if its less than 60 it will always
        // give 0.

        double hour_angle = ((hour % 12) + (double) (minutes) / 60) * 30;
        double min_angle = minutes * 6;

        double ans = Math.abs(hour_angle - min_angle);

        if (ans > 180) {
            return 360 - ans;
        }

        return ans;
    }
}
