// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13

import java.util.Arrays;

public class Minimum_Number_of_Moves_to_Seat_Everyone {
    public static void main(String[] args) {
        int[] seats = { 3, 1, 5 };
        int[] students = { 2, 7, 4 };
        System.out.println(minMovesToSeat(seats, students));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int n = seats.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }

        return sum;
    }
}
