// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/?envType=daily-question&envId=2023-10-02

public class Remove_Colored_Pieces_if_Both_Neighbors_are_the_Same_Color {
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }

    public static boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0;
        int bob = 0;

        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }

        return alice > bob;
    }
}
