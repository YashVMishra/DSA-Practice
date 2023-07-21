//Print all the possible combinations of a number thrown from a dice
//example-4 ans will be 1111, 31, 22 and so on.

import java.util.ArrayList;

public class Dice_Thrower {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        combinations("", 4);
        System.out.println();
        System.out.println(combinations_2("", 4));
        System.out.println(combinations_3("", 4, list));
    }

    public static void combinations(String ans, int target) {
        if (target == 0) {
            System.out.print(ans + "    ");
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            combinations(ans + i, target - i);
        }
    }

    public static ArrayList<String> combinations_2(String ans, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(combinations_2(ans + i, target - i));
        }

        return list;
    }

    public static ArrayList<String> combinations_3(String ans, int target, ArrayList<String> list) {
        if (target == 0) {
            list.add(ans);
            return list;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(combinations_2(ans + i, target - i));
        }

        return list;
    }
}
