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
        int count = 0;
        Arrays.sort(people);

        while (start <= end) {
            int sum = people[start] + people[end];
            if (sum <= limit) {
                start++;
                end--;
            }

            else {
                end--;
            }

            count++;
        }

        return count;

    }
}
