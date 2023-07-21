
//Print all the permutations of a string.
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutations("abc", "");
        ArrayList<String> list = new ArrayList<>();
        System.out.println();
        System.out.println(permutations_with_List_in_the_call("abc", "", list));
        // System.out.println();
        System.out.println(permutations_without_List_in_the_call("abc", ""));
    }

    // simply printing the permutations.
    public static void permutations(String str, String ans) {
        if (str.isEmpty()) {
            System.out.print(ans + "  ");
            return;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            permutations(str.substring(1), (first + ch + second));
        }
    }

    // list in method definition
    public static ArrayList<String> permutations_with_List_in_the_call(String str, String ans, ArrayList<String> list) {
        if (str.isEmpty()) {
            // System.out.print(ans + " ");
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            permutations_with_List_in_the_call(str.substring(1), (first + ch + second), list);
        }

        return list;
    }

    // list not in method definition.
    public static ArrayList<String> permutations_without_List_in_the_call(String str, String ans) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);

        ArrayList<String> list_2 = new ArrayList<>();

        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i, ans.length());
            list_2.addAll(permutations_without_List_in_the_call(str.substring(1), first + ch + second));
        }

        return list_2;
    }

}
