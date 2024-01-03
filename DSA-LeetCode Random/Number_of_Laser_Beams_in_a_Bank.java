// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=daily-question&envId=2024-01-03

public class Number_of_Laser_Beams_in_a_Bank {
    public static void main(String[] args) {
        String[] bank = { "000", "111", "000" };
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;

        for (String row : bank) {
            int curr = 0;

            for (char c : row.toCharArray()) {
                if (c == '1') {
                    curr++;
                }
            }

            ans = ans + (curr * prev);

            if (curr != 0) {
                prev = curr;
            }
        }

        return ans;
    }
}
