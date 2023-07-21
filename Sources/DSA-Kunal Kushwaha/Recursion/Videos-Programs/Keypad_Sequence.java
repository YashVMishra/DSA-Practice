import java.util.ArrayList;

public class Keypad_Sequence {
    public static void main(String[] args) {
        char[][] arr = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
                { 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

        ArrayList<String> list = new ArrayList<>();

        System.out.println(helper_1(arr, "23", "", list));
    }

    public static ArrayList<String> helper_1(char[][] arr, String word, String ans, ArrayList<String> list) {
        if (word.equals("")) {
            return list;
        }

        if (word.length() == 0) {
            list.add(ans);
            return list;
        }

        int digit = word.charAt(0) - '0';

        if (digit == 1) {
            helper_1(arr, word.substring(1), ans, list);
        }

        for (int i = 0; i < arr[digit].length; i++) {
            helper_1(arr, word.substring(1), ans + arr[digit][i], list);
        }

        return list;
    }
}
