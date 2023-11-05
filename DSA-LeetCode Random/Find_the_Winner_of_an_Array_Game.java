// https://leetcode.com/problems/find-the-winner-of-an-array-game/description/?envType=daily-question&envId=2023-11-05

public class Find_the_Winner_of_an_Array_Game {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        int k = 2;

        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        int n = arr.length;
        int maxEl = 0;
        for (int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }

        if (k >= n) {
            return maxEl;
        }

        int winner = arr[0];
        int wins = 0;

        for (int i = 1; i < n; i++) {
            if (winner > arr[i]) {
                wins++;
            } else {
                winner = arr[i];
                wins = 1;
            }

            if (wins == k || winner == maxEl) {
                return winner;
            }
        }

        return winner;
    }
}
