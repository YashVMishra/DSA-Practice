//https://leetcode.com/problems/boats-to-save-people/description/

import java.util.Arrays;

public class Boats_To_Save_People {
    public static void main(String[] args) {
        int[] people = { 1, 2 };
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int boats = 0;
        Arrays.sort(people);

        while (start <= end) {

            // try to send the heaviest person with the lightest person
            // if possible then send them else send the heaviest person alone
            int sum = people[start] + people[end];

            if (sum <= limit) {
                start++;
                end--;
            } else {
                end--;
            }

            boats++;
        }

        return boats;
    }
}
